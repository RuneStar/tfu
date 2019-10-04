/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.script.ScriptManager;
import java.util.EnumSet;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.worldelement.L51;
import rs2.client.worldelement.Npc;
import tfu.Bb4;
import tfu.Ed472;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Jn470;
import tfu.Kh56;
import tfu.Kr260;
import tfu.Mn54;

public class Gb471 {
    private static final Logger logger = LoggerFactory.getLogger(Gb471.class);

    public static final void g(Gs329 gs329) {
        Bb4 bb4 = Bb4.e(gs329, Ed472.NPC);
        Npc npc = (Npc)client.ft.get(bb4);
        int n = Gs329.bd(gs329);
        EnumSet<Jn470> enumSet = EnumSet.noneOf(Jn470.class);
        int n2 = 0;
        while (n2 < Jn470.values().length) {
            if ((n & 1) != 0) {
                enumSet.add(Jn470.values()[n2]);
            }
            ++n2;
            n >>>= 1;
        }
        block9 : for (Jn470 jn470 : Jn470.values()) {
            if (!enumSet.contains(jn470)) continue;
            switch (jn470) {
                case CHAT_LINE: {
                    logger.warn("CHAT_LINE unhandled: '{}'", (Object)Gs329.bk(gs329));
                    continue block9;
                }
                case VARIABLE_FULL: {
                    Integer n3;
                    Object object;
                    VarType varType;
                    Object object2;
                    int n4;
                    npc.by.b();
                    int n5 = gs329.r[gs329.v++] & 0xFF;
                    for (n4 = 0; n4 < n5; ++n4) {
                        object2 = client.fn.decodeVarValue(gs329);
                        object = npc.by.h(((Kr260)object2).g);
                        npc.by.s(((Kr260)object2).g, ((Kr260)object2).d);
                        if (Kh56.g(((Kr260)object2).d, object)) continue;
                        varType = client.fd.list(((Kr260)object2).g);
                        n3 = Npc.ex(npc, varType.debugNameHash32);
                        if (n3 == null) continue;
                        npc.triggerEvent(n3, ((Kr260)object2).d);
                    }
                    continue block9;
                }
                case VARIABLE_PARTIAL: {
                    Integer n3;
                    Object object;
                    VarType varType;
                    Object object2;
                    int n4;
                    int n5 = gs329.r[gs329.v++] & 0xFF;
                    for (n4 = 0; n4 < n5; ++n4) {
                        object2 = client.fn.decodeVarValue(gs329);
                        object = npc.by.h(((Kr260)object2).g);
                        npc.by.s(((Kr260)object2).g, ((Kr260)object2).d);
                        if (Kh56.g(((Kr260)object2).d, object)) continue;
                        varType = client.fd.list(((Kr260)object2).g);
                        n3 = Npc.ex(npc, varType.debugNameHash32);
                        if (n3 == null) continue;
                        npc.triggerEvent(n3, ((Kr260)object2).d);
                    }
                    continue block9;
                }
                case CLIENT_ROUTINE_FULL: 
                case CLIENT_ROUTINE_PARTIAL: {
                    Object object2;
                    int n4;
                    int n5 = Gs329.ar(gs329);
                    for (n4 = 0; n4 < n5; ++n4) {
                        object2 = gs329.bh();
                        try {
                            logger.info("Running {}", object2);
                            client.cj.runScriptEvent((String)object2, npc, null);
                            continue;
                        }
                        catch (Exception exception) {
                            logger.info("Script execution failed " + (String)object2, exception);
                        }
                    }
                    continue block9;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
    }
}

