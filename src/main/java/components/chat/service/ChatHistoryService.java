package components.chat.service;

import components.chat.model.ChatHistory;
import components.chat.model.ChatMessage;

import java.util.UUID;

public interface ChatHistoryService {
    ChatHistory getHistory(UUID chatId);

    void addHistory(UUID chatId, ChatHistory history);

    void updateHistoryByMessage(ChatMessage message);
}
