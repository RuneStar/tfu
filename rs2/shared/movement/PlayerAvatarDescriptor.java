/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.J93;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.W94;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="PlayerPhysicsAvatarDescriptor")
public class PlayerAvatarDescriptor {
    public static final HashMap i;
    static Set k;
    private static final Logger logger;
    public static final HashMap o;
    public float b = 0.0f;
    public J93 d = null;
    public float e;
    public float h;
    public B45 j = null;
    public float l;
    public EventHandler m = null;
    public EventHandler n = null;
    public Vector3 p = new Vector3(1.0f, 1.0f, 1.0f);
    public W94 q = null;
    public float r = 1.0f;
    public float s;
    public float t;
    public float u = (float)Math.toRadians(45.0);
    public float v = 0.0f;
    public float w = -29.41995f;
    public float x = 0.0f;
    public float y = 0.3f;
    public float z = (float)Math.toRadians(45.0);

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMaxWalkSlope(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.u;
    }

    private PlayerAvatarDescriptor(J93 j93) {
        this.t = (float)Math.toRadians(30.0);
        this.d = j93;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(3000);
        stringBuilder.append("\n=============\n");
        stringBuilder.append("type: ");
        stringBuilder.append((Object)this.d);
        stringBuilder.append("\nshapeType: ");
        stringBuilder.append((Object)this.q);
        stringBuilder.append("\ndimension: ");
        stringBuilder.append(this.e);
        stringBuilder.append(" ");
        stringBuilder.append(this.h);
        stringBuilder.append(" ");
        stringBuilder.append(this.s);
        stringBuilder.append(" ");
        stringBuilder.append(this.b);
        stringBuilder.append("\nmass: ");
        stringBuilder.append(this.l);
        stringBuilder.append("\ninAirGravityY: ");
        stringBuilder.append(this.w);
        stringBuilder.append("\nonWallGravityMultiplier: ");
        stringBuilder.append(this.r);
        stringBuilder.append("\nfriction: ");
        stringBuilder.append(this.v);
        stringBuilder.append("\nrestitution: ");
        stringBuilder.append(this.y);
        stringBuilder.append("\ninertiaScaleRelativeToShape: ");
        stringBuilder.append(this.p);
        stringBuilder.append("\nstepHeight: ");
        stringBuilder.append(this.x);
        stringBuilder.append("\nmaxWalkSlopeRadians: ");
        stringBuilder.append(this.u);
        stringBuilder.append("\nmaxJumpSlopeRadians: ");
        stringBuilder.append(this.z);
        stringBuilder.append("\nminSlideSlopeRadians: ");
        stringBuilder.append(this.t);
        if (this.j != null) {
            stringBuilder.append("\n------------");
            stringBuilder.append(this.j.toString());
        }
        stringBuilder.append("\n=============");
        return stringBuilder.toString();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createBodyDescriptor(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = new PlayerAvatarDescriptor(J93.BODY);
        i.put(n, playerAvatarDescriptor);
        o.put(n, 1);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxLinearVelocity(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.br = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsCharacterController(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.d == J93.CHARACTERCONTROLLER;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollStrength(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.t = f;
        PlayerAvatarDescriptor.q(n);
    }

    public static int d(int n) {
        Integer n2 = (Integer)o.get(n);
        if (n2 == null) {
            return 0;
        }
        return n2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void CreateDuplicateDescriptor(@ScriptID Integer n, @ScriptID Integer n2) {
        PlayerAvatarDescriptor.j(n, n2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setBoxShape(@ScriptID Integer n, float f, float f2, float f3, @ScriptDefaults(defaultNumber=0.0) float f4) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.q = W94.BOX;
        playerAvatarDescriptor.e = f;
        playerAvatarDescriptor.h = f2;
        playerAvatarDescriptor.s = f3;
        playerAvatarDescriptor.b = f4;
        PlayerAvatarDescriptor.q(n);
    }

    public static float h(PlayerAvatarDescriptor playerAvatarDescriptor) {
        switch (playerAvatarDescriptor.q) {
            case BOX: {
                return 2.0f * playerAvatarDescriptor.h + 2.0f * playerAvatarDescriptor.b;
            }
            case CAPSULE_Y: {
                return playerAvatarDescriptor.e + 2.0f * playerAvatarDescriptor.b;
            }
            case SPHERE: {
                return 2.0f * playerAvatarDescriptor.b;
            }
        }
        return 0.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setSphereShape(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.q = W94.SPHERE;
        playerAvatarDescriptor.b = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension1(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.e;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension2(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.h;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollMaxAngle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setLeftWheelPretransformZangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bq = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetRadius(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.b;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMass(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.l = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetLowEndSteeringFullLockAngle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ar;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setInAirGravity(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        if ((double)f >= 0.0) {
            logger.warn("lua::SetInAirGravity(): gravity should be negative. Supplied value: {}", Float.valueOf(f));
        }
        playerAvatarDescriptor.w = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getInAirGravity(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.w;
    }

    public static RotTrans r(PlayerAvatarDescriptor playerAvatarDescriptor, PlayerPhysicsAvatar playerPhysicsAvatar) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            return RotTrans.g;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getOnWallGravityMultiplier(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.r;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFriction(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.v = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetFriction(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.v;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchSpeed(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.i;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetRestitution(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.y;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVerticalInertiaScale(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.p = playerAvatarDescriptor.p.an(f);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setInertiaScalesRelativeToShape(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.p = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleTopSpeedInReverse(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ah = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setStepHeight(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.x = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetStepHeight(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.x;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createCharacterControllerDescriptor(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = new PlayerAvatarDescriptor(J93.CHARACTERCONTROLLER);
        i.put(n, playerAvatarDescriptor);
        o.put(n, 1);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionStrengths(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bb;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxJumpSlope(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.z = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollStrength(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.t;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMinSlideSlope(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.t = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMinSlideSlope(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.t;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionStiffness(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.d = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionStiffness(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.d;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setCapsuleYShape(@ScriptID Integer n, float f, float f2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.q = W94.CAPSULE_Y;
        playerAvatarDescriptor.e = f;
        playerAvatarDescriptor.b = f2;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionCompression(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.q;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionDamping(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.j = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionDamping(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.j;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxSuspensionForce(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.e = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaxSuspensionForce(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.e;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaximumBrakingForce(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ak;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleSuspensionRestLength(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.h;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelSpinRateOnSkid(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.s = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelSpinRateOnSkid(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.s;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxSuspensionTravel(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.b = f * 100.0f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMaxSuspensionTravel(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.b / 100.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelFrictions(@ScriptID Integer n, float f, float f2, float f3, float f4, @ScriptDefaults(defaultNumber=1.0) float f5, @ScriptDefaults(defaultNumber=1.0) float f6) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.l = f;
        playerAvatarDescriptor.j.w = f2;
        playerAvatarDescriptor.j.r = f5;
        playerAvatarDescriptor.j.v = f3;
        playerAvatarDescriptor.j.y = f4;
        playerAvatarDescriptor.j.p = f6;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontForwardToLateralFrictionRatio(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j.r;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearForwardToLateralFrictionRatio(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j.p;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelFriction(@ScriptID Integer n, boolean bl, boolean bl2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        if (bl) {
            if (bl2) {
                return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.w;
            }
            return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.y;
        }
        if (bl2) {
            return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.l;
        }
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.v;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxTorqueAtLowSpeed(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.aq = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMaxJumpSlope(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.z;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelRadius(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.x = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelRadius(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.x;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleWheelWidth(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.u = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleWheelWidth(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.u;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleRollInfluence(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.z = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setExtraAngularPitchVelocityOnTransformation(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.be = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetMaxTorqueAtLowSpeed(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.aq;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setActivationHandler(@ScriptID Integer n, EventHandler eventHandler) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.n = eventHandler;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBlendSpeedToVertical(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bz = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchStrength(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.k;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollSpeed(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.m = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualRollSpeed(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.m;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRestitution(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.y = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 GetInertiaScaleRelativeToShape(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.p;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionRestLength(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.h = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleMaxAngularVelocity(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bv;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleVisualPitchMaxAngle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.o;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionLimits_hard(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bt;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointX(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.a;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleReverseAccelerationAtSpeed(@ScriptID Integer n, float f, float f2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.af.add(new Float(f));
        playerAvatarDescriptor.j.av.add(new Float(f2));
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointZ(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.c;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleEnginePower(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ag = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleEnginePower(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ag;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void VehicleAccelerationCurve_Clear(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.al.clear();
        playerAvatarDescriptor.j.ai.clear();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleAccelerationAtSpeed(@ScriptID Integer n, float f, float f2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ai.add(new Float(f));
        playerAvatarDescriptor.j.al.add(new Float(f2));
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleGraphicsPivotOffset(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bm = Vector3.g(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAccelerationCurve_Acceleration(@ScriptID Integer n, int n2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return ((Float)playerAvatarDescriptor.j.ai.get(n2)).floatValue();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAccelerationCurve_Speed(@ScriptID Integer n, int n2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return ((Float)playerAvatarDescriptor.j.al.get(n2)).floatValue();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionLimits(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bi;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void VehicleReverseAccelerationCurve_Clear(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.av.clear();
        playerAvatarDescriptor.j.af.clear();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleTopSpeedInReverse(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ah;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleReverseAccelerationCurve_Acceleration(@ScriptID Integer n, int n2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return ((Float)playerAvatarDescriptor.j.af.get(n2)).floatValue();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleReverseAccelerationCurve_Speed(@ScriptID Integer n, int n2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return ((Float)playerAvatarDescriptor.j.av.get(n2)).floatValue();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchStrength(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.k = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleRollingFriction(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ac = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleDrivingAxles(@ScriptID Integer n, boolean bl, boolean bl2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ap = bl;
        playerAvatarDescriptor.j.ao = bl2;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean AxleIsDriving(@ScriptID Integer n, boolean bl) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? false : (bl ? playerAvatarDescriptor.j.ap : playerAvatarDescriptor.j.ao);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBrakingAxles(@ScriptID Integer n, boolean bl, boolean bl2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.aa = bl;
        playerAvatarDescriptor.j.an = bl2;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean AxleIsBraking(@ScriptID Integer n, boolean bl) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? false : (bl ? playerAvatarDescriptor.j.aa : playerAvatarDescriptor.j.an);
    }

    public PlayerAvatarDescriptor(PlayerAvatarDescriptor playerAvatarDescriptor) {
        this.t = (float)Math.toRadians(30.0);
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
    public static boolean AxleIsHandBraking(@ScriptID Integer n, boolean bl) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? false : (bl ? playerAvatarDescriptor.j.am : playerAvatarDescriptor.j.as);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setupDumbDownSkiddingEffect(@ScriptID Integer n, float f, float f2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.at = f;
        playerAvatarDescriptor.j.ab = f2;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleRollInfluence(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.z;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bu;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setWheelFrictionConstraintStabilityTweak(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.aw = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearAxlePretransformYangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bk;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleTopSpeed(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.az = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleAxlePointY(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleInertiaContactResolutionScale(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.by;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSuspensionCompression(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.q = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setOnWallGravityMultiplier(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        if (f < 1.0f) {
            logger.warn("lua::SetOnWallGravityMultiplier(): OnWallGravityMultiplier should be >= 1. Supplied value: {}", Float.valueOf(f));
        }
        playerAvatarDescriptor.r = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfMassOffset(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ay = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfMassOffset(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.ay;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfWheelsOffset(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ae = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfMassOffsetY(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ay = playerAvatarDescriptor.j.ay.an(f);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleCentreOfShapeOffset(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ad = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleMassContactResolutionScale(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bx;
    }

    public static RotTrans s(PlayerAvatarDescriptor playerAvatarDescriptor, RotTrans rotTrans, boolean bl) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            I48 i48 = I48.r(playerAvatarDescriptor.j.ay);
            if (bl) {
                I48.o(i48, playerAvatarDescriptor.j.ad);
            }
            I48.t(i48);
            I48.al(i48, rotTrans.rot);
            rotTrans = rotTrans.l(i48);
            I48.y(i48);
        }
        return rotTrans;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 GetVehicleLocalAngularDampings(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bn;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetWheelFrictionConstraintStabilityTweak(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.aw;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleMaxLinearVelocity(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.br;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleMaxAngularVelocity(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bv = f;
        PlayerAvatarDescriptor.q(n);
    }

    E6 e(DiscreteDynamicsWorld discreteDynamicsWorld) {
        switch (this.q) {
            case BOX: {
                if (this.d == J93.VEHICLE && (double)Vector3.f(this.j.ay) > 0.01) {
                    Vector3 vector3 = Vector3.z(Vector3.x(this.j.ay), this.j.ad);
                    float f = 0.0f;
                    logger.debug("creating offset compound shape for avatar. offset :{} additionally rounding by {}", vector3, (Object)Float.valueOf(f));
                    E6 e6 = discreteDynamicsWorld.r(new E6[]{discreteDynamicsWorld.e(this.e - f, this.h - f, this.s - f, this.b + f)}, new Q7[]{new Q7(M47.g, vector3)});
                    return e6;
                }
                return discreteDynamicsWorld.e(this.e, this.h, this.s, this.b);
            }
            case CAPSULE_Y: {
                return discreteDynamicsWorld.j(1, this.b, this.e);
            }
            case SPHERE: {
                return discreteDynamicsWorld.q(this.b);
            }
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMaxWalkSlope(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.u = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleContactResolutionScales(@ScriptID Integer n, float f, float f2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bx = f;
        playerAvatarDescriptor.j.by = f2;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleAxlePoint(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.a = f;
        playerAvatarDescriptor.j.f = f2;
        playerAvatarDescriptor.j.c = f3;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getLeftWheelPretransformZangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bq;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRightWheelPretransformZangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bo = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRightWheelPretransformZangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bo;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFrontAxlePretransformXangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bl = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontAxlePretransformXangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setFrontAxlePretransformYangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bw = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getFrontAxlePretransformYangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bw;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRearAxlePretransformXangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bj = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getRearAxlePretransformXangle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bj;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setRearAxlePretransformYangle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bk = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsBody(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.d == J93.BODY;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setSteeringScale(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bh = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getSteeringScale(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bh;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualRollMaxAngle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.n = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getForkLeanAngle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bp;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDumbDownSkiddingEffectAngleRatio(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ab;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMiddleWhellOffsetFromRear(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bd;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleSteeringCharacteristics(@ScriptID Integer n, float f, float f2, float f3, float f4) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ar = f;
        playerAvatarDescriptor.j.ax = f2;
        playerAvatarDescriptor.j.au = f3;
        playerAvatarDescriptor.j.aj = f4;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetHighEndSteeringSpeed(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ax;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetHighEndSteeringFullLockAngle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.au;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetSteeringChangeRate(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.aj;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBrakingCharacteristics(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ak = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsVehicle(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.d == J93.VEHICLE;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLeanAmount(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bf = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleLeanAmount(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null || Float.isNaN(playerAvatarDescriptor.j.bf) ? 0.0f : playerAvatarDescriptor.j.bf;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAngularDampings(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bn = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDumbDownSkiddingEffectStrength(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.at;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getMass(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.l;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionLimits_hard(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bt = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int GetVehicleReverseAccelerationCurve_NumPoints(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j.af.size();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleBlendSpeedToVertical(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bz;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleBlendSpeedToSurface(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bc = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getVehicleBlendSpeedToSurface(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.bc;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setMiddleWhellOffsetFromRear(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bd = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bg = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bu = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bg;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfShapeOffset(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.ad;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setBikeVerticalDisplacementOnLean(@ScriptID Integer n, float f) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionStrengths(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bb = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionStrengths_hard(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.ba = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchSpeed(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.i = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleOrientationCorrectionStrengths_hard(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.ba;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void createVehicleDescriptor(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = new PlayerAvatarDescriptor(J93.VEHICLE);
        playerAvatarDescriptor.j = new B45();
        i.put(n, playerAvatarDescriptor);
        o.put(n, 1);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getExtraAngularPitchVelocityOnTransformation(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.be;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setControlHandler(@ScriptID Integer n, EventHandler eventHandler) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        if (k.add(n)) {
            logger.debug("NEW DESCRIPTOR HASH: " + n);
        }
        playerAvatarDescriptor.m = eventHandler;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleHandBrakingAxles(@ScriptID Integer n, boolean bl, boolean bl2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.am = bl;
        playerAvatarDescriptor.j.as = bl2;
        PlayerAvatarDescriptor.q(n);
    }

    public static PlayerAvatarDescriptor g(int n) {
        return (PlayerAvatarDescriptor)i.get(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVehicleVisualPitchMaxAngle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.o = f;
        PlayerAvatarDescriptor.q(n);
    }

    static void q(int n) {
        Integer n2 = (Integer)o.get(n);
        if (n2 == null) {
            n2 = 0;
        }
        o.put(n, n2 + 1);
    }

    public static PlayerAvatarDescriptor j(int n, int n2) {
        PlayerAvatarDescriptor playerAvatarDescriptor = new PlayerAvatarDescriptor((PlayerAvatarDescriptor)i.get(n));
        i.put(n2, playerAvatarDescriptor);
        o.put(n2, 1);
        return playerAvatarDescriptor;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleCentreOfWheelsOffset(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.ae;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setVehicleOrientationCorrectionLimits(@ScriptID Integer n, float f, float f2, float f3) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bi = new Vector3(f, f2, f3);
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetDimension3(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.s;
    }

    public static RotTrans b(PlayerAvatarDescriptor playerAvatarDescriptor, RotTrans rotTrans) {
        return PlayerAvatarDescriptor.s(playerAvatarDescriptor, rotTrans, false);
    }

    public static RotTrans l(PlayerAvatarDescriptor playerAvatarDescriptor, RotTrans rotTrans) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            Vector3 vector3 = Vector3.al(playerAvatarDescriptor.j.ay, rotTrans.rot);
            rotTrans = rotTrans.b(vector3);
        }
        return rotTrans;
    }

    public static Q7 w(PlayerAvatarDescriptor playerAvatarDescriptor, Q7 q7) {
        if (playerAvatarDescriptor.d == J93.VEHICLE) {
            Vector3 vector3 = Vector3.af(playerAvatarDescriptor.j.ay, q7.d);
            q7 = q7.e(vector3);
        }
        return q7;
    }

    public static float v(PlayerAvatarDescriptor playerAvatarDescriptor, PlayerPhysicsAvatar playerPhysicsAvatar) {
        if (playerPhysicsAvatar != null && playerPhysicsAvatar.q != null && playerPhysicsAvatar.d != null && playerPhysicsAvatar.d.d != null) {
            Quaternion quaternion = playerPhysicsAvatar.q.as().q();
            Vector3 vector3 = playerPhysicsAvatar.q.l();
            Vector3 vector32 = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), quaternion);
            float f = Vector3.o(vector3, vector32);
            Vector3 vector33 = playerPhysicsAvatar.q.w();
            Vector3 vector34 = Vector3.al(Vector3.g(0.0f, 1.0f, 0.0f), quaternion);
            float f2 = Vector3.o(vector33, vector34) * playerAvatarDescriptor.j.bf;
            float f3 = Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsAvatar.d.d));
            float f4 = (float)Math.atan(f * f2 / f3);
            return f4;
        }
        return 0.0f;
    }

    static {
        logger = LoggerFactory.getLogger(PlayerAvatarDescriptor.class);
        k = new HashSet();
        i = new HashMap();
        o = new HashMap();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setForkLeanAngle(@ScriptID Integer n, float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        playerAvatarDescriptor.j.bp = f;
        PlayerAvatarDescriptor.q(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getAabbFullSize(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        switch (playerAvatarDescriptor.q) {
            case BOX: {
                return new Vector3(2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.e), 2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.h), 2.0f * (playerAvatarDescriptor.b + playerAvatarDescriptor.s));
            }
            case SPHERE: {
                return new Vector3(2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b);
            }
            case CAPSULE_Y: {
                return new Vector3(2.0f * playerAvatarDescriptor.b, 2.0f * playerAvatarDescriptor.b + playerAvatarDescriptor.h, 2.0f * playerAvatarDescriptor.b);
            }
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int GetVehicleAccelerationCurve_NumPoints(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j.ai.size();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleRollingFriction(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.ac;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getVehicleGraphicsPivotOffset(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? Vector3.g : playerAvatarDescriptor.j.bm;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float GetVehicleTopSpeed(@ScriptID Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor = (PlayerAvatarDescriptor)i.get(n);
        return playerAvatarDescriptor.j == null ? 0.0f : playerAvatarDescriptor.j.az;
    }
}

