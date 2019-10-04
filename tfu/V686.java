/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class V686 {
    public int b;
    public byte[] d;
    public int e;
    public byte[] g;
    public int h;
    public int j;
    public int l;
    public int q;
    public int s;

    public V686() {
    }

    public V686(V686 v686) {
        if (v686.g != null) {
            this.g = (byte[])v686.g.clone();
        }
        if (v686.d != null) {
            this.d = (byte[])v686.d.clone();
        }
        this.q = v686.q;
        this.j = v686.j;
        this.e = v686.e;
        this.h = v686.h;
        this.s = v686.s;
        this.b = v686.b;
        this.l = v686.l;
    }
}

