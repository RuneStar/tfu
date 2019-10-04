// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.proto;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import tfu.Ia63;
import tfu.Hp62;

public class ProtocolBufferDefinition implements Hp62
{
    public static final Ia63 PROTO_CONSTRUCTOR;
    public final String definition;
    public final List messageProtocolIds;
    public final String name;
    
    ProtocolBufferDefinition(final String name, final List c, final String definition) {
        this.name = name;
        this.definition = definition;
        this.messageProtocolIds = new ArrayList(c);
    }
    
    static {
        PROTO_CONSTRUCTOR = new ProtocolBufferDefinition$1();
    }
    
    @Override
    public void onAllRefsReleased() {
    }
}
