/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.worldelement.player;
import tfu.Gc330;
import tfu.Gz143;
import tfu.Ha262;
import tfu.Ln265;
import tfu.Lo465;

public final class Fw152
implements VarDomain {
    private static final long d = 0x3FFFFFFFFFFFFFFFL;
    private static final long e = 500L;
    private static final long j = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Fw152.class);
    private static final long q = 0x4000000000000000L;
    public Ha262 b = new Ha262(128);
    private int[] h = new int[client.fd.length()];
    private int[] s = new int[client.fd.length()];

    public static int g(Fw152 fw152, boolean bl) {
        Lo465 lo465;
        player player2 = Gc330.j();
        long l = Gz143.g();
        Lo465 lo4652 = lo465 = bl ? (Lo465)Ha262.e(fw152.b) : (Lo465)Ha262.h(fw152.b);
        while (lo465 != null) {
            if ((lo465.g & 0x3FFFFFFFFFFFFFFFL) < l) {
                if ((lo465.g & 0x4000000000000000L) != 0L) {
                    logger.trace("Copying server variable {}", lo465.bq);
                    int n = (int)lo465.bq;
                    int n2 = fw152.s[n];
                    fw152.s[n] = fw152.h[n];
                    Lo465.ef(lo465);
                    if (player2 != null) {
                        VarType varType;
                        player.cv(player2, n, fw152.s[n]);
                        if (fw152.s[n] != n2 && (varType = client.fd.list(n)) != null) {
                            player.ed(player2, varType.debugNameHash32, fw152.s[n], n2);
                        }
                    }
                    return n;
                }
                Lo465.ef(lo465);
            }
            lo465 = (Lo465)Ha262.h(fw152.b);
        }
        return -1;
    }

    public void d() {
        for (int i = 0; i < client.fd.length(); ++i) {
            VarType varType = client.fd.list(i);
            if (varType == null || ((VarPlayerType)varType).clientCode != 0) continue;
            this.h[i] = 0;
            this.s[i] = 0;
        }
        this.b = new Ha262(128);
    }

    @Override
    public int getVarValueInt(VarType varType) {
        return this.s[varType.id];
    }

    @Override
    public void setVarValueInt(VarType varType, int n) {
        Lo465 lo465;
        logger.trace("Setting varp from client: {}", varType.id);
        int n2 = this.s[varType.id];
        this.s[varType.id] = n;
        player player2 = Gc330.j();
        if (player2 != null) {
            player.ed(player2, varType.debugNameHash32, n, n2);
        }
        if ((lo465 = (Lo465)Ha262.d(this.b, varType.id)) != null) {
            lo465.g = Gz143.g() + 500L;
        } else {
            lo465 = new Lo465(Gz143.g() + 500L);
            Ha262.q(this.b, lo465, varType.id);
        }
    }

    public void q(VarType varType, int n) {
        Lo465 lo465;
        logger.trace("Incoming varp from server: {}", varType.id);
        int n2 = this.h[varType.id];
        this.h[varType.id] = n;
        player player2 = Gc330.j();
        if (player2 != null) {
            player.ed(player2, varType.debugNameHash32, n, n2);
        }
        if ((lo465 = (Lo465)Ha262.d(this.b, varType.id)) != null) {
            if (lo465.g != 4611686018427387905L) {
                lo465.g = Gz143.g() + 500L | 0x4000000000000000L;
            }
        } else {
            lo465 = new Lo465(4611686018427387905L);
            Ha262.q(this.b, lo465, varType.id);
        }
    }

    @Override
    public int getVarBitValue(VarBitType varBitType) {
        return varBitType.getVarbitValue(this.s[varBitType.baseVar.id]);
    }

    @Override
    public void setVarValueLong(VarType varType, long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setVarBitValue(VarBitType varBitType, int n) throws VarBitOverflowException {
        logger.trace("Setting varbit from client: {}", varBitType.id);
        int n2 = varBitType.setVarbitValue(this.s[varBitType.baseVar.id], n);
        this.setVarValueInt(varBitType.baseVar, n2);
    }

    @Override
    public long getVarValueLong(VarType varType) {
        throw new UnsupportedOperationException();
    }

    public static void j(Fw152 fw152, VarBitType varBitType, int n) {
        logger.trace("Incoming varbit from server: {}", varBitType.id);
        try {
            int n2 = varBitType.setVarbitValue(fw152.h[varBitType.baseVar.id], n);
            fw152.q(varBitType.baseVar, n2);
        }
        catch (VarBitOverflowException varBitOverflowException) {
            logger.error("", varBitOverflowException);
        }
    }

    @Override
    public Object getVarValue(VarType varType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setVarValue(VarType varType, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canModifyVarValue(VarType varType) {
        return true;
    }
}

