/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import tfu.Gg3;

public class Ls502 {
    public static byte[] d = new byte[]{31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private static final boolean g = false;
    CRC32 b;
    int e;
    int h;
    int j;
    Inflater l;
    public Gg3 q;
    Deflater s;

    public Ls502(int n, int n2, int n3) {
        this.j = n;
        this.e = n2;
        this.h = n3;
    }

    public void g(Gg3 gg3, byte[] arrby) {
        if (gg3.r[gg3.v] != 31 || gg3.r[gg3.v + 1] != -117) {
            throw new RuntimeException("");
        }
        if (this.l == null) {
            this.l = new Inflater(true);
        }
        try {
            this.l.setInput(gg3.r, gg3.v + 10, gg3.r.length - (gg3.v + 10 + 8));
            this.l.inflate(arrby);
        }
        catch (Exception exception) {
            this.l.reset();
            throw new RuntimeException("");
        }
        this.l.reset();
    }

    public Ls502() {
        this(-1, 1000000, 1000000);
    }
}

