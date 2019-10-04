// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

public class J251
{
    private long g;
    
    public static boolean g(final J251 j251) {
        return j251.g != 0L;
    }
    
    public static void d(final J251 j251, final X243 x243) {
        fmod.EventGroup_freeEventData(j251.g, x243.m, true);
    }
    
    public X243 q(final int n, final int n2) {
        return new X243(fmod.EventGroup_getEventByIndex(this.g, n, n2));
    }
    
    public T239 s() {
        final T239 t239 = new T239();
        for (final R257 r257 : fmod.j(fmod.EventGroup_getInfo(this.g))) {
            if (r257.g.equals("index")) {
                t239.g = Integer.parseInt((String)r257.d);
            }
            if (r257.g.equals("name")) {
                t239.d = (String)r257.d;
            }
        }
        return t239;
    }
    
    @Override
    public String toString() {
        return this.s().d;
    }
    
    public J251 h(final int n) {
        return new J251(fmod.EventGroup_getGroupByIndex(this.g, n, false));
    }
    
    public static int b(final J251 j251) {
        return fmod.EventGroup_getNumEvents(j251.g);
    }
    
    public static int l(final J251 j251) {
        return fmod.EventGroup_getNumGroups(j251.g);
    }
    
    public static X243[] e(final J251 j251) {
        final int b = b(j251);
        final X243[] array = new X243[b];
        for (int i = 0; i < b; ++i) {
            array[i] = j251.q(i, 4);
        }
        return array;
    }
    
    public J251(final long g) {
        this.g = g;
    }
    
    public static J251[] j(final J251 j251) {
        final int l = l(j251);
        final J251[] array = new J251[l];
        for (int i = 0; i < l; ++i) {
            array[i] = j251.h(i);
        }
        return array;
    }
}
