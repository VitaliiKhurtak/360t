package components.chat_provider.service.impl;

import components.chat.model.Chat;
import components.chat_provider.service.ChatRegister;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestChatRegister implements ChatRegister {
    private final Map<Chat, Thread> chatMap;

    public TestChatRegister(Chat chat, Thread chatThread) {
        chatMap = new ConcurrentHashMap<>(Map.of(chat, chatThread));
    }

    @Override
    public boolean isEmpty() {
        return chatMap.isEmpty();
    }

    @Override
    public ChatRegister register(Chat chat, Thread chatThread) {
        Objects.requireNonNull(chat);
        Objects.requireNonNull(chatThread);
        chatMap.put(chat, chatThread);
        return this;
    }

    @Override
    public void unregister(Chat chat) {
        chatMap.remove(chat).interrupt();
    }

    @Override
    public Set<Thread> getChatThreads() {
        return new HashSet<>(chatMap.values());
    }

    @Override
    public Set<Chat> getChats() {
        return chatMap.keySet();
    }
}
