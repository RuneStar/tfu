package tfu;

class Ct636 {
   private int d = Cg550.j(24);
   private int e = Cg550.j(6) + 1;
   int g = Cg550.j(16);
   private int h = Cg550.j(8);
   private int j = Cg550.j(24) + 1;
   private int q = Cg550.j(24);
   private int[] s;

   Ct636() {
      int[] var1 = new int[this.e];

      int var2;
      for(var2 = 0; var2 < this.e; ++var2) {
         int var3 = 0;
         int var4 = Cg550.j(3);
         boolean var5 = Cg550.q() != 0;
         if (var5) {
            var3 = Cg550.j(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.s = new int[this.e * 8];

      for(var2 = 0; var2 < this.e * 8; ++var2) {
         this.s[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? Cg550.j(8) : -1;
      }

   }
}
