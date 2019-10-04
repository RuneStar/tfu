// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.Vector3;

public class CameraController extends CollisionObject
{
    private final E6 g;
    
    CameraController(final long n, final E6 g, final DiscreteDynamicsWorld discreteDynamicsWorld, final int n2, final int n3, final Object o) {
        super(n, discreteDynamicsWorld, g, n2, n3, o);
        this.g = g;
    }
    
    private static native boolean nativeSetDesiredLocation(final long p0, final long p1, final float p2, final float p3, final float p4);
    
    public void h(final float n) {
        super.b.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeSetCameraRadius(final long p0, final long p1, final float p2);
    
    public boolean e(final Vector3 vector3) {
        if (super.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        H46.q();
        this.ap();
        final boolean nativeSetDesiredLocation = nativeSetDesiredLocation(super.s, super.b.d, vector3.x, vector3.y, vector3.z);
        H46.j();
        return nativeSetDesiredLocation;
    }
}
