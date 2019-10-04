// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import org.slf4j.LoggerFactory;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import java.nio.ByteBuffer;

public class CharacterController extends CollisionObject
{
    private static final ByteBuffer j;
    private static final Logger logger;
    public static final int q;
    private final E6 d;
    
    public void b(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    CharacterController(final long n, final E6 d, final DiscreteDynamicsWorld discreteDynamicsWorld, final int n2, final int n3, final Object o) {
        super(n, discreteDynamicsWorld, d, n2, n3, o);
        this.d = d;
    }
    
    public Vector3 h() {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void l(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetMaxWalkSlope(final long p0, final long p1, final float p2);
    
    private static native void nativeSetMaxJumpSlope(final long p0, final long p1, final float p2);
    
    public void r(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetMinSlideSlope(final long p0, final long p1, final float p2);
    
    public void w(final boolean b) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetCanBePushedByCc(final long p0, final long p1, final boolean p2);
    
    public void s(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeJump(final long p0, final long p1, final float p2, final float p3);
    
    private static native void nativeGetWalkPerFrame(final long p0, final long p1, final float[] p2);
    
    private static native void nativeSetVerticalVelocity(final long p0, final long p1, final float p2);
    
    public float y() {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native float nativeGetVerticalVelocity(final long p0, final long p1);
    
    private static native int nativeGetRequiredDynamicStatePacketSize();
    
    public boolean p() {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeIsTouchingGround(final long p0, final long p1);
    
    public boolean x() {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public boolean u(final D194 d194, final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeGetLandingPredicition(final long p0, final long p1, final float[] p2, final float p3, final float p4, final int p5);
    
    public void z(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetYGravity(final long p0, final long p1, final float p2);
    
    static {
        logger = LoggerFactory.getLogger(CharacterController.class);
        q = nativeGetRequiredDynamicStatePacketSize();
        j = ByteBuffer.allocateDirect(CharacterController.q);
    }
    
    public void e(final Vector3 vector3) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void v(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetWalkPerFrame(final long p0, final long p1, final float p2, final float p3, final float p4);
}
