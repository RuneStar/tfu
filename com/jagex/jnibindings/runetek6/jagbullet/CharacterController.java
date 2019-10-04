/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.D194;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterController
extends CollisionObject {
    private static final ByteBuffer j;
    private static final Logger logger;
    public static final int q;
    private final E6 d;

    public void b(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    CharacterController(long l, E6 e6, DiscreteDynamicsWorld discreteDynamicsWorld, int n, int n2, Object object) {
        super(l, discreteDynamicsWorld, e6, n, n2, object);
        this.d = e6;
    }

    public Vector3 h() {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void l(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetMaxWalkSlope(long var0, long var2, float var4);

    private static native void nativeSetMaxJumpSlope(long var0, long var2, float var4);

    public void r(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetMinSlideSlope(long var0, long var2, float var4);

    public void w(boolean bl) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetCanBePushedByCc(long var0, long var2, boolean var4);

    public void s(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeJump(long var0, long var2, float var4, float var5);

    private static native void nativeGetWalkPerFrame(long var0, long var2, float[] var4);

    private static native void nativeSetVerticalVelocity(long var0, long var2, float var4);

    public float y() {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native float nativeGetVerticalVelocity(long var0, long var2);

    private static native int nativeGetRequiredDynamicStatePacketSize();

    public boolean p() {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeIsTouchingGround(long var0, long var2);

    public boolean x() {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public boolean u(D194 d194, float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeGetLandingPredicition(long var0, long var2, float[] var4, float var5, float var6, int var7);

    public void z(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetYGravity(long var0, long var2, float var4);

    static {
        logger = LoggerFactory.getLogger(CharacterController.class);
        q = CharacterController.nativeGetRequiredDynamicStatePacketSize();
        j = ByteBuffer.allocateDirect(q);
    }

    public void e(Vector3 vector3) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void v(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetWalkPerFrame(long var0, long var2, float var4, float var5, float var6);
}

