// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.client.worldelement.player;
import rs2.client.client;
import org.slf4j.Logger;
import com.jagex.game.runetek6.config.vartype.VarDomain;

public final class Fw152 implements VarDomain
{
    private static final long d = 4611686018427387903L;
    private static final long e = 500L;
    private static final long j = 1L;
    private static final Logger logger;
    private static final long q = 4611686018427387904L;
    public Ha262 b;
    private int[] h;
    private int[] s;
    
    public Fw152() {
        this.b = new Ha262(128);
        this.h = new int[client.fd.length()];
        this.s = new int[client.fd.length()];
    }
    
    public static int g(final Fw152 fw152, final boolean b) {
        final player j = Gc330.j();
        final long g = Gz143.g();
        for (Lo465 lo465 = (Lo465)(b ? Ha262.e(fw152.b) : ((Lo465)Ha262.h(fw152.b))); lo465 != null; lo465 = (Lo465)Ha262.h(fw152.b)) {
            if ((lo465.g & 0x3FFFFFFFFFFFFFFFL) < g) {
                if ((lo465.g & 0x4000000000000000L) != 0x0L) {
                    Fw152.logger.trace("Copying server variable {}", lo465.bq);
                    final int n = (int)lo465.bq;
                    final int n2 = fw152.s[n];
                    fw152.s[n] = fw152.h[n];
                    Ln265.ef(lo465);
                    if (j != null) {
                        player.cv(j, n, fw152.s[n]);
                        if (fw152.s[n] != n2) {
                            final VarPlayerType list = client.fd.list(n);
                            if (list != null) {
                                GameEntity.ed(j, list.debugNameHash32, fw152.s[n], n2);
                            }
                        }
                    }
                    return n;
                }
                Ln265.ef(lo465);
            }
        }
        return -1;
    }
    
    public void d() {
        for (int i = 0; i < client.fd.length(); ++i) {
            final VarPlayerType list = client.fd.list(i);
            if (list != null && list.clientCode == 0) {
                this.h[i] = 0;
                this.s[i] = 0;
            }
        }
        this.b = new Ha262(128);
    }
    
    @Override
    public int getVarValueInt(final VarType varType) {
        return this.s[varType.id];
    }
    
    @Override
    public void setVarValueInt(final VarType varType, final int n) {
        Fw152.logger.trace("Setting varp from client: {}", varType.id);
        final int n2 = this.s[varType.id];
        this.s[varType.id] = n;
        final player j = Gc330.j();
        if (j != null) {
            GameEntity.ed(j, varType.debugNameHash32, n, n2);
        }
        final Lo465 lo465 = (Lo465)Ha262.d(this.b, varType.id);
        if (lo465 != null) {
            lo465.g = Gz143.g() + 500L;
        }
        else {
            Ha262.q(this.b, new Lo465(Gz143.g() + 500L), varType.id);
        }
    }
    
    public void q(final VarType varType, final int n) {
        Fw152.logger.trace("Incoming varp from server: {}", varType.id);
        final int n2 = this.h[varType.id];
        this.h[varType.id] = n;
        final player j = Gc330.j();
        if (j != null) {
            GameEntity.ed(j, varType.debugNameHash32, n, n2);
        }
        final Lo465 lo465 = (Lo465)Ha262.d(this.b, varType.id);
        if (lo465 != null) {
            if (lo465.g != 4611686018427387905L) {
                lo465.g = (Gz143.g() + 500L | 0x4000000000000000L);
            }
        }
        else {
            Ha262.q(this.b, new Lo465(4611686018427387905L), varType.id);
        }
    }
    
    @Override
    public int getVarBitValue(final VarBitType varBitType) {
        return varBitType.getVarbitValue(this.s[varBitType.baseVar.id]);
    }
    
    @Override
    public void setVarValueLong(final VarType varType, final long n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setVarBitValue(final VarBitType varBitType, final int n) throws VarBitOverflowException {
        Fw152.logger.trace("Setting varbit from client: {}", varBitType.id);
        this.setVarValueInt(varBitType.baseVar, varBitType.setVarbitValue(this.s[varBitType.baseVar.id], n));
    }
    
    @Override
    public long getVarValueLong(final VarType varType) {
        throw new UnsupportedOperationException();
    }
    
    public static void j(final Fw152 fw152, final VarBitType varBitType, final int n) {
        Fw152.logger.trace("Incoming varbit from server: {}", varBitType.id);
        try {
            fw152.q(varBitType.baseVar, varBitType.setVarbitValue(fw152.h[varBitType.baseVar.id], n));
        }
        catch (VarBitOverflowException ex) {
            Fw152.logger.error("", ex);
        }
    }
    
    @Override
    public Object getVarValue(final VarType varType) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setVarValue(final VarType varType, final Object o) {
        throw new UnsupportedOperationException();
    }
    
    static {
        logger = LoggerFactory.getLogger(Fw152.class);
    }
    
    @Override
    public boolean canModifyVarValue(final VarType varType) {
        return true;
    }
}
