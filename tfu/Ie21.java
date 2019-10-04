// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Ie21
{
    BOX("BOX", 1, 2), 
    CONVEX_HULL("CONVEX_HULL", 4, 5), 
    SPHERE("SPHERE", 0, 1), 
    GENERIC_STATIC_MESH("GENERIC_STATIC_MESH", 5, 6), 
    CAPSULE("CAPSULE", 3, 4), 
    CONVEX_2D_POLYGON("CONVEX_2D_POLYGON", 2, 3), 
    GENERIC_STATIC_MESH_INTERNAL("GENERIC_STATIC_MESH_INTERNAL", 6, 7);
    
    public final int b;
    
    private Ie21(final String name, final int ordinal, final int b) {
        this.b = b;
    }
    
    public static Ie21 g(final int n) {
        for (final Ie21 ie21 : values()) {
            if (ie21.b == n) {
                return ie21;
            }
        }
        return null;
    }
}
