// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.LinkedList;

public class Cr641
{
    private static LinkedList g;
    
    public static void g(final Cg550 cg550) {
        if (!Cr641.g.contains(cg550)) {
            Cr641.g.add(cg550);
        }
    }
    
    static {
        Cr641.g = new LinkedList();
    }
}
