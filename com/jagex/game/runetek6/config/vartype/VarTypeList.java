/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.constants.BaseVarType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import java.util.HashMap;
import java.util.Map;
import tfu.Ff259;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Kf58;
import tfu.Kr260;
import tfu.Kz261;

public abstract class VarTypeList
extends Ff259
implements Kf58 {
    private Map hashLookup = null;
    public final VarDomainType variableDomain;

    protected VarTypeList(Gd27 gd27, VarDomainType varDomainType, Language language, int n) {
        super(gd27, language, n);
        this.variableDomain = varDomainType;
    }

    @Override
    public int length() {
        return this.q;
    }

    public static Map createDomainToListEnumMap(VarTypeList ... arrvarTypeList) {
        if (arrvarTypeList == null || arrvarTypeList.length == 0) {
            return null;
        }
        HashMap<VarDomainType, VarTypeList> hashMap = new HashMap<VarDomainType, VarTypeList>();
        for (VarTypeList varTypeList : arrvarTypeList) {
            hashMap.put(varTypeList.variableDomain, varTypeList);
        }
        return hashMap;
    }

    public abstract VarType list(int var1);

    public void createHashMapLookup() {
        this.hashLookup = new HashMap<K, V>();
        for (int i = 0; i < this.q; ++i) {
            VarType varType = this.list(i);
            if (varType.debugNameHash32 == 0) continue;
            this.hashLookup.put(varType.debugNameHash32, i);
        }
    }

    @Override
    public Object getDefaultValue(int n) {
        VarType varType = this.list(n);
        if (varType == null || !varType.isValidDefinition()) {
            return null;
        }
        return varType.getDefaultValue();
    }

    public VarType hashLookup(int n) {
        if (this.hashLookup.containsKey(n)) {
            return this.list((Integer)this.hashLookup.get(n));
        }
        return null;
    }

    public void encodeVarValue(Gg3 gg3, Kr260 kr260) {
        Gg3.i(gg3, kr260.g);
        if (kr260.d instanceof Integer) {
            Gg3.a(gg3, (Integer)kr260.d);
        } else if (kr260.d instanceof Long) {
            Gg3.ag(gg3, (Long)kr260.d);
        } else if (kr260.d instanceof String) {
            gg3.ap((String)kr260.d);
        } else if (kr260.d instanceof Kz261) {
            ((Kz261)kr260.d).d(gg3);
        } else {
            throw new IllegalStateException();
        }
    }

    public Kr260 decodeVarValue(Gg3 gg3) {
        int n = Gg3.au(gg3);
        VarType varType = this.list(n);
        if (!varType.isValidDefinition()) {
            return null;
        }
        Kr260 kr260 = new Kr260(n);
        Class class_ = varType.dataType.getVarBaseType().javaClass;
        if (class_ == Integer.class) {
            kr260.d = Gg3.bd(gg3);
        } else if (class_ == Long.class) {
            kr260.d = Gg3.bq(gg3);
        } else if (class_ == String.class) {
            kr260.d = gg3.bh();
        } else if (Kz261.class.isAssignableFrom(class_)) {
            try {
                Kz261 kz261 = (Kz261)class_.newInstance();
                kz261.q(gg3);
                kr260.d = kz261;
            }
            catch (InstantiationException instantiationException) {
            }
            catch (IllegalAccessException illegalAccessException) {}
        } else {
            throw new IllegalStateException();
        }
        return kr260;
    }

    public int getValueEncodingLength(Kr260 kr260) {
        int n = 2;
        if (kr260.d instanceof Integer) {
            n += 4;
        } else if (kr260.d instanceof Long) {
            n += 8;
        } else if (kr260.d instanceof String) {
            n += Gg3.av((String)kr260.d);
        } else if (kr260.d instanceof Kz261) {
            n += ((Kz261)kr260.d).g();
        } else {
            throw new IllegalStateException();
        }
        return n;
    }
}

