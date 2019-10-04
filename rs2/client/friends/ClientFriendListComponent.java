package rs2.client.friends;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.chat.G232;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gc330;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Md230;
import tfu.Mk163;

@ScriptEntryClass("FriendListComponent")
public class ClientFriendListComponent extends Component {
   private static final int d = 100;
   private static final int g = 200;
   public static final String q = "ON_FRIENDLIST_UPDATE";
   private static final int s = StringTools.l(ClientFriendListComponent.class.getName());
   public D236 e = new D236(100);
   boolean h;
   public J228 j = new J228(200);

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Integer getFriendSlotByDisplayName(String var1) {
      return !this.isReadyForUse() ? null : J228.g(this.j, var1);
   }

   public static void g(ClientFriendListComponent var0, boolean var1) {
      var0.h = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isReadyForUse() {
      return this.h;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public final void removeIgnore(String var1) {
      if (this.isReadyForUse()) {
         if (D236.h(this.e, var1)) {
            N272 var2 = client.i();
            El328 var3 = El328.d(Eu326.IGNORELIST_DEL, var2.s);
            Gs329.k(var3.q, Gg3.al(var1));
            var3.q.af(var1);
            N272.e(var2, var3);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
         }

      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Integer getFriendCount() {
      return !this.isReadyForUse() ? null : this.j.g;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public String getFriendDisplayName(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         Q210 var2 = J228.q(this.j, var1);
         return var2 == null ? null : var2.g;
      }
   }

   public static void d(ClientFriendListComponent var0) {
      J228.s(var0.j);
      D236.s(var0.e);
      g(var0, false);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Integer getIgnoreCount() {
      return !this.isReadyForUse() ? null : this.e.g;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public String getFriendOldDisplayName(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         Q210 var2 = J228.q(this.j, var1);
         return var2 == null ? null : var2.g;
      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public String getIgnoreDisplayName(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         E235 var2 = D236.d(this.e, var1);
         return var2 == null ? null : var2.g;
      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public String getIgnoreOldDisplayName(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         E235 var2 = D236.d(this.e, var1);
         return var2 == null ? null : var2.q;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return s;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Integer getIgnoreSlotByDisplayName(String var1) {
      return !this.isReadyForUse() ? null : D236.e(this.e, var1);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public void addFriend(String var1) {
      if (var1 != null) {
         if (this.isReadyForUse()) {
            if (J228.e(this.j)) {
               G232.d(4, Mk163.g(Mk163.FRIENDLIST_FULL, client.n));
            } else {
               String var2 = Md230.e(var1, client.m.l);
               if (var2 != null) {
                  if (J228.d(this.j, var1, true) != null) {
                     G232.d(4, var1 + Mk163.g(Mk163.FRIENDLISTDUPE, client.n));
                  } else if (D236.j(this.e, var1, true) != null) {
                     G232.d(4, Mk163.g(Mk163.REMOVEIGNORE1, client.n) + var1 + Mk163.g(Mk163.REMOVEIGNORE2, client.n));
                  } else if (Md230.e(Gc330.j().ai, client.m.l).equals(var2)) {
                     G232.d(4, Mk163.g(Mk163.FRIENDCANTADDSELF, client.n));
                  } else {
                     N272 var3 = client.i();
                     El328 var4 = El328.d(Eu326.FRIENDLIST_ADD, var3.s);
                     Gs329.k(var4.q, Gg3.al(var1));
                     var4.q.af(var1);
                     N272.e(var3, var4);
                  }
               }
            }
         }
      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public final void addIgnore(String var1, boolean var2) {
      if (var1 != null) {
         if (this.isReadyForUse()) {
            if (D236.q(this.e)) {
               G232.d(4, Mk163.g(Mk163.IGNORELISTFULL, client.n));
            } else {
               String var3 = Md230.e(var1, client.m.l);
               if (var3 != null) {
                  if (D236.j(this.e, var1, true) != null) {
                     G232.d(4, var1 + Mk163.g(Mk163.IGNORELISTDUPE, client.n));
                  } else if (J228.d(this.j, var1, true) != null) {
                     G232.d(4, Mk163.g(Mk163.REMOVEFRIEND1, client.n) + var1 + Mk163.g(Mk163.REMOVEFRIEND2, client.n));
                  } else if (Md230.e(Gc330.j().ai, client.m.l).equals(var3)) {
                     G232.d(4, Mk163.g(Mk163.IGNORECANTADDSELF, client.n));
                  } else {
                     N272 var4 = client.i();
                     El328 var5 = El328.d(Eu326.IGNORELIST_ADD, var4.s);
                     Gs329.k(var5.q, Gg3.al(var1) + 1);
                     var5.q.af(var1);
                     Gs329.k(var5.q, var2 ? 1 : 0);
                     N272.e(var4, var5);
                  }
               }
            }
         }
      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public final void removeFriend(String var1) {
      if (this.isReadyForUse()) {
         if (J228.h(this.j, var1)) {
            N272 var2 = client.i();
            El328 var3 = El328.d(Eu326.FRIENDLIST_DEL, var2.s);
            Gs329.k(var3.q, Gg3.al(var1));
            var3.q.af(var1);
            N272.e(var2, var3);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
         }

      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Boolean isIgnoreTemporary(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         E235 var2 = D236.d(this.e, var1);
         return var2 == null ? null : var2.e;
      }
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public Boolean isFriendOnline(int var1) {
      if (!this.isReadyForUse()) {
         return null;
      } else {
         Q210 var2 = J228.q(this.j, var1);
         return var2 == null ? null : var2.q != 0;
      }
   }
}
