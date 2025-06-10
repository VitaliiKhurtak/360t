package components.message.service;

import components.chat.model.ChatMessage;

import java.util.UUID;

/**
 * add listener to receive messages and notify about new messages
 */
public interface MessageListener {
    void listen(UUID chatId, MessageConsumer consumer);
    void notify(UUID chatId, ChatMessage message);
}
