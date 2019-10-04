/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.friends;

import com.jagex.core.constants.Language;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.N272;
import rs2.client.chat.G232;
import rs2.client.client;
import rs2.client.friends.D236;
import rs2.client.friends.E235;
import rs2.client.friends.J228;
import rs2.client.friends.Q210;
import rs2.client.worldelement.player;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gc330;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Ic327;
import tfu.Ly234;
import tfu.Md230;
import tfu.Mk163;

@ScriptEntryClass(value="FriendListComponent")
public class ClientFriendListComponent
extends Component {
    private static final int d = 100;
    private static final int g = 200;
    public static final String q = "ON_FRIENDLIST_UPDATE";
    private static final int s = StringTools.l(ClientFriendListComponent.class.getName());
    public D236 e;
    boolean h;
    public J228 j = new J228(200);

    @ScriptEntryPoint
    @Bs1
    @Be2
    public Integer getFriendSlotByDisplayName(String string) {
        if (!this.isReadyForUse()) {
            return null;
        }
        return J228.g(this.j, string);
    }

    public static void g(ClientFriendListComponent clientFriendListComponent, boolean bl) {
        clientFriendListComponent.h = bl;
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
    public final void removeIgnore(String string) {
        if (!this.isReadyForUse()) {
            return;
        }
        if (D236.h(this.e, string)) {
            N272 n272 = client.i();
            El328 el328 = El328.d(Eu326.IGNORELIST_DEL, n272.s);
            Gs329.k(el328.q, Gg3.al(string));
            el328.q.af(string);
            N272.e(n272, el328);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
        }
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public Integer getFriendCount() {
        if (!this.isReadyForUse()) {
            return null;
        }
        return this.j.g;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getFriendDisplayName(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        Q210 q210 = J228.q(this.j, n);
        if (q210 == null) {
            return null;
        }
        return q210.g;
    }

    public static void d(ClientFriendListComponent clientFriendListComponent) {
        J228.s(clientFriendListComponent.j);
        D236.s(clientFriendListComponent.e);
        ClientFriendListComponent.g(clientFriendListComponent, false);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public Integer getIgnoreCount() {
        if (!this.isReadyForUse()) {
            return null;
        }
        return this.e.g;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getFriendOldDisplayName(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        Q210 q210 = J228.q(this.j, n);
        if (q210 == null) {
            return null;
        }
        return q210.g;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getIgnoreDisplayName(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        E235 e235 = D236.d(this.e, n);
        if (e235 == null) {
            return null;
        }
        return e235.g;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getIgnoreOldDisplayName(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        E235 e235 = D236.d(this.e, n);
        if (e235 == null) {
            return null;
        }
        return e235.q;
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
    public Integer getIgnoreSlotByDisplayName(String string) {
        if (!this.isReadyForUse()) {
            return null;
        }
        return D236.e(this.e, string);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public void addFriend(String string) {
        if (string == null) {
            return;
        }
        if (!this.isReadyForUse()) {
            return;
        }
        if (J228.e(this.j)) {
            G232.d(4, Mk163.g(Mk163.FRIENDLIST_FULL, client.n));
            return;
        }
        String string2 = Md230.e(string, client.m.l);
        if (string2 == null) {
            return;
        }
        if (J228.d(this.j, string, true) != null) {
            G232.d(4, string + Mk163.g(Mk163.FRIENDLISTDUPE, client.n));
            return;
        }
        if (D236.j(this.e, string, true) != null) {
            G232.d(4, Mk163.g(Mk163.REMOVEIGNORE1, client.n) + string + Mk163.g(Mk163.REMOVEIGNORE2, client.n));
            return;
        }
        if (Md230.e(Gc330.j().ai, client.m.l).equals(string2)) {
            G232.d(4, Mk163.g(Mk163.FRIENDCANTADDSELF, client.n));
            return;
        }
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.FRIENDLIST_ADD, n272.s);
        Gs329.k(el328.q, Gg3.al(string));
        el328.q.af(string);
        N272.e(n272, el328);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public final void addIgnore(String string, boolean bl) {
        if (string == null) {
            return;
        }
        if (!this.isReadyForUse()) {
            return;
        }
        if (D236.q(this.e)) {
            G232.d(4, Mk163.g(Mk163.IGNORELISTFULL, client.n));
            return;
        }
        String string2 = Md230.e(string, client.m.l);
        if (string2 == null) {
            return;
        }
        if (D236.j(this.e, string, true) != null) {
            G232.d(4, string + Mk163.g(Mk163.IGNORELISTDUPE, client.n));
            return;
        }
        if (J228.d(this.j, string, true) != null) {
            G232.d(4, Mk163.g(Mk163.REMOVEFRIEND1, client.n) + string + Mk163.g(Mk163.REMOVEFRIEND2, client.n));
            return;
        }
        if (Md230.e(Gc330.j().ai, client.m.l).equals(string2)) {
            G232.d(4, Mk163.g(Mk163.IGNORECANTADDSELF, client.n));
            return;
        }
        N272 n272 = client.i();
        El328 el328 = El328.d(Eu326.IGNORELIST_ADD, n272.s);
        Gs329.k(el328.q, Gg3.al(string) + 1);
        el328.q.af(string);
        Gs329.k(el328.q, bl ? 1 : 0);
        N272.e(n272, el328);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public final void removeFriend(String string) {
        if (!this.isReadyForUse()) {
            return;
        }
        if (J228.h(this.j, string)) {
            N272 n272 = client.i();
            El328 el328 = El328.d(Eu326.FRIENDLIST_DEL, n272.s);
            Gs329.k(el328.q, Gg3.al(string));
            el328.q.af(string);
            N272.e(n272, el328);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
        }
    }

    public ClientFriendListComponent() {
        this.e = new D236(100);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public Boolean isIgnoreTemporary(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        E235 e235 = D236.d(this.e, n);
        if (e235 == null) {
            return null;
        }
        return e235.e;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public Boolean isFriendOnline(int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        Q210 q210 = J228.q(this.j, n);
        if (q210 == null) {
            return null;
        }
        return q210.q != 0;
    }
}

