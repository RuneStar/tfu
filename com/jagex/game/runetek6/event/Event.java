package com.jagex.game.runetek6.event;

import java.util.ArrayList;

public class Event extends ArrayList {
   public void removeStaticallyConfiguredHandlers() {
      for(int var1 = this.size() - 1; var1 >= 0; --var1) {
         EventHandler var2 = (EventHandler)this.get(var1);

         assert var2 != null;

         if (var2 != null) {
            if (var2.staticallyConfigured) {
               this.remove(var1);
            }
         } else {
            System.err.println("XXXXX null handler found in Event<> list when removing statically configured handlers");
         }
      }

   }

   public void trigger(Object var1, Object var2) {
      for(int var3 = 0; var3 < this.size(); ++var3) {
         EventHandler var4 = (EventHandler)this.get(var3);
         if (var4 != null) {
            var4.trigger(var1, var2);
         } else {
            System.err.println("XXXXX null handler found in Event<> list when triggering");
         }
      }

   }

   public void add(int var1, EventHandler var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("XXXXX added handler mustn't be null");
      } else {
         super.add(var1, var2);
      }
   }

   public boolean add(EventHandler var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("XXXXX added handler mustn't be null");
      } else {
         return super.add(var1);
      }
   }
}
