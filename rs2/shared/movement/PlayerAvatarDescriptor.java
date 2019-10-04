// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import java.util.HashSet;
import org.slf4j.LoggerFactory;
import com.jagex.maths.Quaternion;
import com.jagex.maths.M47;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.I48;
import com.jagex.maths.RotTrans;
import com.jagex.game.runetek6.script.ScriptDefaults;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import org.slf4j.Logger;
import java.util.Set;
import java.util.HashMap;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("PlayerPhysicsAvatarDescriptor")
public class PlayerAvatarDescriptor
{
    public static final HashMap i;
    static Set k;
    private static final Logger logger;
    public static final HashMap o;
    public float b;
    public J93 d;
    public float e;
    public float h;
    public B45 j;
    public float l;
    public EventHandler m;
    public EventHandler n;
    public Vector3 p;
    public W94 q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMaxWalkSlope(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).u;
    }
    
    private PlayerAvatarDescriptor(final J93 d) {
        this.d = null;
        this.q = null;
        this.j = null;
        this.b = 0.0f;
        this.w = -29.41995f;
        this.r = 1.0f;
        this.v = 0.0f;
        this.y = 0.3f;
        this.p = new Vector3(1.0f, 1.0f, 1.0f);
        this.x = 0.0f;
        this.u = (float)Math.toRadians(45.0);
        this.z = (float)Math.toRadians(45.0);
        this.t = (float)Math.toRadians(30.0);
        this.m = null;
        this.n = null;
        this.d = d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(3000);
        sb.append("\n=============\n");
        sb.append("type: ");
        sb.append(this.d);
        sb.append("\nshapeType: ");
        sb.append(this.q);
        sb.append("\ndimension: ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(this.h);
        sb.append(" ");
        sb.append(this.s);
        sb.append(" ");
        sb.append(this.b);
        sb.append("\nmass: ");
        sb.append(this.l);
        sb.append("\ninAirGravityY: ");
        sb.append(this.w);
        sb.append("\nonWallGravityMultiplier: ");
        sb.append(this.r);
        sb.append("\nfriction: ");
        sb.append(this.v);
        sb.append("\nrestitution: ");
        sb.append(this.y);
        sb.append("\ninertiaScaleRelativeToShape: ");
        sb.append(this.p);
        sb.append("\nstepHeight: ");
        sb.append(this.x);
        sb.append("\nmaxWalkSlopeRadians: ");
        sb.append(this.u);
        sb.append("\nmaxJumpSlopeRadians: ");
        sb.append(this.z);
        sb.append("\nminSlideSlopeRadians: ");
        sb.append(this.t);
        if (this.j != null) {
            sb.append("\n------------");
            sb.append(this.j.toString());
        }
        sb.append("\n=============");
        return sb.toString();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createBodyDescriptor(@ScriptID final Integer n) {
        PlayerAvatarDescriptor.i.put(n, new PlayerAvatarDescriptor(J93.BODY));
        PlayerAvatarDescriptor.o.put(n, 1);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxLinearVelocity(@ScriptID final Integer key, final float br) {
        PlayerAvatarDescriptor.i.get(key).j.br = br;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsCharacterController(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).d == J93.CHARACTERCONTROLLER;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollStrength(@ScriptID final Integer key, final float t) {
        PlayerAvatarDescriptor.i.get(key).j.t = t;
        q(key);
    }
    
    public static int d(final int i) {
        final Integer n = PlayerAvatarDescriptor.o.get(i);
        if (n == null) {
            return 0;
        }
        return n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void CreateDuplicateDescriptor(@ScriptID final Integer n, @ScriptID final Integer n2) {
        j(n, n2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setBoxShape(@ScriptID final Integer key, final float e, final float h, final float s, @ScriptDefaults(defaultNumber = 0.0) final float b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.q = W94.BOX;
        playerAvatarDescriptor.e = e;
        playerAvatarDescriptor.h = h;
        playerAvatarDescriptor.s = s;
        playerAvatarDescriptor.b = b;
        q(key);
    }
    
    public static float h(final PlayerAvatarDescriptor playerAvatarDescriptor) {
        switch (Al95.g[playerAvatarDescriptor.q.ordinal()]) {
            case 1: {
                return 2.0f * playerAvatarDescriptor.h + 2.0f * playerAvatarDescriptor.b;
            }
            case 3: {
                return playerAvatarDescriptor.e + 2.0f * playerAvatarDescriptor.b;
            }
            case 2: {
                return 2.0f * playerAvatarDescriptor.b;
            }
            default: {
                return 0.0f;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setSphereShape(@ScriptID final Integer key, final float b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.q = W94.SPHERE;
        playerAvatarDescriptor.b = b;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension1(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).e;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension2(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).h;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollMaxAngle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setLeftWheelPretransformZangle(@ScriptID final Integer key, final float bq) {
        PlayerAvatarDescriptor.i.get(key).j.bq = bq;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetRadius(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).b;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMass(@ScriptID final Integer key, final float l) {
        PlayerAvatarDescriptor.i.get(key).l = l;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetLowEndSteeringFullLockAngle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ar;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setInAirGravity(@ScriptID final Integer key, final float n) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        if (n >= 0.0) {
            PlayerAvatarDescriptor.logger.warn("lua::SetInAirGravity(): gravity should be negative. Supplied value: {}", n);
        }
        playerAvatarDescriptor.w = n;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getInAirGravity(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).w;
    }
    
    public static RotTrans r(final PlayerAvatarDescriptor playerAvatarDescriptor, final PlayerPhysicsAvatar playerPhysicsAvatar) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            return RotTrans.g;
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getOnWallGravityMultiplier(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).r;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFriction(@ScriptID final Integer key, final float v) {
        PlayerAvatarDescriptor.i.get(key).v = v;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetFriction(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).v;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchSpeed(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.i;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetRestitution(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).y;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVerticalInertiaScale(@ScriptID final Integer key, final float n) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.p = playerAvatarDescriptor.p.an(n);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setInertiaScalesRelativeToShape(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).p = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleTopSpeedInReverse(@ScriptID final Integer key, final float ah) {
        PlayerAvatarDescriptor.i.get(key).j.ah = ah;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setStepHeight(@ScriptID final Integer key, final float x) {
        PlayerAvatarDescriptor.i.get(key).x = x;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetStepHeight(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).x;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createCharacterControllerDescriptor(@ScriptID final Integer n) {
        PlayerAvatarDescriptor.i.put(n, new PlayerAvatarDescriptor(J93.CHARACTERCONTROLLER));
        PlayerAvatarDescriptor.o.put(n, 1);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionStrengths(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bb;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxJumpSlope(@ScriptID final Integer key, final float z) {
        PlayerAvatarDescriptor.i.get(key).z = z;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollStrength(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.t;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMinSlideSlope(@ScriptID final Integer key, final float t) {
        PlayerAvatarDescriptor.i.get(key).t = t;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMinSlideSlope(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).t;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionStiffness(@ScriptID final Integer key, final float d) {
        PlayerAvatarDescriptor.i.get(key).j.d = d;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionStiffness(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setCapsuleYShape(@ScriptID final Integer key, final float e, final float b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.q = W94.CAPSULE_Y;
        playerAvatarDescriptor.e = e;
        playerAvatarDescriptor.b = b;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionCompression(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionDamping(@ScriptID final Integer key, final float j) {
        PlayerAvatarDescriptor.i.get(key).j.j = j;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionDamping(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.j;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxSuspensionForce(@ScriptID final Integer key, final float e) {
        PlayerAvatarDescriptor.i.get(key).j.e = e;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaxSuspensionForce(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.e;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaximumBrakingForce(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ak;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionRestLength(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.h;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelSpinRateOnSkid(@ScriptID final Integer key, final float s) {
        PlayerAvatarDescriptor.i.get(key).j.s = s;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelSpinRateOnSkid(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.s;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxSuspensionTravel(@ScriptID final Integer key, final float n) {
        PlayerAvatarDescriptor.i.get(key).j.b = n * 100.0f;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaxSuspensionTravel(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : (playerAvatarDescriptor.j.b / 100.0f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelFrictions(@ScriptID final Integer key, final float l, final float w, final float v, final float y, @ScriptDefaults(defaultNumber = 1.0) final float r, @ScriptDefaults(defaultNumber = 1.0) final float p7) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.l = l;
        playerAvatarDescriptor.j.w = w;
        playerAvatarDescriptor.j.r = r;
        playerAvatarDescriptor.j.v = v;
        playerAvatarDescriptor.j.y = y;
        playerAvatarDescriptor.j.p = p7;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontForwardToLateralFrictionRatio(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).j.r;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearForwardToLateralFrictionRatio(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).j.p;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelFriction(@ScriptID final Integer key, final boolean b, final boolean b2) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        if (b) {
            if (b2) {
                return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.w;
            }
            return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.y;
        }
        else {
            if (b2) {
                return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.l;
            }
            return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.v;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxTorqueAtLowSpeed(@ScriptID final Integer key, final float aq) {
        PlayerAvatarDescriptor.i.get(key).j.aq = aq;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMaxJumpSlope(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).z;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelRadius(@ScriptID final Integer key, final float x) {
        PlayerAvatarDescriptor.i.get(key).j.x = x;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelRadius(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.x;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelWidth(@ScriptID final Integer key, final float u) {
        PlayerAvatarDescriptor.i.get(key).j.u = u;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelWidth(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.u;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleRollInfluence(@ScriptID final Integer key, final float z) {
        PlayerAvatarDescriptor.i.get(key).j.z = z;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setExtraAngularPitchVelocityOnTransformation(@ScriptID final Integer key, final float be) {
        PlayerAvatarDescriptor.i.get(key).j.be = be;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetMaxTorqueAtLowSpeed(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.aq;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setActivationHandler(@ScriptID final Integer key, final EventHandler n) {
        PlayerAvatarDescriptor.i.get(key).n = n;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBlendSpeedToVertical(@ScriptID final Integer key, final float bz) {
        PlayerAvatarDescriptor.i.get(key).j.bz = bz;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchStrength(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.k;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollSpeed(@ScriptID final Integer key, final float m) {
        PlayerAvatarDescriptor.i.get(key).j.m = m;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollSpeed(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.m;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRestitution(@ScriptID final Integer key, final float y) {
        PlayerAvatarDescriptor.i.get(key).y = y;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 GetInertiaScaleRelativeToShape(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).p;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionRestLength(@ScriptID final Integer key, final float h) {
        PlayerAvatarDescriptor.i.get(key).j.h = h;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleMaxAngularVelocity(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bv;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchMaxAngle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.o;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionLimits_hard(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bt;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointX(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.a;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleReverseAccelerationAtSpeed(@ScriptID final Integer key, final float value, final float value2) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.af.add(new Float(value));
        playerAvatarDescriptor.j.av.add(new Float(value2));
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointZ(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.c;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleEnginePower(@ScriptID final Integer key, final float ag) {
        PlayerAvatarDescriptor.i.get(key).j.ag = ag;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleEnginePower(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void VehicleAccelerationCurve_Clear(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.al.clear();
        playerAvatarDescriptor.j.ai.clear();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleAccelerationAtSpeed(@ScriptID final Integer key, final float value, final float value2) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.ai.add(new Float(value));
        playerAvatarDescriptor.j.al.add(new Float(value2));
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleGraphicsPivotOffset(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bm = Vector3.g(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAccelerationCurve_Acceleration(@ScriptID final Integer key, final int index) {
        return PlayerAvatarDescriptor.i.get(key).j.ai.get(index);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAccelerationCurve_Speed(@ScriptID final Integer key, final int index) {
        return PlayerAvatarDescriptor.i.get(key).j.al.get(index);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionLimits(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bi;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void VehicleReverseAccelerationCurve_Clear(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.av.clear();
        playerAvatarDescriptor.j.af.clear();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleTopSpeedInReverse(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ah;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleReverseAccelerationCurve_Acceleration(@ScriptID final Integer key, final int index) {
        return PlayerAvatarDescriptor.i.get(key).j.af.get(index);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleReverseAccelerationCurve_Speed(@ScriptID final Integer key, final int index) {
        return PlayerAvatarDescriptor.i.get(key).j.av.get(index);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchStrength(@ScriptID final Integer key, final float k) {
        PlayerAvatarDescriptor.i.get(key).j.k = k;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleRollingFriction(@ScriptID final Integer key, final float ac) {
        PlayerAvatarDescriptor.i.get(key).j.ac = ac;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleDrivingAxles(@ScriptID final Integer key, final boolean ap, final boolean ao) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.ap = ap;
        playerAvatarDescriptor.j.ao = ao;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean AxleIsDriving(@ScriptID final Integer key, final boolean b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return playerAvatarDescriptor.j != null && (b ? playerAvatarDescriptor.j.ap : playerAvatarDescriptor.j.ao);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBrakingAxles(@ScriptID final Integer key, final boolean aa, final boolean an) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.aa = aa;
        playerAvatarDescriptor.j.an = an;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean AxleIsBraking(@ScriptID final Integer key, final boolean b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return playerAvatarDescriptor.j != null && (b ? playerAvatarDescriptor.j.aa : playerAvatarDescriptor.j.an);
    }
    
    public PlayerAvatarDescriptor(final PlayerAvatarDescriptor playerAvatarDescriptor) {
        this.d = null;
        this.q = null;
        this.j = null;
        this.b = 0.0f;
        this.w = -29.41995f;
        this.r = 1.0f;
        this.v = 0.0f;
        this.y = 0.3f;
        this.p = new Vector3(1.0f, 1.0f, 1.0f);
        this.x = 0.0f;
        this.u = (float)Math.toRadians(45.0);
        this.z = (float)Math.toRadians(45.0);
        this.t = (float)Math.toRadians(30.0);
        this.m = null;
        this.n = null;
        this.d = playerAvatarDescriptor.d;
        this.q = playerAvatarDescriptor.q;
        this.e = playerAvatarDescriptor.e;
        this.h = playerAvatarDescriptor.h;
        this.s = playerAvatarDescriptor.s;
        this.b = playerAvatarDescriptor.b;
        this.l = playerAvatarDescriptor.l;
        this.w = playerAvatarDescriptor.w;
        this.r = playerAvatarDescriptor.r;
        this.y = playerAvatarDescriptor.y;
        this.v = playerAvatarDescriptor.v;
        this.p = playerAvatarDescriptor.p;
        this.x = playerAvatarDescriptor.x;
        this.u = playerAvatarDescriptor.u;
        this.z = playerAvatarDescriptor.z;
        this.t = playerAvatarDescriptor.t;
        if (playerAvatarDescriptor.j != null) {
            this.j = new B45(playerAvatarDescriptor.j);
        }
        this.m = playerAvatarDescriptor.m;
        this.n = playerAvatarDescriptor.n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean AxleIsHandBraking(@ScriptID final Integer key, final boolean b) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return playerAvatarDescriptor.j != null && (b ? playerAvatarDescriptor.j.am : playerAvatarDescriptor.j.as);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setupDumbDownSkiddingEffect(@ScriptID final Integer key, final float at, final float ab) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.at = at;
        playerAvatarDescriptor.j.ab = ab;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleRollInfluence(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.z;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bu;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setWheelFrictionConstraintStabilityTweak(@ScriptID final Integer key, final float aw) {
        PlayerAvatarDescriptor.i.get(key).j.aw = aw;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearAxlePretransformYangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bk;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleTopSpeed(@ScriptID final Integer key, final float az) {
        PlayerAvatarDescriptor.i.get(key).j.az = az;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointY(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleInertiaContactResolutionScale(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.by;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionCompression(@ScriptID final Integer key, final float q) {
        PlayerAvatarDescriptor.i.get(key).j.q = q;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setOnWallGravityMultiplier(@ScriptID final Integer key, final float n) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        if (n < 1.0f) {
            PlayerAvatarDescriptor.logger.warn("lua::SetOnWallGravityMultiplier(): OnWallGravityMultiplier should be >= 1. Supplied value: {}", n);
        }
        playerAvatarDescriptor.r = n;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfMassOffset(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.ay = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfMassOffset(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.ay;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfWheelsOffset(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.ae = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfMassOffsetY(@ScriptID final Integer key, final float n) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.ay = playerAvatarDescriptor.j.ay.an(n);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfShapeOffset(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.ad = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMassContactResolutionScale(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bx;
    }
    
    public static RotTrans s(final PlayerAvatarDescriptor playerAvatarDescriptor, RotTrans l, final boolean b) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            final I48 r = I48.r(playerAvatarDescriptor.j.ay);
            if (b) {
                I48.o(r, playerAvatarDescriptor.j.ad);
            }
            I48.t(r);
            I48.al(r, l.rot);
            l = l.l(r);
            I48.y(r);
        }
        return l;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 GetVehicleLocalAngularDampings(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bn;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetWheelFrictionConstraintStabilityTweak(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.aw;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleMaxLinearVelocity(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.br;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxAngularVelocity(@ScriptID final Integer key, final float bv) {
        PlayerAvatarDescriptor.i.get(key).j.bv = bv;
        q(key);
    }
    
    E6 e(final DiscreteDynamicsWorld discreteDynamicsWorld) {
        switch (Al95.g[this.q.ordinal()]) {
            case 1: {
                if (this.d == J93.VEHICLE && Vector3.f(this.j.ay) > 0.01) {
                    final Vector3 z = Vector3.z(Vector3.x(this.j.ay), this.j.ad);
                    final float f = 0.0f;
                    PlayerAvatarDescriptor.logger.debug("creating offset compound shape for avatar. offset :{} additionally rounding by {}", z, f);
                    return discreteDynamicsWorld.r(new E6[] { discreteDynamicsWorld.e(this.e - f, this.h - f, this.s - f, this.b + f) }, new Q7[] { new Q7(M47.g, z) });
                }
                return discreteDynamicsWorld.e(this.e, this.h, this.s, this.b);
            }
            case 3: {
                return discreteDynamicsWorld.j(1, this.b, this.e);
            }
            case 2: {
                return discreteDynamicsWorld.q(this.b);
            }
            default: {
                return null;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxWalkSlope(@ScriptID final Integer key, final float u) {
        PlayerAvatarDescriptor.i.get(key).u = u;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleContactResolutionScales(@ScriptID final Integer key, final float bx, final float by) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.bx = bx;
        playerAvatarDescriptor.j.by = by;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleAxlePoint(@ScriptID final Integer key, final float a, final float f, final float c) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.a = a;
        playerAvatarDescriptor.j.f = f;
        playerAvatarDescriptor.j.c = c;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getLeftWheelPretransformZangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bq;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRightWheelPretransformZangle(@ScriptID final Integer key, final float bo) {
        PlayerAvatarDescriptor.i.get(key).j.bo = bo;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRightWheelPretransformZangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bo;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFrontAxlePretransformXangle(@ScriptID final Integer key, final float bl) {
        PlayerAvatarDescriptor.i.get(key).j.bl = bl;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontAxlePretransformXangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bl;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFrontAxlePretransformYangle(@ScriptID final Integer key, final float bw) {
        PlayerAvatarDescriptor.i.get(key).j.bw = bw;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontAxlePretransformYangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bw;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRearAxlePretransformXangle(@ScriptID final Integer key, final float bj) {
        PlayerAvatarDescriptor.i.get(key).j.bj = bj;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearAxlePretransformXangle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bj;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRearAxlePretransformYangle(@ScriptID final Integer key, final float bk) {
        PlayerAvatarDescriptor.i.get(key).j.bk = bk;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsBody(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).d == J93.BODY;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setSteeringScale(@ScriptID final Integer key, final float bh) {
        PlayerAvatarDescriptor.i.get(key).j.bh = bh;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getSteeringScale(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bh;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollMaxAngle(@ScriptID final Integer key, final float n) {
        PlayerAvatarDescriptor.i.get(key).j.n = n;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getForkLeanAngle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bp;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDumbDownSkiddingEffectAngleRatio(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ab;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMiddleWhellOffsetFromRear(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bd;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSteeringCharacteristics(@ScriptID final Integer key, final float ar, final float ax, final float au, final float aj) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.ar = ar;
        playerAvatarDescriptor.j.ax = ax;
        playerAvatarDescriptor.j.au = au;
        playerAvatarDescriptor.j.aj = aj;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetHighEndSteeringSpeed(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ax;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetHighEndSteeringFullLockAngle(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.au;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetSteeringChangeRate(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.aj;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBrakingCharacteristics(@ScriptID final Integer key, final float ak) {
        PlayerAvatarDescriptor.i.get(key).j.ak = ak;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsVehicle(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).d == J93.VEHICLE;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLeanAmount(@ScriptID final Integer key, final float bf) {
        PlayerAvatarDescriptor.i.get(key).j.bf = bf;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleLeanAmount(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null || Float.isNaN(playerAvatarDescriptor.j.bf)) ? 0.0f : playerAvatarDescriptor.j.bf;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAngularDampings(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bn = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDumbDownSkiddingEffectStrength(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.at;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMass(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).l;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionLimits_hard(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bt = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int GetVehicleReverseAccelerationCurve_NumPoints(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).j.af.size();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleBlendSpeedToVertical(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bz;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBlendSpeedToSurface(@ScriptID final Integer key, final float bc) {
        PlayerAvatarDescriptor.i.get(key).j.bc = bc;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleBlendSpeedToSurface(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.bc;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMiddleWhellOffsetFromRear(@ScriptID final Integer key, final float bd) {
        PlayerAvatarDescriptor.i.get(key).j.bd = bd;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bg = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bu = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bg;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfShapeOffset(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.ad;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setBikeVerticalDisplacementOnLean(@ScriptID final Integer n, final float n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionStrengths(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bb = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionStrengths_hard(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.ba = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchSpeed(@ScriptID final Integer key, final float i) {
        PlayerAvatarDescriptor.i.get(key).j.i = i;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionStrengths_hard(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.ba;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createVehicleDescriptor(@ScriptID final Integer n) {
        final PlayerAvatarDescriptor value = new PlayerAvatarDescriptor(J93.VEHICLE);
        value.j = new B45();
        PlayerAvatarDescriptor.i.put(n, value);
        PlayerAvatarDescriptor.o.put(n, 1);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getExtraAngularPitchVelocityOnTransformation(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.be;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setControlHandler(@ScriptID final Integer n, final EventHandler m) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(n);
        if (PlayerAvatarDescriptor.k.add(n)) {
            PlayerAvatarDescriptor.logger.debug("NEW DESCRIPTOR HASH: " + n);
        }
        playerAvatarDescriptor.m = m;
        q(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleHandBrakingAxles(@ScriptID final Integer key, final boolean am, final boolean as) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        playerAvatarDescriptor.j.am = am;
        playerAvatarDescriptor.j.as = as;
        q(key);
    }
    
    public static PlayerAvatarDescriptor g(final int i) {
        return PlayerAvatarDescriptor.i.get(i);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchMaxAngle(@ScriptID final Integer key, final float o) {
        PlayerAvatarDescriptor.i.get(key).j.o = o;
        q(key);
    }
    
    static void q(final int n) {
        Integer value = PlayerAvatarDescriptor.o.get(n);
        if (value == null) {
            value = 0;
        }
        PlayerAvatarDescriptor.o.put(n, value + 1);
    }
    
    public static PlayerAvatarDescriptor j(final int i, final int n) {
        final PlayerAvatarDescriptor value = new PlayerAvatarDescriptor(PlayerAvatarDescriptor.i.get(i));
        PlayerAvatarDescriptor.i.put(n, value);
        PlayerAvatarDescriptor.o.put(n, 1);
        return value;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfWheelsOffset(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.ae;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionLimits(@ScriptID final Integer key, final float n, final float n2, final float n3) {
        PlayerAvatarDescriptor.i.get(key).j.bi = new Vector3(n, n2, n3);
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension3(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).s;
    }
    
    public static RotTrans b(final PlayerAvatarDescriptor playerAvatarDescriptor, final RotTrans rotTrans) {
        return s(playerAvatarDescriptor, rotTrans, false);
    }
    
    public static RotTrans l(final PlayerAvatarDescriptor playerAvatarDescriptor, RotTrans b) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            b = b.b(Vector3.al(playerAvatarDescriptor.j.ay, b.rot));
        }
        return b;
    }
    
    public static Q7 w(final PlayerAvatarDescriptor playerAvatarDescriptor, Q7 e) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            e = e.e(Vector3.af(playerAvatarDescriptor.j.ay, e.d));
        }
        return e;
    }
    
    public static float v(final PlayerAvatarDescriptor playerAvatarDescriptor, final PlayerPhysicsAvatar playerPhysicsAvatar) {
        if (playerPhysicsAvatar != null && playerPhysicsAvatar.q != null && playerPhysicsAvatar.d != null && playerPhysicsAvatar.d.d != null) {
            final Quaternion q = playerPhysicsAvatar.q.as().q();
            return (float)Math.atan(Vector3.o(playerPhysicsAvatar.q.l(), Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), q)) * (Vector3.o(playerPhysicsAvatar.q.w(), Vector3.al(Vector3.g(0.0f, 1.0f, 0.0f), q)) * playerAvatarDescriptor.j.bf) / Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsAvatar.d.d)));
        }
        return 0.0f;
    }
    
    static {
        logger = LoggerFactory.getLogger(PlayerAvatarDescriptor.class);
        PlayerAvatarDescriptor.k = new HashSet();
        i = new HashMap();
        o = new HashMap();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setForkLeanAngle(@ScriptID final Integer key, final float bp) {
        PlayerAvatarDescriptor.i.get(key).j.bp = bp;
        q(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getAabbFullSize(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        switch (Al95.g[playerAvatarDescriptor.q.ordinal()]) {
            case 1: {
                return new Vector3(2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.e), 2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.h), 2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.s));
            }
            case 2: {
                return new Vector3(2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b);
            }
            case 3: {
                return new Vector3(2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b + playerAvatarDescriptor.h, 2.0f * playerAvatarDescriptor.b);
            }
            default: {
                return null;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int GetVehicleAccelerationCurve_NumPoints(@ScriptID final Integer key) {
        return PlayerAvatarDescriptor.i.get(key).j.ai.size();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleRollingFriction(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.ac;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleGraphicsPivotOffset(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? Vector3.g : playerAvatarDescriptor.j.bm;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleTopSpeed(@ScriptID final Integer key) {
        final PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.i.get(key);
        return (playerAvatarDescriptor.j == null) ? 0.0f : playerAvatarDescriptor.j.az;
    }
}
