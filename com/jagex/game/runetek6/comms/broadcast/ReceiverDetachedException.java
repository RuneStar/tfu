package com.jagex.game.runetek6.comms.broadcast;

final class ReceiverDetachedException extends Exception {
   public synchronized Throwable fillInStackTrace() {
      return this;
   }
}
