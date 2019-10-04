/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.maths.I48;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;

public class RigidBody
extends CollisionObject {
    private static ByteBuffer g = null;
    public final E6 d;
    private final float[] j = new float[7];
    public final float q;
    private final ByteBuffer z = ByteBuffer.allocateDirect(1024);

    private static native void nativeGetVelocities(long var0, long var2, float[] var4);

    public void r(Vector3 vector3) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void e(I48 i48, I48 i482) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void h(Vector3 vector3, Vector3 vector32) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetVelocities(long var0, long var2, float[] var4);

    public static void s(RigidBody rigidBody, Vector3 vector3) {
        rigidBody.h(vector3, rigidBody.w());
    }

    public Vector3 l() {
        I48 i48 = new I48();
        this.e(i48, null);
        return i48.ao();
    }

    public Vector3 w() {
        I48 i48 = new I48();
        this.e(null, i48);
        return i48.ao();
    }

    private static native void nativeApplyCentralForce(long var0, long var2, float var4, float var5, float var6);

    public void v(Vector3 vector3) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeApplyTorque(long var0, long var2, float var4, float var5, float var6);

    @Override
    protected native void nativeSetTransform(long var1, long var3, float[] var5);

    public static void y(RigidBody rigidBody) {
        rigidBody.b.o(rigidBody);
    }

    public static void p(RigidBody rigidBody) {
        rigidBody.b.a(rigidBody);
    }

    public static boolean x(RigidBody rigidBody) {
        return rigidBody.b.f(rigidBody);
    }

    public static void b(RigidBody rigidBody, Vector3 vector3) {
        rigidBody.h(rigidBody.l(), vector3);
    }

    RigidBody(long l, DiscreteDynamicsWorld discreteDynamicsWorld, E6 e6, int n, int n2, Object object, float f) {
        super(l, discreteDynamicsWorld, e6, n, n2, object);
        this.d = e6;
        this.q = f;
    }
}

