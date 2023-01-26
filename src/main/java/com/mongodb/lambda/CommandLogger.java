package com.mongodb.lambda;

import java.util.concurrent.TimeUnit;

import com.mongodb.event.CommandFailedEvent;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandSucceededEvent;

class CommandLogger implements CommandListener {

  @Override
  public synchronized void commandSucceeded(final CommandSucceededEvent event) {
    System.out.println(
      String.format(
        "COMMAND SUCCEEDED: %s %s ms",
        event.getCommandName(),
        event.getElapsedTime(TimeUnit.MILLISECONDS)
      )
    );
  }

  @Override
  public void commandFailed(final CommandFailedEvent event) {
    System.out.println(
      String.format(
        "COMMAND FAILED: %s %s ms",
        event.getCommandName(),
        event.getElapsedTime(TimeUnit.MILLISECONDS)
      )
    );
  }
}
