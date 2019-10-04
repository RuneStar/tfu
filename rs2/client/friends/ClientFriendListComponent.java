// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.friends;

import tfu.Gc330;
import tfu.Md230;
import rs2.client.chat.G232;
import tfu.Mk163;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.N272;
import tfu.Gg3;
import tfu.El328;
import tfu.Eu326;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass("FriendListComponent")
public class ClientFriendListComponent extends Component
{
    private static final int d = 100;
    private static final int g = 200;
    public static final String q = "ON_FRIENDLIST_UPDATE";
    private static final int s;
    public D236 e;
    boolean h;
    public J228 j;
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public Integer getFriendSlotByDisplayName(final String s) {
        if (!this.isReadyForUse()) {
            return null;
        }
        return J228.g(this.j, s);
    }
    
    public static void g(final ClientFriendListComponent clientFriendListComponent, final boolean h) {
        clientFriendListComponent.h = h;
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
    public final void removeIgnore(final String s) {
        if (!this.isReadyForUse()) {
            return;
        }
        if (D236.h(this.e, s)) {
            final N272 i = client.i();
            final El328 d = El328.d(Eu326.IGNORELIST_DEL, i.s);
            Gg3.k(d.q, Gg3.al(s));
            d.q.af(s);
            N272.e(i, d);
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
    public String getFriendDisplayName(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final Q210 q = J228.q(this.j, n);
        if (q == null) {
            return null;
        }
        return q.g;
    }
    
    public static void d(final ClientFriendListComponent clientFriendListComponent) {
        J228.s(clientFriendListComponent.j);
        D236.s(clientFriendListComponent.e);
        g(clientFriendListComponent, false);
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
    public String getFriendOldDisplayName(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final Q210 q = J228.q(this.j, n);
        if (q == null) {
            return null;
        }
        return q.g;
    }
    
    static {
        s = StringTools.l(ClientFriendListComponent.class.getName());
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getIgnoreDisplayName(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final E235 d = D236.d(this.e, n);
        if (d == null) {
            return null;
        }
        return d.g;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getIgnoreOldDisplayName(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final E235 d = D236.d(this.e, n);
        if (d == null) {
            return null;
        }
        return d.q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return ClientFriendListComponent.s;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public Integer getIgnoreSlotByDisplayName(final String s) {
        if (!this.isReadyForUse()) {
            return null;
        }
        return D236.e(this.e, s);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public void addFriend(final String s) {
        if (s == null) {
            return;
        }
        if (!this.isReadyForUse()) {
            return;
        }
        if (J228.e(this.j)) {
            G232.d(4, Mk163.g(Mk163.FRIENDLIST_FULL, client.n));
            return;
        }
        final String e = Md230.e(s, client.m.l);
        if (e == null) {
            return;
        }
        if (J228.d(this.j, s, true) != null) {
            G232.d(4, s + Mk163.g(Mk163.FRIENDLISTDUPE, client.n));
            return;
        }
        if (D236.j(this.e, s, true) != null) {
            G232.d(4, Mk163.g(Mk163.REMOVEIGNORE1, client.n) + s + Mk163.g(Mk163.REMOVEIGNORE2, client.n));
            return;
        }
        if (Md230.e(Gc330.j().ai, client.m.l).equals(e)) {
            G232.d(4, Mk163.g(Mk163.FRIENDCANTADDSELF, client.n));
            return;
        }
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.FRIENDLIST_ADD, i.s);
        Gg3.k(d.q, Gg3.al(s));
        d.q.af(s);
        N272.e(i, d);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public final void addIgnore(final String s, final boolean b) {
        if (s == null) {
            return;
        }
        if (!this.isReadyForUse()) {
            return;
        }
        if (D236.q(this.e)) {
            G232.d(4, Mk163.g(Mk163.IGNORELISTFULL, client.n));
            return;
        }
        final String e = Md230.e(s, client.m.l);
        if (e == null) {
            return;
        }
        if (D236.j(this.e, s, true) != null) {
            G232.d(4, s + Mk163.g(Mk163.IGNORELISTDUPE, client.n));
            return;
        }
        if (J228.d(this.j, s, true) != null) {
            G232.d(4, Mk163.g(Mk163.REMOVEFRIEND1, client.n) + s + Mk163.g(Mk163.REMOVEFRIEND2, client.n));
            return;
        }
        if (Md230.e(Gc330.j().ai, client.m.l).equals(e)) {
            G232.d(4, Mk163.g(Mk163.IGNORECANTADDSELF, client.n));
            return;
        }
        final N272 i = client.i();
        final El328 d = El328.d(Eu326.IGNORELIST_ADD, i.s);
        Gg3.k(d.q, Gg3.al(s) + 1);
        d.q.af(s);
        Gg3.k(d.q, b ? 1 : 0);
        N272.e(i, d);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public final void removeFriend(final String s) {
        if (!this.isReadyForUse()) {
            return;
        }
        if (J228.h(this.j, s)) {
            final N272 i = client.i();
            final El328 d = El328.d(Eu326.FRIENDLIST_DEL, i.s);
            Gg3.k(d.q, Gg3.al(s));
            d.q.af(s);
            N272.e(i, d);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
        }
    }
    
    public ClientFriendListComponent() {
        this.j = new J228(200);
        this.e = new D236(100);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public Boolean isIgnoreTemporary(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final E235 d = D236.d(this.e, n);
        if (d == null) {
            return null;
        }
        return d.e;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public Boolean isFriendOnline(final int n) {
        if (!this.isReadyForUse()) {
            return null;
        }
        final Q210 q = J228.q(this.j, n);
        if (q == null) {
            return null;
        }
        return q.q != 0;
    }
}
