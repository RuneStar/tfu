/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ij60;

public class FileScriptResourceAddressLister
implements Ij60 {
    protected static final Logger logger = LoggerFactory.getLogger(FileScriptResourceAddressLister.class);
    final File baseDir;
    final String extension;

    @Override
    public List getAddresses() {
        LinkedList linkedList = new LinkedList();
        this.getAddresses(this.baseDir, null, linkedList);
        logger.debug("Done adding scripts.");
        return linkedList;
    }

    private void getAddresses(File file, List list, List list2) {
        File[] arrfile;
        for (File file2 : arrfile = file.listFiles()) {
            if (list != null && !list.contains(file2)) continue;
            if (file2.isFile()) {
                if (!file2.getName().endsWith(this.extension)) continue;
                String string = file2.getPath().substring(this.baseDir.getPath().length() + 1);
                string = string.replace('\\', '/');
                string = string.substring(0, string.lastIndexOf(46));
                logger.debug("Adding Lua chunk \"{}\".", (Object)string);
                list2.add(string);
                continue;
            }
            if (!file2.isDirectory() || file2.getName().equals("modules")) continue;
            this.getAddresses(file2, list, list2);
        }
    }

    public FileScriptResourceAddressLister(File file, String string) {
        this.baseDir = file;
        this.extension = string;
    }
}

