// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Hp62;
import tfu.Id102;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;

final class K67 implements Ia63
{
    public Bj61 g(final byte[] array, final Integer n, final Hi86 hi86) throws Id102 {
        try {
            return Bj61.q(new Gg3(array));
        }
        catch (Au64 au64) {
            throw new Id102("Exception whilst constructing an animation set", au64);
        }
    }
    
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}
