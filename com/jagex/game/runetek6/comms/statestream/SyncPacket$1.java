/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;

class SyncPacket$1 {
    static final /* synthetic */ int[] $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType;

    static {
        $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType = new int[SyncPacket$SectionType.values().length];
        try {
            SyncPacket$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.PACKET_ACKNOWLEDGE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            SyncPacket$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.DELTA.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            SyncPacket$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            SyncPacket$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.RESET.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

