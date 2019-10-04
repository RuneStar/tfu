// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Gj16
{
    GATE7_CLOSE("GATE7_CLOSE", 23, 65279), 
    GATE14_CLOSE("GATE14_CLOSE", 30, 32767), 
    GATE10_CLOSE("GATE10_CLOSE", 26, 63487), 
    GATE12_CLOSE("GATE12_CLOSE", 28, 57343), 
    GATE13_CLOSE("GATE13_CLOSE", 29, 49151), 
    GATE11_CLOSE("GATE11_CLOSE", 27, 61439), 
    ALL_GATES("ALL_GATES", 31, 65532), 
    GATE5_OPEN("GATE5_OPEN", 7, 64), 
    GATE9_CLOSE("GATE9_CLOSE", 25, 64511), 
    PLAYER("PLAYER", 1, 1), 
    GATE2_OPEN("GATE2_OPEN", 4, 8), 
    GATE8_CLOSE("GATE8_CLOSE", 24, 65023), 
    NONE("NONE", 0, 0), 
    GATE3_OPEN("GATE3_OPEN", 5, 16), 
    GATE5_CLOSE("GATE5_CLOSE", 21, 65471), 
    GATE1_OPEN("GATE1_OPEN", 3, 4), 
    GATE4_CLOSE("GATE4_CLOSE", 20, 65503), 
    GATE6_OPEN("GATE6_OPEN", 8, 128), 
    GATE2_CLOSE("GATE2_CLOSE", 18, 65527), 
    GATE3_CLOSE("GATE3_CLOSE", 19, 65519), 
    GATE6_CLOSE("GATE6_CLOSE", 22, 65407), 
    GATE11_OPEN("GATE11_OPEN", 13, 4096), 
    NPC("NPC", 2, 2), 
    GATE8_OPEN("GATE8_OPEN", 10, 512), 
    GATE4_OPEN("GATE4_OPEN", 6, 32), 
    GATE1_CLOSE("GATE1_CLOSE", 17, 65531), 
    GATE13_OPEN("GATE13_OPEN", 15, 16384), 
    GATE9_OPEN("GATE9_OPEN", 11, 1024), 
    GATE7_OPEN("GATE7_OPEN", 9, 256), 
    GATE12_OPEN("GATE12_OPEN", 14, 8192), 
    GATE10_OPEN("GATE10_OPEN", 12, 2048), 
    GATE14_OPEN("GATE14_OPEN", 16, 32768);
    
    public final int az;
    
    private Gj16(final String name, final int ordinal, final int az) {
        this.az = az;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(16);
        sb.append(Integer.toBinaryString(this.az));
        while (sb.length() < 16) {
            sb.insert(0, '0');
        }
        return String.format("{ CollisionMask: %s - 0b%s }", this.name(), sb.toString());
    }
    
    public static void g(final int n) {
        if ((n & 0xFFFF0000) != 0x0) {
            throw new IllegalArgumentException("Collision masks cannot use more than 16-bits (note: two bits are reserved, so only 14 bits can be used for gate types).");
        }
        if ((n & 0x1) != 0x0 || (n & 0x2) != 0x0) {
            throw new IllegalArgumentException("First two bits of collision masks are reserved for players & NPCs.");
        }
        if (n != Gj16.NONE.az && n != Gj16.GATE1_OPEN.az && n != Gj16.GATE2_OPEN.az && n != Gj16.GATE3_OPEN.az && n != Gj16.GATE4_OPEN.az && n != Gj16.GATE5_OPEN.az && n != Gj16.GATE6_OPEN.az && n != Gj16.GATE7_OPEN.az && n != Gj16.GATE8_OPEN.az && n != Gj16.GATE9_OPEN.az && n != Gj16.GATE10_OPEN.az && n != Gj16.GATE11_OPEN.az && n != Gj16.GATE12_OPEN.az && n != Gj16.GATE13_OPEN.az && n != Gj16.GATE14_OPEN.az) {
            throw new IllegalArgumentException("Gate collision masks can only have a single bit field set.");
        }
    }
}
