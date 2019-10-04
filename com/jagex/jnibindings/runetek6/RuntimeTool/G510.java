package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Component;
import javax.swing.JTextField;

class G510 implements Runnable {
   // $FF: synthetic field
   final Y227 d;
   // $FF: synthetic field
   final long g;

   G510(Y227 var1, long var2) {
      this.g = var2;
      this.d = var1;
   }

   public void run() {
      if (this.g != 0L) {
         int var1 = 0;
         StateManager.callMatrixCommand(this.g, "Get" + this.d.d, this.d.s);
         Component[] var2 = this.d.e.getComponents();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Component var5 = var2[var4];
            if (var5 instanceof JTextField) {
               ((JTextField)var5).setText(String.valueOf(this.d.s[var1]).toString());
               ++var1;
               if (var1 == 3 || var1 == 7 || var1 == 11 || var1 == 15) {
                  ++var1;
               }
            }
         }
      }

   }
}
