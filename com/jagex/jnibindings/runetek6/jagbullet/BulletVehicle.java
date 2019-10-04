// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import org.slf4j.LoggerFactory;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import java.nio.ByteBuffer;

public class BulletVehicle
{
    private static ByteBuffer h;
    private static final Logger logger;
    public float b;
    public final long d;
    public final RigidBody e;
    public final B45 j;
    public float l;
    public float p;
    public final DiscreteDynamicsWorld q;
    public float r;
    public Vector3 s;
    public float[] u;
    public float v;
    public float w;
    public float x;
    public float y;
    
    public void x(final float n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public static int g(final BulletVehicle bulletVehicle) {
        return bulletVehicle.j.g;
    }
    
    public void d(final float n, final float n2, final boolean b, final float n3) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetOnWallGravityMultiplier(final long p0, final long p1, final float p2);
    
    private static native void nativeControl(final long p0, final long p1, final float p2, final float p3, final boolean p4, final float p5);
    
    public Q7 j(final int n) {
        return new Q7(new M47(this.u[12 + n * 21 + 12], this.u[12 + n * 21 + 15], this.u[12 + n * 21 + 18], this.u[12 + n * 21 + 13], this.u[12 + n * 21 + 16], this.u[12 + n * 21 + 19], this.u[12 + n * 21 + 14], this.u[12 + n * 21 + 17], this.u[12 + n * 21 + 20]), new Vector3(this.u[12 + n * 21 + 0], this.u[12 + n * 21 + 1], this.u[12 + n * 21 + 2]));
    }
    
    public boolean e(final int n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeGetWheelIsTouchingGround(final long p0, final long p1, final int p2);
    
    public float h(final int n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public static Vector3 l(final BulletVehicle bulletVehicle, final int n) {
        return Vector3.i(bulletVehicle.q(n).g, 0.0f, bulletVehicle.j.x, 0.0f);
    }
    
    public float s(final int n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetInducedDriftEffect(final long p0, final long p1, final float p2);
    
    public float b(final int n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native float nativeGetWheelSlipSpeed(final long p0, final long p1, final int p2);
    
    private static native float nativeGetWheelSuspensionCompression(final long p0, final long p1, final int p2);
    
    public void r(final Vector3 vector3, final Vector3 vector4, final Vector3 vector5, final Vector3 vector6) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeGetWheelContactNormal(final long p0, final long p1, final long p2, final float[] p3);
    
    private static native void nativeSetOrientationCorrectionLimits(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13);
    
    public void v(final I48 i48) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetOrientationCorrectionReferenceVector(final long p0, final long p1, final float p2, final float p3, final float p4);
    
    public void y(final float n, final float n2, final float n3) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetCarDesiredOrientations(final long p0, final long p1, final float p2, final float p3, final float p4);
    
    public void p(final float n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetOrientationCorrectionStrengths(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10);
    
    public void n(final float n, final float n2) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void w(final Vector3 vector3, final Vector3 vector4, final Vector3 vector5) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void u(final float n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetLateralFrictionMultiplier(final long p0, final long p1, final float p2);
    
    public void z(final float n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void t(final float n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetFrictionDissipationReduction(final long p0, final long p1, final float p2);
    
    public Vector3 m(final int n) {
        this.q.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native float nativeGetWheelSlipStatus(final long p0, final long p1, final int p2);
    
    public Q7 q(final int n) {
        return new Q7(new M47(this.u[12 + n * 21 + 3], this.u[12 + n * 21 + 6], this.u[12 + n * 21 + 9], this.u[12 + n * 21 + 4], this.u[12 + n * 21 + 7], this.u[12 + n * 21 + 10], this.u[12 + n * 21 + 5], this.u[12 + n * 21 + 8], this.u[12 + n * 21 + 11]), new Vector3(this.u[12 + n * 21 + 0], this.u[12 + n * 21 + 1], this.u[12 + n * 21 + 2]));
    }
    
    private static native void nativeSetWheelTransformVisualModifiers(final long p0, final long p1, final float p2, final float p3);
    
    private static native void nativeSetInAirGravityY(final long p0, final long p1, final float p2);
    
    static {
        logger = LoggerFactory.getLogger(BulletVehicle.class);
        BulletVehicle.h = null;
    }
    
    public BulletVehicle(final long d, final DiscreteDynamicsWorld q, final B45 j, final RigidBody e) {
        this.s = new Vector3(0.0f, 0.0f, 0.0f);
        this.b = 0.0f;
        this.l = 0.0f;
        this.w = 1.0f;
        this.r = 0.1f;
        this.v = 1.0f;
        this.y = 0.1f;
        this.p = 0.0f;
        this.x = 0.0f;
        this.u = null;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.u = new float[12 + 21 * g(this)];
    }
}
