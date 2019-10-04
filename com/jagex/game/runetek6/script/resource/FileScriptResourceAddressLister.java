// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource;

import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import org.slf4j.Logger;
import tfu.Ij60;

public class FileScriptResourceAddressLister implements Ij60
{
    protected static final Logger logger;
    final File baseDir;
    final String extension;
    
    @Override
    public List getAddresses() {
        final LinkedList list = new LinkedList();
        this.getAddresses(this.baseDir, null, list);
        FileScriptResourceAddressLister.logger.debug("Done adding scripts.");
        return list;
    }
    
    private void getAddresses(final File file, final List list, final List list2) {
        for (final File file2 : file.listFiles()) {
            if (list == null || list.contains(file2)) {
                if (file2.isFile()) {
                    if (file2.getName().endsWith(this.extension)) {
                        final String replace = file2.getPath().substring(this.baseDir.getPath().length() + 1).replace('\\', '/');
                        final String substring = replace.substring(0, replace.lastIndexOf(46));
                        FileScriptResourceAddressLister.logger.debug("Adding Lua chunk \"{}\".", substring);
                        list2.add(substring);
                    }
                }
                else if (file2.isDirectory() && !file2.getName().equals("modules")) {
                    this.getAddresses(file2, list, list2);
                }
            }
        }
    }
    
    public FileScriptResourceAddressLister(final File baseDir, final String extension) {
        this.baseDir = baseDir;
        this.extension = extension;
    }
    
    static {
        logger = LoggerFactory.getLogger(FileScriptResourceAddressLister.class);
    }
}
