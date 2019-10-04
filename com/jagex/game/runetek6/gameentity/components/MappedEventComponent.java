/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.gameentity.components.D387;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class MappedEventComponent
extends Component {
    public static final int h = StringTools.l(MappedEventComponent.class.getName());
    private PhysicsEventMode d;
    private final Q344 e = new D387(this);
    private Map g;
    Set j;
    Set q;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return h;
    }

    public static void g(MappedEventComponent mappedEventComponent, GameEntity gameEntity) {
        MappedEventComponent.d(mappedEventComponent, MappedEventType.ON_COLLIDE, gameEntity);
    }

    private static void d(MappedEventComponent mappedEventComponent, MappedEventType mappedEventType, GameEntity gameEntity) {
        if (mappedEventComponent.g != null && mappedEventComponent.g.containsKey(mappedEventType)) {
            mappedEventComponent.getEntity().triggerEvent((Integer)mappedEventComponent.g.get(mappedEventType), gameEntity);
        }
    }

    public static boolean q(MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d != PhysicsEventMode.OFF;
    }

    private static void w(MappedEventComponent mappedEventComponent, Set set) {
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                GameEntity gameEntity = (GameEntity)iterator.next();
                iterator.remove();
                MappedEventComponent.s(mappedEventComponent, gameEntity);
            }
        }
    }

    public static boolean e(MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d == PhysicsEventMode.VOLUME;
    }

    private static void h(MappedEventComponent mappedEventComponent, GameEntity gameEntity) {
        gameEntity.et(mappedEventComponent.e);
        MappedEventComponent.d(mappedEventComponent, MappedEventType.ON_ENTER, gameEntity);
    }

    static void s(MappedEventComponent mappedEventComponent, GameEntity gameEntity) {
        GameEntity.eu(gameEntity, mappedEventComponent.e);
        MappedEventComponent.d(mappedEventComponent, MappedEventType.ON_EXIT, gameEntity);
    }

    public void b(GameEntity gameEntity) {
        if (this.j == null) {
            this.j = this.q != null ? new HashSet(this.q.size() * 2) : new HashSet();
        }
        if (this.j.contains(gameEntity)) {
            return;
        }
        this.j.add(gameEntity);
        if (this.q == null) {
            MappedEventComponent.h(this, gameEntity);
        } else {
            boolean bl = this.q.remove(gameEntity);
            if (!bl) {
                MappedEventComponent.h(this, gameEntity);
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnExit(@ScriptID Integer n) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't set onExit on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_EXIT);
            }
        } else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_EXIT, n);
        }
    }

    private static void r(MappedEventComponent mappedEventComponent) {
        MappedEventComponent.w(mappedEventComponent, mappedEventComponent.q);
        MappedEventComponent.w(mappedEventComponent, mappedEventComponent.j);
        mappedEventComponent.q = null;
        mappedEventComponent.j = null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean entityIsInsideMe(GameEntity gameEntity) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        return this.q != null && this.q.contains(gameEntity) || this.j != null && this.j.contains(gameEntity);
    }

    public static boolean j(MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d != PhysicsEventMode.VOLUME;
    }

    @Override
    protected void detachFromEntity() {
        MappedEventComponent.r(this);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnCollide(@ScriptID Integer n) {
        if (this.d != PhysicsEventMode.COLLISION) {
            throw new IllegalStateException("Can't set onCollide on this entity unless there is a <CollisionEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_COLLIDE);
            }
        } else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_COLLIDE, n);
        }
    }

    public static void l(MappedEventComponent mappedEventComponent) {
        MappedEventComponent.w(mappedEventComponent, mappedEventComponent.q);
        mappedEventComponent.q = mappedEventComponent.j;
        mappedEventComponent.j = null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getNumEntitiesInsideMe() {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        int n = 0;
        if (this.q != null) {
            n += this.q.size();
        }
        if (this.j != null) {
            n += this.j.size();
        }
        return n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getAllEntitiesInsideMe() {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        GameEntity[] arrgameEntity = new GameEntity[this.getNumEntitiesInsideMe()];
        int n = 0;
        if (this.q != null) {
            for (GameEntity gameEntity : this.q) {
                arrgameEntity[n++] = gameEntity;
            }
        }
        if (this.j != null) {
            for (GameEntity gameEntity : this.j) {
                arrgameEntity[n++] = gameEntity;
            }
        }
        return arrgameEntity;
    }

    public MappedEventComponent(Map map, PhysicsEventMode physicsEventMode) {
        this.g = map;
        this.d = physicsEventMode;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnEnter(@ScriptID Integer n) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't set onEnter on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_ENTER);
            }
        } else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_ENTER, n);
        }
    }

    @Override
    public void bd() {
        MappedEventComponent.r(this);
    }
}

