// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import rs2.client.client;
import java.io.IOException;
import com.jagex.game.runetek6.config.vartype.VarType;
import org.slf4j.Logger;
import com.jagex.game.runetek6.config.vartype.SparseVarDomain;

public final class Fg140 extends SparseVarDomain
{
    public static final int d = 1;
    private static final Logger logger;
    private final boolean[] e;
    public long j;
    public boolean q;
    
    public static void d(final Fg140 fg140) {
        for (int i = 0; i < fg140.e.length; ++i) {
            if (!fg140.e[i]) {
                fg140.varValues.l(i);
            }
        }
    }
    
    @Override
    public void setVarValueInt(final VarType varType, final int n) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValueInt(varType, n);
    }
    
    @Override
    public void setVarValue(final VarType varType, final Object o) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValue(varType, o);
    }
    
    @Override
    public void setVarValueLong(final VarType varType, final long n) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValueLong(varType, n);
    }
    
    public void q(final Is139 is139) {
        try {
            final byte[] array = new byte[(int)Is139.e(is139)];
            int h;
            for (int i = 0; i < array.length; i += h) {
                h = Is139.h(is139, array, i, array.length - i);
                if (h == -1) {
                    throw new IOException("EOF");
                }
            }
            final Gg3 gg3 = new Gg3(array);
            if (gg3.r.length - gg3.v < 1) {
                return;
            }
            final int ar = Gg3.ar(gg3);
            if (ar >= 0) {
                if (ar <= 1) {
                    if (gg3.r.length - gg3.v < 2) {
                        return;
                    }
                    final int au = Gg3.au(gg3);
                    if (gg3.r.length - gg3.v < au * 6) {
                        return;
                    }
                    for (int j = 0; j < au; ++j) {
                        final Kr260 decodeVarValue = client.fo.decodeVarValue(gg3);
                        if (g(client.jr, decodeVarValue.g)) {
                            if (!client.fo.list(decodeVarValue.g).dataType.getVarBaseType().javaClass.isAssignableFrom(decodeVarValue.d.getClass())) {
                                Fg140.logger.info("Tried to load {} as {}", client.fo.list(decodeVarValue.g).dataType.getVarBaseType(), decodeVarValue.d.getClass());
                            }
                            else {
                                super.varValues.s(decodeVarValue.g, decodeVarValue.d);
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            Fg140.logger.error("Unable to load varcs", ex);
        }
        finally {
            try {
                Is139.j(is139);
            }
            catch (Exception ex2) {}
        }
    }
    
    public void j(final Is139 is139) {
        try {
            int n = 3;
            int n2 = 0;
            for (final Kr260 kr260 : super.varValues) {
                if (g(this, kr260.g)) {
                    n += client.fo.getValueEncodingLength(kr260);
                    ++n2;
                }
            }
            final Gg3 gg3 = new Gg3(n);
            Gg3.k(gg3, 1);
            Gg3.i(gg3, n2);
            for (final Kr260 kr261 : super.varValues) {
                if (g(this, kr261.g)) {
                    client.fo.encodeVarValue(gg3, kr261);
                }
            }
            is139.q(gg3.r, 0, gg3.v);
        }
        catch (Exception ex) {
            Fg140.logger.error("Unable to save varcs", ex);
        }
        finally {
            try {
                Is139.j(is139);
            }
            catch (Exception ex2) {}
        }
        this.j = Gz143.g();
        this.q = false;
    }
    
    static {
        logger = LoggerFactory.getLogger(Fg140.class);
    }
    
    public static boolean g(final Fg140 fg140, final int n) {
        return n >= 0 && n < fg140.e.length && fg140.e[n];
    }
    
    public Fg140(final VarTypeList list) {
        super(list);
        this.q = false;
        this.j = -1L;
        this.e = new boolean[list.length()];
        for (int i = 0; i < list.length(); ++i) {
            if (list.list(i).lifeTime == VarLifetime.PERMANENT) {
                this.e[i] = true;
            }
        }
    }
}
