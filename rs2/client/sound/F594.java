// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.util.Iterator;
import fmod.E245;
import rs2.client.ScriptCamera;
import fmod.X243;
import com.jagex.maths.Vector3;
import fmod.D564;
import java.util.ArrayList;

public class F594
{
    public static final int d = 1;
    public static final int g = 0;
    private static final ArrayList m;
    private static final ArrayList t;
    private static float u;
    private static int x;
    private static float z;
    public D564 b;
    public String e;
    public String h;
    public String j;
    public float l;
    public boolean p;
    public Vector3 q;
    public float r;
    public X243 s;
    public float v;
    public int w;
    public boolean y;
    
    public static synchronized ArrayList g() {
        return F594.t;
    }
    
    public static void d(final F594 e) {
        F594.t.add(e);
    }
    
    public static void j() {
        F594.u += (F594.z - F594.u) * 0.01f;
        if (SoundManager.c != null) {
            if (F594.t.size() == 0) {
                return;
            }
            if (F594.x >= F594.t.size()) {
                F594.x = 0;
            }
            final F594 f594 = F594.t.get(F594.x);
            if (f594.w == 0) {
                final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
                if (activeCamera != null) {
                    float f595 = Vector3.f(Vector3.k(f594.q, activeCamera.getWorldTransform().trans));
                    if (f594.s == null) {
                        if (f595 <= f594.v) {
                            final X243 r = SoundManager.c.r(f594.j, 4);
                            if (X243.h(r)) {
                                X243.t(r, f594.r, f594.v);
                                X243.av(r, 16, 2097152);
                                X243.i(r, f594.l * F594.u);
                                r.z(f594.q.x, f594.q.y, f594.q.z);
                                f594.p = (X243.al(r, 14) == 16);
                                f594.s = E245.v(SoundManager.c, f594.j);
                                if (X243.h(f594.s)) {
                                    f594.s.a();
                                }
                                else {
                                    f594.s = null;
                                }
                            }
                        }
                    }
                    else if (f595 > f594.v) {
                        X243.c(f594.s);
                        f594.s = null;
                    }
                    if (f594.s != null && X243.y(f594.s) && !f594.p) {
                        float n;
                        if (f595 >= f594.v) {
                            n = 0.0f;
                        }
                        else if (f595 <= f594.r) {
                            n = 1.0f;
                        }
                        else {
                            f595 = (f595 - f594.r) / (f594.v - f594.r);
                            n = 1.0f - f595;
                        }
                        X243.i(f594.s, n * F594.u);
                        f594.s.ag("space", f595);
                    }
                }
            }
            ++F594.x;
        }
    }
    
    public static void e() {
        q();
    }
    
    public static void h(final String str) {
        G593.g(str + ".dat", 100000L, false, new Af685(), null);
    }
    
    public static void q() {
        for (final F594 f594 : F594.t) {
            if (f594.s != null) {
                X243.c(f594.s);
            }
        }
        F594.t.clear();
        for (final D564 d564 : F594.m) {
            D564.q(d564, false);
            D564.d(d564);
        }
        F594.m.clear();
    }
    
    static {
        F594.x = 0;
        F594.u = 0.0f;
        F594.z = 1.0f;
        t = new ArrayList();
        m = new ArrayList();
    }
    
    public F594(final Vector3 q, final String j) {
        this.h = "";
        this.l = 1.0f;
        this.r = 500.0f;
        this.v = 1000.0f;
        this.y = false;
        this.p = false;
        this.q = q;
        this.j = j;
        final String[] split = j.split("/");
        if (split.length > 0) {
            this.e = split[split.length - 1];
        }
    }
}
