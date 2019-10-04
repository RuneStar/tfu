// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.maths.Vector3;

public class Av190
{
    public final float d;
    public final Vector3 g;
    public final int j;
    public final float q;
    
    public static boolean g(final Av190 av190, final Av190 av191) {
        return av191 != null && Vector3.v(av190.g, av191.g) && av190.d == av191.d && av190.j == av191.j && av190.q == av191.q;
    }
    
    public Av190(final Vector3 g, final float d, final int j, final float q) {
        this.g = g;
        this.d = d;
        this.j = j;
        this.q = q;
    }
}
