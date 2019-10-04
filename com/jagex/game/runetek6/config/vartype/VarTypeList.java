// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype;

import tfu.Kz261;
import tfu.Kr260;
import tfu.Gg3;
import java.util.HashMap;
import com.jagex.core.constants.Language;
import tfu.Gd27;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import java.util.Map;
import tfu.Kf58;
import tfu.Ff259;

public abstract class VarTypeList extends Ff259 implements Kf58
{
    private Map hashLookup;
    public final VarDomainType variableDomain;
    
    protected VarTypeList(final Gd27 gd27, final VarDomainType variableDomain, final Language language, final int n) {
        super(gd27, language, n);
        this.hashLookup = null;
        this.variableDomain = variableDomain;
    }
    
    @Override
    public int length() {
        return super.q;
    }
    
    public static Map createDomainToListEnumMap(final VarTypeList... array) {
        if (array == null || array.length == 0) {
            return null;
        }
        final HashMap<VarDomainType, VarTypeList> hashMap = new HashMap<VarDomainType, VarTypeList>();
        for (final VarTypeList list : array) {
            hashMap.put(list.variableDomain, list);
        }
        return hashMap;
    }
    
    public abstract VarType list(final int p0);
    
    public void createHashMapLookup() {
        this.hashLookup = new HashMap();
        for (int i = 0; i < super.q; ++i) {
            final VarType list = this.list(i);
            if (list.debugNameHash32 != 0) {
                this.hashLookup.put(list.debugNameHash32, i);
            }
        }
    }
    
    @Override
    public Object getDefaultValue(final int n) {
        final VarType list = this.list(n);
        if (list == null || !list.isValidDefinition()) {
            return null;
        }
        return list.getDefaultValue();
    }
    
    public VarType hashLookup(final int n) {
        if (this.hashLookup.containsKey(n)) {
            return this.list(this.hashLookup.get(n));
        }
        return null;
    }
    
    public void encodeVarValue(final Gg3 gg3, final Kr260 kr260) {
        Gg3.i(gg3, kr260.g);
        if (kr260.d instanceof Integer) {
            Gg3.a(gg3, (int)kr260.d);
        }
        else if (kr260.d instanceof Long) {
            Gg3.ag(gg3, (long)kr260.d);
        }
        else if (kr260.d instanceof String) {
            gg3.ap((String)kr260.d);
        }
        else {
            if (!(kr260.d instanceof Kz261)) {
                throw new IllegalStateException();
            }
            ((Kz261)kr260.d).d(gg3);
        }
    }
    
    public Kr260 decodeVarValue(final Gg3 gg3) {
        final int au = Gg3.au(gg3);
        final VarType list = this.list(au);
        if (!list.isValidDefinition()) {
            return null;
        }
        final Kr260 kr260 = new Kr260(au);
        final Class javaClass = list.dataType.getVarBaseType().javaClass;
        if (javaClass == Integer.class) {
            kr260.d = Gg3.bd(gg3);
        }
        else if (javaClass == Long.class) {
            kr260.d = Gg3.bq(gg3);
        }
        else if (javaClass == String.class) {
            kr260.d = gg3.bh();
        }
        else {
            if (!Kz261.class.isAssignableFrom(javaClass)) {
                throw new IllegalStateException();
            }
            try {
                final Kz261 d = (Kz261)javaClass.newInstance();
                d.q(gg3);
                kr260.d = d;
            }
            catch (InstantiationException ex) {}
            catch (IllegalAccessException ex2) {}
        }
        return kr260;
    }
    
    public int getValueEncodingLength(final Kr260 kr260) {
        int n = 2;
        if (kr260.d instanceof Integer) {
            n += 4;
        }
        else if (kr260.d instanceof Long) {
            n += 8;
        }
        else if (kr260.d instanceof String) {
            n += Gg3.av((String)kr260.d);
        }
        else {
            if (!(kr260.d instanceof Kz261)) {
                throw new IllegalStateException();
            }
            n += ((Kz261)kr260.d).g();
        }
        return n;
    }
}
