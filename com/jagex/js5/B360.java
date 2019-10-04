package com.jagex.js5;

import tfu.Gg3;

public class B360 extends E361 {
   int d;
   Gg3 g;
   byte q;

   byte[] g() {
      if (!super.l && this.g.v >= this.g.r.length - this.q) {
         return this.g.r;
      } else {
         throw new RuntimeException("Not ready!");
      }
   }

   int d() {
      return this.g == null ? 0 : this.g.v * 100 / (this.g.r.length - this.q);
   }

   B360() {
   }
}
