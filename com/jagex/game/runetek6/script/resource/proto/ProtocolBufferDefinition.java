/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.proto;

import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition$1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tfu.Hp62;
import tfu.Ia63;

public class ProtocolBufferDefinition
implements Hp62 {
    public static final Ia63 PROTO_CONSTRUCTOR = new ProtocolBufferDefinition$1();
    public final String definition;
    public final List messageProtocolIds;
    public final String name;

    ProtocolBufferDefinition(String string, List list, String string2) {
        this.name = string;
        this.definition = string2;
        this.messageProtocolIds = new ArrayList(list);
    }

    @Override
    public void onAllRefsReleased() {
    }
}

