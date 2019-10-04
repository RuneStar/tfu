/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

final class ReceiverDetachedException
extends Exception {
    ReceiverDetachedException() {
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

