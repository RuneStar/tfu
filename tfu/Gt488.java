// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public final class Gt488 implements Ib29
{
    private final String d;
    private final js5 g;
    private int q;
    
    public static Integer s(final Gt488 gt488, final String s) {
        final int getgroupid = gt488.g.getgroupid(s);
        if (getgroupid >= 0) {
            return getgroupid;
        }
        return null;
    }
    
    public byte[] h(final Integer obj) throws Hs30 {
        if (this.g.q(obj)) {
            while (!this.g.requestgroupdownload(obj)) {
                Thread.yield();
            }
            return this.g.getfile(obj, 0);
        }
        final String string = "Unrecognised " + this.d + ": " + obj;
        Object.logger.error(string);
        if (this.q >= 0 && this.g.q(this.q)) {
            while (!this.g.requestgroupdownload(this.q)) {
                Thread.yield();
            }
            return this.g.getfile(this.q, 0);
        }
        throw new Hs30(string);
    }
    
    @Override
    public String getIdentifier() {
        return this.d;
    }
    
    public Gt488(final js5 g, final String d) {
        this.q = -1;
        if (g == null) {
            throw new IllegalArgumentException();
        }
        this.g = g;
        this.d = d;
    }
}
