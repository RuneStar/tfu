/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.I48;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import rs2.shared.movement.A207;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.Az206;
import rs2.shared.movement.B348;
import rs2.shared.movement.E181;
import rs2.shared.movement.M188;
import rs2.shared.movement.Z36;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lq191;
import tfu.Me312;

@ScriptEntryClass
public final class ScheduledMovementComponent
extends Component {
    private static StateFactory d;
    static final A207 g;
    public static final int t;
    private Vector3 b = null;
    private float e = Float.NaN;
    private boolean h = false;
    private float j = Float.POSITIVE_INFINITY;
    private Vector3 l = null;
    private Me312 m;
    private int p;
    private Vector3 q = Vector3.g;
    private final LossyStateStream r;
    private I48 s = I48.d();
    private final Z36 u;
    private final LossyStateStream v;
    private Vector3 w = null;
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
        ScheduledMovementComponent.d(this);
        return this.b;
    }

    public static ScheduledMovementComponent g(Bb4 bb4, Z36 z36) {
        LossyStateStream lossyStateStream = new LossyStateStream(d, bb4.h() | 0x3000000, "NPCScheduledMove_" + bb4.h());
        LossyStateStream lossyStateStream2 = new LossyStateStream(new B348(), bb4.h() | 0x5000000, "NPCDynamicState_" + bb4.h());
        return new ScheduledMovementComponent(lossyStateStream, lossyStateStream2, 0, null, z36, new M188(false));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return t;
    }

    public static void p(ScheduledMovementComponent scheduledMovementComponent, int n) {
        scheduledMovementComponent.r.discardStates(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getScheduledVelocityEstimate() {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        ScheduledMovementComponent.d(this);
        return this.w;
    }

    private static void d(ScheduledMovementComponent scheduledMovementComponent) {
        if (scheduledMovementComponent.b == null) {
            RotTrans rotTrans = scheduledMovementComponent.x.q();
            I48 i48 = I48.r(rotTrans.trans);
            I48 i482 = I48.r(scheduledMovementComponent.x.g());
            int n = scheduledMovementComponent.y;
            while (n != scheduledMovementComponent.p) {
                A207 a207 = (A207)scheduledMovementComponent.r.getState(n);
                if (a207 != null) {
                    ScheduledMovementComponent.e(scheduledMovementComponent, a207, i482);
                    I48.k(i48, i482);
                }
                n = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n, 1);
            }
            scheduledMovementComponent.b = i48.ao();
            scheduledMovementComponent.l = i482.ao();
            float f = Lq191.d();
            scheduledMovementComponent.w = Vector3.ai(scheduledMovementComponent.l, f);
        }
    }

    public static void v(ScheduledMovementComponent scheduledMovementComponent, Q7 q7) {
        Ai37 ai37 = scheduledMovementComponent.u.g();
        if (ai37 != null) {
            ai37.h(q7);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setScheduledTargetVelocity(Vector3 vector3) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(vector3.x) || Float.isNaN(vector3.y) || Float.isNaN(vector3.z)) {
            throw new IllegalArgumentException("Invalid input: " + vector3);
        }
        if (Float.isInfinite(vector3.x) || Float.isInfinite(vector3.y) || Float.isInfinite(vector3.z)) {
            throw new IllegalArgumentException("Invalid input: " + vector3);
        }
        this.q = vector3;
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

    public static void t(ScheduledMovementComponent scheduledMovementComponent) {
        for (LossyStateStreamSynchronizer lossyStateStreamSynchronizer : scheduledMovementComponent.m) {
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

    public void q(float f, float f2, float f3) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3)) {
            throw new IllegalArgumentException("Invalid input: " + f + ", " + f2 + ", " + f3);
        }
        if (Float.isInfinite(f) || Float.isInfinite(f2) || Float.isInfinite(f3)) {
            throw new IllegalArgumentException("Invalid input: " + f + ", " + f2 + ", " + f3);
        }
        I48.i(this.s, f, f2, f3);
    }

    private static void j(I48 i48, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        i48.j -= f;
        i48.e -= f2;
        i48.h -= f3;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if ((f8 = I48.c(i48)) > f4) {
            float f9 = f8 - f4;
            I48.aq(i48, f9 / f8);
        } else {
            I48.z(i48);
        }
        i48.j += f;
        i48.e += f2;
        i48.h += f3;
        i48.j += f5;
        i48.e += f6;
        i48.h += f7;
    }

    public static void h(ScheduledMovementComponent scheduledMovementComponent, int n, boolean bl, boolean bl2) {
        Ai37 ai37 = scheduledMovementComponent.u.g();
        if (ai37 == null) {
            return;
        }
        if (bl2) {
            ScheduledMovementComponent.s(scheduledMovementComponent, n, ai37);
            scheduledMovementComponent.y = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n, 1);
        }
    }

    public void b() {
        Ai37 ai37 = this.u.g();
        if (ai37 == null) {
            return;
        }
        RotTrans rotTrans = ai37.q();
        GameEntity gameEntity = this.getEntity();
        gameEntity.setObjectTransform(new ScaleRotTrans(rotTrans, gameEntity.getObjectScale()));
        M188.d(this.z, rotTrans);
        this.u.d();
    }

    public static void l(ScheduledMovementComponent scheduledMovementComponent) {
        Ai37 ai37 = scheduledMovementComponent.u.g();
        if (ai37 == null) {
            return;
        }
        RotTrans rotTrans = ai37.q();
        M188.d(scheduledMovementComponent.z, rotTrans);
    }

    private ScheduledMovementComponent(LossyStateStream lossyStateStream, LossyStateStream lossyStateStream2, int n, Ai37 ai37, Z36 z36, M188 m188) {
        this.m = new Me312();
        this.r = lossyStateStream;
        this.v = lossyStateStream2;
        this.y = n;
        this.p = n;
        this.x = ai37;
        this.u = z36;
        this.z = m188;
    }

    public static E181 r(ScheduledMovementComponent scheduledMovementComponent, int n) {
        if (scheduledMovementComponent.v.hasExplicitState(n)) {
            return (E181)scheduledMovementComponent.v.getState(n);
        }
        return null;
    }

    static {
        g = new A207(0.0f, 0.0f, 0.0f, 0.0f, Float.NaN, false, 0.0f, 0.0f, 0.0f);
        d = new Az206();
        t = StringTools.l(ScheduledMovementComponent.class.getName());
    }

    public static void z(ScheduledMovementComponent scheduledMovementComponent, LossyStateStreamSynchronizer lossyStateStreamSynchronizer) {
        lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.r);
        lossyStateStreamSynchronizer.removeStream(scheduledMovementComponent.v);
        scheduledMovementComponent.m.remove(lossyStateStreamSynchronizer);
    }

    public static void x(ScheduledMovementComponent scheduledMovementComponent, int n) {
        scheduledMovementComponent.v.discardStates(n);
    }

    public static void u(ScheduledMovementComponent scheduledMovementComponent, LossyStateStreamSynchronizer lossyStateStreamSynchronizer) {
        scheduledMovementComponent.m.add(lossyStateStreamSynchronizer);
        lossyStateStreamSynchronizer.addSlaveStream(scheduledMovementComponent.r);
        lossyStateStreamSynchronizer.addSlaveStream(scheduledMovementComponent.v);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void scheduleKick(Vector3 vector3) {
        this.q(vector3.x, vector3.y, vector3.z);
    }

    @Override
    protected void detachFromEntity() {
        ScheduledMovementComponent.t(this);
    }

    @Override
    public void bd() {
        ScheduledMovementComponent.t(this);
    }

    public void w(float f) {
        RotTrans rotTrans = (RotTrans)M188.q(this.z);
        if (rotTrans == null) {
            return;
        }
        RotTrans rotTrans2 = (RotTrans)M188.j(this.z);
        float f2 = M188.l(this.z);
        RotTrans rotTrans3 = rotTrans;
        if (rotTrans2 != null) {
            rotTrans3 = rotTrans3.p(rotTrans2, f2);
        }
        GameEntity gameEntity = this.getEntity();
        gameEntity.setObjectTransform(new ScaleRotTrans(rotTrans3, gameEntity.getObjectScale()));
        this.u.q(f);
    }

    private static void s(ScheduledMovementComponent scheduledMovementComponent, int n, Ai37 ai37) {
        I48 i48 = I48.r(ai37.g());
        float f = Float.NaN;
        boolean bl = false;
        A207 a207 = (A207)scheduledMovementComponent.r.getState(n);
        if (a207 != null) {
            ScheduledMovementComponent.e(scheduledMovementComponent, a207, i48);
            if (!Float.isNaN(a207.e)) {
                f = a207.e;
            }
            bl = a207.h;
        }
        ai37.d(i48.ao(), f, bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setScheduledAcceleration(float f) {
        if (!(this.r instanceof SourceLossyStateStream)) {
            throw new IllegalStateException("Movement can only be scheduled server-side.");
        }
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Invalid input: " + f);
        }
        this.j = f;
    }

    private static void e(ScheduledMovementComponent scheduledMovementComponent, A207 a207, I48 i48) {
        ScheduledMovementComponent.j(i48, a207.g, a207.d, a207.q, a207.j, a207.s, a207.b, a207.l);
    }

    public static E181 y(ScheduledMovementComponent scheduledMovementComponent) {
        Ai37 ai37 = scheduledMovementComponent.u.g();
        if (ai37 != null) {
            return ai37.j();
        }
        return null;
    }
}

