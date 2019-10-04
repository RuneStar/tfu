// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.script;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import tfu.Hp62;

public abstract class ScriptChunk implements Hp62
{
    protected static final Logger logger;
    public final String name;
    
    static {
        logger = LoggerFactory.getLogger(ScriptChunk.class);
    }
    
    public ScriptChunk(final String name) {
        this.name = name;
    }
}
