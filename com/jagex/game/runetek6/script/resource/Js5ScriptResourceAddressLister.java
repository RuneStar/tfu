/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource;

import com.jagex.js5.js5;
import java.util.LinkedList;
import java.util.List;
import tfu.Gg3;
import tfu.Ij60;

public class Js5ScriptResourceAddressLister
implements Ij60 {
    final String groupId;
    final js5 scriptJs5;

    public Js5ScriptResourceAddressLister(js5 js52, String string) {
        this.scriptJs5 = js52;
        this.groupId = string;
    }

    @Override
    public List getAddresses() {
        LinkedList<String> linkedList = new LinkedList<String>();
        this.scriptJs5.m = 0;
        int n = this.scriptJs5.getgroupid(this.groupId);
        for (int i = 0; i < js5.z(this.scriptJs5, n); ++i) {
            String string;
            Gg3 gg3;
            byte[] arrby = this.scriptJs5.getfile(n, i);
            if (arrby == null || (string = (gg3 = new Gg3(arrby)).bh()).startsWith("modules/")) continue;
            linkedList.add(string);
        }
        return linkedList;
    }
}

