/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.H46;
import com.jagex.maths.Vector3;

public class CameraController
extends CollisionObject {
    private final E6 g;

    CameraController(long l, E6 e6, DiscreteDynamicsWorld discreteDynamicsWorld, int n, int n2, Object object) {
        super(l, discreteDynamicsWorld, e6, n, n2, object);
        this.g = e6;
    }

    private static native boolean nativeSetDesiredLocation(long var0, long var2, float var4, float var5, float var6);

    public void h(float f) {
        long l = this.b.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeSetCameraRadius(long var0, long var2, float var4);

    public boolean e(Vector3 vector3) {
        if (this.b.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        boolean bl = false;
        H46.q();
        this.ap();
        bl = CameraController.nativeSetDesiredLocation(this.s, this.b.d, vector3.x, vector3.y, vector3.z);
        H46.j();
        return bl;
    }
}

