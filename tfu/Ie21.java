/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public enum Ie21 {
    SPHERE(1),
    BOX(2),
    CONVEX_2D_POLYGON(3),
    CAPSULE(4),
    CONVEX_HULL(5),
    GENERIC_STATIC_MESH(6),
    GENERIC_STATIC_MESH_INTERNAL(7);
    
    public final int b;

    private Ie21(int n2) {
        this.b = n2;
    }

    public static Ie21 g(int n) {
        for (Ie21 ie21 : Ie21.values()) {
            if (ie21.b != n) continue;
            return ie21;
        }
        return null;
    }
}

