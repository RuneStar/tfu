package tfu;

import com.jagex.core.stringtools.general.StringTools;

public final class Bb4 {
   public static final int e = 2;
   public static final int j = 3;
   final int d;
   final Bc288 g;
   private volatile String q;

   public String toString() {
      String var1 = this.q;
      if (var1 == null) {
         this.q = var1 = this.g.name() + ":" + this.d;
      }

      return var1;
   }

   public int hashCode() {
      return System.identityHashCode(this.g) + this.d;
   }

   public boolean equals(Object var1) {
      Bb4 var2 = (Bb4)var1;
      return this.g == var2.g && this.d == var2.d;
   }

   public static Bb4 g(String var0) {
      int var1 = var0.indexOf(58);
      if (var1 < 0) {
         throw new IllegalArgumentException("Cannot decode GameEntityId " + var0 + " - expected format TYPENAME:12345");
      } else {
         String var2 = var0.substring(0, var1).trim();
         if (var2.isEmpty()) {
            throw new IllegalArgumentException("Cannot decode GameEntityId " + var0 + " - expected format TYPENAME:12345");
         } else {
            Bc288 var3 = Bz650.w(var2);
            String var4 = var0.substring(var1 + 1).trim();
            if (!StringTools.d(var4)) {
               throw new IllegalArgumentException("Cannot decode GameEntityId " + var0 + " - expected format TYPENAME:12345");
            } else {
               int var5 = StringTools.j(var4);
               if ((var5 & '\uffff') != var5) {
                  throw new IllegalArgumentException("Cannot decode GameEntityId " + var0 + " - number is out of range");
               } else {
                  return new Bb4(var3, var5);
               }
            }
         }
      }
   }

   public static void d(Bb4 var0) {
      if (Ba115.q(var0.g)) {
         Ba115 var1 = Ba115.j(var0.g);
         var1.l(var0);
      }

   }

   public static Bb4 e(Gg3 var0, Bc288 var1) {
      if (!Bz650.b(var1)) {
         throw new IllegalArgumentException("Client-side GameEntityId of type " + var1.name() + " cannot be sent to server");
      } else {
         return new Bb4(var1, Gg3.au(var0));
      }
   }

   public int h() {
      if (!Bz650.b(this.g)) {
         throw new IllegalArgumentException("Client-side GameEntityId " + this + " cannot be sent to server");
      } else {
         return (this.g.ordinal() << 16) + this.d;
      }
   }

   public static Bb4 s(int var0) {
      if ((var0 & 16777215) != var0) {
         throw new IllegalArgumentException("Invalid int24: " + var0);
      } else {
         return new Bb4(Bz650.l(var0 >> 16), var0 & '\uffff');
      }
   }

   public static Bb4 j(Gg3 var0) {
      return new Bb4(Bz650.l(Gg3.ar(var0)), Gg3.au(var0));
   }

   Bb4(Bc288 var1, int var2) {
      this.g = var1;
      this.d = var2;
      if (this.g == null) {
         throw new IllegalArgumentException();
      } else if ((this.d & '\uffff') != this.d) {
         throw new IllegalArgumentException();
      }
   }

   public void q(Gg3 var1) {
      if (!Bz650.b(this.g)) {
         throw new IllegalArgumentException("Client-side GameEntityId " + this + " cannot be sent to server");
      } else {
         Gg3.k(var1, this.g.ordinal());
         Gg3.i(var1, this.d);
      }
   }
}
