/*
 * Decompiled with CFR 0.146.
 * 
 * Could not load the following classes:
 *  %s.%s124
 */
package com.jagex.game.runetek6.script;

import %s.%s124;
import com.jagex.core.constants.D123;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.script.LuaDebugEclipseConsole;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager$LuaStackTraceElementProvider;
import com.jagex.game.runetek6.script.ScriptManager$NativeMethodInfoBuilder;
import com.jagex.game.runetek6.script.ScriptManager$NativeRef;
import com.jagex.game.runetek6.script.resource.FileScriptResourceAddressLister;
import com.jagex.game.runetek6.script.resource.Js5ScriptResourceAddressLister;
import com.jagex.game.runetek6.script.resource.proto.FileProtoResourceDataProvider;
import com.jagex.game.runetek6.script.resource.proto.JS5ProtoResourceDataProvider;
import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import com.jagex.game.runetek6.script.resource.script.FileScriptResourceDataProvider;
import com.jagex.game.runetek6.script.resource.script.JS5ScriptResourceDataProvider;
import com.jagex.game.runetek6.script.resource.script.ScriptChunk;
import com.jagex.game.runetek6.script.resource.script.StringScriptChunk;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.js5.js5;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Ap127;
import tfu.Be2;
import tfu.Bs1;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Ib29;
import tfu.Jy122;
import tfu.Ks126;
import tfu.Kt125;

@ScriptEntryClass(value="System")
public class ScriptManager {
    public static Jy122 calltrace;
    static final Logger logger;
    public static final String luaFormatter = "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end ";
    public static int totalHandlersActive;
    public static int totalHandlersCreated;
    public static int totalHandlersDestroyed;
    public static int totalHandlersTriggered;
    private String baseRootDir;
    public LuaEventHandler event = new LuaEventHandler();
    public LuaDebugEclipseConsole luaConsole;
    private Thread luaConsoleThread = null;
    private ScriptManager$NativeRef luaStateNativeRef = null;
    final Thread luaThread;
    final D123 modeWhere;
    public Hi86 resourceManager;
    private ScriptManager$NativeRef scriptManagerNativeRef = null;

