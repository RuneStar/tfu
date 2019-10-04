// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.core.constants.J204;

public enum I384 implements J204
{
    _1024X768("_1024X768", 1, 1), 
    ANY("ANY", 0, 0), 
    _800X600("_800X600", 2, 2);
    
    private final int j;
    
    private I384(final String name, final int ordinal, final int j) {
        this.j = j;
    }
    
    @Override
    public int getId() {
        return this.j;
    }
}
