// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.X243;

public class Y603
{
    static String d;
    static float e;
    static String g;
    static int h;
    static String j;
    static X243 q;
    
    public static X243 g() {
        return Y603.q;
    }
    
    public static void q() {
        if (Y603.q != null) {
            X243.f(Y603.q);
            Y603.q = null;
        }
        Y603.g = (Y603.d = null);
    }
    
    public static void d(final String d, final String j) {
        if (d.equalsIgnoreCase(Y603.g) || d.equalsIgnoreCase(Y603.d)) {
            return;
        }
        if (d.equals("")) {
            Y603.d = (Y603.g = null);
            q();
            return;
        }
        Y603.d = d;
        Y603.j = j;
        if (SoundManager.al.containsValue(d)) {
            Y603.d = d;
            final I684 i684 = new I684();
            final String[] aq = SoundManager.c.r(Y603.d, 4).aq();
            if (aq != null) {
                Y603.h = aq.length;
                final String[] array = aq;
                for (int length = array.length, k = 0; k < length; ++k) {
                    G593.g(array[k], 100000L, true, i684, null);
                }
            }
            else {
                Y603.d = null;
            }
        }
        else if (Y603.q != null) {
            X243.f(Y603.q);
        }
    }
    
    static {
        Y603.g = null;
        Y603.d = null;
        Y603.q = null;
        Y603.j = null;
        Y603.e = 1.0f;
        Y603.h = 0;
    }
}
