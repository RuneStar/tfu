/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.variables.G53;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tfu.Js343;
import tfu.Kh56;

public final class G55 {
    private final Map d = new HashMap();
    private final GameEntity g;
    private Map j = new HashMap();
    private G53 q;

    public String g(String string) {
        String string2 = "On" + string + "Changed";
        int n = StringTools.l(string);
        int n2 = StringTools.l(string2);
        this.j.put(n, n2);
        return string2;
    }

    public static int q(G55 g55, String string, int n) {
        Number number = (Number)g55.j(string);
        return number != null ? number.intValue() : n;
    }

    public Object j(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (this.q != null && this.q.br(string)) {
            return this.q.GetVar(string);
        }
        return this.d.get(string);
    }

    public static Object e(G55 g55, String string, Object object) {
        Object object2 = g55.j(string);
        if (object2 == null) {
            return object;
        }
        return object2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void h(String string, Object object) {
        Integer n;
        if (string == null) {
            throw new NullPointerException();
        }
        int n2 = StringTools.l(string);
        Integer n3 = n = this.g == null ? null : (Integer)this.j.get(n2);
        if (this.q != null && this.q.br(string)) {
            try {
                Object object2 = this.q.GetVar(string);
                this.q.SetVar(string, object);
                Object object3 = this.q.GetVar(string);
                if (Kh56.g(object3, object2)) return;
                if (n != null) {
                    this.g.triggerEvent(n, object);
                }
                for (Integer n4 : this.g.ca) {
                    this.g.triggerEvent(n4, new Js343(string, new Object[]{object2, object3}));
                }
                return;
            }
            catch (VarBitOverflowException varBitOverflowException) {
                throw new IllegalArgumentException(varBitOverflowException);
            }
        } else {
            Object v = this.d.get(string);
            if (Kh56.g(object, v)) return;
            if (object != null) {
                this.d.put(string, object);
            } else {
                this.d.remove(string);
            }
            if (n == null) return;
            this.g.triggerEvent(n, object);
        }
    }

    public static Integer s(G55 g55, int n) {
        return g55.g == null ? null : (Integer)g55.j.get(n);
    }

    public G55(GameEntity gameEntity) {
        this.g = gameEntity;
    }

    public void d(G53 g53) {
        if (this.q != null) {
            throw new IllegalStateException("Already set");
        }
        if (g53 == null) {
            throw new NullPointerException();
        }
        this.q = g53;
        Iterator iterator = this.d.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (!this.q.br((String)entry.getKey())) continue;
            try {
                this.q.SetVar((String)entry.getKey(), entry.getValue());
            }
            catch (VarBitOverflowException varBitOverflowException) {
                throw new IllegalStateException(varBitOverflowException);
            }
            iterator.remove();
        }
    }
}

