package com.jagex.game.runetek6.comms.statestream;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncPacket {
   private static Logger logger = LoggerFactory.getLogger(SyncPacket.class);
   public boolean keyframe = false;
   final Map sections = new HashMap();

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("SyncPacket\n\n");
      var1.append("Section Data:\n");
      Iterator var2 = this.sections.keySet().iterator();

      while(var2.hasNext()) {
         SyncPacket$SectionType var3 = (SyncPacket$SectionType)var2.next();
         Map var4 = (Map)this.sections.get(var3);
         var1.append("  Section Type: " + var3.id + " count=" + var4.size() + "\n");
         Iterator var5 = var4.keySet().iterator();

         while(var5.hasNext()) {
            Integer var6 = (Integer)var5.next();
            List var7 = (List)var4.get(var6);
            var1.append("    Stream: " + var6 + " Sections=" + var7.size() + "\n");
            Iterator var8 = var7.iterator();

            while(var8.hasNext()) {
               SyncPacket$Section var9 = (SyncPacket$Section)var8.next();
               String var10 = var9.toStringForDebug();
               String[] var11 = var10.split("\n");
               int var12 = var11.length;

               for(int var13 = 0; var13 < var12; ++var13) {
                  String var14 = var11[var13];
                  var1.append("      " + var14 + "\n");
               }
            }
         }
      }

      return var1.toString();
   }

   private void addSection(int var1, SyncPacket$Section var2) {
      SyncPacket$SectionType var3 = var2.getType();
      Object var4 = (Map)this.sections.get(var3);
      if (var4 == null) {
         var4 = new HashMap();
         this.sections.put(var3, var4);
      }

      Object var5 = (List)((Map)var4).get(var1);
      if (var5 == null) {
         var5 = new LinkedList();
         ((Map)var4).put(var1, var5);
      }

      ((List)var5).add(var2);
   }

   void addPacketAcknowledgeSection(int var1) {
      this.addSection(0, new SyncPacket$PacketAcknowledgeSection(var1));
   }

   void addDeltaSection(Class var1, int var2, int var3, int var4, int var5, byte var6, byte[] var7, long var8) {
      this.addSection(var2, new SyncPacket$DeltaSection(var1, var3, var4, var5, var6, var7, var8));
   }

   void addResetSection(int var1) {
      this.addSection(var1, new SyncPacket$ResetSection());
   }

   List sizedSubpacketSplit(int var1) {
      LinkedList var2 = new LinkedList();
      if (this.sections.isEmpty()) {
         var2.add(new SyncPacket());
         return var2;
      } else {
         HashSet var3 = new HashSet();

         boolean var4;
         do {
            var4 = false;
            SyncPacket var5 = new SyncPacket();
            var5.keyframe = this.keyframe;
            int var6 = var1;
            int var7 = 0;
            Iterator var8 = this.sections.keySet().iterator();

            while(var8.hasNext()) {
               SyncPacket$SectionType var9 = (SyncPacket$SectionType)var8.next();
               int var10 = var6 - 5;
               int var11 = 0;
               Map var12 = (Map)this.sections.get(var9);
               Iterator var13 = var12.keySet().iterator();

               while(true) {
                  label70:
                  while(var13.hasNext()) {
                     Integer var14 = (Integer)var13.next();
                     boolean var15 = false;
                     List var16 = (List)var12.get(var14);
                     Iterator var17 = var16.iterator();

                     while(true) {
                        while(true) {
                           SyncPacket$Section var18;
                           do {
                              if (!var17.hasNext()) {
                                 continue label70;
                              }

                              var18 = (SyncPacket$Section)var17.next();
                           } while(var3.contains(var18));

                           int var19 = var18.getBodySize();
                           if (var10 < var19 && var7 > 0) {
                              var4 = true;
                           } else {
                              if (!var15) {
                                 if (var7 > 0 && var10 - var19 <= 8) {
                                    var4 = true;
                                    continue label70;
                                 }

                                 var10 -= 8;
                                 var15 = true;
                              }

                              var10 -= var19;
                              ++var11;
                              var3.add(var18);
                              Object var20 = (Map)var5.sections.get(var9);
                              if (var20 == null) {
                                 var20 = new HashMap();
                                 var5.sections.put(var9, var20);
                              }

                              Object var21 = (List)((Map)var20).get(var14);
                              if (var21 == null) {
                                 var21 = new LinkedList();
                                 ((Map)var20).put(var14, var21);
                              }

                              ((List)var21).add(var18);
                              ++var7;
                           }
                        }
                     }
                  }

                  if (var11 != 0) {
                     var6 = var10;
                  }
                  break;
               }
            }

            var2.add(var5);
         } while(var4);

         return var2;
      }
   }

   boolean generatePacket(ByteBuffer var1) {
      try {
         Iterator var2 = this.sections.keySet().iterator();

         while(var2.hasNext()) {
            SyncPacket$SectionType var3 = (SyncPacket$SectionType)var2.next();
            Map var4 = (Map)this.sections.get(var3);
            var1.put(var3.id);
            var1.putInt(var4.size());
            Iterator var5 = var4.keySet().iterator();

            while(var5.hasNext()) {
               Integer var6 = (Integer)var5.next();
               var1.putInt(var6);
               List var7 = (List)var4.get(var6);
               Collections.sort(var7);
               var1.putInt(var7.size());
               Iterator var8 = var7.iterator();

               while(var8.hasNext()) {
                  SyncPacket$Section var9 = (SyncPacket$Section)var8.next();
                  var9.writeBody(var1);
               }
            }
         }

         return true;
      } catch (BufferOverflowException var10) {
         return false;
      }
   }

   static SyncPacket parsePacket(ByteBuffer var0) {
      // $FF: Couldn't be decompiled
   }

   void addErrorSection(int var1) {
      this.addSection(var1, new SyncPacket$ErrorSection());
   }
}
