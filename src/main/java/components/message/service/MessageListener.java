package components.message.service;

import components.chat.model.ChatMessage;

import java.util.UUID;

public interface MessageListener {
    void listen(UUID chatId, MessageConsumer consumer);
    void notify(UUID chatId, ChatMessage message);
}
