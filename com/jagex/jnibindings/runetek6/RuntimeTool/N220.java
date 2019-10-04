package com.jagex.jnibindings.runetek6.RuntimeTool;

import javax.swing.JTextField;

public class N220 extends H221 {
   String e;
   String h;
   int j = 0;
   public JTextField s = new JTextField(10);

   void j() {
      String var1 = this.s.getText();
      long var2 = super.g;
      RuntimeTool.h.add(new V503(this, var1, var2));
   }

   public void g() {
      long var1 = super.g;
      RuntimeTool.h.add(new C504(this, var1));
   }

   public N220(String var1, String var2, String var3) {
      super.d = var1;
      this.e = var2;
      this.h = var3;
      this.s.addActionListener(new B505(this));
   }
}
