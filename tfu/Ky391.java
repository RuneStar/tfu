// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ky391
{
    public Ky391 b;
    public Ky391 s;
    
    public static void g(final Ky391 ky391) {
        if (ky391.b == null) {
            return;
        }
        ky391.b.s = ky391.s;
        ky391.s.b = ky391.b;
        ky391.s = null;
        ky391.b = null;
    }
}
