/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.G119;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.E41;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollisionObject
implements G119 {
    private static final Logger logger = LoggerFactory.getLogger(CollisionObject.class);
    private static final boolean u = true;
    public final DiscreteDynamicsWorld b;
    private boolean h = false;
    public final E6 l;
    private final ByteBuffer p;
    private int r;
    public final long s;
    private int v;
    public Object w;
    public int x = -1;
    protected final float[] y = new float[12];

    public void ap() {
        if (this.b.q[(int)this.s] == null) {
            if (CollisionObject.nativeIsValid(this.s, this.b.d)) {
                logger.error("Grab Eugene if this fires.");
                throw new RuntimeException("Grab Eugene if this fires.");
            }
            String string = "!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.";
            logger.error("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
            throw new RuntimeException("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
        }
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
    }

    public Vector3 an() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject collisionObject = this;
        logger.info("!!!Outdated reference to a collision object. Retruning identity position.");
        return Vector3.g;
    }

    @Override
    public boolean d() {
        return this.h;
    }

    public Q7 ao() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject collisionObject = this;
        logger.info("!!!Outdated reference to a collision object. Returning an identity transform.");
        return Q7.q;
    }

    private static native void nativeGetTransform(long var0, long var2, float[] var4);

    public M47 as() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject collisionObject = this;
        logger.info("!!!Outdated reference to a collision object. Retruning identity orientation.");
        return M47.g;
    }

    protected native void nativeSetTransform(long var1, long var3, float[] var5);

    public void aa(Q7 q7) {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject collisionObject = this;
        logger.info("!!!Outdated reference to a collision object. Doing nothing in setTransform().");
    }

    private static native boolean nativeIsValid(long var0, long var2);

    public void ac(M47 m47) {
        Q7 q7 = new Q7(m47, this.an());
        this.aa(q7);
    }

    public CollisionObject(long l, DiscreteDynamicsWorld discreteDynamicsWorld, E6 e6, int n, int n2, Object object) {
        this.p = ByteBuffer.allocateDirect(1024);
        this.s = l;
        this.b = discreteDynamicsWorld;
        this.l = e6;
        this.r = n;
        this.v = n2;
        this.w = object;
    }

    private static native void nativeGetAabb(long var0, long var2, float[] var4);

    @Override
    public void g() {
        CollisionObject collisionObject = this;
        synchronized (collisionObject) {
            this.h = true;
        }
    }

    public void am(Vector3 vector3) {
        Q7 q7 = new Q7(this.as(), vector3);
        this.aa(q7);
    }

    public E41 at() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject collisionObject = this;
        logger.info("!!!Outdated reference to a collision object. Retruning random aabbox.");
        return null;
    }

    public static int ab(CollisionObject collisionObject) {
        return collisionObject.v;
    }
}

