// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.ArrayList;
import com.jagex.jnibindings.runetek6.DrawUtilities;
import com.jagex.maths.Vector3;
import java.util.List;

public class Lu496
{
    public static int e;
    public static int j;
    private int d;
    private List g;
    private boolean q;
    
    public static void s(final Lu496 lu496, final boolean q) {
        lu496.q = q;
    }
    
    public static boolean h(final Lu496 lu496) {
        return lu496.q;
    }
    
    public static void e(final Lu496 lu496, final int d) {
        lu496.d = d;
    }
    
    private static void q(final Lu496 lu496, final Vector3 vector3, final Vector3 vector4, final int n) {
        DrawUtilities.drawLine(vector3.x, vector3.y, vector3.z, vector4.x, vector4.y, vector4.z, ((n & 0xFF0000) >> 16) / 255.0f, ((n & 0xFF00) >> 8) / 255.0f, ((n & 0xFF) >> 0) / 255.0f);
    }
    
    public static int j(final Lu496 lu496) {
        return lu496.d;
    }
    
    public Lu496() {
        this.g = new ArrayList();
        this.d = -65536;
        this.q = true;
    }
    
    public static void d(final Lu496 lu496) {
        Vector3 vector4;
        final Vector3 vector3 = vector4 = g(lu496).get(0);
        for (int i = 1; i < lu496.g.size(); ++i) {
            final Vector3 vector5 = g(lu496).get(i);
            q(lu496, vector4, vector5, j(lu496));
            vector4 = vector5;
        }
        if (h(lu496)) {
            q(lu496, vector4, vector3, j(lu496));
        }
    }
    
    public static void b(final int j, final int e) {
        Lu496.j = j;
        Lu496.e = e;
    }
    
    static {
        Lu496.j = 0;
        Lu496.e = 0;
    }
    
    public static List g(final Lu496 lu496) {
        return lu496.g;
    }
}
