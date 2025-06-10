package components.chat_moderator.service;

import components.chat.model.Chat;

/**
 * service that moderates chat by checking chat rules with help of moderator services
 */
public interface ChatModerator {
    boolean moderate(Chat chat);
}
