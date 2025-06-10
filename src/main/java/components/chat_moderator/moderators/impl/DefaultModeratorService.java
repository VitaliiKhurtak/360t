package components.chat_moderator.moderators.impl;

import components.chat.model.Chat;
import components.chat.model.ChatRules;
import components.chat.service.ChatHistoryService;
import components.chat_moderator.moderators.MaxMemberModeratorService;
import components.chat_moderator.moderators.MaxReceivedMessagesModeratorService;
import components.chat_moderator.moderators.MaxSentMessagesModeratorService;
import components.chat_moderator.service.ChatRulesService;

import java.util.Objects;

/**
 * default moderator that implements all rules for the test scenario. Also possible to create a separate class for each rule with more complex logic if needed
 */
public class DefaultModeratorService implements MaxMemberModeratorService, MaxReceivedMessagesModeratorService, MaxSentMessagesModeratorService {
    private final ChatRulesService chatRulesService;
    private final ChatHistoryService chatHistoryService;

    public DefaultModeratorService(ChatRulesService chatRulesService, ChatHistoryService chatHistoryService) {
        this.chatRulesService = chatRulesService;
        this.chatHistoryService = chatHistoryService;
    }

    @Override
    public boolean isMemberCountExceeded(Chat chat) {
        ChatRules rules = getRules(chat);
        return chat.getMembers().size() > rules.getMaxMembers();
    }

    @Override
    public boolean isMaxMessagesReceived(Chat chat) {
        ChatRules rules = getRules(chat);
        return chatHistoryService.getHistory(chat.getId()).getMessages().size() > rules.getMaxReceivedMessages();
    }

    @Override
    public boolean isMaxMessagesSent(Chat chat) {
        ChatRules rules = getRules(chat);
        return chatHistoryService.getHistory(chat.getId()).getMessages().size() > rules.getMaxReceivedMessages();
    }

    private ChatRules getRules(Chat chat) {
        Objects.requireNonNull(chat);
        ChatRules rules = chatRulesService.getRules(chat.getId());
        Objects.requireNonNull(rules);
        return rules;
    }
}
