package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.Scripting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class LuaDebugEclipseConsole implements Runnable {
   private static final Logger logger = LoggerFactory.getLogger(LuaDebugEclipseConsole.class);
   List commands = new LinkedList();
   private volatile boolean run = true;
   private final ScriptManager scriptManager;

   public void run() {
      BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

      while(this.run) {
         try {
            String var2 = var1.readLine();
            if (var2 == null) {
               logger.error("Console input stream closed by Ctrl-Z - Don't press that key again...");
               break;
            }

            List var3 = this.commands;
            synchronized(var3) {
               this.commands.add(var2);
            }
         } catch (IOException var6) {
            logger.error("", var6);
            break;
         }
      }

   }

   public void service() {
      Lb33.g(Lb33.LuaConsole);

      try {
         if (this.commands.size() > 0) {
            List var1 = this.commands;
            synchronized(var1) {
               try {
                  String var2 = (String)this.commands.remove(0);
                  if (var2.compareToIgnoreCase("/rl") != 0 && var2.compareToIgnoreCase("/reload") != 0 && var2.compareToIgnoreCase("/reloadui") != 0 && !var2.trim().isEmpty()) {
                     Scripting.executeScriptFromMemory(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), var2, 0, true);
                  }
               } catch (Exception var8) {
                  logger.error("", var8);
               }
            }
         }

         Lb33.d(Lb33.LuaConsole);
      } finally {
         Lb33.d(Lb33.LuaConsole);
      }
   }

   public LuaDebugEclipseConsole(ScriptManager var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         this.scriptManager = var1;
      }
   }
}
