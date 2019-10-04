// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import org.slf4j.LoggerFactory;
import java.nio.BufferOverflowException;
import java.util.Collections;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;

public class SyncPacket
{
    private static Logger logger;
    public boolean keyframe;
    final Map sections;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SyncPacket\n\n");
        sb.append("Section Data:\n");
        for (final SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
            final Map<Integer, Map<Integer, Map<Integer, Map>>> map = this.sections.get(syncPacket$SectionType);
            sb.append("  Section Type: " + syncPacket$SectionType.id + " count=" + map.size() + "\n");
            for (final Integer obj : map.keySet()) {
                final List<SyncPacket$Section> list = (List<SyncPacket$Section>)map.get(obj);
                sb.append("    Stream: " + obj + " Sections=" + list.size() + "\n");
                final Iterator<SyncPacket$Section> iterator3 = list.iterator();
                while (iterator3.hasNext()) {
                    final String[] split = iterator3.next().toStringForDebug().split("\n");
                    for (int length = split.length, i = 0; i < length; ++i) {
                        sb.append("      " + split[i] + "\n");
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private void addSection(final int n, final SyncPacket$Section syncPacket$Section) {
        final SyncPacket$SectionType type = syncPacket$Section.getType();
        Object o = this.sections.get(type);
        if (o == null) {
            o = new HashMap<SyncPacket$SectionType, List<?>>();
            this.sections.put(type, o);
        }
        List<?> list = ((Map<SyncPacket$SectionType, List<?>>)o).get(n);
        if (list == null) {
            list = new LinkedList<Object>();
            ((Map<SyncPacket$SectionType, List<?>>)o).put((SyncPacket$SectionType)n, list);
        }
        list.add(syncPacket$Section);
    }
    
    void addPacketAcknowledgeSection(final int n) {
        this.addSection(0, new SyncPacket$PacketAcknowledgeSection(n));
    }
    
    void addDeltaSection(final Class clazz, final int n, final int n2, final int n3, final int n4, final byte b, final byte[] array, final long n5) {
        this.addSection(n, new SyncPacket$DeltaSection(clazz, n2, n3, n4, b, array, n5));
    }
    
    void addResetSection(final int n) {
        this.addSection(n, new SyncPacket$ResetSection());
    }
    
    public SyncPacket() {
        this.keyframe = false;
        this.sections = new HashMap();
    }
    
    List sizedSubpacketSplit(final int n) {
        final LinkedList<SyncPacket> list = new LinkedList<SyncPacket>();
        if (this.sections.isEmpty()) {
            list.add(new SyncPacket());
            return list;
        }
        final HashSet<SyncPacket$Section> set = new HashSet<SyncPacket$Section>();
        while (true) {
            boolean b = false;
            final SyncPacket syncPacket = new SyncPacket();
            syncPacket.keyframe = this.keyframe;
            int n2 = n;
            int n3 = 0;
            for (final SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
                int n4 = n2 - 5;
                int n5 = 0;
                final Map<Integer, Map<Integer, Map<Integer, Map>>> map = this.sections.get(syncPacket$SectionType);
                for (final Integer n6 : map.keySet()) {
                    int n7 = 0;
                    for (final SyncPacket$Section syncPacket$Section : (List<SyncPacket$Section>)map.get(n6)) {
                        if (set.contains(syncPacket$Section)) {
                            continue;
                        }
                        final int bodySize = syncPacket$Section.getBodySize();
                        if (n4 < bodySize && n3 > 0) {
                            b = true;
                        }
                        else {
                            if (n7 == 0) {
                                if (n3 > 0 && n4 - bodySize <= 8) {
                                    b = true;
                                    break;
                                }
                                n4 -= 8;
                                n7 = 1;
                            }
                            n4 -= bodySize;
                            ++n5;
                            set.add(syncPacket$Section);
                            Map<?, ?> map2 = syncPacket.sections.get(syncPacket$SectionType);
                            if (map2 == null) {
                                map2 = new HashMap<Object, Object>();
                                syncPacket.sections.put(syncPacket$SectionType, map2);
                            }
                            List<?> list2 = map2.get(n6);
                            if (list2 == null) {
                                list2 = new LinkedList<Object>();
                                map2.put(n6, list2);
                            }
                            list2.add(syncPacket$Section);
                            ++n3;
                        }
                    }
                }
                if (n5 == 0) {
                    continue;
                }
                n2 = n4;
            }
            list.add(syncPacket);
            if (!b) {
                break;
            }
        }
        return list;
    }
    
    boolean generatePacket(final ByteBuffer byteBuffer) {
        try {
            for (final SyncPacket$SectionType syncPacket$SectionType : this.sections.keySet()) {
                final Map<Integer, Map<Integer, Map<Integer, Map>>> map = this.sections.get(syncPacket$SectionType);
                byteBuffer.put(syncPacket$SectionType.id);
                byteBuffer.putInt(map.size());
                for (final Integer n : map.keySet()) {
                    byteBuffer.putInt(n);
                    final List<SyncPacket$Section> list = (List<SyncPacket$Section>)map.get(n);
                    Collections.sort((List<Comparable>)list);
                    byteBuffer.putInt(list.size());
                    final Iterator<SyncPacket$Section> iterator3 = list.iterator();
                    while (iterator3.hasNext()) {
                        iterator3.next().writeBody(byteBuffer);
                    }
                }
            }
            return true;
        }
        catch (BufferOverflowException ex) {
            return false;
        }
    }
    
    static SyncPacket parsePacket(final ByteBuffer byteBuffer) {
        final SyncPacket syncPacket = new SyncPacket();
        while (byteBuffer.remaining() > 0) {
            final SyncPacket$SectionType byID = SyncPacket$SectionType.getByID(byteBuffer.get());
            if (byID == null) {
                throw new IllegalArgumentException("Unrecognised section type");
            }
            for (int int1 = byteBuffer.getInt(), i = 0; i < int1; ++i) {
                final int int2 = byteBuffer.getInt();
                for (int int3 = byteBuffer.getInt(), j = 0; j < int3; ++j) {
                    switch (SyncPacket$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[byID.ordinal()]) {
                        case 1: {
                            syncPacket.addSection(int2, new SyncPacket$PacketAcknowledgeSection(byteBuffer));
                            break;
                        }
                        case 2: {
                            syncPacket.addSection(int2, new SyncPacket$DeltaSection(byteBuffer));
                            break;
                        }
                        case 3: {
                            syncPacket.addSection(int2, new SyncPacket$ErrorSection(byteBuffer));
                            break;
                        }
                        case 4: {
                            syncPacket.addSection(int2, new SyncPacket$ResetSection());
                            break;
                        }
                    }
                }
            }
        }
        return syncPacket;
    }
    
    void addErrorSection(final int n) {
        this.addSection(n, new SyncPacket$ErrorSection());
    }
    
    static {
        SyncPacket.logger = LoggerFactory.getLogger(SyncPacket.class);
    }
}
