/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import java.util.Arrays;

public class O376 {
    public final Object[] d;
    public final String g;

    public boolean equals(Object object) {
        if (!(object instanceof O376)) {
            return false;
        }
        O376 o376 = (O376)object;
        if (!this.g.equals(o376.g)) {
            return false;
        }
        return Arrays.equals(this.d, o376.d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g + "(");
        boolean bl = true;
        for (Object object : this.d) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(object);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public O376(String string, Object[] arrobject) {
        this.g = string;
        this.d = arrobject;
    }
}

