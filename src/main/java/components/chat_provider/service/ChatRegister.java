package components.chat_provider.service;

import components.chat.model.Chat;

import java.util.Set;
import java.util.UUID;

/**
 * CRUD service for chats in terms of ChatProvider
 */
public interface ChatRegister {
    boolean isEmpty();

    ChatRegister register(Chat chat, Thread chatThread);

    void unregister(Chat chat);

    Set<Thread> getChatThreads();

    Set<Chat> getChats();
}
