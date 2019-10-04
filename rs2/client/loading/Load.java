// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.loading;

import com.jagex.js5.Q138;
import tfu.Mk163;
import com.jagex.core.constants.Language;
import org.slf4j.LoggerFactory;
import rs2.client.Al161;
import rs2.client.W159;
import tfu.Fg140;
import tfu.Aw157;
import tfu.Fr156;
import tfu.Af155;
import tfu.Al154;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.lua.debugdialog.DebugDialog;
import com.jagex.jnibindings.runetek6.Scripting;
import rs2.client.web.ClientURLTools;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.player;
import rs2.client.lua.ChatScriptAPI;
import rs2.client.lua.OffscreenSceneManager;
import rs2.client.friends.ClientFriendListComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import rs2.client.geographicentities.GeographicEntityScriptAPIClient;
import com.jagex.game.runetek6.comms.broadcast.Flag;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes;
import rs2.client.login.Login;
import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import rs2.client.ScriptCamera;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsQueryResultList;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.sound.SoundAdapter;
import rs2.shared.sound.SoundComponent;
import rs2.shared.movement.PhysicsComponent;
import rs2.client.worldelement.PlayerComponent;
import rs2.client.worldelement.NpcComponent;
import rs2.client.lua.Mouse2ScriptAPI;
import rs2.client.lua.ClientScriptAPI;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import tfu.Gj16;
import tfu.Gn5;
import rs2.client.lua.ClientScriptMessaging;
import tfu.J153;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.Decals;
import com.jagex.jnibindings.runetek6.ParticleEngine;
import tfu.Fw152;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import tfu.Bk151;
import rs2.client.D150;
import tfu.H149;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.ScriptManager$Init;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import tfu.Lv148;
import tfu.Df147;
import rs2.client.R146;
import tfu.Gz143;
import tfu.Lb33;
import rs2.client.sound.SoundManager;
import tfu.Gh19;
import tfu.Gg3;
import tfu.Kg142;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.G137;
import java.io.IOException;
import com.jagex.js5.J135;
import java.io.File;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.core.constants.D123;
import rs2.client.client;
import tfu.Hl134;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.js5.js5;
import com.jagex.game.runetek6.config.Js5Archive;
import tfu.Ks126;
import com.jagex.jnibindings.runetek6.StateManager;
import tfu.Kt125;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Ap127;
import rs2.client.debugconsole;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import tfu.Dh131;
import java.util.Scanner;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("ClientCore")
public class Load
{
    static G130[] d;
    private static G130 e;
    private static int h;
    private static long j;
    private static final Logger logger;
    private static long q;
    private static int s;
    
