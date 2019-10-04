// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.E41;
import org.slf4j.LoggerFactory;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import org.slf4j.Logger;

public class CollisionObject implements G119
{
    private static final Logger logger;
    private static final boolean u = true;
    public final DiscreteDynamicsWorld b;
    private boolean h;
    public final E6 l;
    private final ByteBuffer p;
    private int r;
    public final long s;
    private int v;
    public Object w;
    public int x;
    protected final float[] y;
    
    public void ap() {
        if (this.b.q[(int)this.s] == null) {
            if (nativeIsValid(this.s, this.b.d)) {
                CollisionObject.logger.error("Grab Eugene if this fires.");
                throw new RuntimeException("Grab Eugene if this fires.");
            }
            CollisionObject.logger.error("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
            throw new RuntimeException("!!!Outdated reference to a collision object - on native side the CO does not exist. Probably reset() of physics world has happened but java/lua references to this CO were not invalidated.");
        }
        else if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
    }
    
    public Vector3 an() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject.logger.info("!!!Outdated reference to a collision object. Retruning identity position.");
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
        CollisionObject.logger.info("!!!Outdated reference to a collision object. Returning an identity transform.");
        return Q7.q;
    }
    
    private static native void nativeGetTransform(final long p0, final long p1, final float[] p2);
    
    public M47 as() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject.logger.info("!!!Outdated reference to a collision object. Retruning identity orientation.");
        return M47.g;
    }
    
    protected native void nativeSetTransform(final long p0, final long p1, final float[] p2);
    
    public void aa(final Q7 q7) {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject.logger.info("!!!Outdated reference to a collision object. Doing nothing in setTransform().");
    }
    
    private static native boolean nativeIsValid(final long p0, final long p1);
    
    public void ac(final M47 m47) {
        this.aa(new Q7(m47, this.an()));
    }
    
    public CollisionObject(final long s, final DiscreteDynamicsWorld b, final E6 l, final int r, final int v, final Object w) {
        this.h = false;
        this.y = new float[12];
        this.p = ByteBuffer.allocateDirect(1024);
        this.x = -1;
        this.s = s;
        this.b = b;
        this.l = l;
        this.r = r;
        this.v = v;
        this.w = w;
    }
    
    private static native void nativeGetAabb(final long p0, final long p1, final float[] p2);
    
    @Override
    public void g() {
        synchronized (this) {
            this.h = true;
        }
    }
    
    public void am(final Vector3 vector3) {
        this.aa(new Q7(this.as(), vector3));
    }
    
    static {
        logger = LoggerFactory.getLogger(CollisionObject.class);
    }
    
    public E41 at() {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        CollisionObject.logger.info("!!!Outdated reference to a collision object. Retruning random aabbox.");
        return null;
    }
    
    public static int ab(final CollisionObject collisionObject) {
        return collisionObject.v;
    }
}
