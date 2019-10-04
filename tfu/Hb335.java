// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Hb335
{
    private Ky391 d;
    public Ky391 g;
    
    public static void g(final Hb335 hb335) {
        while (true) {
            final Ky391 s = hb335.g.s;
            if (s == hb335.g) {
                break;
            }
            Ky391.g(s);
        }
        hb335.d = null;
    }
    
    public static void d(final Hb335 hb335, final Ky391 ky391) {
        if (ky391.b != null) {
            Ky391.g(ky391);
        }
        ky391.b = hb335.g.b;
        ky391.s = hb335.g;
        ky391.b.s = ky391;
        ky391.s.b = ky391;
    }
    
    public Hb335() {
        this.g = new Ky391();
        this.g.s = this.g;
        this.g.b = this.g;
    }
}
