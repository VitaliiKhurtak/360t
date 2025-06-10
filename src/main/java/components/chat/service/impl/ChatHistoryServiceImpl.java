package components.chat.service.impl;

import components.chat.model.ChatHistory;
import components.chat.model.ChatMessage;
import components.chat.service.ChatHistoryService;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ChatHistoryServiceImpl implements ChatHistoryService {
    private final Map<UUID, ChatHistory> historyMap;

    public ChatHistoryServiceImpl() {
        this.historyMap = new ConcurrentHashMap<>();
    }

    @Override
    public ChatHistory getHistory(UUID chatId) {
        return historyMap.computeIfAbsent(chatId, chatId1 -> new ChatHistory(chatId));
    }

    @Override
    public void addHistory(UUID chatId, ChatHistory history) {
        historyMap.put(chatId, history);
    }

    @Override
    public void updateHistoryByMessage(ChatMessage message) {
        getHistory(message.getChatId()).addMessage(message);
    }
}
