package components.chat.service;

import components.chat.model.Chat;

import java.util.UUID;

public interface ChatRunnerService {
    void startChat(UUID chatId);
    ChatRunnerService addChat(Chat chat);

    void deleteChat(UUID chatId);
    void stopChat(UUID chatId);
}
