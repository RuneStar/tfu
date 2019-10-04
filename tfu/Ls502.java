// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.CRC32;

public class Ls502
{
    public static byte[] d;
    private static final boolean g = false;
    CRC32 b;
    int e;
    int h;
    int j;
    Inflater l;
    public Gg3 q;
    Deflater s;
    
    public Ls502(final int j, final int e, final int h) {
        this.j = j;
        this.e = e;
        this.h = h;
    }
    
    public void g(final Gg3 gg3, final byte[] output) {
        if (gg3.r[gg3.v] != 31 || gg3.r[gg3.v + 1] != -117) {
            throw new RuntimeException("");
        }
        if (this.l == null) {
            this.l = new Inflater(true);
        }
        try {
            this.l.setInput(gg3.r, gg3.v + 10, gg3.r.length - (gg3.v + 10 + 8));
            this.l.inflate(output);
        }
        catch (Exception ex) {
            this.l.reset();
            throw new RuntimeException("");
        }
        this.l.reset();
    }
    
    public Ls502() {
        this(-1, 1000000, 1000000);
    }
    
    static {
        Ls502.d = new byte[] { 31, -117, 8, 0, 0, 0, 0, 0, 0, 0 };
    }
}
