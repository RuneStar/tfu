/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public enum Hf380 {
    PUBLIC(0),
    FRIENDSONLY(1),
    OFF(2);
    
    public final int j;

    public static Hf380 g(int n) {
        for (Hf380 hf380 : Hf380.values()) {
            if (hf380.j != n) continue;
            return hf380;
        }
        return null;
    }

    private Hf380(int n2) {
        this.j = n2;
    }
}

