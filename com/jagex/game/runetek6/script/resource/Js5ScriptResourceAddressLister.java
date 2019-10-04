// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource;

import tfu.Gg3;
import java.util.LinkedList;
import java.util.List;
import com.jagex.js5.js5;
import tfu.Ij60;

public class Js5ScriptResourceAddressLister implements Ij60
{
    final String groupId;
    final js5 scriptJs5;
    
    public Js5ScriptResourceAddressLister(final js5 scriptJs5, final String groupId) {
        this.scriptJs5 = scriptJs5;
        this.groupId = groupId;
    }
    
    @Override
    public List getAddresses() {
        final LinkedList<String> list = new LinkedList<String>();
        this.scriptJs5.m = 0;
        for (int getgroupid = this.scriptJs5.getgroupid(this.groupId), i = 0; i < js5.z(this.scriptJs5, getgroupid); ++i) {
            final byte[] getfile = this.scriptJs5.getfile(getgroupid, i);
            if (getfile != null) {
                final String bh = new Gg3(getfile).bh();
                if (!bh.startsWith("modules/")) {
                    list.add(bh);
                }
            }
        }
        return list;
    }
}
