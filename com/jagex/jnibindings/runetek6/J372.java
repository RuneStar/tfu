// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import tfu.Hp62;
import tfu.Id102;
import tfu.Hi86;
import tfu.Ia63;

final class J372 implements Ia63
{
    public Skeleton g(final byte[] array, final Integer n, final Hi86 hi86) throws Id102 {
        final Skeleton skeleton = new Skeleton(hi86);
        if (Skeleton.q(skeleton, array, 0.015625f) == 0) {
            throw new Id102("Error loading skeleton");
        }
        return skeleton;
    }
    
    @Override
    public boolean resourceNeedsRefCounting() {
        return true;
    }
}