    private static void b() {
        final String s = "log4j.properties";
        final InputStream resourceAsStream = Load.logger.getClass().getClassLoader().getResourceAsStream(s);
        if (resourceAsStream == null) {
            Load.logger.error("cannot access {} in jar", s);
        }
        final String next = new Scanner(resourceAsStream).useDelimiter("\\A").next();
        Load.logger.trace("log config: {}", next);
        PrintWriter printWriter = null;
        try {
            final String absolutePath = Dh131.d(s).getAbsolutePath();
            Load.logger.trace("log config location will be {}", absolutePath);
            printWriter = new PrintWriter(absolutePath);
            printWriter.print(next);
        }
        catch (FileNotFoundException ex) {
            Load.logger.error("cannot store Native logging configuration (" + s + ") to the disk", ex);
        }
        finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void output(final String x) {
        if (x != null) {
            if (debugconsole.isavailable() && debugconsole.isopen()) {
                debugconsole.addline(x);
            }
            if (!Ap127.d) {
                System.out.println(x);
            }
        }
    }
    
    private static int d() {
        final int ordinal = Load.e.ordinal();
        if (ordinal < Load.d.length - 1) {
            Load.e = Load.d[ordinal + 1];
        }
        Load.logger.debug("mainLoad: {}", Load.e.name());
        Z132.q("LOAD_" + Load.d[ordinal].name());
        if (ordinal < Load.d.length - 1) {
            Load.e = Load.d[ordinal + 1];
            Z132.g("LOAD_" + Load.d[Load.e.ordinal()].name());
            if (Kt125.q()) {
                final Ks126 d = Kt125.d();
                if (d.j("JNIBindings") && d.e("JNIBindings")) {
                    StateManager.sendEvent("End_" + Load.d[ordinal - 1].toString());
                    StateManager.sendEvent("Start_" + Load.e.toString());
                }
            }
        }
        return 100;
    }
    
    public static js5 l(final Js5Archive js5Archive, final boolean b, final int n) {
        final int archiveId = js5Archive.getArchiveId();
        Hl134 hl134 = null;
        if (GameShell3.cacheDat != null) {
            hl134 = new Hl134(archiveId, GameShell3.cacheDat, GameShell3.cacheIndex[archiveId], 16777216);
        }
        if (client.ai != null && js5Archive.getDefaultName() != null) {
            if (client.t == D123.LOCAL) {
                XElement.q = true;
            }
            final File obj = new File(client.ai, js5Archive.getDefaultName() + ".js5");
            try {
                final J135 j135 = new J135(obj);
                J135.j(j135, !b);
                client.dx[archiveId] = j135;
            }
            catch (IOException ex) {
                Load.logger.error("Failed to load " + obj, ex);
            }
        }
        else {
            ((Q138)(client.dx[archiveId] = G137.d(client.dt, archiveId, hl134, client.ej))).l();
        }
        return new js5(client.dx[archiveId], b, n);
    }
    
    private static void s() {
        client.jr.q(GameShell3.openPrefs("2", client.m.h, false));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Object GetVar(final String s) {
        if (s == null) {
            throw new RuntimeException("null variable name passed to client GetVar");
        }
        final int l = StringTools.l(s);
        VarBasicType varBasicType = (VarBasicType)client.fo.hashLookup(l);
        if (varBasicType == null) {
            varBasicType = (VarBasicType)client.fm.hashLookup(l);
        }
        final VarDomain j = j(s, varBasicType);
        if (j == null) {
            return null;
        }
        switch (D141.d[varBasicType.dataType.getVarBaseType().ordinal()]) {
            case 1: {
                return j.getVarValueInt(varBasicType);
            }
            case 2: {
                return j.getVarValueLong(varBasicType);
            }
            case 3: {
                return j.getVarValue(varBasicType);
            }
            case 4: {
                return j.getVarValue(varBasicType);
            }
            default: {
                return j.getVarValue(varBasicType);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetVar(final String str, final Object o) {
        if (str == null) {
            throw new RuntimeException("null variable name passed to client SetVar");
        }
        final VarBasicType varBasicType = (VarBasicType)client.fo.hashLookup(StringTools.l(str));
        final VarDomain j = j(str, varBasicType);
        if (j != null) {
            switch (D141.d[varBasicType.dataType.getVarBaseType().ordinal()]) {
                case 1: {
                    if (!(o instanceof Double)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting client variable: '" + str + "'.");
                    }
                    j.setVarValueInt(varBasicType, ((Double)o).intValue());
                    break;
                }
                case 2: {
                    if (!(o instanceof Double)) {
                        throw new RuntimeException("Passed non-number type as value to SetVar when setting client variable: '" + str + "'.");
                    }
                    j.setVarValueLong(varBasicType, ((Double)o).longValue());
                    break;
                }
                case 3: {
                    if (!(o instanceof String)) {
                        throw new RuntimeException("Passed non-string type as value to SetVar when setting client variable: '" + str + "'.");
                    }
                    j.setVarValue(varBasicType, o);
                    break;
                }
                case 4: {
                    if (!(o instanceof Vector3) && !(o instanceof Kg142)) {
                        throw new RuntimeException("Passed non-Vector3 type as value to SetVar when setting client variable: '" + str + "'.");
                    }
                    if (o instanceof Vector3) {
                        j.setVarValue(varBasicType, new Kg142((Vector3)o));
                        break;
                    }
                    j.setVarValue(varBasicType, o);
                    break;
                }
                default: {
                    throw new RuntimeException("Passed unsupported type as value to SetVar when setting client variable: '" + str + "'.");
                }
            }
        }
    }
    
    private static VarDomain j(final String str, final VarType varType) {
        if (varType != null) {
            switch (D141.g[varType.domain.ordinal()]) {
                case 1: {
                    if (client.jr == null) {
                        throw new RuntimeException("Tried retrieving client variable '" + str + "' before client variables have been loaded.");
                    }
                    return client.jr;
                }
                case 2: {
                    if (client.js == null) {
                        throw new RuntimeException("Tried retrieving clan (client) variable '" + str + "' before clan (client) variables have been loaded.");
                    }
                    return client.js;
                }
            }
        }
        throw new RuntimeException("Variable '" + str + "' not found in CLIENT or CLAN variable domains");
    }
    
    private static void e(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            if (ar == 1) {
                final Gg3 gg4 = gg3;
                gg4.v += 12;
            }
            else if (ar == 4) {
                for (int ar2 = Gg3.ar(gg3), i = 0; i < ar2; ++i) {
                    Gg3.au(gg3);
                }
            }
            else if (ar == 5) {
                for (int ar3 = Gg3.ar(gg3), j = 0; j < ar3; ++j) {
                    Gg3.au(gg3);
                }
            }
            else {
                if (ar != 7) {
                    continue;
                }
                final float bl = Gg3.bl(gg3);
                final float bl2 = Gg3.bl(gg3);
                final float bl3 = Gg3.bl(gg3);
                final float bl4 = Gg3.bl(gg3);
                Gh19.v = bl;
                Gh19.p = bl2;
                Gh19.y = bl3;
                Gh19.x = bl4;
            }
        }
    }
    
    private static void h(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        while (true) {
            final int ar = Gg3.ar(gg3);
            if (ar == 0) {
                break;
            }
            if (ar != 1) {
                continue;
            }
            final int au = Gg3.au(gg3);
            if (SoundManager.z != -1) {
                continue;
            }
            SoundManager.z = au;
        }
    }
    
    public static void g() {
        if (Load.d == null) {
            Load.d = G130.values();
            Load.e = Load.d[0];
            Z132.g("LOAD_" + Load.d[0].name());
        }
        Load.h = q();
        if (Load.e == G130.LOADING_COMPLETE) {
            client.z(3);
        }
    }
    
    private static int q() {
        Lb33.g(Lb33.MainLoad);
        try {
            if (client.w || client.ai != null) {}
            final boolean b = client.al != null && new File(client.al).exists();
            if (Load.e == G130.WAIT_FOR_MEMORY) {
                final Runtime runtime = Runtime.getRuntime();
                final int n = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                final long g = Gz143.g();
                if (Load.j == 0L) {
                    Load.j = g;
                }
                if (n > 16384 && g - Load.j < 5000L) {
                    if (g - Load.q > 1000L) {
                        System.gc();
                        Load.q = g;
                    }
                    return 0;
                }
            }
            if (Load.e == G130.INIT_NATIVE_REGISTRY) {
                if (client.dt == null) {
                    client.dt = new G137(client.dm, client.dj, R146.q, R146.j);
                }
                if (!client.dt.g()) {
                    return 0;
                }
                client.ey = l(Js5Archive.DLLS, true, 1);
                client.ea = l(Js5Archive.SHADERS, false, 0);
                Kt125.g(client.el = new Df147(client.ey));
                return d();
            }
            else {
                if (Load.e == G130.LOAD_NATIVE_DLLS) {
                    if (client.el.d("JNIBindings") != 100) {
                        return 1;
                    }
                    if (!js5.l(client.ea)) {
                        return 1;
                    }
                }
                if (Load.e == G130.CONSTRUCT_TOOLKIT) {
                    final Ks126 d = Kt125.d();
                    if (d.j("JNIBindings") && !d.e("JNIBindings")) {
                        if (client.t != D123.LOCAL) {
                            b();
                        }
                        Load.logger.debug("Loading JNIBindings!");
                        if (!d.h("JNIBindings")) {
                            throw new RuntimeException("Failed to load JNIBindings");
                        }
                        Load.logger.debug("JNIBindings loaded");
                        client.e = true;
                        Load.logger.debug("start profiling");
                        Lv148.g(false);
                    }
                    Lb33.g(Lb33.ContructToolkitLoading);
                    try {
                        Js5NativeInterface.g();
                        Js5NativeInterface.BindToThread();
                        if (!b) {
                            Lb33.g(Lb33.RegisterSharedJs5);
                            try {
                                Js5NativeInterface.RegisterShaderJs5(client.ea);
                            }
                            finally {
                                Lb33.d(Lb33.RegisterSharedJs5);
                            }
                        }
                        Lb33.g(Lb33.InitNativeResourceLoader);
                        try {
                            NativeResourceLoader.g();
                        }
                        finally {
                            Lb33.d(Lb33.InitNativeResourceLoader);
                        }
                        if (b) {
                            final String property = System.getProperty("jagex.luadir");
                            final File file = (property != null) ? new File(property) : new File(client.al, "lua");
                            if (file.exists()) {
                                file.getPath();
                            }
                        }
                        Lb33.g(Lb33.CreateScriptManager);
                        try {
                            client.cj = new ScriptManager(ScriptManager$Init.CLIENT.ordinal(), client.t);
                        }
                        finally {
                            Lb33.d(Lb33.CreateScriptManager);
                        }
                        H149.g(client.al, GameShell3.canvas);
                    }
                    finally {
                        Lb33.d(Lb33.ContructToolkitLoading);
                    }
                }
                if (Load.e == G130.OPEN_JS5_ARCHIVES) {
                    Lb33.g(Lb33.JS5Open);
                    try {
                        client.er = l(Js5Archive.FONTMETRICS, false, 1);
                        client.dy = l(Js5Archive.SPRITES, false, 1);
                        client.dr = l(Js5Archive.CONFIG, false, 1);
                        client.db = l(Js5Archive.SCALEFORM, false, 1);
                        client.dd = l(Js5Archive.SCALEFORMDDS, false, 1);
                        client.dg = l(Js5Archive.BINARY, false, 1);
                        client.ez = l(Js5Archive.VORBIS, true, 1);
                        client.et = l(Js5Archive.CONFIG_OBJ, false, 1);
                        client.eu = l(Js5Archive.DEFAULTS, true, 1);
                        client.eg = l(Js5Archive.GFX_CONFIG, false, 1);
                        client.em = l(Js5Archive.MATERIALS, false, 1);
                        client.eh = l(Js5Archive.MESHES, true, 2);
                        client.es = l(Js5Archive.SKELETONS, false, 1);
                        client.ec = l(Js5Archive.ANIMCLIPS, true, 2);
                        client.ei = l(Js5Archive.DDSTEXTURES, true, 2);
                        client.eo = l(Js5Archive.PHYSICAL_GEOMETRY, false, 1);
                        client.ef = l(Js5Archive.XMAPS, true, 2);
                        client.ek = l(Js5Archive.XELEMENTS, false, 2);
                        client.ep = l(Js5Archive.STATES, false, 1);
                        client.eb = l(Js5Archive.XAREAS, false, 2);
                        client.ee = l(Js5Archive.CLIENT_LUA, true, 0);
                    }
                    finally {
                        Lb33.d(Lb33.JS5Open);
                    }
                }
                if (Load.e == G130.GET_JS5_INDEXES) {
                    int s = 0;
                    int n2 = 0;
                    for (int i = 0; i < Js5Archive.getRequiredArrayLength(); ++i) {
                        if (client.dx[i] != null) {
                            s += client.dx[i].g();
                            ++n2;
                        }
                    }
                    if (s < n2 * 100) {
                        if (Load.s < 0) {
                            Load.s = s;
                        }
                        return (s - Load.s) * 100 / (100 - Load.s);
                    }
                    D150.g(client.dy);
                }
                if (Load.e == G130.DOWNLOAD_STUFF) {
                    if (client.ai == null) {
                        final int g2 = Bk151.g();
                        if (g2 < 100) {
                            return g2;
                        }
                    }
                    e(js5.y(client.eu, DefaultsGroup.MAP.js5GroupId));
                    client.fz = new GraphicsDefaults(client.eu);
                    client.an(Q79.e(new Gg3(js5.f(client.ek, "_propertynameindex", ""))), client.ai);
                }
                if (Load.e == G130.REGISTER_NATIVE_JS5S) {
                    Js5NativeInterface.RegisterTextureJs5(client.ei, !b);
                    Js5NativeInterface.RegisterAnimationJs5(client.ec);
                    if (!b) {
                        Js5NativeInterface.RegisterLuaJs5(client.ee, client.ee);
                        Js5NativeInterface.RegisterScaleformJs5(client.db, client.dd);
                        Js5NativeInterface.RegisterAnimationGraphJs5(client.eg);
                        Js5NativeInterface.RegisterGroundCoverLayerInstanceJs5(client.eg);
                    }
                }
                if (Load.e == G130.SETUP_CONFIG_DECODERS) {
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
                if (Load.e == G130.SETUP_SOUND_LIBRARY) {
                    final byte[] p = js5.p(client.eu, DefaultsGroup.AUDIO.js5GroupId);
                    if (p == null) {
                        return 0;
                    }
                    h(p);
                    SoundManager.g();
                }
                if (Load.e == G130.SETUP_GRAPHICS_CONFIGURATIONS) {
                    ParticleEngine.q(client.eg, "Materials");
                    ParticleEngine.d(client.eg, "Meshes");
                    ParticleEngine.g(client.eg, "Particles");
                    Decals.d(client.eg, "DecalMaterials");
                    Decals.g(client.eg, "Decals");
                    GroundCover.g(H149.u, client.eg);
                }
                if (Load.e == G130.INIT_SCRIPTING) {
                    if (client.al == null) {
                        StateManager.g(client.ep, "states");
                    }
                    else {
                        StateManager.load(client.al + "/states/");
                    }
                    J153.g();
                    client.cj.createGlobalFunction("System.Write", String.format("%s ClientCore.Output(\"Lua> \" .. str)", "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end "));
                    client.cj.createGlobalFunction("IsServer", "return false");
                    client.cj.createGlobalFunction("IsClient", "return true");
                    client.cj.registerScriptAPI(ClientScriptMessaging.class);
                    client.cj.executeScriptFromMemory("_G.engineBranch=\"scaleform\"");
                    final StringBuffer sb = new StringBuffer("CollisionGroup={");
                    for (final Gn5 gn5 : Gn5.values()) {
                        sb.append(gn5.name());
                        sb.append("=");
                        sb.append(gn5.ordinal());
                        sb.append(",");
                    }
                    if (Gn5.values().length > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    sb.append("} CollisionMask={");
                    for (final Gj16 gj16 : Gj16.values()) {
                        sb.append(gj16.name());
                        sb.append("=");
                        sb.append(gj16.az);
                        sb.append(",");
                    }
                    if (Gj16.values().length > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    sb.append("}");
                    client.cj.executeScriptFromMemory(sb.toString());
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
                    final String property2 = System.getProperty("jagex.luadir");
                    File file2 = null;
                    if (b || property2 != null) {
                        file2 = ((property2 != null) ? new File(property2) : new File(client.al, "lua"));
                        client.cj.executeScriptFromMemory("package[\"root\"] = \"" + file2.getPath().replace("\\", "/") + "\" " + "package[\"path\"] = \"" + file2.getPath().replace("\\", "\\\\") + "\\\\?.lua;.\\\\?.lua\" " + "package[\"canDebug\"] = true");
                        Load.logger.info("Loading lua from src");
                        client.cj.initResourceManagerFromSource(file2);
                    }
                    else {
                        Load.logger.info("Loading lua from pack");
                        client.cj.initResourceManagerFromJS5(client.ee, client.ee);
                    }
                    Scripting.initLuaProtocolBuffers(client.cj.getLuaStateNativeRef(), (file2 == null) ? null : file2.getPath());
                    client.cj.loadAllScripts();
                    ClientScriptMessaging.g(client.cj.getAllProtocolBufferDefinitions(), !b);
                    Scripting.populateFunctionTable(client.cj.getLuaStateNativeRef());
                    Scripting.enableScriptProfiler(true);
                    client.cj.runRaw("initClient", new Object[0]);
                    LuaNativeEvents.g();
                    Af155.g(new Al154(js5.f(client.dg, "huffman", "")));
                    client.aj = new Fr156(false);
                }
                if (Load.e == G130.SETUP_STATIC_SPRITES) {
                    if (client.eq == null) {
                        client.eq = new Aw157(client.dy, client.er, D150.d());
                    }
                    final int q = Aw157.q(client.eq, true);
                    final int l = Aw157.j(client.eq);
                    if (q < l) {
                        return q * 100 / l;
                    }
                }
                if (Load.e == G130.FETCH_FONTS) {
                    final int d2 = Aw157.d(client.eq);
                    final int m = Aw157.j(client.eq);
                    if (d2 < m) {
                        return d2 * 100 / m;
                    }
                    client.eq.g(client.ew);
                    D150.q();
                }
                if (Load.e == G130.SETUP_VARC_SYSTEM) {
                    client.jr = new Fg140(client.fo);
                    s();
                    js5.n(client.dy, true, true);
                    js5.n(client.er, true, true);
                    js5.n(client.dg, true, true);
                    client.bg = true;
                    client.dr.m = 2;
                    client.et.m = 2;
                }
                if (Load.e == G130.CLEANUP) {
                    client.f(W159.g().j, -1, -1, false);
                    Al161.g();
                }
            }
        }
        finally {
            Lb33.d(Lb33.MainLoad);
        }
        return d();
    }
    
    static {
        logger = LoggerFactory.getLogger(Load.class);
        Load.q = 0L;
        Load.j = 0L;
        Load.s = -1;
    }
    
    public static Q162 w() {
        int n;
        if (Load.e.o) {
            n = Load.e.n + (Load.e.k - Load.e.n) * Load.h / 100;
        }
        else {
            n = Load.e.n;
        }
        return new Q162(Mk163.g(Load.e.t, Language.EN), n);
    }
}
