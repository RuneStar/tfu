package tfu;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.jnibindings.runetek6.Scripting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Az399 {
   private static final Logger logger = LoggerFactory.getLogger(Az399.class);
   private final ScriptManager d;
   public String e;
   public String h;
   public int j;
   public Object q;
   public byte[] s;

   public static LuaRef g(Az399 var0, Object var1) {
      try {
         return Scripting.deserialiseScriptMessage(var0.d.getScriptManagerNativeRef(), var0.d.getLuaStateNativeRef(), var0.e, var0.h, var0.s, var1, var1 != null ? Scripting.getClassName(var1) : "");
      } catch (Exception var3) {
         logger.error("", var3);
         return null;
      }
   }

   Az399(ScriptManager var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         this.d = var1;
      }
   }

   public Az399(ScriptManager var1, Object var2, int var3, String var4, String var5, byte[] var6) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         this.d = var1;
         this.q = var2;
         this.j = var3;
         this.h = var5;
         this.e = var4;
         this.s = var6;
      }
   }
}
