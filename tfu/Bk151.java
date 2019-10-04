// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import rs2.client.client;

public class Bk151
{
    private static int d;
    private static Ja527[] g;
    private static long q;
    
    public static int g() {
        if (Bk151.d == 0) {
            Bk151.d = 1;
        }
        if (Bk151.d == 1) {
            Bk151.g = Ja527.values();
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
            for (int i = 0; i < Bk151.g.length; ++i) {
                if (Ja527.q(Bk151.g[i]) == null) {
                    throw new RuntimeException();
                }
            }
            long q = 0L;
            for (final Ja527 ja527 : Bk151.g) {
                final long n = Ja527.g(ja527);
                if (n < 0L) {
                    throw new RuntimeException();
                }
                q += Ja527.q(ja527).g() * n / 100L;
            }
            Bk151.q = q;
            Bk151.d = 2;
        }
        if (Bk151.g == null) {
            return 100;
        }
        long n2 = 0L;
        long lng = 0L;
        int n3 = 1;
        for (final Ja527 ja528 : Bk151.g) {
            final long lng2 = Ja527.g(ja528);
            if (lng2 < 0L) {
                throw new RuntimeException();
            }
            long lng3 = 0L;
            boolean b = false;
            if (n3 != 0) {
                b = true;
                lng3 = Ja527.q(ja528).g();
            }
            if (lng3 < 100L) {
                n3 = 0;
            }
            n2 += lng2;
            lng += lng3 * lng2 / 100L;
            if (b && !F511.j(ja528.m)) {
                F511.d(ja528.m);
                Z132.d("PACKAGE_" + ja528.name(), "size:" + Ja527.g(ja528) + " perc:" + lng3);
            }
            if (b && lng3 >= 100L && !F511.e(ja528.m)) {
                F511.q(ja528.m);
                Z132.q("PACKAGE_" + ja528.name());
            }
            if (lng < 0L) {
                throw new RuntimeException("td " + lng + " s " + lng2);
            }
        }
        if (n3 != 0) {
            if (!Bx652.w((Bx652)Ja527.q(Ja527.NL_JAGTHEORA))) {
                client.bc = client.bu.load_jagtheora();
            }
            Bk151.g = null;
        }
        final long n4 = lng - Bk151.q;
        final long n5 = n2 - Bk151.q;
        int n6 = (int)((n5 > 0L) ? (n4 * 100L / n5) : 100L);
        if (n3 == 0 && n6 > 99) {
            n6 = 99;
        }
        return n6;
    }
    
    static {
        Bk151.d = 0;
        Bk151.q = 0L;
    }
}
