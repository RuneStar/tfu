/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulletVehicle {
    private static ByteBuffer h;
    private static final Logger logger;
    public float b = 0.0f;
    public final long d;
    public final RigidBody e;
    public final B45 j;
    public float l = 0.0f;
    public float p = 0.0f;
    public final DiscreteDynamicsWorld q;
    public float r = 0.1f;
    public Vector3 s = new Vector3(0.0f, 0.0f, 0.0f);
    public float[] u = null;
    public float v = 1.0f;
    public float w = 1.0f;
    public float x = 0.0f;
    public float y = 0.1f;

    public void x(float f) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public static int g(BulletVehicle bulletVehicle) {
        return bulletVehicle.j.g;
    }

    public void d(float f, float f2, boolean bl, float f3) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetOnWallGravityMultiplier(long var0, long var2, float var4);

    private static native void nativeControl(long var0, long var2, float var4, float var5, boolean var6, float var7);

    public Q7 j(int n) {
        M47 m47 = new M47(this.u[12 + n * 21 + 12], this.u[12 + n * 21 + 15], this.u[12 + n * 21 + 18], this.u[12 + n * 21 + 13], this.u[12 + n * 21 + 16], this.u[12 + n * 21 + 19], this.u[12 + n * 21 + 14], this.u[12 + n * 21 + 17], this.u[12 + n * 21 + 20]);
        Vector3 vector3 = new Vector3(this.u[12 + n * 21 + 0], this.u[12 + n * 21 + 1], this.u[12 + n * 21 + 2]);
        return new Q7(m47, vector3);
    }

    public boolean e(int n) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeGetWheelIsTouchingGround(long var0, long var2, int var4);

    public float h(int n) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public static Vector3 l(BulletVehicle bulletVehicle, int n) {
        Q7 q7 = bulletVehicle.q(n);
        return Vector3.i(q7.g, 0.0f, bulletVehicle.j.x, 0.0f);
    }

    public float s(int n) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetInducedDriftEffect(long var0, long var2, float var4);

    public float b(int n) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native float nativeGetWheelSlipSpeed(long var0, long var2, int var4);

    private static native float nativeGetWheelSuspensionCompression(long var0, long var2, int var4);

    public void r(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeGetWheelContactNormal(long var0, long var2, long var4, float[] var6);

    private static native void nativeSetOrientationCorrectionLimits(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

    public void v(I48 i48) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetOrientationCorrectionReferenceVector(long var0, long var2, float var4, float var5, float var6);

    public void y(float f, float f2, float f3) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetCarDesiredOrientations(long var0, long var2, float var4, float var5, float var6);

    public void p(float f) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetOrientationCorrectionStrengths(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12);

    public void n(float f, float f2) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void w(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void u(float f) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetLateralFrictionMultiplier(long var0, long var2, float var4);

    public void z(float f) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void t(float f) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetFrictionDissipationReduction(long var0, long var2, float var4);

    public Vector3 m(int n) {
        long l = this.q.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native float nativeGetWheelSlipStatus(long var0, long var2, int var4);

    public Q7 q(int n) {
        M47 m47 = new M47(this.u[12 + n * 21 + 3], this.u[12 + n * 21 + 6], this.u[12 + n * 21 + 9], this.u[12 + n * 21 + 4], this.u[12 + n * 21 + 7], this.u[12 + n * 21 + 10], this.u[12 + n * 21 + 5], this.u[12 + n * 21 + 8], this.u[12 + n * 21 + 11]);
        Vector3 vector3 = new Vector3(this.u[12 + n * 21 + 0], this.u[12 + n * 21 + 1], this.u[12 + n * 21 + 2]);
        return new Q7(m47, vector3);
    }

    private static native void nativeSetWheelTransformVisualModifiers(long var0, long var2, float var4, float var5);

    private static native void nativeSetInAirGravityY(long var0, long var2, float var4);

    static {
        logger = LoggerFactory.getLogger(BulletVehicle.class);
        h = null;
    }

    public BulletVehicle(long l, DiscreteDynamicsWorld discreteDynamicsWorld, B45 b45, RigidBody rigidBody) {
        this.d = l;
        this.q = discreteDynamicsWorld;
        this.j = b45;
        this.e = rigidBody;
        this.u = new float[12 + 21 * BulletVehicle.g(this)];
    }
}

