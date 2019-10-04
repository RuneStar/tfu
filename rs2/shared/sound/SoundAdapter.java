// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.sound;

import java.util.Iterator;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.Event;
import com.jagex.core.stringtools.general.StringTools;
import rs2.shared.movement.PlayerPhysicsComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import tfu.Ko370;
import com.jagex.maths.RotTrans;
import java.util.Hashtable;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.event.EventForwarder;

@ScriptEntryClass
public class SoundAdapter implements EventForwarder
{
    private GameEntity b;
    private String d;
    private boolean e;
    private String g;
    private Vector3 h;
    private int j;
    private SoundComponent l;
    private float q;
    private Hashtable r;
    private Vector3 s;
    private RotTrans w;
    static final /* synthetic */ boolean v;
    
    @Override
    protected void finalize() {
        Ko370.g(new D377(this));
    }
    
    SoundAdapter(final SoundComponent l, final String s, final String s2, final RotTrans worldTransform) {
        this(s, s2);
        this.b = null;
        this.setWorldTransform(worldTransform);
        this.l = l;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID final Integer key) {
        this.r.remove(key);
    }
    
    public static void g(final SoundAdapter soundAdapter, final float n) {
        if (soundAdapter.b == null) {
            return;
        }
        if (!soundAdapter.e) {
            return;
        }
        final RotTrans q = soundAdapter.b.getWorldTransform().q();
        final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(soundAdapter.b, PlayerPhysicsComponent.class);
        Vector3 h;
        Vector3 s;
        if (playerPhysicsComponent != null) {
            h = playerPhysicsComponent.getLinearVelocity(true);
            s = playerPhysicsComponent.getAngularVelocity(true);
        }
        else {
            h = Vector3.ai(Vector3.k(q.trans, soundAdapter.w.trans), n);
            s = Vector3.g;
            if (Vector3.f(soundAdapter.h) * (1.0f / n) > 100.0f) {
                soundAdapter.h = Vector3.g;
            }
            if (Vector3.f(soundAdapter.s) * (1.0f / n) > 100.0f) {
                soundAdapter.s = Vector3.g;
            }
        }
        final boolean b = !RotTrans.q(soundAdapter.w, q, 0.001f);
        final boolean b2 = !Vector3.p(soundAdapter.h, h, 0.001f);
        final boolean b3 = !Vector3.p(soundAdapter.s, s, 0.001f);
        if (b) {
            soundAdapter.w = q;
            e(soundAdapter, "SoundTransformChangedEvent", soundAdapter);
        }
        if (b2) {
            soundAdapter.h = h;
            e(soundAdapter, "SoundLinearVelocityChangedEvent", soundAdapter);
        }
        if (b3) {
            soundAdapter.s = s;
            e(soundAdapter, "SoundAngularVelocityChangedEvent", soundAdapter);
        }
    }
    
    public static void d(final SoundAdapter soundAdapter, final String d, final int j) {
        soundAdapter.d = d;
        soundAdapter.j = j;
        soundAdapter.e = true;
        e(soundAdapter, "SoundStartedEvent", soundAdapter);
    }
    
    public static void q(final SoundAdapter soundAdapter) {
        soundAdapter.e = false;
        e(soundAdapter, "SoundStoppedEvent", soundAdapter);
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
    
    public void s(final String d) {
        if (!SoundAdapter.v && d == null) {
            throw new AssertionError();
        }
        this.d = d;
        e(this, "SoundParamsChangedEvent", this);
    }
    
    SoundAdapter(final SoundComponent l, final String s, final String s2) {
        this(s, s2);
        this.l = l;
        this.b = this.l.getEntity();
        this.w = this.b.getWorldTransform().q();
    }
    
    private SoundAdapter(final String original, final String original2) {
        this.d = "";
        this.q = 1.0f;
        this.j = -1;
        this.e = false;
        this.h = Vector3.g;
        this.s = Vector3.g;
        this.w = RotTrans.g;
        this.r = new Hashtable();
        if (!SoundAdapter.v && original == null) {
            throw new AssertionError();
        }
        this.g = new String(original);
        if (!SoundAdapter.v && original2 == null) {
            throw new AssertionError();
        }
        this.d = new String(original2);
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
    
    public void h(final float q) {
        if (q < 0.0f || q > 1.0f) {
            throw new NumberFormatException("Volume expected value between 0 and 1.");
        }
        this.q = q;
        e(this, "SoundVolumeChangedEvent", this);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(final String s, final EventHandler eventHandler) {
        this.addEventHandlerByID(StringTools.l(s), eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeEventHandler(final String s, final EventHandler eventHandler) {
        this.removeEventHandlerByID(StringTools.l(s), eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID final Integer key, final EventHandler eventHandler) {
        final Event event = this.r.get(key);
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
    
    public static void j(final SoundAdapter soundAdapter) {
        final Iterator iterator = soundAdapter.r.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID final Integer key, final Object o) {
        final Event event = this.r.get(key);
        if (event == null) {
            throw new RuntimeException("Could not trigger SoundAdapter event. Specified event does not exist.");
        }
        event.trigger(this, o);
    }
    
    static void e(final SoundAdapter soundAdapter, final String s, final Object o) {
        soundAdapter.triggerEvent(StringTools.l(s), o);
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
    public void removeEventHandlerByID(@ScriptID final Integer key, final EventHandler o) {
        final Event event = this.r.get(key);
        if (event == null) {
            throw new RuntimeException("Could remove SoundAdapter event handle. Specified event does not exist.");
        }
        event.remove(o);
    }
    
    public static void b(final SoundAdapter soundAdapter) {
        soundAdapter.b = soundAdapter.l.getEntity();
        soundAdapter.w = soundAdapter.b.getWorldTransform().q();
    }
    
    public static void l(final SoundAdapter soundAdapter) {
        soundAdapter.b = null;
        soundAdapter.h = Vector3.g;
        soundAdapter.s = Vector3.g;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setWorldTransform(final RotTrans w) {
        if (w == null) {
            throw new IllegalStateException();
        }
        if (this.b != null) {
            throw new UnsupportedOperationException("Tried to override the transform of a sound when it was already attached to a SceneGraphNode.");
        }
        this.w = w;
    }
    
    static {
        v = !SoundAdapter.class.desiredAssertionStatus();
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
