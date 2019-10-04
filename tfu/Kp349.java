// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Kp349 extends Ln265
{
    private static final boolean y = true;
    public long p;
    public Kp349 u;
    public Kp349 x;
    
    public static void t(final Kp349 kp349) {
        if (kp349.u == null) {
            return;
        }
        kp349.u.x = kp349.x;
        kp349.x.u = kp349.u;
        kp349.x = null;
        kp349.u = null;
    }
}
