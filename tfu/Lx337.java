package tfu;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Lx337 {
   public String d;
   private boolean e = true;
   public int g;
   private boolean h = false;
   public int j = 443;
   public int q = 43594;

   public Socket g() throws IOException {
      return !this.h ? new Socket(InetAddress.getByName(this.d), this.e ? this.j : this.q) : Jm443.s(this.d, this.e ? this.j : this.q).g();
   }

   public static int d(Lx337 var0) {
      return var0.e ? var0.j : var0.q;
   }

   public static void q(Lx337 var0) {
      if (!var0.e) {
         var0.e = true;
         var0.h = true;
      } else if (var0.h) {
         var0.h = false;
      } else {
         var0.e = false;
      }

   }
}
