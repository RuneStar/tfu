// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.I48;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;

public class RigidBody extends CollisionObject
{
    private static ByteBuffer g;
    public final E6 d;
    private final float[] j;
    public final float q;
    private final ByteBuffer z;
    
    private static native void nativeGetVelocities(final long p0, final long p1, final float[] p2);
    
    public void r(final Vector3 vector3) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void e(final I48 i48, final I48 i49) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void h(final Vector3 vector3, final Vector3 vector4) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetVelocities(final long p0, final long p1, final float[] p2);
    
    public static void s(final RigidBody rigidBody, final Vector3 vector3) {
        rigidBody.h(vector3, rigidBody.w());
    }
    
    public Vector3 l() {
        final I48 i48 = new I48();
        this.e(i48, null);
        return i48.ao();
    }
    
    public Vector3 w() {
        final I48 i48 = new I48();
        this.e(null, i48);
        return i48.ao();
    }
    
    private static native void nativeApplyCentralForce(final long p0, final long p1, final float p2, final float p3, final float p4);
    
    public void v(final Vector3 vector3) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeApplyTorque(final long p0, final long p1, final float p2, final float p3, final float p4);
    
    @Override
    protected native void nativeSetTransform(final long p0, final long p1, final float[] p2);
    
    public static void y(final RigidBody rigidBody) {
        rigidBody.b.o(rigidBody);
    }
    
    public static void p(final RigidBody rigidBody) {
        rigidBody.b.a(rigidBody);
    }
    
    public static boolean x(final RigidBody rigidBody) {
        return rigidBody.b.f(rigidBody);
    }
    
    static {
        RigidBody.g = null;
    }
    
    public static void b(final RigidBody rigidBody, final Vector3 vector3) {
        rigidBody.h(rigidBody.l(), vector3);
    }
    
    RigidBody(final long n, final DiscreteDynamicsWorld discreteDynamicsWorld, final E6 d, final int n2, final int n3, final Object o, final float q) {
        super(n, discreteDynamicsWorld, d, n2, n3, o);
        this.j = new float[7];
        this.z = ByteBuffer.allocateDirect(1024);
        this.d = d;
        this.q = q;
    }
}
