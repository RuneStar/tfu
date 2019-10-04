/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.loading;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.Language;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes;
import com.jagex.game.runetek6.comms.broadcast.Flag;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.config.Js5Archive;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.ScriptManager$Init;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.jnibindings.runetek6.Decals;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import com.jagex.jnibindings.runetek6.ParticleEngine;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.StateManager;
import com.jagex.js5.G137;
import com.jagex.js5.J135;
import com.jagex.js5.L145;
import com.jagex.js5.Q138;
import com.jagex.js5.S136;
import com.jagex.js5.W144;
import com.jagex.js5.js5;
import com.jagex.maths.Vector3;
import java.awt.Canvas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.Al161;
import rs2.client.D150;
import rs2.client.J160;
import rs2.client.R146;
import rs2.client.ScriptCamera;
import rs2.client.W159;
import rs2.client.client;
import rs2.client.debugconsole;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.geographicentities.GeographicEntityScriptAPIClient;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.loading.G130;
import rs2.client.loading.Q162;
import rs2.client.login.Login;
import rs2.client.lua.ChatScriptAPI;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.lua.ClientScriptMessaging;
import rs2.client.lua.Mouse2ScriptAPI;
import rs2.client.lua.OffscreenSceneManager;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.sound.SoundManager;
import rs2.client.web.ClientURLTools;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.NpcComponent;
import rs2.client.worldelement.PlayerComponent;
import rs2.client.worldelement.player;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PhysicsQueryResultList;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.sound.SoundAdapter;
import rs2.shared.sound.SoundComponent;
import tfu.Ab158;
import tfu.Af155;
import tfu.Al154;
import tfu.Ap127;
import tfu.Aw157;
import tfu.Be2;
import tfu.Bk151;
import tfu.Bs1;
import tfu.Df147;
import tfu.Dh131;
import tfu.Fg140;
import tfu.Fr156;
import tfu.Fw152;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Gz143;
import tfu.H149;
import tfu.Hl134;
import tfu.Im133;
import tfu.Is139;
import tfu.J153;
import tfu.Kg142;
import tfu.Ks126;
import tfu.Kt125;
import tfu.Lb33;
import tfu.Lv148;
import tfu.Mk163;

@ScriptEntryClass(value="ClientCore")
public class Load {
    static G130[] d;
    private static G130 e;
    private static int h;
    private static long j;
    private static final Logger logger;
    private static long q;
    private static int s;

