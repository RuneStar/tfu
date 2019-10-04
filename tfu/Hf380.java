// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Hf380
{
    FRIENDSONLY("FRIENDSONLY", 1, 1), 
    PUBLIC("PUBLIC", 0, 0), 
    OFF("OFF", 2, 2);
    
    public final int j;
    
    public static Hf380 g(final int n) {
        for (final Hf380 hf380 : values()) {
            if (hf380.j == n) {
                return hf380;
            }
        }
        return null;
    }
    
    private Hf380(final String name, final int ordinal, final int j) {
        this.j = j;
    }
}
