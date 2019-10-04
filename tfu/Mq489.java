/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import java.util.Iterator;
import tfu.Mn54;

public class Mq489
extends SparseVarDomain
implements Iterable {
    int d;
    int g;

    public static int d(Mq489 mq489) {
        return mq489.g;
    }

    public static int q(Mq489 mq489) {
        return mq489.d;
    }

    public Iterator iterator() {
        return this.varValues.iterator();
    }

    public static void j(Mq489 mq489, int n) {
        mq489.d = n;
    }

    public Mq489(int n, int n2, VarTypeList varTypeList) {
        super(varTypeList);
        this.g = n;
        this.d = n2;
    }
}

