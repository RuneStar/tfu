/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public enum Gj16 {
    NONE(0),
    PLAYER(1),
    NPC(2),
    GATE1_OPEN(4),
    GATE2_OPEN(8),
    GATE3_OPEN(16),
    GATE4_OPEN(32),
    GATE5_OPEN(64),
    GATE6_OPEN(128),
    GATE7_OPEN(256),
    GATE8_OPEN(512),
    GATE9_OPEN(1024),
    GATE10_OPEN(2048),
    GATE11_OPEN(4096),
    GATE12_OPEN(8192),
    GATE13_OPEN(16384),
    GATE14_OPEN(32768),
    GATE1_CLOSE(65531),
    GATE2_CLOSE(65527),
    GATE3_CLOSE(65519),
    GATE4_CLOSE(65503),
    GATE5_CLOSE(65471),
    GATE6_CLOSE(65407),
    GATE7_CLOSE(65279),
    GATE8_CLOSE(65023),
    GATE9_CLOSE(64511),
    GATE10_CLOSE(63487),
    GATE11_CLOSE(61439),
    GATE12_CLOSE(57343),
    GATE13_CLOSE(49151),
    GATE14_CLOSE(32767),
    ALL_GATES(65532);
    
    public final int az;

    private Gj16(int n2) {
        this.az = n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(Integer.toBinaryString(this.az));
        while (stringBuffer.length() < 16) {
            stringBuffer.insert(0, '0');
        }
        return String.format("{ CollisionMask: %s - 0b%s }", this.name(), stringBuffer.toString());
    }

    public static void g(int n) {
        if ((n & 0xFFFF0000) != 0) {
            throw new IllegalArgumentException("Collision masks cannot use more than 16-bits (note: two bits are reserved, so only 14 bits can be used for gate types).");
        }
        if ((n & 1) != 0 || (n & 2) != 0) {
            throw new IllegalArgumentException("First two bits of collision masks are reserved for players & NPCs.");
        }
        if (n != Gj16.NONE.az && n != Gj16.GATE1_OPEN.az && n != Gj16.GATE2_OPEN.az && n != Gj16.GATE3_OPEN.az && n != Gj16.GATE4_OPEN.az && n != Gj16.GATE5_OPEN.az && n != Gj16.GATE6_OPEN.az && n != Gj16.GATE7_OPEN.az && n != Gj16.GATE8_OPEN.az && n != Gj16.GATE9_OPEN.az && n != Gj16.GATE10_OPEN.az && n != Gj16.GATE11_OPEN.az && n != Gj16.GATE12_OPEN.az && n != Gj16.GATE13_OPEN.az && n != Gj16.GATE14_OPEN.az) {
            throw new IllegalArgumentException("Gate collision masks can only have a single bit field set.");
        }
    }
}

