/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Hp62;

public abstract class ScriptChunk
implements Hp62 {
    protected static final Logger logger = LoggerFactory.getLogger(ScriptChunk.class);
    public final String name;

    public ScriptChunk(String string) {
        this.name = string;
    }
}

