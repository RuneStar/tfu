// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ln265
{
    public Ln265 bl;
    public Ln265 bo;
    public long bq;
    
    public static boolean ek(final Ln265 ln265) {
        return ln265.bl != null;
    }
    
    public static void ef(final Ln265 ln265) {
        if (ln265.bl == null) {
            return;
        }
        ln265.bl.bo = ln265.bo;
        ln265.bo.bl = ln265.bl;
        ln265.bo = null;
        ln265.bl = null;
    }
}
