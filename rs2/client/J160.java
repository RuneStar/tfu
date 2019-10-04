// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.core.constants.J204;

public enum J160 implements J204
{
    RESIZABLE("RESIZABLE", 1, 2, "resizable"), 
    SMALL("SMALL", 0, 1, "small"), 
    FULLSCREEN("FULLSCREEN", 2, 3, "fullscreen");
    
    public String e;
    private final int j;
    
    private J160(final String name, final int ordinal, final int j, final String e) {
        this.j = j;
        this.e = e;
    }
    
    @Override
    public int getId() {
        return this.j;
    }
}
