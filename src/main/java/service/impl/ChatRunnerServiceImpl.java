package service.impl;

import model.Chat;
import service.ChatRunnerService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class ChatRunnerServiceImpl implements ChatRunnerService {
    private final Map<UUID, Chat> chatMap;

    public ChatRunnerServiceImpl() {
        this.chatMap = new HashMap<>();
    }

    @Override
    public void startChat(UUID chatId) {
        
    }

    @Override
    public ChatRunnerService addChat(Chat chat) {
        Objects.requireNonNull(chat, "Chat cannot be null");
        chatMap.put(chat.getId(), chat);
        return this;
    }

    @Override
    public void deleteChat(UUID chatId) {
        Objects.requireNonNull(chatId, "ChatId cannot be null");
        chatMap.remove(chatId);
    }

    @Override
    public void stopChat(UUID chatId) {
        Objects.requireNonNull(chatId, "ChatId cannot be null");
    }
}
