package com.jagex.game.runetek6.script;

import %s.%s124;
import com.jagex.core.constants.D123;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
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
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Ap127;
import tfu.Be2;
import tfu.Bs1;
import tfu.Hi86;
import tfu.Ib29;
import tfu.Jy122;
import tfu.Ks126;
import tfu.Kt125;

@ScriptEntryClass("System")
public class ScriptManager {
   public static Jy122 calltrace = new Jy122(LoggerFactory.getLogger(ScriptManager.class.getName() + ".TreePrinter"));
   static final Logger logger = LoggerFactory.getLogger(ScriptManager.class);
   public static final String luaFormatter = "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end ";
   public static int totalHandlersActive = 0;
   public static int totalHandlersCreated = 0;
   public static int totalHandlersDestroyed = 0;
   public static int totalHandlersTriggered = 0;
   private String baseRootDir;
   public LuaEventHandler event = new LuaEventHandler();
   public LuaDebugEclipseConsole luaConsole;
   private Thread luaConsoleThread = null;
   private ScriptManager$NativeRef luaStateNativeRef = null;
   final Thread luaThread;
   final D123 modeWhere;
   public Hi86 resourceManager;
   private ScriptManager$NativeRef scriptManagerNativeRef = null;

   public ScriptEventHandler createEventHandler(String var1, Object[] var2) {
      ScriptEventHandler var3 = null;

      try {
         var3 = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(this.getLuaFunctionRef(var1), var1), var2);
      } catch (Exception var5) {
         logger.error("Error creating event handler for script function: " + var1, var5);
      }

