package rs2.client.chat;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

public class ChatLine {
   private String b;
   private long d = System.currentTimeMillis();
   private String e;
   private int g = G232.g();
   private String h;
   private int j;
   private int l;
   private int q;
   private String s;
   private String w;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getNameSimple() {
      return this.s;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getType() {
      return this.q;
   }

   public String toString() {
      return "{ ChatLine : " + this.e + "(" + this.g + ") }";
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getFlags() {
      return this.j;
   }

   static void g(ChatLine var0, int var1, int var2, String var3, String var4, String var5, String var6, int var7, String var8) {
      var0.g = G232.g();
      var0.d = System.currentTimeMillis();
      var0.q = var1;
      var0.j = var2;
      var0.e = var3;
      var0.h = var4;
      var0.s = var5;
      var0.b = var6;
      var0.l = var7;
      var0.w = var8;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getNameUnfiltered() {
      return this.h;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getName() {
      return this.e;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getMessage() {
      return this.w;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String getClan() {
      return this.b;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public long getTime() {
      return this.d;
   }

   ChatLine(int var1, int var2, String var3, String var4, String var5, String var6, int var7, String var8) {
      this.q = var1;
      this.j = var2;
      this.e = var3;
      this.h = var4;
      this.s = var5;
      this.b = var6;
      this.l = var7;
      this.w = var8;
   }
}
