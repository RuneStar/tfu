/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket$DeltaSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$ErrorSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$PacketAcknowledgeSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$ResetSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncPacket {
    private static Logger logger = LoggerFactory.getLogger(SyncPacket.class);
    public boolean keyframe = false;
    final Map sections = new HashMap();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SyncPacket\n\n");
        stringBuilder.append("Section Data:\n");
        for (SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
            Map map = (Map)this.sections.get((Object)syncPacket$SectionType);
            stringBuilder.append("  Section Type: " + syncPacket$SectionType.id + " count=" + map.size() + "\n");
            for (Integer n : map.keySet()) {
                List list = (List)map.get(n);
                stringBuilder.append("    Stream: " + n + " Sections=" + list.size() + "\n");
                for (SyncPacket$Section syncPacket$Section : list) {
                    String string = syncPacket$Section.toStringForDebug();
                    for (String string2 : string.split("\n")) {
                        stringBuilder.append("      " + string2 + "\n");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private void addSection(int n, SyncPacket$Section syncPacket$Section) {
        LinkedList<SyncPacket$Section> linkedList;
        SyncPacket$SectionType syncPacket$SectionType = syncPacket$Section.getType();
        HashMap<Integer, LinkedList<SyncPacket$Section>> hashMap = (HashMap<Integer, LinkedList<SyncPacket$Section>>)this.sections.get((Object)syncPacket$SectionType);
        if (hashMap == null) {
            hashMap = new HashMap<Integer, LinkedList<SyncPacket$Section>>();
            this.sections.put(syncPacket$SectionType, hashMap);
        }
        if ((linkedList = (LinkedList<SyncPacket$Section>)hashMap.get(n)) == null) {
            linkedList = new LinkedList<SyncPacket$Section>();
            hashMap.put(n, linkedList);
        }
        linkedList.add(syncPacket$Section);
    }

    void addPacketAcknowledgeSection(int n) {
        this.addSection(0, new SyncPacket$PacketAcknowledgeSection(n));
    }

    void addDeltaSection(Class class_, int n, int n2, int n3, int n4, byte by, byte[] arrby, long l) {
        this.addSection(n, new SyncPacket$DeltaSection(class_, n2, n3, n4, by, arrby, l));
    }

    void addResetSection(int n) {
        this.addSection(n, new SyncPacket$ResetSection());
    }

    List sizedSubpacketSplit(int n) {
        boolean bl;
        LinkedList<SyncPacket> linkedList = new LinkedList<SyncPacket>();
        if (this.sections.isEmpty()) {
            linkedList.add(new SyncPacket());
            return linkedList;
        }
        HashSet<SyncPacket$Section> hashSet = new HashSet<SyncPacket$Section>();
        do {
            bl = false;
            SyncPacket syncPacket = new SyncPacket();
            syncPacket.keyframe = this.keyframe;
            int n2 = n;
            int n3 = 0;
            for (SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
                int n4 = n2 - 5;
                int n5 = 0;
                Map map = (Map)this.sections.get((Object)syncPacket$SectionType);
                block2 : for (Integer n6 : map.keySet()) {
                    boolean bl2 = false;
                    List list = (List)map.get(n6);
                    for (SyncPacket$Section syncPacket$Section : list) {
                        LinkedList<SyncPacket$Section> linkedList2;
                        if (hashSet.contains(syncPacket$Section)) continue;
                        int n7 = syncPacket$Section.getBodySize();
                        if (n4 < n7 && n3 > 0) {
                            bl = true;
                            continue;
                        }
                        if (!bl2) {
                            if (n3 > 0 && n4 - n7 <= 8) {
                                bl = true;
                                continue block2;
                            }
                            n4 -= 8;
                            bl2 = true;
                        }
                        n4 -= n7;
                        ++n5;
                        hashSet.add(syncPacket$Section);
                        HashMap<Integer, LinkedList<SyncPacket$Section>> hashMap = (HashMap<Integer, LinkedList<SyncPacket$Section>>)syncPacket.sections.get((Object)syncPacket$SectionType);
                        if (hashMap == null) {
                            hashMap = new HashMap<Integer, LinkedList<SyncPacket$Section>>();
                            syncPacket.sections.put(syncPacket$SectionType, hashMap);
                        }
                        if ((linkedList2 = (LinkedList<SyncPacket$Section>)hashMap.get(n6)) == null) {
                            linkedList2 = new LinkedList<SyncPacket$Section>();
                            hashMap.put(n6, linkedList2);
                        }
                        linkedList2.add(syncPacket$Section);
                        ++n3;
                    }
                }
                if (n5 == 0) continue;
                n2 = n4;
            }
            linkedList.add(syncPacket);
        } while (bl);
        return linkedList;
    }

    boolean generatePacket(ByteBuffer byteBuffer) {
        try {
            for (SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
                Map map = (Map)this.sections.get((Object)syncPacket$SectionType);
                byteBuffer.put(syncPacket$SectionType.id);
                byteBuffer.putInt(map.size());
                for (Integer n : map.keySet()) {
                    byteBuffer.putInt(n);
                    List list = (List)map.get(n);
                    Collections.sort(list);
                    byteBuffer.putInt(list.size());
                    for (SyncPacket$Section syncPacket$Section : list) {
                        syncPacket$Section.writeBody(byteBuffer);
                    }
                }
            }
            return true;
        }
        catch (BufferOverflowException bufferOverflowException) {
            return false;
        }
    }

    static SyncPacket parsePacket(ByteBuffer byteBuffer) {
        SyncPacket syncPacket = new SyncPacket();
        while (byteBuffer.remaining() > 0) {
            SyncPacket$SectionType syncPacket$SectionType = SyncPacket$SectionType.getByID(byteBuffer.get());
            if (syncPacket$SectionType == null) {
                throw new IllegalArgumentException("Unrecognised section type");
            }
            int n = byteBuffer.getInt();
            for (int i = 0; i < n; ++i) {
                int n2 = byteBuffer.getInt();
                int n3 = byteBuffer.getInt();
                block8 : for (int j = 0; j < n3; ++j) {
                    switch (syncPacket$SectionType) {
                        case PACKET_ACKNOWLEDGE: {
                            syncPacket.addSection(n2, new SyncPacket$PacketAcknowledgeSection(byteBuffer));
                            continue block8;
                        }
                        case DELTA: {
                            syncPacket.addSection(n2, new SyncPacket$DeltaSection(byteBuffer));
                            continue block8;
                        }
                        case ERROR: {
                            syncPacket.addSection(n2, new SyncPacket$ErrorSection(byteBuffer));
                            continue block8;
                        }
                        case RESET: {
                            syncPacket.addSection(n2, new SyncPacket$ResetSection());
                        }
                    }
                }
            }
        }
        return syncPacket;
    }

    void addErrorSection(int n) {
        this.addSection(n, new SyncPacket$ErrorSection());
    }
}

