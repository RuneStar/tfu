/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ah536;
import tfu.Js343;

final class Av542
extends Js343 {
    final /* synthetic */ Ah536 g;

    @Override
    public int hashCode() {
        int n = 0;
        if (this.d != null) {
            n += ((String)this.d).toLowerCase().hashCode();
        }
        if (this.q != null) {
            n += 31 * ((String)this.q).toLowerCase().hashCode();
        }
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Js343)) {
            return false;
        }
        Av542 av542 = (Av542)object;
        if (this.d == null ? av542.d != null : !((String)this.d).equalsIgnoreCase((String)av542.d)) {
            return false;
        }
        return !(this.q == null ? av542.q != null : !((String)this.q).equalsIgnoreCase((String)av542.q));
    }

    public Av542(Ah536 ah536, String string, String string2) {
        super(string, string2);
        this.g = ah536;
    }
}

