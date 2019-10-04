package com.jagex.game.runetek6.script.resource;

import com.jagex.js5.js5;
import java.util.LinkedList;
import java.util.List;
import tfu.Gg3;
import tfu.Ij60;

public class Js5ScriptResourceAddressLister implements Ij60 {
   final String groupId;
   final js5 scriptJs5;

   public Js5ScriptResourceAddressLister(js5 var1, String var2) {
      this.scriptJs5 = var1;
      this.groupId = var2;
   }

   public List getAddresses() {
      LinkedList var1 = new LinkedList();
      this.scriptJs5.m = 0;
      int var2 = this.scriptJs5.getgroupid(this.groupId);

      for(int var3 = 0; var3 < js5.z(this.scriptJs5, var2); ++var3) {
         byte[] var4 = this.scriptJs5.getfile(var2, var3);
         if (var4 != null) {
            Gg3 var5 = new Gg3(var4);
            String var6 = var5.bh();
            if (!var6.startsWith("modules/")) {
               var1.add(var6);
            }
         }
      }

      return var1;
   }
}