      return var3;
   }

   public void registerScriptAPI(Class var1) {
      if (!var1.isAnnotationPresent(ScriptEntryClass.class)) {
         throw new RuntimeException("ScriptManager tried to register class " + var1.getName() + " but no ScriptEntryClass annotation was found!");
      } else {
         ScriptEntryClass var2 = (ScriptEntryClass)var1.getAnnotation(ScriptEntryClass.class);
         String var3 = var2.value();
         if ("".equals(var3)) {
            var3 = var1.getSimpleName();
         }

         try {
            Scripting.bindClass(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), var1, String.format(%s124.class, var1.getName().replace('.', '/')), var3, buildNativeMethodsInfo(var1));
         } catch (Exception var5) {
            logger.error("", var5);
            throw new RuntimeException(String.format("Error in native binding (%s/%s)", var1.getSimpleName(), var3));
         }
      }
   }

   public final Thread getThread() {
      return this.luaThread;
   }

   public final long getLuaStateNativeRef() {
      if (this.luaStateNativeRef == null) {
         throw new IllegalStateException("Native Lua state reference was invalid.");
      } else {
         return this.luaStateNativeRef.getRef();
      }
   }

   public void runScriptEvent(String var1, Object var2, Object var3) {
      Jy122.h(calltrace, "SCRIPTING EVENT: " + var1 + "(" + var3 + ")");
      int var4 = this.getLuaFunctionRef(var1);
      if (var4 != -2) {
         ScriptEventHandler var5 = ScriptEventHandler.createScriptEventHandler(this, new LuaFunctionRef(var4, var1), (Object[])null);

         try {
            var5.trigger(var2, var3);
            Jy122.l(calltrace, "END");
         } catch (Exception var7) {
            Jy122.b(calltrace, "Error executing script function: " + var1);
            logger.error("", var7);
            Jy122.l(calltrace, "END: **EXCEPTION:** " + var7);
         }

      }
   }

   public String executeScriptFromMemory(String var1) {
      try {
         return Scripting.executeScriptFromMemory(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), var1, 1, true);
      } catch (Exception var3) {
         logger.error("", var3);
         return "nil";
      }
   }

   public final long getScriptManagerNativeRef() {
      if (this.scriptManagerNativeRef == null) {
         throw new IllegalStateException("Native ScriptManager reference was invalid.");
      } else {
         return this.scriptManagerNativeRef.getRef();
      }
   }

   public void initResourceManagerFromSource(File var1) {
      this.baseRootDir = var1.getPath();
      this.resourceManager = new Hi86(String.class);
      Hi86.r(this.resourceManager, ScriptChunk.class, new FileScriptResourceAddressLister(var1, ".lua"));
      Hi86.p(this.resourceManager, ScriptChunk.class, new FileScriptResourceDataProvider(var1, ".lua"));
      Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new FileProtoResourceDataProvider(var1));
      Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
      Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public EventHandler addEventHandlerArgs(@ScriptID Integer var1, LuaFunctionRef var2, Object... var3) {
      return this.event.addEventHandlerArgs(this, var1, var2, var3);
   }

   public ScriptManager(int var1, D123 var2) {
      this.modeWhere = var2;
      this.luaThread = Thread.currentThread();
      Ks126 var3 = Kt125.d();
      if (var3.j("JNIBindings") && !var3.e("JNIBindings")) {
         logger.debug("Loading JNIBindings!");
         if (!var3.h("JNIBindings")) {
            throw new RuntimeException("Failed to load JNIBindings");
         }
      }

      long[] var4 = Scripting.d(var1);
      if (var4 != null && var4.length == 2) {
         this.scriptManagerNativeRef = new ScriptManager$NativeRef(this, var4[0]);
         this.luaStateNativeRef = new ScriptManager$NativeRef(this, var4[1]);
         this.registerScriptAPI(ScriptManager.class);
         this.executeScriptFromMemory("function ScriptManagerInit(_ScriptManagerInstance) if not _ScriptManagerInstance then error(\"Java ScriptManager reference was invalid.\") end if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end _G.System[\"__InstanceRef\"] = _ScriptManagerInstance end");
         this.runRaw("_G.ScriptManagerInit", this);
         this.executeScriptFromMemory("_G.ScriptManagerInit = {} if not _G.System and type(_G.System) ~= \"table\" then error(\"System global ScriptManager table did not exist in Lua state.\") end if not _G.System[\"__InstanceRef\"] or type(_G.System[\"__InstanceRef\"]) ~= \"" + String.format(%s124.class, this.getClass().getName().replace('.', '/')) + "\" then error(\"Java ScriptManager reference in System table was invalid.\") end " + "local SystemInstanceRef = _G.System[\"__InstanceRef\"] " + "_G.System[\"__InstanceRef\"] = nil " + "local SystemFunctionTable = _G.System " + "_G.System = setmetatable({},{" + "__SystemInstanceRef = SystemInstanceRef," + "__SystemFunctionTable = SystemFunctionTable," + "__index = function(self, key) " + "local mt = getmetatable(self) " + "local ref = mt.__SystemInstanceRef " + "local func = mt.__SystemFunctionTable[key] " + "if func and ref and type(func) == \"function\" then " + "local f = function(...) " + "return func(ref, ...) " + "end " + "rawset(self, key, f) " + "return f " + "end " + "return nil " + "end" + "})");
         if (Ap127.e) {
            this.createGlobalFunction("System.Write", "return");
            this.createGlobalFunction("print", "return");
            this.createGlobalFunction("printf", "return");
            this.createGlobalFunction("rawprint", "return");
            this.createGlobalFunction("rawprintf", "return");
         } else {
            this.createGlobalFunction("System.Write", String.format("%s System.Output(\"Lua> \" .. str)", "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end "));
            this.createGlobalFunction("print", "System.Write(...)");
            this.createGlobalFunction("printf", "print(string.format(...))");
            this.executeScriptFromMemory("rawprint=print");
            this.createGlobalFunction("rawprintf", "rawprint(string.format(...))");
         }

         Ao128.g(new ScriptManager$LuaStackTraceElementProvider(this));
         if (this.modeWhere == D123.LOCAL) {
            this.luaConsole = new LuaDebugEclipseConsole(this);
            this.luaConsoleThread = new Thread(this.luaConsole, "Lua Console");
            this.luaConsoleThread.start();
         }

      } else {
         throw new RuntimeException("Error during native ScriptManager initilisation.");
      }
   }

   public void loadAllScripts() {
      List var1 = Hi86.v(this.resourceManager, ScriptChunk.class);
      String[] var2 = (String[])var1.toArray(new String[var1.size()]);
      Scripting.loadAllScripts(this.getLuaStateNativeRef(), var2);
   }

   public List getAllProtocolBufferDefinitions() {
      LinkedList var1 = new LinkedList();
      Iterator var2 = Hi86.v(this.resourceManager, ProtocolBufferDefinition.class).iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();

         try {
            ProtocolBufferDefinition var4 = (ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, var3);
            var1.add(var4);
         } catch (Exception var5) {
            System.out.println("Proto load failed: " + var5.getMessage());
         }
      }

      return var1;
   }

   @Be2
   @Bs1
   public byte[] loadScriptChunkForNative(String var1, String var2) {
      try {
         if (var2.equals(".lua")) {
            Ib29 var3 = Hi86.y(this.resourceManager, ScriptChunk.class);
            byte[] var4 = var3.getData(var1);
            if (var4 != null && var4.length > 0) {
               return var4;
            }
         } else {
            ProtocolBufferDefinition var6 = (ProtocolBufferDefinition)this.resourceManager.j(ProtocolBufferDefinition.class, var1);
            if (var6 != null) {
               return var6.definition.getBytes();
            }
         }
      } catch (Exception var5) {
      }

      return null;
   }

   public int getLuaFunctionRef(String var1) {
      try {
         return Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), var1);
      } catch (Exception var3) {
         logger.error("cannot create event handler for script function: " + var1, var3);
         return -2;
      }
   }

   public void createGlobalFunction(String var1, String var2) {
      try {
         Scripting.createGlobalFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), var1.split("\\."), new ByteArrayInputStream(var2.getBytes("UTF-8")));
      } catch (UnsupportedEncodingException var4) {
         logger.error("", var4);
      } catch (Exception var5) {
         logger.error("Error creating global Lua function: " + var1, var5);
      }

   }

   public void initResourceManagerFromJS5(js5 var1, js5 var2) {
      this.resourceManager = new Hi86(String.class);
      Hi86.r(this.resourceManager, ScriptChunk.class, new Js5ScriptResourceAddressLister(var1, ".lua"));
      Hi86.r(this.resourceManager, ProtocolBufferDefinition.class, new Js5ScriptResourceAddressLister(var2, ".proto"));
      Hi86.p(this.resourceManager, ScriptChunk.class, new JS5ScriptResourceDataProvider(var1, ".lua"));
      Hi86.p(this.resourceManager, ProtocolBufferDefinition.class, new JS5ProtoResourceDataProvider(var2));
      Hi86.u(this.resourceManager, ScriptChunk.class, StringScriptChunk.CHUNK_CONSTRUCTOR);
      Hi86.u(this.resourceManager, ProtocolBufferDefinition.class, ProtocolBufferDefinition.PROTO_CONSTRUCTOR);
   }

   @Bs1
   @Be2
   private static NativeScriptAPIInfo[] buildNativeMethodsInfo(Class var0) {
      if (var0 == null) {
         return null;
      } else {
         ScriptManager$NativeMethodInfoBuilder var1 = new ScriptManager$NativeMethodInfoBuilder();
         var1.scan(var0);
         return (NativeScriptAPIInfo[])var1.scriptEntryPointMethods.toArray(new NativeScriptAPIInfo[var1.scriptEntryPointMethods.size()]);
      }
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
   public EventHandler addEventHandler(@ScriptID Integer var1, LuaFunctionRef var2) {
      return this.event.addEventHandler(this, var1, var2);
   }

   public Object runRaw(String var1, Object... var2) {
      int var3 = Scripting.getLuaFunctionRef(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), var1);
      if (var3 == -2) {
         return null;
      } else {
         LuaFunctionRef var4 = new LuaFunctionRef(var3, var1);
         Object var5 = null;

         try {
            var5 = Scripting.callLuaFunction(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef(), LuaFunctionRef.g(var4), LuaFunctionRef.j(var4), (Object[])null, (Object)null, "", var2, 1);
         } catch (Exception var7) {
            Jy122.b(calltrace, "Error executing raw Lua function: " + var1);
            logger.error("", var7);
         }

         return var5;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      this.event.removeAllEventHandlers(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandler(@ScriptID Integer var1, EventHandler var2) {
      this.event.removeEventHandler(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void output(String var1) {
      if (var1 != null) {
         System.out.println(var1);
      }

   }

   public double getLuaPoolSize() {
      return Scripting.getLuaPoolSize(this.getScriptManagerNativeRef(), this.getLuaStateNativeRef());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public ScriptEventHandler createEventHandler(LuaFunctionRef var1, Object... var2) {
      return new ScriptEventHandler(this, var1, var2);
   }

   public void purgeNative() {
      Scripting.purge(this.getScriptManagerNativeRef());
      this.scriptManagerNativeRef = null;
      this.luaStateNativeRef = null;
   }
}
