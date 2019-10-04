// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.J204;

public enum Go485 implements J204
{
    SERVERFULL("SERVERFULL", 7, 7), 
    NONE("NONE", 1, -2), 
    TIMEOUT("TIMEOUT", 4, -5), 
    EOF("EOF", 0, -1), 
    OK("OK", 5, 2), 
    IOERROR("IOERROR", 3, -4), 
    IP_BLOCKED1("IP_BLOCKED1", 8, 9), 
    INPROGRESS("INPROGRESS", 2, -3), 
    SERVERERROR("SERVERERROR", 6, 3), 
    OUTOFDATE("OUTOFDATE", 9, 37);
    
    private final int r;
    
    private Go485(final String name, final int ordinal, final int r) {
        this.r = r;
    }
    
    @Override
    public int getId() {
        return this.r;
    }
}
