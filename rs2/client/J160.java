/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.core.constants.J204;

public enum J160 implements J204
{
    SMALL(1, "small"),
    RESIZABLE(2, "resizable"),
    FULLSCREEN(3, "fullscreen");
    
    public String e;
    private final int j;

    private J160(int n2, String string2) {
        this.j = n2;
        this.e = string2;
    }

    @Override
    public int getId() {
        return this.j;
    }
}

