/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Jn470 implements J204
{
    CHAT_LINE,
    CLIENT_ROUTINE_PARTIAL,
    CLIENT_ROUTINE_FULL,
    HITMARK,
    VARIABLE_FULL,
    VARIABLE_PARTIAL;
    

    @Override
    public int getId() {
        return this.ordinal();
    }
}

