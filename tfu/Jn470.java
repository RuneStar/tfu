// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.J204;

public enum Jn470 implements J204
{
    CLIENT_ROUTINE_PARTIAL("CLIENT_ROUTINE_PARTIAL", 1), 
    VARIABLE_FULL("VARIABLE_FULL", 4), 
    CHAT_LINE("CHAT_LINE", 0), 
    VARIABLE_PARTIAL("VARIABLE_PARTIAL", 5), 
    HITMARK("HITMARK", 3), 
    CLIENT_ROUTINE_FULL("CLIENT_ROUTINE_FULL", 2);
    
    private Jn470(final String name, final int ordinal) {
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
