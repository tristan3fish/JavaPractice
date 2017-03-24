package com.tristan3fish.revision.protobuf;

import com.google.protobuf.Message;

public interface ProtoSender {
	public void send(Message proto);
}
