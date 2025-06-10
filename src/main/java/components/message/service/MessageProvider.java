package components.message.service;

import components.chat.model.ChatMessage;

public interface MessageProvider {
    void sendMessage(ChatMessage message);
}