    private static void b() {
        String string = "log4j.properties";
        InputStream inputStream = logger.getClass().getClassLoader().getResourceAsStream(string);
        if (inputStream == null) {
            logger.error("cannot access {} in jar", (Object)string);
        }
        String string2 = new Scanner(inputStream).useDelimiter("\\A").next();
        logger.trace("log config: {}", (Object)string2);
        PrintWriter printWriter = null;
        try {
            try {
                String string3 = Dh131.d(string).getAbsolutePath();
                logger.trace("log config location will be {}", (Object)string3);
                printWriter = new PrintWriter(string3);
                printWriter.print(string2);
                if (printWriter != null) {
                    printWriter.close();
                }
            }
            catch (FileNotFoundException fileNotFoundException) {
                logger.error("cannot store Native logging configuration (" + string + ") to the disk", fileNotFoundException);
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        }
        catch (Throwable throwable) {
            if (printWriter != null) {
                printWriter.close();
            }
            throw throwable;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void output(String string) {
        if (string != null) {
            if (debugconsole.isavailable() && debugconsole.isopen()) {
                debugconsole.addline(string);
            }
            if (!Ap127.d) {
                System.out.println(string);
            }
        }
    }

    private static int d() {
        int n = e.ordinal();
        if (n < d.length - 1) {
            e = d[n + 1];
        }
        logger.debug("mainLoad: {}", (Object)e.name());
        Z132.q("LOAD_" + d[n].name());
        if (n < d.length - 1) {
            Ks126 ks126;
            e = d[n + 1];
            Z132.g("LOAD_" + d[e.ordinal()].name());
            if (Kt125.q() && (ks126 = Kt125.d()).j("JNIBindings") && ks126.e("JNIBindings")) {
                StateManager.sendEvent("End_" + d[n - 1].toString());
                StateManager.sendEvent("Start_" + e.toString());
            }
        }
        return 100;
    }

    public static js5 l(Js5Archive js5Archive, boolean bl, int n) {
        int n2 = js5Archive.getArchiveId();
        Hl134 hl134 = null;
        if (GameShell3.cacheDat != null) {
            hl134 = new Hl134(n2, GameShell3.cacheDat, GameShell3.cacheIndex[n2], 16777216);
        }
        if (client.ai != null && js5Archive.getDefaultName() != null) {
            if (client.t == D123.LOCAL) {
                XElement.q = true;
            }
            File file = new File(client.ai, js5Archive.getDefaultName() + ".js5");
            try {
                J135 j135 = new J135(file);
                J135.j(j135, !bl);
                client.dx[n2] = j135;
            }
            catch (IOException iOException) {
                logger.error("Failed to load " + file, iOException);
            }
        } else {
            Q138 q138 = G137.d(client.dt, n2, hl134, client.ej);
            client.dx[n2] = q138;
            q138.l();
        }
        return new js5(client.dx[n2], bl, n);
    }

    private static void s() {
        Is139 is139 = GameShell3.openPrefs("2", client.m.h, false);
        client.jr.q(is139);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Object GetVar(String string) {
        VarDomain varDomain;
        if (string == null) {
            throw new RuntimeException("null variable name passed to client GetVar");
        }
        int n = StringTools.l(string);
        VarBasicType varBasicType = (VarBasicType)client.fo.hashLookup(n);
        if (varBasicType == null) {
            varBasicType = (VarBasicType)client.fm.hashLookup(n);
        }
        if ((varDomain = Load.j(string, varBasicType)) != null) {
            switch (varBasicType.dataType.getVarBaseType()) {
                case INTEGER: {
                    return varDomain.getVarValueInt(varBasicType);
                }
                case LONG: {
                    return varDomain.getVarValueLong(varBasicType);
                }
                case STRING: {
                    return (String)varDomain.getVarValue(varBasicType);
                }
                case VECTOR3: {
                    return (Vector3)varDomain.getVarValue(varBasicType);
                }
            }
            return varDomain.getVarValue(varBasicType);
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVar(String string, Object object) {
        if (string == null) {
            throw new RuntimeException("null variable name passed to client SetVar");
        }
        int n = StringTools.l(string);
        VarBasicType varBasicType = (VarBasicType)client.fo.hashLookup(n);
        VarDomain varDomain = Load.j(string, varBasicType);
        if (varDomain != null) {
            switch (varBasicType.dataType.getVarBaseType()) {
                case INTEGER: {
                    if (!(object instanceof Double)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting client variable: '" + string + "'.");
                    }
                    varDomain.setVarValueInt(varBasicType, ((Double)object).intValue());
                    break;
                }
                case LONG: {
                    if (!(object instanceof Double)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting client variable: '" + string + "'.");
                    }
                    varDomain.setVarValueLong(varBasicType, ((Double)object).longValue());
                    break;
                }
                case STRING: {
                    if (!(object instanceof String)) {
                        throw new RuntimeException("Passed non-string type as value to SetVar when setting client variable: '" + string + "'.");
                    }
                    varDomain.setVarValue(varBasicType, (String)object);
                    break;
                }
                case VECTOR3: {
                    if (!(object instanceof Vector3) && !(object instanceof Kg142)) {
                        throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting client variable: '" + string + "'.");
                    }
                    if (object instanceof Vector3) {
                        varDomain.setVarValue(varBasicType, new Kg142((Vector3)object));
                        break;
                    }
                    varDomain.setVarValue(varBasicType, (Kg142)object);
                    break;
                }
                default: {
                    throw new RuntimeException("Passed unsupported type as value to SetVar when setting client variable: '" + string + "'.");
                }
            }
        }
    }

    private static VarDomain j(String string, VarType varType) {
        if (varType != null) {
            switch (varType.domain) {
                case CLIENT: {
                    if (client.jr == null) {
                        throw new RuntimeException("Tried retrieving client variable '" + string + "' before client variables have been loaded.");
                    }
                    return client.jr;
                }
                case CLAN: {
                    if (client.js == null) {
                        throw new RuntimeException("Tried retrieving clan (client) variable '" + string + "' before clan (client) variables have been loaded.");
                    }
                    return client.js;
                }
            }
        }
        throw new RuntimeException("Variable '" + string + "' not found in CLIENT or CLAN variable domains");
    }

    private static void e(byte[] arrby) {
        int n;
        Gg3 gg3 = new Gg3(arrby);
        while ((n = Gg3.ar(gg3)) != 0) {
            int n2;
            int n3;
            if (n == 1) {
                gg3.v += 12;
                continue;
            }
            if (n == 4) {
                n2 = Gg3.ar(gg3);
                for (n3 = 0; n3 < n2; ++n3) {
                    Gg3.au(gg3);
                }
                continue;
            }
            if (n == 5) {
                n2 = Gg3.ar(gg3);
                for (n3 = 0; n3 < n2; ++n3) {
                    Gg3.au(gg3);
                }
                continue;
            }
            if (n != 7) continue;
            float f = Gg3.bl(gg3);
            float f2 = Gg3.bl(gg3);
            float f3 = Gg3.bl(gg3);
            float f4 = Gg3.bl(gg3);
            Gh19.v = f;
            Gh19.p = f2;
            Gh19.y = f3;
            Gh19.x = f4;
        }
    }

    private static void h(byte[] arrby) {
        int n;
        Gg3 gg3 = new Gg3(arrby);
        while ((n = Gg3.ar(gg3)) != 0) {
            if (n != 1) continue;
            int n2 = Gg3.au(gg3);
            if (SoundManager.z != -1) continue;
            SoundManager.z = n2;
        }
    }

    public static void g() {
        if (d == null) {
            d = G130.values();
            e = d[0];
            Z132.g("LOAD_" + d[0].name());
        }
        h = Load.q();
        if (e == G130.LOADING_COMPLETE) {
            client.z(3);
        }
    }

    private static int q() {
        Lb33.g(Lb33.MainLoad);
        try {
            boolean bl;
            Object object;
            int n;
            if (client.w || client.ai != null) {
                // empty if block
            }
            boolean bl2 = bl = client.al != null && new File(client.al).exists();
            if (e == G130.WAIT_FOR_MEMORY) {
                object = Runtime.getRuntime();
                n = (int)((((Runtime)object).totalMemory() - ((Runtime)object).freeMemory()) / 1024L);
                long l = Gz143.g();
                if (j == 0L) {
                    j = l;
                }
                if (n > 16384 && l - j < 5000L) {
                    if (l - q > 1000L) {
                        System.gc();
                        q = l;
                    }
                    int n2 = 0;
                    Lb33.d(Lb33.MainLoad);
                    return n2;
                }
            }
            if (e == G130.INIT_NATIVE_REGISTRY) {
                if (client.dt == null) {
                    client.dt = new G137(client.dm, client.dj, R146.q, R146.j);
                }
                if (!client.dt.g()) {
                    int n3 = 0;
                    Lb33.d(Lb33.MainLoad);
                    return n3;
                }
                client.ey = Load.l(Js5Archive.DLLS, true, 1);
                client.ea = Load.l(Js5Archive.SHADERS, false, 0);
                client.el = new Df147(client.ey);
                Kt125.g(client.el);
                int n4 = Load.d();
                Lb33.d(Lb33.MainLoad);
                return n4;
            }
            if (e == G130.LOAD_NATIVE_DLLS) {
                if (client.el.d("JNIBindings") != 100) {
                    int n5 = 1;
                    Lb33.d(Lb33.MainLoad);
                    return n5;
                }
                if (!js5.l(client.ea)) {
                    int n6 = 1;
                    Lb33.d(Lb33.MainLoad);
                    return n6;
                }
            }
            if (e == G130.CONSTRUCT_TOOLKIT) {
                object = Kt125.d();
                if (object.j("JNIBindings") && !object.e("JNIBindings")) {
                    if (client.t != D123.LOCAL) {
                        Load.b();
                    }
                    logger.debug("Loading JNIBindings!");
                    if (!object.h("JNIBindings")) {
                        throw new RuntimeException("Failed to load JNIBindings");
                    }
                    logger.debug("JNIBindings loaded");
                    client.e = true;
                    logger.debug("start profiling");
                    Lv148.g(false);
                }
                Lb33.g(Lb33.ContructToolkitLoading);
                try {
                    Js5NativeInterface.g();
                    Js5NativeInterface.BindToThread();
                    if (!bl) {
                        Lb33.g(Lb33.RegisterSharedJs5);
                        try {
                            Js5NativeInterface.RegisterShaderJs5(client.ea);
                            Lb33.d(Lb33.RegisterSharedJs5);
                        }
                        catch (Throwable throwable) {
                            Lb33.d(Lb33.RegisterSharedJs5);
                            throw throwable;
                        }
                    }
                    Lb33.g(Lb33.InitNativeResourceLoader);
                    NativeResourceLoader.g();
                    Lb33.d(Lb33.InitNativeResourceLoader);
                    Object string = null;
                    if (bl) {
                        File file;
                        String file2 = System.getProperty("jagex.luadir");
                        File file3 = file = file2 != null ? new File(file2) : new File(client.al, "lua");
                        if (file.exists()) {
                            String gg3 = file.getPath();
                        }
                    }
                    Lb33.g(Lb33.CreateScriptManager);
                    client.cj = new ScriptManager(ScriptManager$Init.CLIENT.ordinal(), client.t);
                    Lb33.d(Lb33.CreateScriptManager);
                    H149.g(client.al, GameShell3.canvas);
                    Lb33.d(Lb33.ContructToolkitLoading);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.ContructToolkitLoading);
                    throw throwable;
                }
            }
            if (e == G130.OPEN_JS5_ARCHIVES) {
                Lb33.g(Lb33.JS5Open);
                try {
                    client.er = Load.l(Js5Archive.FONTMETRICS, false, 1);
                    client.dy = Load.l(Js5Archive.SPRITES, false, 1);
                    client.dr = Load.l(Js5Archive.CONFIG, false, 1);
                    client.db = Load.l(Js5Archive.SCALEFORM, false, 1);
                    client.dd = Load.l(Js5Archive.SCALEFORMDDS, false, 1);
                    client.dg = Load.l(Js5Archive.BINARY, false, 1);
                    client.ez = Load.l(Js5Archive.VORBIS, true, 1);
                    client.et = Load.l(Js5Archive.CONFIG_OBJ, false, 1);
                    client.eu = Load.l(Js5Archive.DEFAULTS, true, 1);
                    client.eg = Load.l(Js5Archive.GFX_CONFIG, false, 1);
                    client.em = Load.l(Js5Archive.MATERIALS, false, 1);
                    client.eh = Load.l(Js5Archive.MESHES, true, 2);
                    client.es = Load.l(Js5Archive.SKELETONS, false, 1);
                    client.ec = Load.l(Js5Archive.ANIMCLIPS, true, 2);
                    client.ei = Load.l(Js5Archive.DDSTEXTURES, true, 2);
                    client.eo = Load.l(Js5Archive.PHYSICAL_GEOMETRY, false, 1);
                    client.ef = Load.l(Js5Archive.XMAPS, true, 2);
                    client.ek = Load.l(Js5Archive.XELEMENTS, false, 2);
                    client.ep = Load.l(Js5Archive.STATES, false, 1);
                    client.eb = Load.l(Js5Archive.XAREAS, false, 2);
                    client.ee = Load.l(Js5Archive.CLIENT_LUA, true, 0);
                    Lb33.d(Lb33.JS5Open);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.JS5Open);
                    throw throwable;
                }
            }
            if (e == G130.GET_JS5_INDEXES) {
                int n11;
                int n8 = 0;
                n = 0;
                for (n11 = 0; n11 < Js5Archive.getRequiredArrayLength(); ++n11) {
                    if (client.dx[n11] == null) continue;
                    n8 += client.dx[n11].g();
                    ++n;
                }
                if (n8 < n * 100) {
                    if (s < 0) {
                        s = n8;
                    }
                    n11 = (n8 - s) * 100 / (100 - s);
                    Lb33.d(Lb33.MainLoad);
                    return n11;
                }
                D150.g(client.dy);
            }
            if (e == G130.DOWNLOAD_STUFF) {
                int n9;
                if (client.ai == null && (n9 = Bk151.g()) < 100) {
                    n = n9;
                    Lb33.d(Lb33.MainLoad);
                    return n;
                }
                Load.e(js5.y(client.eu, DefaultsGroup.MAP.js5GroupId));
                client.fz = new GraphicsDefaults(client.eu);
                object = js5.f(client.ek, "_propertynameindex", "");
                Gg3 gg3 = new Gg3((byte[])object);
                Q79 n13 = Q79.e(gg3);
                client.an(n13, client.ai);
            }
            if (e == G130.REGISTER_NATIVE_JS5S) {
                Js5NativeInterface.RegisterTextureJs5(client.ei, !bl);
                Js5NativeInterface.RegisterAnimationJs5(client.ec);
                if (!bl) {
                    Js5NativeInterface.RegisterLuaJs5(client.ee, client.ee);
                    Js5NativeInterface.RegisterScaleformJs5(client.db, client.dd);
                    Js5NativeInterface.RegisterAnimationGraphJs5(client.eg);
                    Js5NativeInterface.RegisterGroundCoverLayerInstanceJs5(client.eg);
                }
            }
            if (e == G130.SETUP_CONFIG_DECODERS) {
                client.fh = new ParamTypeList(client.m, client.n, client.dr);
                client.en = new CursorTypeList(client.m, client.n, client.dr, client.dy);
                client.fv = new InvTypeList(client.m, client.n, client.dr);
                client.fa = new ObjTypeList(client.m, client.n, true, client.fh, client.et, client.eh);
                client.fo = new VarBasicTypeListClient(client.m, VarDomainType.CLIENT, client.n, client.dr);
                client.fd = new VarPlayerTypeListClient(client.m, VarDomainType.PLAYER, client.n, client.dr);
                client.fi = new VarBasicTypeListClient(client.m, VarDomainType.OBJECT, client.n, client.dr);
                client.fn = new VarBasicTypeListClient(client.m, VarDomainType.NPC, client.n, client.dr);
                client.fm = new VarBasicTypeListClient(client.m, VarDomainType.CLAN, client.n, client.dr);
                client.fs = new VarBasicTypeListClient(client.m, VarDomainType.CLAN_SETTING, client.n, client.dr);
                client.fp = VarTypeList.createDomainToListEnumMap(client.fo, client.fd, client.fi, client.fn, client.fm, client.fs);
                client.fl = new VarBitTypeListClient(client.m, client.n, client.dr, client.fp);
                client.fo.createHashMapLookup();
                client.fd.createHashMapLookup();
                client.fi.createHashMapLookup();
                client.fn.createHashMapLookup();
                client.fm.createHashMapLookup();
                client.fl.createHashMapLookup();
                client.jw = new Fw152();
            }
            if (e == G130.SETUP_SOUND_LIBRARY) {
                object = js5.p(client.eu, DefaultsGroup.AUDIO.js5GroupId);
                if (object == null) {
                    n = 0;
                    Lb33.d(Lb33.MainLoad);
                    return n;
                }
                Load.h((byte[])object);
                SoundManager.g();
            }
            if (e == G130.SETUP_GRAPHICS_CONFIGURATIONS) {
                ParticleEngine.q(client.eg, "Materials");
                ParticleEngine.d(client.eg, "Meshes");
                ParticleEngine.g(client.eg, "Particles");
                Decals.d(client.eg, "DecalMaterials");
                Decals.g(client.eg, "Decals");
                GroundCover.g(H149.u, client.eg);
            }
            if (e == G130.INIT_SCRIPTING) {
                if (client.al == null) {
                    StateManager.g(client.ep, "states");
                } else {
                    StateManager.load(client.al + "/states/");
                }
                J153.g();
                client.cj.createGlobalFunction("System.Write", String.format("%s ClientCore.Output(\"Lua> \" .. str)", "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end "));
                client.cj.createGlobalFunction("IsServer", "return false");
                client.cj.createGlobalFunction("IsClient", "return true");
                client.cj.registerScriptAPI(ClientScriptMessaging.class);
                client.cj.executeScriptFromMemory("_G.engineBranch=\"scaleform\"");
                object = new StringBuffer("CollisionGroup={");
                for (Gn5 gn5 : Gn5.values()) {
                    ((StringBuffer)object).append(gn5.name());
                    ((StringBuffer)object).append("=");
                    ((StringBuffer)object).append(gn5.ordinal());
                    ((StringBuffer)object).append(",");
                }
                if (Gn5.values().length > 0) {
                    ((StringBuffer)object).setLength(((StringBuffer)object).length() - 1);
                }
                ((StringBuffer)object).append("} CollisionMask={");
                for (Gj16 gj16 : Gj16.values()) {
                    ((StringBuffer)object).append(gj16.name());
                    ((StringBuffer)object).append("=");
                    ((StringBuffer)object).append(gj16.az);
                    ((StringBuffer)object).append(",");
                }
                if (Gj16.values().length > 0) {
                    ((StringBuffer)object).setLength(((StringBuffer)object).length() - 1);
                }
                ((StringBuffer)object).append("}");
                client.cj.executeScriptFromMemory(((StringBuffer)object).toString());
                client.cj.registerScriptAPI(Load.class);
                client.cj.createGlobalFunction("GetVar", "return ClientCore.GetVar(...)");
                client.cj.createGlobalFunction("SetVar", "return ClientCore.SetVar(...)");
                client.cj.registerScriptAPI(SceneGraphNode.class);
                client.cj.registerScriptAPI(XElementLibrary.class);
                client.cj.registerScriptAPI(XElement.class);
                client.cj.registerScriptAPI(GameEntity.class);
                client.cj.registerScriptAPI(TimerComponent.class);
                client.cj.registerScriptAPI(AnimationGraphComponent.class);
                client.cj.registerScriptAPI(ClientScriptAPI.class);
                client.cj.registerScriptAPI(Mouse2ScriptAPI.class);
                client.cj.registerScriptAPI(NpcComponent.class);
                client.cj.registerScriptAPI(PlayerComponent.class);
                client.cj.registerScriptAPI(PhysicsComponent.class);
                client.cj.registerScriptAPI(SoundComponent.class);
                client.cj.registerScriptAPI(SoundAdapter.class);
                client.cj.registerScriptAPI(PlayerPhysicsComponent.class);
                client.cj.registerScriptAPI(PlayerAvatarDescriptor.class);
                client.cj.registerScriptAPI(PhysicsWorldWrapper.class);
                client.cj.registerScriptAPI(PhysicsQueryResultList.class);
                client.cj.registerScriptAPI(CollisionObjectData.class);
                client.cj.registerScriptAPI(ProcessLogicEventComponent.class);
                client.cj.registerScriptAPI(ScriptCamera.class);
                client.cj.registerScriptAPI(Scene.class);
                client.cj.registerScriptAPI(SoundManager.class);
                client.cj.registerScriptAPI(MappedEventComponent.class);
                client.cj.registerScriptAPI(ScriptablePickResult.class);
                client.cj.registerScriptAPI(Login.class);
                client.cj.registerScriptAPI(BroadcastStateAndEventsTypes.class);
                client.cj.registerScriptAPI(Flag.class);
                client.cj.registerScriptAPI(GeographicEntityScriptAPIClient.class);
                client.cj.registerScriptAPI(GeographicEntityWrangler.class);
                client.cj.registerScriptAPI(GeographicEntityWranglerClient.class);
                client.cj.registerScriptAPI(ScheduledMovementComponent.class);
                client.cj.registerScriptAPI(ClientFriendListComponent.class);
                client.cj.registerScriptAPI(OffscreenSceneManager.class);
                client.cj.registerScriptAPI(ChatScriptAPI.class);
                client.cj.registerScriptAPI(player.class);
                client.cj.registerScriptAPI(Npc.class);
                client.cj.registerScriptAPI(ClientURLTools.class);
                client.cj.executeScriptFromMemory("_G.player = nil _G.Npc = nil");
                Scripting.postRegisterScriptAPI(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef());
                client.cj.registerScriptAPI(debugconsole.class);
                DebugDialog.q(client.cj);
                client.cj.executeScriptFromMemory("_G.requestLoginGame = function(a,b) LoginManager.requestLoginGame(a,b) end");
                debugconsole.initNative();
                client.initNative();
                Mouse2ScriptAPI.initNativeMouse(client.cj.getLuaStateNativeRef());
                String string = System.getProperty("jagex.luadir");
                File file = null;
                if (bl || string != null) {
                    file = string != null ? new File(string) : new File(client.al, "lua");
                    client.cj.executeScriptFromMemory("package[\"root\"] = \"" + file.getPath().replace("\\", "/") + "\" " + "package[\"path\"] = \"" + file.getPath().replace("\\", "\\\\") + "\\\\?.lua;.\\\\?.lua\" " + "package[\"canDebug\"] = true");
                    logger.info("Loading lua from src");
                    client.cj.initResourceManagerFromSource(file);
                } else {
                    logger.info("Loading lua from pack");
                    client.cj.initResourceManagerFromJS5(client.ee, client.ee);
                }
                Scripting.initLuaProtocolBuffers(client.cj.getLuaStateNativeRef(), file == null ? null : file.getPath());
                client.cj.loadAllScripts();
                ClientScriptMessaging.g(client.cj.getAllProtocolBufferDefinitions(), !bl);
                Scripting.populateFunctionTable(client.cj.getLuaStateNativeRef());
                Scripting.enableScriptProfiler(true);
                client.cj.runRaw("initClient", new Object[0]);
                LuaNativeEvents.g();
                Al154 al154 = new Al154(js5.f(client.dg, "huffman", ""));
                Af155.g(al154);
                client.aj = new Fr156(false);
            }
            if (e == G130.SETUP_STATIC_SPRITES) {
                int n10;
                if (client.eq == null) {
                    client.eq = new Aw157(client.dy, client.er, D150.d());
                }
                if ((n10 = Aw157.q(client.eq, true)) < (n = Aw157.j(client.eq))) {
                    int n3 = n10 * 100 / n;
                    Lb33.d(Lb33.MainLoad);
                    return n3;
                }
            }
            if (e == G130.FETCH_FONTS) {
                int n12 = Aw157.d(client.eq);
                if (n12 < (n = Aw157.j(client.eq))) {
                    int n4 = n12 * 100 / n;
                    Lb33.d(Lb33.MainLoad);
                    return n4;
                }
                client.eq.g(client.ew);
                D150.q();
            }
            if (e == G130.SETUP_VARC_SYSTEM) {
                client.jr = new Fg140(client.fo);
                Load.s();
                js5.n(client.dy, true, true);
                js5.n(client.er, true, true);
                js5.n(client.dg, true, true);
                client.bg = true;
                client.dr.m = 2;
                client.et.m = 2;
            }
            if (e == G130.CLEANUP) {
                client.f(W159.g().j, -1, -1, false);
                Al161.g();
            }
            Lb33.d(Lb33.MainLoad);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.MainLoad);
            throw throwable;
        }
        return Load.d();
    }

    static {
        logger = LoggerFactory.getLogger(Load.class);
        q = 0L;
        j = 0L;
        s = -1;
    }

    public static Q162 w() {
        int n;
        if (Load.e.o) {
            int n2 = Load.e.k - Load.e.n;
            n = Load.e.n + n2 * h / 100;
        } else {
            n = Load.e.n;
        }
        return new Q162(Mk163.g(Load.e.t, Language.EN), n);
    }
}

