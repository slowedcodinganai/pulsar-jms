/*
 * Copyright DataStax, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker.region;

import org.apache.activemq.command.ConsumerId;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.MessageId;

/**
 * Keeps track of a message that is flowing through the Broker. This object may hold a hard
 * reference to the message or only hold the id of the message if the message has been persisted on
 * in a MessageStore.
 */
public interface MessageReference {

  MessageId getMessageId();

  Message getMessageHardRef();

  Message getMessage();

  boolean isPersistent();

  Message.MessageDestination getRegionDestination();

  int getRedeliveryCounter();

  void incrementRedeliveryCounter();

  int getReferenceCount();

  int incrementReferenceCount();

  int decrementReferenceCount();

  ConsumerId getTargetConsumerId();

  int getSize();

  long getExpiration();

  String getGroupID();

  int getGroupSequence();

  /** Returns true if this message is expired */
  boolean isExpired();

  /** Returns true if this message is dropped. */
  boolean isDropped();

  /** @return true if the message is an advisory */
  boolean isAdvisory();

  boolean canProcessAsExpired();
}