    public ScriptEventHandler createEventHandler(String string, Object[] arrobject) {
        ScriptEventHandler scriptEventHandler = null;
        try {
            scriptEventHandler = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(this.getLuaFunctionRef(string), string), arrobject);
        }
        catch (Exception exception) {
            logger.error("Error creating event handler for script function: " + string, exception);
        }
        return scriptEventHandler;
    }

    public void registerScriptAPI(Class class_) {
        if (!class_.isAnnotationPresent(ScriptEntryClass.class)) {
            throw new RuntimeException("ScriptManager tried to register class " + class_.getName() + " but no ScriptEntryClass annotation was found!");
        }
        ScriptEntryClass scriptEntryClass = class_.getAnnotation(ScriptEntryClass.class);
        String string = scriptEntryClass.value();
        if ("".equals(string)) {
            string = class_.getSimpleName();
        }
        try {
            Scripting.bindClass(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), class_, String.format(%s124.class, new Object[]{class_.getName().replace('.', '/')}), string, ScriptManager.buildNativeMethodsInfo(class_));
        }
        catch (Exception exception) {
            logger.error("", exception);
            throw new RuntimeException(String.format("Error in native binding (%s/%s)", class_.getSimpleName(), string));
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

    public void runScriptEvent(String string, Object object, Object object2) {
        Jy122.h(calltrace, "SCRIPTING EVENT: " + string + "(" + object2 + ")");
        int n = this.getLuaFunctionRef(string);
        if (n == -2) {
            return;
        }
        ScriptEventHandler scriptEventHandler = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(n, string), null);
        try {
            scriptEventHandler.trigger(object, object2);
            Jy122.l(calltrace, "END");
        }
        catch (Exception exception) {
            Jy122.b(calltrace, "Error executing script function: " + string);
            logger.error("", exception);
            Jy122.l(calltrace, "END: **EXCEPTION:** " + exception);
        }
    }

    public String executeScriptFromMemory(String string) {
        try {
            return Scripting.executeScriptFromMemory(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), string, 1, true);
        }
        catch (Exception exception) {
            logger.error("", exception);
            return "nil";
        }
    }

    public final long getScriptManagerNativeRef() {
        if (this.scriptManagerNativeRef == null) {
            throw new IllegalStateException("Native ScriptManager reference was invalid.");
        }
        return this.scriptManagerNativeRef.getRef();
    }

    public void initResourceManagerFromSource(File file) {
        this.baseRootDir = file.getPath();
        this.resourceManager = new Hi86(String.class);
        Hi86.r(this.resourceManager, ScriptChunk.class, new FileScriptResourceAddressLister(file, ".lua"));
        Hi86.p(this.resourceManager, ScriptChunk.class, new FileScriptResourceDataProvider(file, ".lua"));
        Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new FileProtoResourceDataProvider(file));
        Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
        Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandlerArgs(@ScriptID Integer n, LuaFunctionRef luaFunctionRef, Object ... arrobject) {
        return this.event.addEventHandlerArgs(this, n, luaFunctionRef, arrobject);
    }

    public ScriptManager(int n, D123 d123) {
        long[] arrl;
        this.modeWhere = d123;
        this.luaThread = Thread.currentThread();
        Ks126 ks126 = Kt125.d();
        if (ks126.j("JNIBindings") && !ks126.e("JNIBindings")) {
            logger.debug("Loading JNIBindings!");
            if (!ks126.h("JNIBindings")) {
                throw new RuntimeException("Failed to load JNIBindings");
            }
        }
        if ((arrl = Scripting.d(n)) == null || arrl.length != 2) {
            throw new RuntimeException("Error during native ScriptManager initilisation.");
        }
        this.scriptManagerNativeRef = new ScriptManager$NativeRef(this, arrl[0]);
        this.luaStateNativeRef = new ScriptManager$NativeRef(this, arrl[1]);
        this.registerScriptAPI(ScriptManager.class);
        this.executeScriptFromMemory("function ScriptManagerInit(_ScriptManagerInstance) if not _ScriptManagerInstance then error(\"Java ScriptManager reference was invalid.\") end if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end _G.System[\"__InstanceRef\"] = _ScriptManagerInstance end");
        this.runRaw("_G.ScriptManagerInit", this);
        this.executeScriptFromMemory("_G.ScriptManagerInit = {} if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end if not _G.System[\"__InstanceRef\"] or type(_G.System[\"__InstanceRef\"]) ~= \"" + String.format(%s124.class, new Object[]{this.getClass().getName().replace('.', '/')}) + "\" then error(\"Java ScriptManager reference in System table was invalid.\") end " + "local SystemInstanceRef = _G.System[\"__InstanceRef\"] " + "_G.System[\"__InstanceRef\"] = nil " + "local SystemFunctionTable = _G.System " + "_G.System = setmetatable({},{" + "__SystemInstanceRef = SystemInstanceRef," + "__SystemFunctionTable = SystemFunctionTable," + "__index = function(self, key) " + "local mt = getmetatable(self) " + "local ref = mt.__SystemInstanceRef " + "local func = mt.__SystemFunctionTable[key] " + "if func and ref and type(func) == \"function\" then " + "local f = function(...) " + "return func(ref, ...) " + "end " + "rawset(self, key, f) " + "return f " + "end " + "return nil " + "end" + "})");
        if (Ap127.e) {
            this.createGlobalFunction("System.Write", "return");
            this.createGlobalFunction("print", "return");
            this.createGlobalFunction("printf", "return");
            this.createGlobalFunction("rawprint", "return");
            this.createGlobalFunction("rawprintf", "return");
        } else {
            this.createGlobalFunction("System.Write", String.format("%s System.Output(\"Lua> \" .. str)", luaFormatter));
            this.createGlobalFunction("print", "System.Write(...)");
            this.createGlobalFunction("printf", "print(string.format(...))");
            this.executeScriptFromMemory("rawprint=print");
            this.createGlobalFunction("rawprintf", "rawprint(string.format(...))");
        }
        Ao128.g(new ScriptManager$LuaStackTraceElementProvider(this));
        if (this.modeWhere == D123.LOCAL) {
            this.luaConsole = new LuaDebugEclipseConsole(this);
            this.luaConsoleThread = new Thread((Runnable)this.luaConsole, "Lua Console");
            this.luaConsoleThread.start();
        }
    }

    public void loadAllScripts() {
        List list = Hi86.v(this.resourceManager, ScriptChunk.class);
        String[] arrstring = list.toArray(new String[list.size()]);
        Scripting.loadAllScripts(this.getLuaStateNativeRef(), arrstring);
    }

    public List getAllProtocolBufferDefinitions() {
        LinkedList<ProtocolBufferDefinition> linkedList = new LinkedList<ProtocolBufferDefinition>();
        for (String string : Hi86.v(this.resourceManager, ProtocolBufferDefinition.class)) {
            try {
                ProtocolBufferDefinition protocolBufferDefinition = (ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, string);
                linkedList.add(protocolBufferDefinition);
            }
            catch (Exception exception) {
                System.out.println("Proto load failed: " + exception.getMessage());
            }
        }
        return linkedList;
    }

    @Be2
    @Bs1
    public byte[] loadScriptChunkForNative(String string, String string2) {
        try {
            if (string2.equals(".lua")) {
                Ib29 ib29 = Hi86.y(this.resourceManager, ScriptChunk.class);
                byte[] arrby = ib29.getData(string);
                if (arrby != null && arrby.length > 0) {
                    return arrby;
                }
            } else {
                ProtocolBufferDefinition protocolBufferDefinition = (ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, string);
                if (protocolBufferDefinition != null) {
                    return protocolBufferDefinition.definition.getBytes();
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public int getLuaFunctionRef(String string) {
        try {
            return Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), string);
        }
        catch (Exception exception) {
            logger.error("cannot create event handler for script function: " + string, exception);
            return -2;
        }
    }

    public void createGlobalFunction(String string, String string2) {
        try {
            Scripting.createGlobalFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), string.split("\\."), new ByteArrayInputStream(string2.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            logger.error("", unsupportedEncodingException);
        }
        catch (Exception exception) {
            logger.error("Error creating global Lua function: " + string, exception);
        }
    }

    static {
        logger = LoggerFactory.getLogger(ScriptManager.class);
        calltrace = new Jy122(LoggerFactory.getLogger(ScriptManager.class.getName() + ".TreePrinter"));
        totalHandlersCreated = 0;
        totalHandlersDestroyed = 0;
        totalHandlersActive = 0;
        totalHandlersTriggered = 0;
    }

    public void initResourceManagerFromJS5(js5 js52, js5 js53) {
        this.resourceManager = new Hi86(String.class);
        Hi86.r(this.resourceManager, ScriptChunk.class, new Js5ScriptResourceAddressLister(js52, ".lua"));
        Hi86.r(this.resourceManager, ProtocolBufferDefinition.class, new Js5ScriptResourceAddressLister(js53, ".proto"));
        Hi86.p(this.resourceManager, ScriptChunk.class, new JS5ScriptResourceDataProvider(js52, ".lua"));
        Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new JS5ProtoResourceDataProvider(js53));
        Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
        Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
    }

    @Bs1
    @Be2
    private static NativeScriptAPIInfo[] buildNativeMethodsInfo(Class class_) {
        if (class_ == null) {
            return null;
        }
        ScriptManager$NativeMethodInfoBuilder scriptManager$NativeMethodInfoBuilder = new ScriptManager$NativeMethodInfoBuilder();
        scriptManager$NativeMethodInfoBuilder.scan(class_);
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
    public EventHandler addEventHandler(@ScriptID Integer n, LuaFunctionRef luaFunctionRef) {
        return this.event.addEventHandler(this, n, luaFunctionRef);
    }

    public Object runRaw(String string, Object ... arrobject) {
        int n = Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), string);
        if (n == -2) {
            return null;
        }
        LuaFunctionRef luaFunctionRef = new LuaFunctionRef(n, string);
        Object object = null;
        try {
            object = Scripting.callLuaFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), LuaFunctionRef.g(luaFunctionRef), LuaFunctionRef.j(luaFunctionRef), null, null, "", arrobject, 1);
        }
        catch (Exception exception) {
            Jy122.b(calltrace, "Error executing raw Lua function: " + string);
            logger.error("", exception);
        }
        return object;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeAllEventHandlers(@ScriptID Integer n) {
        this.event.removeAllEventHandlers(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeEventHandler(@ScriptID Integer n, EventHandler eventHandler) {
        this.event.removeEventHandler(n, eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void output(String string) {
        if (string != null) {
            System.out.println(string);
        }
    }

    public double getLuaPoolSize() {
        return Scripting.getLuaPoolSize(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef());
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public ScriptEventHandler createEventHandler(LuaFunctionRef luaFunctionRef, Object ... arrobject) {
        return new ScriptEventHandler(this, luaFunctionRef, arrobject);
    }

    public void purgeNative() {
        Scripting.purge(this.getScriptManagerNativeRef());
        this.scriptManagerNativeRef = null;
        this.luaStateNativeRef = null;
    }
}

