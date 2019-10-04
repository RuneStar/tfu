package com.jagex.maths;

import java.util.ArrayList;

public final class T313 {
   public final Vector3 d;
   public final Vector3 g;
   ArrayList j;
   public final Vector3 q;

   public int hashCode() {
      return System.identityHashCode(this.g) + System.identityHashCode(this.d) + System.identityHashCode(this.q);
   }

   public boolean equals(Object var1) {
      T313 var2 = (T313)var1;
      if (this.g == var2.g && this.d == var2.d && this.q == var2.q) {
         return true;
      } else if (this.g == var2.d && this.d == var2.q && this.q == var2.g) {
         return true;
      } else if (this.g == var2.q && this.d == var2.g && this.q == var2.d) {
         return true;
      } else if (this.g == var2.g && this.d == var2.q && this.q == var2.d) {
         return true;
      } else if (this.g == var2.d && this.d == var2.g && this.q == var2.q) {
         return true;
      } else {
         return this.g == var2.q && this.d == var2.d && this.q == var2.g;
      }
   }

   T313(Vector3 var1, Vector3 var2, Vector3 var3) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
   }
}
