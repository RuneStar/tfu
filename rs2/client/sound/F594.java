/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.D564;
import fmod.E245;
import fmod.X243;
import java.util.ArrayList;
import rs2.client.ScriptCamera;
import rs2.client.sound.Af685;
import rs2.client.sound.G593;
import rs2.client.sound.SoundManager;

public class F594 {
    public static final int d = 1;
    public static final int g = 0;
    private static final ArrayList m;
    private static final ArrayList t;
    private static float u;
    private static int x;
    private static float z;
    public D564 b;
    public String e;
    public String h = "";
    public String j;
    public float l = 1.0f;
    public boolean p = false;
    public Vector3 q;
    public float r = 500.0f;
    public X243 s;
    public float v = 1000.0f;
    public int w;
    public boolean y = false;

    static /* synthetic */ float b(float f) {
        z = f;
        return z;
    }

    public static synchronized ArrayList g() {
        return t;
    }

    public static void d(F594 f594) {
        t.add(f594);
    }

    public static void j() {
        u += (z - u) * 0.01f;
        if (SoundManager.c != null) {
            ScriptCamera scriptCamera;
            if (t.size() == 0) {
                return;
            }
            if (x >= t.size()) {
                x = 0;
            }
            F594 f594 = (F594)t.get(x);
            if (f594.w == 0 && (scriptCamera = ScriptCamera.getActiveCamera()) != null) {
                float f = Vector3.f(Vector3.k(f594.q, scriptCamera.getWorldTransform().trans));
                if (f594.s == null) {
                    X243 x243;
                    if (f <= f594.v && X243.h(x243 = SoundManager.c.r(f594.j, 4))) {
                        X243.t(x243, f594.r, f594.v);
                        X243.av(x243, 16, 2097152);
                        X243.i(x243, f594.l * u);
                        x243.z(f594.q.x, f594.q.y, f594.q.z);
                        f594.p = X243.al(x243, 14) == 16;
                        f594.s = E245.v(SoundManager.c, f594.j);
                        if (X243.h(f594.s)) {
                            f594.s.a();
                        } else {
                            f594.s = null;
                        }
                    }
                } else if (f > f594.v) {
                    X243.c(f594.s);
                    f594.s = null;
                }
                if (f594.s != null && X243.y(f594.s) && !f594.p) {
                    float f2;
                    if (f >= f594.v) {
                        f2 = 0.0f;
                    } else if (f <= f594.r) {
                        f2 = 1.0f;
                    } else {
                        f = (f - f594.r) / (f594.v - f594.r);
                        f2 = 1.0f - f;
                    }
                    X243.i(f594.s, f2 * u);
                    f594.s.ag("space", f);
                }
            }
            ++x;
        }
    }

    public static void e() {
        F594.q();
    }

    public static void h(String string) {
        Af685 af685 = new Af685();
        G593.g(string + ".dat", 100000L, false, af685, null);
    }

    static /* synthetic */ float s(float f) {
        u = f;
        return u;
    }

    public static void q() {
        for (Object object : t) {
            if (((F594)object).s == null) continue;
            X243.c(((F594)object).s);
        }
        t.clear();
        for (Object object : m) {
            D564.q((D564)object, false);
            D564.d((D564)object);
        }
        m.clear();
    }

    static /* synthetic */ ArrayList l() {
        return m;
    }

    static {
        x = 0;
        u = 0.0f;
        z = 1.0f;
        t = new ArrayList();
        m = new ArrayList();
    }

    public F594(Vector3 vector3, String string) {
        this.q = vector3;
        this.j = string;
        String[] arrstring = string.split("/");
        if (arrstring.length > 0) {
            this.e = arrstring[arrstring.length - 1];
        }
    }
}

