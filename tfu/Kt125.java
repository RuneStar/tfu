// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Kt125
{
    private static Ks126 g;
    
    public static boolean q() {
        return Kt125.g != null;
    }
    
    public static void g(final Ks126 g) {
        if (Kt125.g != null) {
            throw new IllegalStateException("Duplicate NativeLibraryRegistry initialisation!");
        }
        Kt125.g = g;
    }
    
    public static Ks126 d() {
        if (Kt125.g == null) {
            throw new IllegalStateException("NativeLibraryRegistry not initialised!");
        }
        return Kt125.g;
    }
}
