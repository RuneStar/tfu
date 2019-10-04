/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.D564;
import fmod.K560;
import fmod.M249;
import fmod.Q244;
import fmod.U240;
import fmod.X243;
import fmod.Z256;
import fmod.fmod;
import tfu.Lb33;

public class E245 {
    private long g = 0L;

    public static int s(E245 e245, int n, long l, int n2) {
        return e245.g != 0L ? fmod.EventSystem_init(e245.g, n, l, n2) : 0;
    }

    public M249 g(int n) {
        return this.g != 0L ? new M249(fmod.EventSystem_getCategoryByIndex(this.g, n)) : null;
    }

    public static M249[] d(E245 e245) {
        if (e245.g == 0L) {
            return null;
        }
        int n = E245.j(e245);
        M249[] arrm249 = new M249[n];
        for (int i = 0; i < n; ++i) {
            arrm249[i] = e245.g(i);
        }
        return arrm249;
    }

    public U240 q() {
        return this.g != 0L ? new U240(fmod.EventSystem_getSystemObject(this.g)) : null;
    }

    public E245(long l) {
        this.g = l;
    }

    public static int e(E245 e245) {
        return e245.g != 0L ? fmod.EventSystem_getNumProjects(e245.g) : 0;
    }

    public Z256 w(byte[] arrby) {
        return this.g != 0L ? new Z256(fmod.EventSystem_loadFromMemory(this.g, arrby)) : new Z256(0L);
    }

    public static int l(E245 e245, String string) {
        return e245.g != 0L ? fmod.EventSystem_setMediaPath(e245.g, string) : 0;
    }

    public X243 r(String string, int n) {
        X243 x243;
        Lb33.g(Lb33.Fmod_getEvent);
        try {
            if (string == null || this.g == 0L) {
                X243 x2432 = new X243(0L);
                Lb33.d(Lb33.Fmod_getEvent);
                return x2432;
            }
            x243 = new X243(fmod.EventSystem_getEvent(this.g, string, n));
            x243.n = fmod.EventSystem_getEvent(this.g, string, 4);
            x243.aq = string;
            x243.al = this;
            x243.af = n;
            x243.ai = string;
            x243.az = false;
            if (n != 4 && x243.m == -1L) {
                String[] arrstring = this.n(string);
                if (arrstring != null) {
                    for (String string2 : arrstring) {
                        fmod.e.g(string2);
                    }
                }
                X243.e(x243);
            }
            Lb33.d(Lb33.Fmod_getEvent);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.Fmod_getEvent);
            throw throwable;
        }
        return x243;
    }

    public X243 y(String string, Q244 q244) {
        if (this.g == 0L) {
            return new X243(0L);
        }
        X243 x243 = E245.v(this, string);
        if (q244 != null) {
            X243.u(x243, q244);
        }
        if (X243.h(x243)) {
            x243.az = true;
            x243.a();
        }
        return x243;
    }

    public X243 p(String string, float f, float f2, float f3) {
        return this.g != 0L ? this.y(string, new Q244(f, f2, f3)) : new X243(0L);
    }

    public static int u(E245 e245, int n, Q244 q244, Q244 q2442, Q244 q2443, Q244 q2444) {
        return e245.g != 0L ? fmod.EventSystem_set3DListenerAttributes(e245.g, n, q244.g, q244.d, q244.q, q2442.g, q2442.d, q2442.q, q2443.g, q2443.d, q2443.q, q2444.g, q2444.d, q2444.q) : 0;
    }

    public X243 x(String string, int n) {
        X243 x243;
        if (string == null) {
            return new X243(0L);
        }
        X243 x2432 = x243 = this.g != 0L ? E245.v(this, string) : new X243(0L);
        if (x243.m != 0L) {
            x243.az = true;
            x243.a();
        }
        return x243;
    }

    public static void t(E245 e245) {
        Lb33.g(Lb33.FmodEventSystem);
        try {
            if (e245.g != 0L) {
                fmod.EventSystem_update(e245.g);
            }
            Lb33.d(Lb33.FmodEventSystem);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.FmodEventSystem);
            throw throwable;
        }
    }

    public Z256 h(int n) {
        return this.g != 0L ? new Z256(fmod.EventSystem_getProjectByIndex(this.g, n)) : null;
    }

    public static Z256[] m(E245 e245) {
        if (e245.g == 0L) {
            return null;
        }
        int n = E245.e(e245);
        Z256[] arrz256 = new Z256[n];
        for (int i = 0; i < n; ++i) {
            arrz256[i] = e245.h(i);
        }
        return arrz256;
    }

    public String[] n(String string) {
        if (this.g == 0L) {
            return new String[0];
        }
        String string2 = fmod.EventSystem_getWaveBanksNeeded(this.g, string);
        if (string2 != null) {
            String[] arrstring = string2.split("\\|");
            int n = 0;
            while (n < arrstring.length) {
                String[] arrstring2 = arrstring;
                int n2 = n++;
                arrstring2[n2] = arrstring2[n2] + ".fsb";
            }
            return arrstring;
        }
        return null;
    }

    public D564 z(String string) {
        if (this.g == 0L) {
            return new D564(0L);
        }
        long l = fmod.EventSystem_create3dReverb(this.g, string);
        D564 d564 = new D564(l);
        d564.d = string;
        return d564;
    }

    public static int b(E245 e245) {
        return e245.g != 0L ? fmod.EventSystem_release(e245.g) : 0;
    }

    public static X243 v(E245 e245, String string) {
        return e245.r(string, 0);
    }

    public static int j(E245 e245) {
        return e245.g != 0L ? fmod.EventSystem_getNumCategories(e245.g) : 0;
    }
}

