/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Ln265 {
    public Ln265 bl;
    public Ln265 bo;
    public long bq;

    public static boolean ek(Ln265 ln265) {
        return ln265.bl != null;
    }

    public static void ef(Ln265 ln265) {
        if (ln265.bl == null) {
            return;
        }
        ln265.bl.bo = ln265.bo;
        ln265.bo.bl = ln265.bl;
        ln265.bo = null;
        ln265.bl = null;
    }
}

