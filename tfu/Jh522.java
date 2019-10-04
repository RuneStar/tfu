// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Jh522
{
    private final byte[][] g;
    
    public static int g(final Jh522 jh522) {
        return jh522.g.length;
    }
    
    public Jh522(final int n) {
        this.g = new byte[n][0];
    }
    
    public static byte[] q(final Jh522 jh522, final int n) {
        return jh522.g[n];
    }
    
    public static void d(final Jh522 jh522, final int n, final byte[] array) {
        jh522.g[n] = array;
    }
}
