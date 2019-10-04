// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.game.runetek6.script.resource.proto.JS5ProtoResourceDataProvider;
import com.jagex.game.runetek6.script.resource.script.JS5ScriptResourceDataProvider;
import com.jagex.game.runetek6.script.resource.Js5ScriptResourceAddressLister;
import com.jagex.js5.js5;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tfu.Ks126;
import tfu.Aa129;
import tfu.Ao128;
import tfu.Ap127;
import tfu.Kt125;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.resource.script.StringScriptChunk;
import com.jagex.game.runetek6.script.resource.proto.FileProtoResourceDataProvider;
import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import tfu.Ib29;
import com.jagex.game.runetek6.script.resource.script.FileScriptResourceDataProvider;
import tfu.Ij60;
import com.jagex.game.runetek6.script.resource.FileScriptResourceAddressLister;
import com.jagex.game.runetek6.script.resource.script.ScriptChunk;
import java.io.File;
import com.jagex.jnibindings.runetek6.Scripting;
import %s.%s124;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import tfu.Hi86;
import com.jagex.core.constants.D123;
import org.slf4j.Logger;
import tfu.Jy122;

@ScriptEntryClass("System")
public class ScriptManager
{
    public static Jy122 calltrace;
    static final Logger logger;
    public static final String luaFormatter = "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end ";
    public static int totalHandlersActive;
    public static int totalHandlersCreated;
    public static int totalHandlersDestroyed;
    public static int totalHandlersTriggered;
    private String baseRootDir;
    public LuaEventHandler event;
    public LuaDebugEclipseConsole luaConsole;
    private Thread luaConsoleThread;
    private ScriptManager$NativeRef luaStateNativeRef;
    final Thread luaThread;
    final D123 modeWhere;
    public Hi86 resourceManager;
    private ScriptManager$NativeRef scriptManagerNativeRef;
    
