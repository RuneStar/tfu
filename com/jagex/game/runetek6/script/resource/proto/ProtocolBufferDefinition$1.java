/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.proto;

import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import java.util.LinkedList;
import java.util.List;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;
import tfu.Js343;
import tfu.Mj383;

final class ProtocolBufferDefinition$1
implements Ia63 {
    public ProtocolBufferDefinition constructResource(byte[] arrby, String string, Hi86 hi86) {
        Gg3 gg3 = new Gg3(arrby);
        String string2 = gg3.bh();
        int n = Gg3.au(gg3);
        LinkedList<Js343> linkedList = new LinkedList<Js343>();
        for (int i = 0; i < n; ++i) {
            int n2 = Gg3.bd(gg3);
            String string3 = gg3.bh();
            linkedList.add(new Js343(string3, n2));
        }
        byte[] arrby2 = new byte[gg3.r.length - gg3.v];
        Gg3.bx(gg3, arrby2, 0, arrby2.length);
        return new ProtocolBufferDefinition(string2.replace('/', '.'), linkedList, Mj383.q(arrby2));
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }

    ProtocolBufferDefinition$1() {
    }
}

