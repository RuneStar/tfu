// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Gu487 implements Ib29
{
    public static final int g = 16777216;
    private final js5 d;
    private int e;
    private final String j;
    private final int q;
    
    @Override
    public String getIdentifier() {
        return this.j;
    }
    
    public byte[] h(final Integer obj) throws Hs30 {
        if (!this.d.q(this.q)) {
            throw new Hs30("Unrecognised " + this.j + ": " + obj);
        }
        while (!this.d.requestgroupdownload(this.q)) {
            Thread.yield();
        }
        return this.d.getfile(this.q, obj);
    }
    
    public static Integer s(final Gu487 gu487, final String s) {
        final int getfileid = gu487.d.getfileid(gu487.q, s);
        if (getfileid >= 0) {
            return getfileid;
        }
        return null;
    }
    
    public Gu487(final js5 d, final String s, final String j) {
        this.e = -1;
        if (d == null) {
            throw new IllegalArgumentException();
        }
        this.d = d;
        this.j = j;
        this.q = this.d.getgroupid(s);
    }
}
