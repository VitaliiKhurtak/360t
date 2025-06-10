package components.message.service;

import components.chat.model.ChatMessage;

public interface MessageConsumer {
    void consume(ChatMessage message);
}
