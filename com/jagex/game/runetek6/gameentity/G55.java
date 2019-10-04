// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity;

import java.util.HashMap;
import java.util.Iterator;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import tfu.Js343;
import tfu.Kh56;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.variables.G53;
import java.util.Map;

public final class G55
{
    private final Map d;
    private final GameEntity g;
    private Map j;
    private G53 q;
    
    public String g(final String str) {
        final String string = "On" + str + "Changed";
        this.j.put(StringTools.l(str), StringTools.l(string));
        return string;
    }
    
    public static int q(final G55 g55, final String s, final int n) {
        final Number n2 = (Number)g55.j(s);
        return (n2 != null) ? n2.intValue() : n;
    }
    
    public Object j(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (this.q != null && this.q.br(s)) {
            return this.q.GetVar(s);
        }
        return this.d.get(s);
    }
    
    public static Object e(final G55 g55, final String s, final Object o) {
        final Object j = g55.j(s);
        if (j == null) {
            return o;
        }
        return j;
    }
    
    public void h(final String s, final Object o) {
        if (s == null) {
            throw new NullPointerException();
        }
        final int l = StringTools.l(s);
        final Integer n = (this.g == null) ? null : this.j.get(l);
        if (this.q != null && this.q.br(s)) {
            try {
                final Object getVar = this.q.GetVar(s);
                this.q.SetVar(s, o);
                final Object getVar2 = this.q.GetVar(s);
                if (!Kh56.g(getVar2, getVar)) {
                    if (n != null) {
                        this.g.triggerEvent(n, o);
                    }
                    final Iterator<Integer> iterator = this.g.ca.iterator();
                    while (iterator.hasNext()) {
                        this.g.triggerEvent(iterator.next(), new Js343(s, new Object[] { getVar, getVar2 }));
                    }
                }
                return;
            }
            catch (VarBitOverflowException cause) {
                throw new IllegalArgumentException(cause);
            }
        }
        if (!Kh56.g(o, this.d.get(s))) {
            if (o != null) {
                this.d.put(s, o);
            }
            else {
                this.d.remove(s);
            }
            if (n != null) {
                this.g.triggerEvent(n, o);
            }
        }
    }
    
    public static Integer s(final G55 g55, final int i) {
        return (g55.g == null) ? null : g55.j.get(i);
    }
    
    public G55(final GameEntity g) {
        this.d = new HashMap();
        this.j = new HashMap();
        this.g = g;
    }
    
    public void d(final G53 q) {
        if (this.q != null) {
            throw new IllegalStateException("Already set");
        }
        if (q == null) {
            throw new NullPointerException();
        }
        this.q = q;
        final Iterator<Map.Entry<String, V>> iterator = this.d.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, V> entry = iterator.next();
            if (this.q.br(entry.getKey())) {
                try {
                    this.q.SetVar(entry.getKey(), entry.getValue());
                }
                catch (VarBitOverflowException cause) {
                    throw new IllegalStateException(cause);
                }
                iterator.remove();
            }
        }
    }
}
