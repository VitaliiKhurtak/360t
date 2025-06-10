package components.chat_moderator.service;

import components.chat.model.ChatRules;

import java.util.UUID;

/**
 * CRUD service for chat rules
 */
public interface ChatRulesService {
    ChatRules getRules(UUID chatId);

    void addRules(UUID chatId, ChatRules rules);
}
