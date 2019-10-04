// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

import tfu.Lb33;

public class E245
{
    private long g;
    
    public static int s(final E245 e245, final int n, final long n2, final int n3) {
        return (e245.g != 0L) ? fmod.EventSystem_init(e245.g, n, n2, n3) : 0;
    }
    
    public M249 g(final int n) {
        return (this.g != 0L) ? new M249(fmod.EventSystem_getCategoryByIndex(this.g, n)) : null;
    }
    
    public static M249[] d(final E245 e245) {
        if (e245.g == 0L) {
            return null;
        }
        final int j = j(e245);
        final M249[] array = new M249[j];
        for (int i = 0; i < j; ++i) {
            array[i] = e245.g(i);
        }
        return array;
    }
    
    public U240 q() {
        return (this.g != 0L) ? new U240(fmod.EventSystem_getSystemObject(this.g)) : null;
    }
    
    public E245(final long g) {
        this.g = 0L;
        this.g = g;
    }
    
    public static int e(final E245 e245) {
        return (e245.g != 0L) ? fmod.EventSystem_getNumProjects(e245.g) : 0;
    }
    
    public Z256 w(final byte[] array) {
        return (this.g != 0L) ? new Z256(fmod.EventSystem_loadFromMemory(this.g, array)) : new Z256(0L);
    }
    
    public static int l(final E245 e245, final String s) {
        return (e245.g != 0L) ? fmod.EventSystem_setMediaPath(e245.g, s) : 0;
    }
    
    public X243 r(final String s, final int af) {
        Lb33.g(Lb33.Fmod_getEvent);
        X243 x243;
        try {
            if (s == null || this.g == 0L) {
                return new X243(0L);
            }
            x243 = new X243(fmod.EventSystem_getEvent(this.g, s, af));
            x243.n = fmod.EventSystem_getEvent(this.g, s, 4);
            x243.aq = s;
            x243.al = this;
            x243.af = af;
            x243.ai = s;
            x243.az = false;
            if (af != 4 && x243.m == -1L) {
                final String[] n = this.n(s);
                if (n != null) {
                    final String[] array = n;
                    for (int length = array.length, i = 0; i < length; ++i) {
                        fmod.e.g(array[i]);
                    }
                }
                X243.e(x243);
            }
        }
        finally {
            Lb33.d(Lb33.Fmod_getEvent);
        }
        return x243;
    }
    
    public X243 y(final String s, final Q244 q244) {
        if (this.g == 0L) {
            return new X243(0L);
        }
        final X243 v = v(this, s);
        if (q244 != null) {
            X243.u(v, q244);
        }
        if (X243.h(v)) {
            v.az = true;
            v.a();
        }
        return v;
    }
    
    public X243 p(final String s, final float n, final float n2, final float n3) {
        return (this.g != 0L) ? this.y(s, new Q244(n, n2, n3)) : new X243(0L);
    }
    
    public static int u(final E245 e245, final int n, final Q244 q244, final Q244 q245, final Q244 q246, final Q244 q247) {
        return (e245.g != 0L) ? fmod.EventSystem_set3DListenerAttributes(e245.g, n, q244.g, q244.d, q244.q, q245.g, q245.d, q245.q, q246.g, q246.d, q246.q, q247.g, q247.d, q247.q) : 0;
    }
    
    public X243 x(final String s, final int n) {
        if (s == null) {
            return new X243(0L);
        }
        final X243 x243 = (this.g != 0L) ? v(this, s) : new X243(0L);
        if (x243.m != 0L) {
            x243.az = true;
            x243.a();
        }
        return x243;
    }
    
    public static void t(final E245 e245) {
        Lb33.g(Lb33.FmodEventSystem);
        try {
            if (e245.g != 0L) {
                fmod.EventSystem_update(e245.g);
            }
        }
        finally {
            Lb33.d(Lb33.FmodEventSystem);
        }
    }
    
    public Z256 h(final int n) {
        return (this.g != 0L) ? new Z256(fmod.EventSystem_getProjectByIndex(this.g, n)) : null;
    }
    
    public static Z256[] m(final E245 e245) {
        if (e245.g == 0L) {
            return null;
        }
        final int e246 = e(e245);
        final Z256[] array = new Z256[e246];
        for (int i = 0; i < e246; ++i) {
            array[i] = e245.h(i);
        }
        return array;
    }
    
    public String[] n(final String s) {
        if (this.g == 0L) {
            return new String[0];
        }
        final String eventSystem_getWaveBanksNeeded = fmod.EventSystem_getWaveBanksNeeded(this.g, s);
        if (eventSystem_getWaveBanksNeeded != null) {
            final String[] split = eventSystem_getWaveBanksNeeded.split("\\|");
            for (int i = 0; i < split.length; ++i) {
                final StringBuilder sb = new StringBuilder();
                final String[] array = split;
                final int n = i;
                array[n] = sb.append(array[n]).append(".fsb").toString();
            }
            return split;
        }
        return null;
    }
    
    public D564 z(final String d) {
        if (this.g == 0L) {
            return new D564(0L);
        }
        final D564 d2 = new D564(fmod.EventSystem_create3dReverb(this.g, d));
        d2.d = d;
        return d2;
    }
    
    public static int b(final E245 e245) {
        return (e245.g != 0L) ? fmod.EventSystem_release(e245.g) : 0;
    }
    
    public static X243 v(final E245 e245, final String s) {
        return e245.r(s, 0);
    }
    
    public static int j(final E245 e245) {
        return (e245.g != 0L) ? fmod.EventSystem_getNumCategories(e245.g) : 0;
    }
}
