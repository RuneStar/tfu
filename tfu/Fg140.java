/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Gg3;
import tfu.Gz143;
import tfu.Is139;
import tfu.Kr260;
import tfu.Mn54;

public final class Fg140
extends SparseVarDomain {
    public static final int d = 1;
    private static final Logger logger = LoggerFactory.getLogger(Fg140.class);
    private final boolean[] e;
    public long j = -1L;
    public boolean q = false;

    public static void d(Fg140 fg140) {
        for (int i = 0; i < fg140.e.length; ++i) {
            if (fg140.e[i]) continue;
            fg140.varValues.l(i);
        }
    }

    @Override
    public void setVarValueInt(VarType varType, int n) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValueInt(varType, n);
    }

    @Override
    public void setVarValue(VarType varType, Object object) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValue(varType, object);
    }

    @Override
    public void setVarValueLong(VarType varType, long l) {
        if (this.e[varType.id]) {
            this.q = true;
        }
        super.setVarValueLong(varType, l);
    }

    public void q(Is139 is139) {
        try {
            try {
                int n;
                byte[] arrby = new byte[(int)Is139.e(is139)];
                for (int i = 0; i < arrby.length; i += n) {
                    n = Is139.h(is139, arrby, i, arrby.length - i);
                    if (n != -1) continue;
                    throw new IOException("EOF");
                }
                Gg3 gg3 = new Gg3(arrby);
                if (gg3.r.length - gg3.v < 1) {
                    try {
                        Is139.j(is139);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    return;
                }
                int n2 = Gg3.ar(gg3);
                if (n2 < 0 || n2 > 1) {
                    try {
                        Is139.j(is139);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    return;
                }
                if (gg3.r.length - gg3.v < 2) {
                    try {
                        Is139.j(is139);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    return;
                }
                int n3 = Gg3.au(gg3);
                if (gg3.r.length - gg3.v < n3 * 6) {
                    try {
                        Is139.j(is139);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    return;
                }
                for (int i = 0; i < n3; ++i) {
                    Kr260 kr260 = client.fo.decodeVarValue(gg3);
                    if (!Fg140.g(client.jr, kr260.g)) continue;
                    if (!client.fo.list((int)kr260.g).dataType.getVarBaseType().javaClass.isAssignableFrom(kr260.d.getClass())) {
                        logger.info("Tried to load {} as {}", client.fo.list((int)kr260.g).dataType.getVarBaseType(), kr260.d.getClass());
                        continue;
                    }
                    this.varValues.s(kr260.g, kr260.d);
                }
            }
            catch (Exception exception) {
                logger.error("Unable to load varcs", exception);
                try {
                    Is139.j(is139);
                }
                catch (Exception exception2) {}
            }
            try {
                Is139.j(is139);
            }
            catch (Exception exception) {}
        }
        catch (Throwable throwable) {
            try {
                Is139.j(is139);
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw throwable;
        }
    }

    public void j(Is139 is139) {
        try {
            try {
                int n = 3;
                int n2 = 0;
                for (Object object : this.varValues) {
                    if (!Fg140.g(this, ((Kr260)object).g)) continue;
                    n += client.fo.getValueEncodingLength((Kr260)object);
                    ++n2;
                }
                Gg3 gg3 = new Gg3(n);
                Gg3.k(gg3, 1);
                Gg3.i(gg3, n2);
                for (Kr260 kr260 : this.varValues) {
                    if (!Fg140.g(this, kr260.g)) continue;
                    client.fo.encodeVarValue(gg3, kr260);
                }
                is139.q(gg3.r, 0, gg3.v);
            }
            catch (Exception exception) {
                logger.error("Unable to save varcs", exception);
                try {
                    Is139.j(is139);
                }
                catch (Exception exception2) {}
            }
            try {
                Is139.j(is139);
            }
            catch (Exception exception) {}
        }
        catch (Throwable throwable) {
            try {
                Is139.j(is139);
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw throwable;
        }
        this.j = Gz143.g();
        this.q = false;
    }

    public static boolean g(Fg140 fg140, int n) {
        if (n < 0 || n >= fg140.e.length) {
            return false;
        }
        return fg140.e[n];
    }

    public Fg140(VarTypeList varTypeList) {
        super(varTypeList);
        this.e = new boolean[varTypeList.length()];
        for (int i = 0; i < varTypeList.length(); ++i) {
            if (varTypeList.list((int)i).lifeTime != VarLifetime.PERMANENT) continue;
            this.e[i] = true;
        }
    }
}

