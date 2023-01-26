package com.mongodb.lambda;

import java.util.concurrent.TimeUnit;

import com.mongodb.event.ServerHeartbeatFailedEvent;
import com.mongodb.event.ServerHeartbeatSucceededEvent;
import com.mongodb.event.ServerMonitorListener;

class ServerHeartbeatLogger implements ServerMonitorListener {

  @Override
  public synchronized void serverHeartbeatSucceeded(final ServerHeartbeatSucceededEvent event) {
    System.out.println(
      String.format(
        "HEARTBEAT SUCCEEDED: %s %s",
        event.getReply().toString(),
        event.getElapsedTime(TimeUnit.MILLISECONDS)
      )
    );
  }

  @Override
  public void serverHeartbeatFailed(final ServerHeartbeatFailedEvent event) {
    System.out.println(
      String.format(
        "HEARTBEAT FAILED: %s",
        event.getElapsedTime(TimeUnit.MILLISECONDS)
      )
    );
  }
}
