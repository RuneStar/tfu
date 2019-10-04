/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.js5.js5;
import rs2.client.client;
import tfu.Bh662;
import tfu.Bj661;
import tfu.Bp655;
import tfu.Bx652;
import tfu.Ja527;
import tfu.Jj524;

public class Bk151 {
    private static int d = 0;
    private static Ja527[] g;
    private static long q;

    public static int g() {
        long l;
        if (d == 0) {
            d = 1;
        }
        if (d == 1) {
            g = Ja527.values();
            Ja527.JS5_DEFAULTS.j(new Bp655(client.eu));
            Ja527.NL_JAGTHEORA.j(new Bx652("jagtheora"));
            Ja527.NL_JNIBINDINGS.j(new Bx652("JNIBindings"));
            Ja527.JS5_SHADERS.j(new Bp655(client.ea));
            Ja527.JS5_CONFIG.j(new Bp655(client.dr));
            Ja527.JS5_CONFIG_OBJ.j(new Bp655(client.et));
            Ja527.JS5_GFX_CONFIG.j(new Bp655(client.eg));
            Ja527.JS5FILE_HUFFMAN.j(new Bh662(client.dg, "huffman"));
            Ja527.JS5_SCALEFORM.j(new Bp655(client.db));
            Ja527.JS5_SCALEFORMDDS.j(new Bp655(client.dd));
            Ja527.JS5_FONTMETRICS.j(new Bp655(client.er));
            Ja527.JS5GROUP_PROPERTYINDEX.j(new Bj661(client.ek, "_propertynameindex"));
            Ja527.JS5_LUA.j(new Bp655(client.ee));
            Ja527.JS5_STATES.j(new Bp655(client.ep));
            Ja527.JS5_SPRITES.j(new Bp655(client.dy));
            for (int i = 0; i < g.length; ++i) {
                if (Ja527.q(g[i]) != null) continue;
                throw new RuntimeException();
            }
            l = 0L;
            for (Ja527 object : g) {
                long l2 = Ja527.g(object);
                if (l2 < 0L) {
                    throw new RuntimeException();
                }
                long ja527 = Ja527.q(object).g();
                l += ja527 * l2 / 100L;
            }
            q = l;
            d = 2;
        }
        if (g == null) {
            return 100;
        }
        l = 0L;
        long l4 = 0L;
        int n = 1;
        for (Ja527 ja527 : g) {
            long l3 = Ja527.g(ja527);
            if (l3 < 0L) {
                throw new RuntimeException();
            }
            long l5 = 0L;
            boolean bl = false;
            if (n != 0) {
                bl = true;
                l5 = Ja527.q(ja527).g();
            }
            if (l5 < 100L) {
                n = 0;
            }
            l += l3;
            l4 += l5 * l3 / 100L;
            if (bl && !F511.j(ja527.m)) {
                F511.d(ja527.m);
                Z132.d("PACKAGE_" + ja527.name(), "size:" + Ja527.g(ja527) + " perc:" + l5);
            }
            if (bl && l5 >= 100L && !F511.e(ja527.m)) {
                F511.q(ja527.m);
                Z132.q("PACKAGE_" + ja527.name());
            }
            if (l4 >= 0L) continue;
            throw new RuntimeException("td " + l4 + " s " + l3);
        }
        if (n != 0) {
            if (!Bx652.w((Bx652)Ja527.q(Ja527.NL_JAGTHEORA))) {
                client.bc = client.bu.load_jagtheora();
            }
            g = null;
        }
        int n2 = (int)((l -= q) > 0L ? (l4 -= q) * 100L / l : 100L);
        if (n == 0 && n2 > 99) {
            n2 = 99;
        }
        return n2;
    }

    static {
        q = 0L;
    }
}

