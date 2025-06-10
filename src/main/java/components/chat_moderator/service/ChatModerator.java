package components.chat_moderator.service;

import components.chat.model.Chat;

public interface ChatModerator {
    boolean moderate(Chat chat);
}
