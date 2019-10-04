// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

public enum S15
{
    GROUND("GROUND", 1, 1), 
    CAMERA("CAMERA", 4, 4), 
    SCENERY("SCENERY", 0, 0), 
    NPC("NPC", 3, 3), 
    PLAYER("PLAYER", 2, 2);
    
    public final int h;
    
    private S15(final String name, final int ordinal, final int h) {
        this.h = h;
    }
}
