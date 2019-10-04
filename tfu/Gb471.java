// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.EnumSet;
import rs2.client.client;
import rs2.client.worldelement.Npc;
import org.slf4j.Logger;

public class Gb471
{
    private static final Logger logger;
    
    public static final void g(final Gs329 gs329) {
        final Npc npc = client.ft.get(Bb4.e(gs329, Ed472.NPC));
        int bd = Gg3.bd(gs329);
        final EnumSet<Jn470> none = EnumSet.noneOf(Jn470.class);
        for (int i = 0; i < Jn470.values().length; ++i, bd >>>= 1) {
            if ((bd & 0x1) != 0x0) {
                none.add(Jn470.values()[i]);
            }
        }
        for (final Jn470 o : Jn470.values()) {
            if (none.contains(o)) {
                switch (Ga469.g[o.ordinal()]) {
                    case 1: {
                        Gb471.logger.warn("CHAT_LINE unhandled: '{}'", Gg3.bk(gs329));
                        break;
                    }
                    case 2: {
                        npc.by.b();
                        for (int n = gs329.r[gs329.v++] & 0xFF, k = 0; k < n; ++k) {
                            final Kr260 decodeVarValue = client.fn.decodeVarValue(gs329);
                            final Object h = npc.by.h(decodeVarValue.g);
                            npc.by.s(decodeVarValue.g, decodeVarValue.d);
                            if (!Kh56.g(decodeVarValue.d, h)) {
                                final Integer ex = GameEntity.ex(npc, client.fd.list(decodeVarValue.g).debugNameHash32);
                                if (ex != null) {
                                    npc.triggerEvent(ex, decodeVarValue.d);
                                }
                            }
                        }
                        break;
                    }
                    case 3: {
                        for (int n2 = gs329.r[gs329.v++] & 0xFF, l = 0; l < n2; ++l) {
                            final Kr260 decodeVarValue2 = client.fn.decodeVarValue(gs329);
                            final Object h2 = npc.by.h(decodeVarValue2.g);
                            npc.by.s(decodeVarValue2.g, decodeVarValue2.d);
                            if (!Kh56.g(decodeVarValue2.d, h2)) {
                                final Integer ex2 = GameEntity.ex(npc, client.fd.list(decodeVarValue2.g).debugNameHash32);
                                if (ex2 != null) {
                                    npc.triggerEvent(ex2, decodeVarValue2.d);
                                }
                            }
                        }
                        break;
                    }
                    case 4:
                    case 5: {
                        for (int ar = Gg3.ar(gs329), n3 = 0; n3 < ar; ++n3) {
                            final String bh = gs329.bh();
                            try {
                                Gb471.logger.info("Running {}", bh);
                                client.cj.runScriptEvent(bh, npc, null);
                            }
                            catch (Exception ex3) {
                                Gb471.logger.info("Script execution failed " + bh, ex3);
                            }
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Gb471.class);
    }
}
