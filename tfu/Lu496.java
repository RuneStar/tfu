/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.DrawUtilities;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.List;

public class Lu496 {
    public static int e;
    public static int j;
    private int d = -65536;
    private List g = new ArrayList();
    private boolean q = true;

    public static void s(Lu496 lu496, boolean bl) {
        lu496.q = bl;
    }

    public static boolean h(Lu496 lu496) {
        return lu496.q;
    }

    public static void e(Lu496 lu496, int n) {
        lu496.d = n;
    }

    private static void q(Lu496 lu496, Vector3 vector3, Vector3 vector32, int n) {
        DrawUtilities.drawLine(vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, (float)((n & 0xFF0000) >> 16) / 255.0f, (float)((n & 0xFF00) >> 8) / 255.0f, (float)((n & 0xFF) >> 0) / 255.0f);
    }

    public static int j(Lu496 lu496) {
        return lu496.d;
    }

    public static void d(Lu496 lu496) {
        Vector3 vector3;
        Vector3 vector32 = vector3 = (Vector3)Lu496.g(lu496).get(0);
        for (int i = 1; i < lu496.g.size(); ++i) {
            Vector3 vector33 = (Vector3)Lu496.g(lu496).get(i);
            Lu496.q(lu496, vector32, vector33, Lu496.j(lu496));
            vector32 = vector33;
        }
        if (Lu496.h(lu496)) {
            Lu496.q(lu496, vector32, vector3, Lu496.j(lu496));
        }
    }

    public static void b(int n, int n2) {
        j = n;
        e = n2;
    }

    static {
        j = 0;
        e = 0;
    }

    public static List g(Lu496 lu496) {
        return lu496.g;
    }
}

