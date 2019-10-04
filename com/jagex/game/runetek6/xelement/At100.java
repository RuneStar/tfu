// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Hp62;
import tfu.Id102;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;

final class At100 implements Ia63
{
    public T101 g(final byte[] array, final Integer n, final Hi86 hi86) throws Id102 {
        return T101.g(new Gg3(array));
    }
    
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}
