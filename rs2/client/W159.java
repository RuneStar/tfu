package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;

public class W159 {
   private static W159 d;
   public final boolean b;
   public final I384 e;
   public final int g = 0;
   public final int h = 127;
   public J160 j;
   public final int q = 0;
   public final int s = 127;

   public static W159 g() {
      if (d == null) {
         d = new W159();
      }

      return d;
   }

   private W159() {
      this.j = GameShell3.osArchRaw.toLowerCase().indexOf("arm") != -1 ? J160.FULLSCREEN : J160.RESIZABLE;
      this.e = I384.ANY;
      this.b = true;
   }
}
