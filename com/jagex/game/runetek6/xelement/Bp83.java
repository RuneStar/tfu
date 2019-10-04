// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Id102;
import tfu.Hp62;
import tfu.Hi86;
import tfu.Ia63;

final class Bp83 implements Ia63
{
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
    
    public Bh77 g(final byte[] array, final Integer n, final Hi86 hi86) throws Id102 {
        try {
            return Bh77.w(new Gg3(array), XElement.ai);
        }
        catch (Au64 au64) {
            throw new Id102(au64);
        }
    }
}
