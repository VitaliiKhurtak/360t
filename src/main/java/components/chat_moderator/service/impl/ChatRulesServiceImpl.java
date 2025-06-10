package components.chat_moderator.service.impl;

import components.chat.model.ChatRules;
import components.chat_moderator.service.ChatRulesService;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ChatRulesServiceImpl implements ChatRulesService {
    private final Map<UUID, ChatRules> rules;

    public ChatRulesServiceImpl() {
        this.rules = new ConcurrentHashMap<>();
    }

    @Override
    public ChatRules getRules(UUID chatId) {
        return rules.get(chatId);
    }

    @Override
    public void addRules(UUID chatId, ChatRules rules) {
        this.rules.put(chatId, rules);
    }
}
