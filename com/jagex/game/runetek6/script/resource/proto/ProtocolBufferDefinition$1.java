// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.proto;

import tfu.Id102;
import tfu.Hp62;
import java.util.List;
import tfu.Mj383;
import tfu.Js343;
import java.util.LinkedList;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;

final class ProtocolBufferDefinition$1 implements Ia63
{
    public ProtocolBufferDefinition constructResource(final byte[] array, final String s, final Hi86 hi86) {
        final Gg3 gg3 = new Gg3(array);
        final String bh = gg3.bh();
        final int au = Gg3.au(gg3);
        final LinkedList<Js343> list = new LinkedList<Js343>();
        for (int i = 0; i < au; ++i) {
            list.add(new Js343(gg3.bh(), Gg3.bd(gg3)));
        }
        final byte[] array2 = new byte[gg3.r.length - gg3.v];
        Gg3.bx(gg3, array2, 0, array2.length);
        return new ProtocolBufferDefinition(bh.replace('/', '.'), list, Mj383.q(array2));
    }
    
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}
