package rs2.client;

import com.jagex.core.constants.J204;

public enum J160 implements J204 {
   RESIZABLE(2, "resizable"),
   SMALL(1, "small"),
   FULLSCREEN(3, "fullscreen");

   public String e;
   private final int j;

   private J160(int var3, String var4) {
      this.j = var3;
      this.e = var4;
   }

   public int getId() {
      return this.j;
   }
}
