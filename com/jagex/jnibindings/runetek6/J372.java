/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Skeleton;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

final class J372
implements Ia63 {
    public Skeleton g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        Skeleton skeleton = new Skeleton(hi86);
        if (Skeleton.q(skeleton, arrby, 0.015625f) == 0) {
            throw new Id102("Error loading skeleton");
        }
        return skeleton;
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return true;
    }

    J372() {
    }
}

