// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import java.util.HashMap;
import com.jagex.game.runetek6.script.ScriptID;
import java.util.HashSet;
import java.util.Iterator;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.Set;
import java.util.Map;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class MappedEventComponent extends Component
{
    public static final int h;
    private PhysicsEventMode d;
    private final Q344 e;
    private Map g;
    Set j;
    Set q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return MappedEventComponent.h;
    }
    
    public static void g(final MappedEventComponent mappedEventComponent, final GameEntity gameEntity) {
        d(mappedEventComponent, MappedEventType.ON_COLLIDE, gameEntity);
    }
    
    private static void d(final MappedEventComponent mappedEventComponent, final MappedEventType mappedEventType, final GameEntity gameEntity) {
        if (mappedEventComponent.g != null && mappedEventComponent.g.containsKey(mappedEventType)) {
            mappedEventComponent.getEntity().triggerEvent(mappedEventComponent.g.get(mappedEventType), gameEntity);
        }
    }
    
    public static boolean q(final MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d != PhysicsEventMode.OFF;
    }
    
    private static void w(final MappedEventComponent mappedEventComponent, final Set set) {
        if (set != null) {
            final Iterator<GameEntity> iterator = set.iterator();
            while (iterator.hasNext()) {
                final GameEntity gameEntity = iterator.next();
                iterator.remove();
                s(mappedEventComponent, gameEntity);
            }
        }
    }
    
    public static boolean e(final MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d == PhysicsEventMode.VOLUME;
    }
    
    private static void h(final MappedEventComponent mappedEventComponent, final GameEntity gameEntity) {
        gameEntity.et(mappedEventComponent.e);
        d(mappedEventComponent, MappedEventType.ON_ENTER, gameEntity);
    }
    
    static void s(final MappedEventComponent mappedEventComponent, final GameEntity gameEntity) {
        GameEntity.eu(gameEntity, mappedEventComponent.e);
        d(mappedEventComponent, MappedEventType.ON_EXIT, gameEntity);
    }
    
    public void b(final GameEntity gameEntity) {
        if (this.j == null) {
            if (this.q != null) {
                this.j = new HashSet(this.q.size() * 2);
            }
            else {
                this.j = new HashSet();
            }
        }
        if (this.j.contains(gameEntity)) {
            return;
        }
        this.j.add(gameEntity);
        if (this.q == null) {
            h(this, gameEntity);
        }
        else if (!this.q.remove(gameEntity)) {
            h(this, gameEntity);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnExit(@ScriptID final Integer n) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't set onExit on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_EXIT);
            }
        }
        else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_EXIT, n);
        }
    }
    
    private static void r(final MappedEventComponent mappedEventComponent) {
        w(mappedEventComponent, mappedEventComponent.q);
        w(mappedEventComponent, mappedEventComponent.j);
        mappedEventComponent.q = null;
        mappedEventComponent.j = null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean entityIsInsideMe(final GameEntity gameEntity) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't query entities inside this entity unless this entity has a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        return (this.q != null && this.q.contains(gameEntity)) || (this.j != null && this.j.contains(gameEntity));
    }
    
    public static boolean j(final MappedEventComponent mappedEventComponent) {
        return mappedEventComponent.d != PhysicsEventMode.VOLUME;
    }
    
    @Override
    protected void detachFromEntity() {
        r(this);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnCollide(@ScriptID final Integer n) {
        if (this.d != PhysicsEventMode.COLLISION) {
            throw new IllegalStateException("Can't set onCollide on this entity unless there is a <CollisionEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_COLLIDE);
            }
        }
        else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_COLLIDE, n);
        }
    }
    
    public static void l(final MappedEventComponent mappedEventComponent) {
        w(mappedEventComponent, mappedEventComponent.q);
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
        final GameEntity[] array = new GameEntity[this.getNumEntitiesInsideMe()];
        int n = 0;
        if (this.q != null) {
            final Iterator<GameEntity> iterator = this.q.iterator();
            while (iterator.hasNext()) {
                array[n++] = iterator.next();
            }
        }
        if (this.j != null) {
            final Iterator<GameEntity> iterator2 = this.j.iterator();
            while (iterator2.hasNext()) {
                array[n++] = iterator2.next();
            }
        }
        return array;
    }
    
    static {
        h = StringTools.l(MappedEventComponent.class.getName());
    }
    
    public MappedEventComponent(final Map g, final PhysicsEventMode d) {
        this.e = new D387(this);
        this.g = g;
        this.d = d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOnEnter(@ScriptID final Integer n) {
        if (this.d != PhysicsEventMode.VOLUME) {
            throw new IllegalStateException("Can't set onEnter on this entity unless there is a <VolumeEvents /> tag (possibly empty) in the XML file.");
        }
        if (n == null) {
            if (this.g != null) {
                this.g.remove(MappedEventType.ON_ENTER);
            }
        }
        else {
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.g.put(MappedEventType.ON_ENTER, n);
        }
    }
    
    @Override
    public void bd() {
        r(this);
    }
}