    public ScriptEventHandler createEventHandler(final String str, final Object[] array) {
        ScriptEventHandler scriptEventHandler = null;
        try {
            scriptEventHandler = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(this.getLuaFunctionRef(str), str), array);
        }
        catch (Exception ex) {
            ScriptManager.logger.error("Error creating event handler for script function: " + str, ex);
        }
        return scriptEventHandler;
    }
    
    public void registerScriptAPI(final Class clazz) {
        if (!clazz.isAnnotationPresent(ScriptEntryClass.class)) {
            throw new RuntimeException("ScriptManager tried to register class " + clazz.getName() + " but no ScriptEntryClass annotation was found!");
        }
        String anObject = clazz.getAnnotation(ScriptEntryClass.class).value();
        if ("".equals(anObject)) {
            anObject = clazz.getSimpleName();
        }
        try {
            Scripting.bindClass(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), clazz, String.format((String)%s124.class, clazz.getName().replace('.', '/')), anObject, buildNativeMethodsInfo(clazz));
        }
        catch (Exception ex) {
            ScriptManager.logger.error("", ex);
            throw new RuntimeException(String.format("Error in native binding (%s/%s)", clazz.getSimpleName(), anObject));
        }
    }
    
    public final Thread getThread() {
        return this.luaThread;
    }
    
    public final long getLuaStateNativeRef() {
        if (this.luaStateNativeRef == null) {
            throw new IllegalStateException("Native Lua state reference was invalid.");
        }
        return this.luaStateNativeRef.getRef();
    }
    
    public void runScriptEvent(final String s, final Object o, final Object obj) {
        Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + s + "(" + obj + ")");
        final int luaFunctionRef = this.getLuaFunctionRef(s);
        if (luaFunctionRef == -2) {
            return;
        }
        final ScriptEventHandler scriptEventHandler = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(luaFunctionRef, s), null);
        try {
            scriptEventHandler.trigger(o, obj);
            Jy122.l(ScriptManager.calltrace, "END");
        }
        catch (Exception obj2) {
            Jy122.b(ScriptManager.calltrace, "Error executing script function: " + s);
            ScriptManager.logger.error("", obj2);
            Jy122.l(ScriptManager.calltrace, "END: **EXCEPTION:** " + obj2);
        }
    }
    
    public String executeScriptFromMemory(final String s) {
        try {
            return Scripting.executeScriptFromMemory(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), s, 1, true);
        }
        catch (Exception ex) {
            ScriptManager.logger.error("", ex);
            return "nil";
        }
    }
    
    public final long getScriptManagerNativeRef() {
        if (this.scriptManagerNativeRef == null) {
            throw new IllegalStateException("Native ScriptManager reference was invalid.");
        }
        return this.scriptManagerNativeRef.getRef();
    }
    
    public void initResourceManagerFromSource(final File file) {
        this.baseRootDir = file.getPath();
        Hi86.r(this.resourceManager = new Hi86(String.class), ScriptChunk.class, new FileScriptResourceAddressLister(file, ".lua"));
        Hi86.p(this.resourceManager, ScriptChunk.class, new FileScriptResourceDataProvider(file, ".lua"));
        Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new FileProtoResourceDataProvider(file));
        Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
        Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandlerArgs(@ScriptID final Integer n, final LuaFunctionRef luaFunctionRef, final Object... array) {
        return this.event.addEventHandlerArgs(this, n, luaFunctionRef, array);
    }
    
    public ScriptManager(final int n, final D123 modeWhere) {
        this.scriptManagerNativeRef = null;
        this.luaStateNativeRef = null;
        this.luaConsoleThread = null;
        this.event = new LuaEventHandler();
        this.modeWhere = modeWhere;
        this.luaThread = Thread.currentThread();
        final Ks126 d = Kt125.d();
        if (d.j("JNIBindings") && !d.e("JNIBindings")) {
            ScriptManager.logger.debug("Loading JNIBindings!");
            if (!d.h("JNIBindings")) {
                throw new RuntimeException("Failed to load JNIBindings");
            }
        }
        final long[] d2 = Scripting.d(n);
        if (d2 == null || d2.length != 2) {
            throw new RuntimeException("Error during native ScriptManager initilisation.");
        }
        this.scriptManagerNativeRef = new ScriptManager$NativeRef(this, d2[0]);
        this.luaStateNativeRef = new ScriptManager$NativeRef(this, d2[1]);
        this.registerScriptAPI(ScriptManager.class);
        this.executeScriptFromMemory("function ScriptManagerInit(_ScriptManagerInstance) if not _ScriptManagerInstance then error(\"Java ScriptManager reference was invalid.\") end if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end _G.System[\"__InstanceRef\"] = _ScriptManagerInstance end");
        this.runRaw("_G.ScriptManagerInit", this);
        this.executeScriptFromMemory("_G.ScriptManagerInit = {} if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end if not _G.System[\"__InstanceRef\"] or type(_G.System[\"__InstanceRef\"]) ~= \"" + String.format((String)%s124.class, this.getClass().getName().replace('.', '/')) + "\" then error(\"Java ScriptManager reference in System table was invalid.\") end " + "local SystemInstanceRef = _G.System[\"__InstanceRef\"] " + "_G.System[\"__InstanceRef\"] = nil " + "local SystemFunctionTable = _G.System " + "_G.System = setmetatable({},{" + "__SystemInstanceRef = SystemInstanceRef," + "__SystemFunctionTable = SystemFunctionTable," + "__index = function(self, key) " + "local mt = getmetatable(self) " + "local ref = mt.__SystemInstanceRef " + "local func = mt.__SystemFunctionTable[key] " + "if func and ref and type(func) == \"function\" then " + "local f = function(...) " + "return func(ref, ...) " + "end " + "rawset(self, key, f) " + "return f " + "end " + "return nil " + "end" + "})");
        if (Ap127.e) {
            this.createGlobalFunction("System.Write", "return");
            this.createGlobalFunction("print", "return");
            this.createGlobalFunction("printf", "return");
            this.createGlobalFunction("rawprint", "return");
            this.createGlobalFunction("rawprintf", "return");
        }
        else {
            this.createGlobalFunction("System.Write", String.format("%s System.Output(\"Lua> \" .. str)", "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end "));
            this.createGlobalFunction("print", "System.Write(...)");
            this.createGlobalFunction("printf", "print(string.format(...))");
            this.executeScriptFromMemory("rawprint=print");
            this.createGlobalFunction("rawprintf", "rawprint(string.format(...))");
        }
        Ao128.g(new ScriptManager$LuaStackTraceElementProvider(this));
        if (this.modeWhere == D123.LOCAL) {
            this.luaConsole = new LuaDebugEclipseConsole(this);
            (this.luaConsoleThread = new Thread(this.luaConsole, "Lua Console")).start();
        }
    }
    
    public void loadAllScripts() {
        final List v = Hi86.v(this.resourceManager, ScriptChunk.class);
        Scripting.loadAllScripts(this.getLuaStateNativeRef(), v.toArray(new String[v.size()]));
    }
    
    public List getAllProtocolBufferDefinitions() {
        final LinkedList<ProtocolBufferDefinition> list = new LinkedList<ProtocolBufferDefinition>();
        for (final String s : Hi86.v(this.resourceManager, ProtocolBufferDefinition.class)) {
            try {
                list.add((ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, s));
            }
            catch (Exception ex) {
                System.out.println("Proto load failed: " + ex.getMessage());
            }
        }
        return list;
    }
    
    @Be2
    @Bs1
    public byte[] loadScriptChunkForNative(final String s, final String s2) {
        try {
            if (s2.equals(".lua")) {
                final byte[] data = Hi86.y(this.resourceManager, ScriptChunk.class).getData(s);
                if (data != null && data.length > 0) {
                    return data;
                }
            }
            else {
                final ProtocolBufferDefinition protocolBufferDefinition = (ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, s);
                if (protocolBufferDefinition != null) {
                    return protocolBufferDefinition.definition.getBytes();
                }
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    public int getLuaFunctionRef(final String str) {
        try {
            return Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), str);
        }
        catch (Exception ex) {
            ScriptManager.logger.error("cannot create event handler for script function: " + str, ex);
            return -2;
        }
    }
    
    public void createGlobalFunction(final String str, final String s) {
        try {
            Scripting.createGlobalFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), str.split("\\."), new ByteArrayInputStream(s.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException ex) {
            ScriptManager.logger.error("", ex);
        }
        catch (Exception ex2) {
            ScriptManager.logger.error("Error creating global Lua function: " + str, ex2);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(ScriptManager.class);
        ScriptManager.calltrace = new Jy122(LoggerFactory.getLogger(ScriptManager.class.getName() + ".TreePrinter"));
        ScriptManager.totalHandlersCreated = 0;
        ScriptManager.totalHandlersDestroyed = 0;
        ScriptManager.totalHandlersActive = 0;
        ScriptManager.totalHandlersTriggered = 0;
    }
    
    public void initResourceManagerFromJS5(final js5 js5, final js5 js6) {
        Hi86.r(this.resourceManager = new Hi86(String.class), ScriptChunk.class, new Js5ScriptResourceAddressLister(js5, ".lua"));
        Hi86.r(this.resourceManager, ProtocolBufferDefinition.class, new Js5ScriptResourceAddressLister(js6, ".proto"));
        Hi86.p(this.resourceManager, ScriptChunk.class, new JS5ScriptResourceDataProvider(js5, ".lua"));
        Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new JS5ProtoResourceDataProvider(js6));
        Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
        Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
    }
    
    @Bs1
    @Be2
    private static NativeScriptAPIInfo[] buildNativeMethodsInfo(final Class clazz) {
        if (clazz == null) {
            return null;
        }
        final ScriptManager$NativeMethodInfoBuilder scriptManager$NativeMethodInfoBuilder = new ScriptManager$NativeMethodInfoBuilder();
        scriptManager$NativeMethodInfoBuilder.scan(clazz);
        return scriptManager$NativeMethodInfoBuilder.scriptEntryPointMethods.toArray(new NativeScriptAPIInfo[scriptManager$NativeMethodInfoBuilder.scriptEntryPointMethods.size()]);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public ScriptManager getSelf() {
        return this;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandler(@ScriptID final Integer n, final LuaFunctionRef luaFunctionRef) {
        return this.event.addEventHandler(this, n, luaFunctionRef);
    }
    
    public Object runRaw(final String str, final Object... array) {
        final int luaFunctionRef = Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), str);
        if (luaFunctionRef == -2) {
            return null;
        }
        final LuaFunctionRef luaFunctionRef2 = new LuaFunctionRef(luaFunctionRef, str);
        Object callLuaFunction = null;
        try {
            callLuaFunction = Scripting.callLuaFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), LuaRef.g(luaFunctionRef2), LuaFunctionRef.j(luaFunctionRef2), null, null, "", array, 1);
        }
        catch (Exception ex) {
            Jy122.b(ScriptManager.calltrace, "Error executing raw Lua function: " + str);
            ScriptManager.logger.error("", ex);
        }
        return callLuaFunction;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeAllEventHandlers(@ScriptID final Integer n) {
        this.event.removeAllEventHandlers(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeEventHandler(@ScriptID final Integer n, final EventHandler eventHandler) {
        this.event.removeEventHandler(n, eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void output(final String x) {
        if (x != null) {
            System.out.println(x);
        }
    }
    
    public double getLuaPoolSize() {
        return Scripting.getLuaPoolSize(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef());
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public ScriptEventHandler createEventHandler(final LuaFunctionRef luaFunctionRef, final Object... array) {
        return new ScriptEventHandler(this, luaFunctionRef, array);
    }
    
    public void purgeNative() {
        Scripting.purge(this.getScriptManagerNativeRef());
        this.scriptManagerNativeRef = null;
        this.luaStateNativeRef = null;
    }
}
