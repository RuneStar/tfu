// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import java.util.Iterator;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import tfu.Lq191;
import tfu.Bb4;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.maths.I48;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import tfu.Me312;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public final class ScheduledMovementComponent extends Component
{
    private static StateFactory d;
    static final A207 g;
    public static final int t;
    private Vector3 b;
    private float e;
    private boolean h;
    private float j;
    private Vector3 l;
    private Me312 m;
    private int p;
    private Vector3 q;
    private final LossyStateStream r;
    private I48 s;
    private final Z36 u;
    private final LossyStateStream v;
    private Vector3 w;
    private final Ai37 x;
    private int y;
    private final M188 z;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getScheduledPositionEstimate() {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        d(this);
        return this.b;
    }
    
    public static ScheduledMovementComponent g(final Bb4 bb4, final Z36 z36) {
        return new ScheduledMovementComponent(new LossyStateStream(ScheduledMovementComponent.d, bb4.h() | 0x3000000, "NPCScheduledMove_" + bb4.h()), new LossyStateStream(new B348(), bb4.h() | 0x5000000, "NPCDynamicState_" + bb4.h()), 0, null, z36, new M188(false));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return ScheduledMovementComponent.t;
    }
    
    public static void p(final ScheduledMovementComponent scheduledMovementComponent, final int n) {
        scheduledMovementComponent.r.discardStates(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getScheduledVelocityEstimate() {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        d(this);
        return this.w;
    }
    
    private static void d(final ScheduledMovementComponent scheduledMovementComponent) {
        if (scheduledMovementComponent.b == null) {
            final I48 r = I48.r(scheduledMovementComponent.x.q().trans);
            final I48 r2 = I48.r(scheduledMovementComponent.x.g());
            for (int i = scheduledMovementComponent.y; i != scheduledMovementComponent.p; i = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(i, 1)) {
                final A207 a207 = (A207)scheduledMovementComponent.r.getState(i);
                if (a207 != null) {
                    e(scheduledMovementComponent, a207, r2);
                    I48.k(r, r2);
                }
            }
            scheduledMovementComponent.b = r.ao();
            scheduledMovementComponent.l = r2.ao();
            scheduledMovementComponent.w = Vector3.ai(scheduledMovementComponent.l, Lq191.d());
        }
    }
    
    public static void v(final ScheduledMovementComponent scheduledMovementComponent, final Q7 q7) {
        final Ai37 g = scheduledMovementComponent.u.g();
        if (g != null) {
            g.h(q7);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setScheduledTargetVelocity(final Vector3 q) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(q.x) || Float.isNaN(q.y) || Float.isNaN(q.z)) {
            throw new IllegalArgumentException("Invalid input: " + q);
        }
        if (Float.isInfinite(q.x) || Float.isInfinite(q.y) || Float.isInfinite(q.z)) {
            throw new IllegalArgumentException("Invalid input: " + q);
        }
        this.q = q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getScheduledAcceleration() {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        return this.j;
    }
    
    public static void t(final ScheduledMovementComponent scheduledMovementComponent) {
        for (final LossyStateStreamSynchronizer lossyStateStreamSynchronizer : scheduledMovementComponent.m) {
            lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.r);
            lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.v);
        }
        scheduledMovementComponent.m.clear();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getScheduledTargetVelocity() {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        return this.q;
    }
    
    public void q(final float n, final float n2, final float n3) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(n) || Float.isNaN(n2) || Float.isNaN(n3)) {
            throw new IllegalArgumentException("Invalid input: " + n + ", " + n2 + ", " + n3);
        }
        if (Float.isInfinite(n) || Float.isInfinite(n2) || Float.isInfinite(n3)) {
            throw new IllegalArgumentException("Invalid input: " + n + ", " + n2 + ", " + n3);
        }
        I48.i(this.s, n, n2, n3);
    }
    
    private static void j(final I48 i48, final float n, final float n2, final float n3, float n4, final float n5, final float n6, final float n7) {
        i48.j -= n;
        i48.e -= n2;
        i48.h -= n3;
        if (n4 < 0.0f) {
            n4 = 0.0f;
        }
        final float c = I48.c(i48);
        if (c > n4) {
            I48.aq(i48, (c - n4) / c);
        }
        else {
            I48.z(i48);
        }
        i48.j += n;
        i48.e += n2;
        i48.h += n3;
        i48.j += n5;
        i48.e += n6;
        i48.h += n7;
    }
    
    public static void h(final ScheduledMovementComponent scheduledMovementComponent, final int n, final boolean b, final boolean b2) {
        final Ai37 g = scheduledMovementComponent.u.g();
        if (g == null) {
            return;
        }
        if (b2) {
            s(scheduledMovementComponent, n, g);
            scheduledMovementComponent.y = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n, 1);
        }
    }
    
    public void b() {
        final Ai37 g = this.u.g();
        if (g == null) {
            return;
        }
        final RotTrans q = g.q();
        final GameEntity entity = this.getEntity();
        entity.setObjectTransform(new ScaleRotTrans(q, entity.getObjectScale()));
        M188.d(this.z, q);
        this.u.d();
    }
    
    public static void l(final ScheduledMovementComponent scheduledMovementComponent) {
        final Ai37 g = scheduledMovementComponent.u.g();
        if (g == null) {
            return;
        }
        M188.d(scheduledMovementComponent.z, g.q());
    }
    
    private ScheduledMovementComponent(final LossyStateStream r, final LossyStateStream v, final int n, final Ai37 x, final Z36 u, final M188 z) {
        this.q = Vector3.g;
        this.j = Float.POSITIVE_INFINITY;
        this.e = Float.NaN;
        this.h = false;
        this.s = I48.d();
        this.b = null;
        this.l = null;
        this.w = null;
        this.m = new Me312();
        this.r = r;
        this.v = v;
        this.y = n;
        this.p = n;
        this.x = x;
        this.u = u;
        this.z = z;
    }
    
    public static E181 r(final ScheduledMovementComponent scheduledMovementComponent, final int n) {
        if (scheduledMovementComponent.v.hasExplicitState(n)) {
            return (E181)scheduledMovementComponent.v.getState(n);
        }
        return null;
    }
    
    static {
        g = new A207(0.0f, 0.0f, 0.0f, 0.0f, Float.NaN, false, 0.0f, 0.0f, 0.0f);
        ScheduledMovementComponent.d = new Az206();
        t = StringTools.l(ScheduledMovementComponent.class.getName());
    }
    
    public static void z(final ScheduledMovementComponent scheduledMovementComponent, final LossyStateStreamSynchronizer lossyStateStreamSynchronizer) {
        lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.r);
        lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.v);
        scheduledMovementComponent.m.remove(lossyStateStreamSynchronizer);
    }
    
    public static void x(final ScheduledMovementComponent scheduledMovementComponent, final int n) {
        scheduledMovementComponent.v.discardStates(n);
    }
    
    public static void u(final ScheduledMovementComponent scheduledMovementComponent, final LossyStateStreamSynchronizer lossyStateStreamSynchronizer) {
        scheduledMovementComponent.m.add(lossyStateStreamSynchronizer);
        lossyStateStreamSynchronizer.addSlaveStream(scheduledMovementComponent.r);
        lossyStateStreamSynchronizer.addSlaveStream(scheduledMovementComponent.v);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void scheduleKick(final Vector3 vector3) {
        this.q(vector3.x, vector3.y, vector3.z);
    }
    
    @Override
    protected void detachFromEntity() {
        t(this);
    }
    
    @Override
    public void bd() {
        t(this);
    }
    
    public void w(final float n) {
        final RotTrans rotTrans = (RotTrans)M188.q(this.z);
        if (rotTrans == null) {
            return;
        }
        final RotTrans rotTrans2 = (RotTrans)M188.j(this.z);
        final float l = M188.l(this.z);
        RotTrans p = rotTrans;
        if (rotTrans2 != null) {
            p = p.p(rotTrans2, l);
        }
        final GameEntity entity = this.getEntity();
        entity.setObjectTransform(new ScaleRotTrans(p, entity.getObjectScale()));
        this.u.q(n);
    }
    
    private static void s(final ScheduledMovementComponent scheduledMovementComponent, final int n, final Ai37 ai37) {
        final I48 r = I48.r(ai37.g());
        float e = Float.NaN;
        boolean h = false;
        final A207 a207 = (A207)scheduledMovementComponent.r.getState(n);
        if (a207 != null) {
            e(scheduledMovementComponent, a207, r);
            if (!Float.isNaN(a207.e)) {
                e = a207.e;
            }
            h = a207.h;
        }
        ai37.d(r.ao(), e, h);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setScheduledAcceleration(final float j) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(j)) {
            throw new IllegalArgumentException("Invalid input: " + j);
        }
        this.j = j;
    }
    
    private static void e(final ScheduledMovementComponent scheduledMovementComponent, final A207 a207, final I48 i48) {
        j(i48, a207.g, a207.d, a207.q, a207.j, a207.s, a207.b, a207.l);
    }
    
    public static E181 y(final ScheduledMovementComponent scheduledMovementComponent) {
        final Ai37 g = scheduledMovementComponent.u.g();
        if (g != null) {
            return g.j();
        }
        return null;
    }
}
