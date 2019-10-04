// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Mh508
{
    public static byte[] g(final int n, final int[] array) {
        final Gg3 gg3 = new Gg3(8);
        for (int i = 0; i < 4; ++i) {
            Gg3.i(gg3, n);
        }
        Gg3.bu(gg3, array);
        return gg3.r;
    }
}
