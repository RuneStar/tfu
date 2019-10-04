// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Ca649
{
    private static final boolean g = true;
    private js5 d;
    private Ha262 e;
    private Ha262 h;
    private Ha262 j;
    private js5 q;
    
    public static Cj551 g(final Ca649 ca649, final int n, final int n2, final int[] array) {
        final long n3 = (n2 ^ ((n << 4 & 0xFFFF) | n >>> 12)) | n << 16;
        final Cj551 cj551 = (Cj551)Ha262.d(ca649.h, n3);
        if (cj551 != null) {
            return cj551;
        }
        if (array != null && array[0] <= 0) {
            return null;
        }
        final Co638 g = Co638.g(ca649.d, n, n2);
        if (g == null) {
            return null;
        }
        final Cj551 d = g.d();
        Ha262.q(ca649.h, d, n3);
        if (array != null) {
            final int n4 = 0;
            array[n4] -= d.e.length;
        }
        return d;
    }
    
    public Ca649(final js5 d, final js5 q) {
        this.j = new Ha262(256);
        this.e = new Ha262(256);
        this.h = new Ha262(256);
        this.d = d;
        this.q = q;
    }
    
    public Cj551 q(final int n, final int[] array) {
        if (js5.t(this.d) == 1) {
            return g(this, 0, n, array);
        }
        if (js5.z(this.d, n) == 1) {
            return g(this, n, 0, array);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }
    
    public Ci646 j(final int n, final int[] array) {
        if (js5.t(this.q) == 1) {
            return d(this, 0, n, array);
        }
        if (js5.z(this.q, n) == 1) {
            return d(this, n, 0, array);
        }
        throw new RuntimeException("Unable to determine if id is groupid or fileid");
    }
    
    public static Ci646 d(final Ca649 ca649, final int n, final int n2, final int[] array) {
        final long n3 = (long)((n2 ^ ((n << 4 & 0xFFFF) | n >>> 12)) | n << 16) ^ 0x100000000L;
        final Ci646 ci646 = (Ci646)Ha262.d(ca649.e, n3);
        if (ci646 != null) {
            return ci646;
        }
        if (array != null && array[0] <= 0) {
            return null;
        }
        Cg550 b = (Cg550)Ha262.d(ca649.j, n3);
        if (b == null) {
            b = Cg550.b(ca649.q, n, n2);
            if (b == null) {
                return null;
            }
            Ha262.q(ca649.j, b, n3);
        }
        final Ci646 l = b.l();
        if (l == null) {
            return null;
        }
        Ln265.ef(b);
        Ha262.q(ca649.e, l, n3);
        return l;
    }
}
