/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventForwarder;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Hashtable;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.sound.D377;
import rs2.shared.sound.SoundComponent;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ko370;

@ScriptEntryClass
public class SoundAdapter
implements EventForwarder {
    private GameEntity b;
    private String d = "";
    private boolean e = false;
    private String g;
    private Vector3 h = Vector3.g;
    private int j = -1;
    private SoundComponent l;
    private float q = 1.0f;
    private Hashtable r;
    private Vector3 s = Vector3.g;
    private RotTrans w = RotTrans.g;

    protected void finalize() {
        Ko370.g(new D377(this));
    }

    SoundAdapter(SoundComponent soundComponent, String string, String string2, RotTrans rotTrans) {
        this(string, string2);
        this.b = null;
        this.setWorldTransform(rotTrans);
        this.l = soundComponent;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID Integer n) {
        this.r.remove(n);
    }

    public static void g(SoundAdapter soundAdapter, float f) {
        boolean bl;
        Vector3 vector3;
        Vector3 vector32;
        if (soundAdapter.b == null) {
            return;
        }
        if (!soundAdapter.e) {
            return;
        }
        RotTrans rotTrans = soundAdapter.b.getWorldTransform().q();
        PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(soundAdapter.b, PlayerPhysicsComponent.class);
        if (playerPhysicsComponent != null) {
            vector32 = playerPhysicsComponent.getLinearVelocity(true);
            vector3 = playerPhysicsComponent.getAngularVelocity(true);
        } else {
            Vector3 vector33 = Vector3.k(rotTrans.trans, soundAdapter.w.trans);
            vector32 = Vector3.ai(vector33, f);
            vector3 = Vector3.g;
            float f2 = 100.0f;
            if (Vector3.f(soundAdapter.h) * (1.0f / f) > 100.0f) {
                soundAdapter.h = Vector3.g;
            }
            if (Vector3.f(soundAdapter.s) * (1.0f / f) > 100.0f) {
                soundAdapter.s = Vector3.g;
            }
        }
        boolean bl2 = !RotTrans.q(soundAdapter.w, rotTrans, 0.001f);
        boolean bl3 = !Vector3.p(soundAdapter.h, vector32, 0.001f);
        boolean bl4 = bl = !Vector3.p(soundAdapter.s, vector3, 0.001f);
        if (bl2) {
            soundAdapter.w = rotTrans;
            SoundAdapter.e(soundAdapter, "SoundTransformChangedEvent", soundAdapter);
        }
        if (bl3) {
            soundAdapter.h = vector32;
            SoundAdapter.e(soundAdapter, "SoundLinearVelocityChangedEvent", soundAdapter);
        }
        if (bl) {
            soundAdapter.s = vector3;
            SoundAdapter.e(soundAdapter, "SoundAngularVelocityChangedEvent", soundAdapter);
        }
    }

    public static void d(SoundAdapter soundAdapter, String string, int n) {
        soundAdapter.d = string;
        soundAdapter.j = n;
        soundAdapter.e = true;
        SoundAdapter.e(soundAdapter, "SoundStartedEvent", soundAdapter);
    }

    public static void q(SoundAdapter soundAdapter) {
        soundAdapter.e = false;
        SoundAdapter.e(soundAdapter, "SoundStoppedEvent", soundAdapter);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getVolume() {
        return this.q;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getName() {
        return this.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getWorldTransform() {
        return this.w;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundComponent getComponent() {
        return this.l;
    }

    public void s(String string) {
        assert (string != null);
        this.d = string;
        SoundAdapter.e(this, "SoundParamsChangedEvent", this);
    }

    SoundAdapter(SoundComponent soundComponent, String string, String string2) {
        this(string, string2);
        this.l = soundComponent;
        this.b = this.l.getEntity();
        this.w = this.b.getWorldTransform().q();
    }

    private SoundAdapter(String string, String string2) {
        this.r = new Hashtable();
        assert (string != null);
        this.g = new String(string);
        assert (string2 != null);
        this.d = new String(string2);
        this.r.put(StringTools.l("SoundStartedEvent"), new Event());
        this.r.put(StringTools.l("SoundStoppedEvent"), new Event());
        this.r.put(StringTools.l("SoundRemovedEvent"), new Event());
        this.r.put(StringTools.l("SoundLinearVelocityChangedEvent"), new Event());
        this.r.put(StringTools.l("SoundAngularVelocityChangedEvent"), new Event());
        this.r.put(StringTools.l("SoundTransformChangedEvent"), new Event());
        this.r.put(StringTools.l("SoundParamsChangedEvent"), new Event());
        this.r.put(StringTools.l("SoundVolumeChangedEvent"), new Event());
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getObservedLinearVelocity() {
        return this.h;
    }

    public void h(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new NumberFormatException("Volume expected value between 0 and 1.");
        }
        this.q = f;
        SoundAdapter.e(this, "SoundVolumeChangedEvent", this);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(String string, EventHandler eventHandler) {
        this.addEventHandlerByID(StringTools.l(string), eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeEventHandler(String string, EventHandler eventHandler) {
        this.removeEventHandlerByID(StringTools.l(string), eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID Integer n, EventHandler eventHandler) {
        Event event = (Event)this.r.get(n);
        if (event == null) {
            throw new RuntimeException("Could remove SoundAdapter event handle. Specified event does not exist.");
        }
        event.add(eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getParams() {
        return this.d;
    }

    public static void j(SoundAdapter soundAdapter) {
        Collection collection = soundAdapter.r.values();
        for (Event event : collection) {
            event.clear();
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID Integer n, Object object) {
        Event event = (Event)this.r.get(n);
        if (event == null) {
            throw new RuntimeException("Could not trigger SoundAdapter event. Specified event does not exist.");
        }
        event.trigger(this, object);
    }

    static void e(SoundAdapter soundAdapter, String string, Object object) {
        soundAdapter.triggerEvent(StringTools.l(string), object);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity getParent() {
        return this.b;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeEventHandlerByID(@ScriptID Integer n, EventHandler eventHandler) {
        Event event = (Event)this.r.get(n);
        if (event == null) {
            throw new RuntimeException("Could remove SoundAdapter event handle. Specified event does not exist.");
        }
        event.remove(eventHandler);
    }

    public static void b(SoundAdapter soundAdapter) {
        soundAdapter.b = soundAdapter.l.getEntity();
        soundAdapter.w = soundAdapter.b.getWorldTransform().q();
    }

    public static void l(SoundAdapter soundAdapter) {
        soundAdapter.b = null;
        soundAdapter.h = Vector3.g;
        soundAdapter.s = Vector3.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setWorldTransform(RotTrans rotTrans) {
        if (rotTrans == null) {
            throw new IllegalStateException();
        }
        if (this.b != null) {
            throw new UnsupportedOperationException("Tried to override the transform of a sound when it was already attached to a SceneGraphNode.");
        }
        this.w = rotTrans;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getHandle() {
        return this.j;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getObservedAngularVelocity() {
        return this.s;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isPlaying() {
        return this.e;
    }
}

