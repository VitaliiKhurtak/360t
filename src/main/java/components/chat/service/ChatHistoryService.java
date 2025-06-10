package components.chat.service;

import components.chat.model.ChatHistory;
import components.chat.model.ChatMessage;

import java.util.UUID;

/**
 * CRUD for chat messages
 */
public interface ChatHistoryService {
    ChatHistory getHistory(UUID chatId);

    void addHistory(UUID chatId, ChatHistory history);

    void updateHistoryByMessage(ChatMessage message);
}
