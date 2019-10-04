// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Hp62;
import tfu.Id102;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;

class Ab205 implements Ia63
{
    final /* synthetic */ XElementLibrary g;
    
    public XElement g(final byte[] array, final Integer n, final Hi86 hi86) throws Id102 {
        try {
            return XElement.by(new Gg3(array), this.g);
        }
        catch (Au64 au64) {
            throw new Id102(au64);
        }
    }
    
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
    
    Ab205(final XElementLibrary g) {
        this.g = g;
    }
}
