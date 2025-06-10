package components.chat_moderator.service.impl;

import components.chat.model.Chat;
import components.chat_moderator.moderators.MaxMemberModeratorService;
import components.chat_moderator.moderators.MaxReceivedMessagesModeratorService;
import components.chat_moderator.moderators.MaxSentMessagesModeratorService;
import components.chat_moderator.service.ChatModerator;

public class TestChatModerator implements ChatModerator {
    private final MaxMemberModeratorService maxMemberModeratorService;
    private final MaxSentMessagesModeratorService maxSentMessagesModeratorService;
    private final MaxReceivedMessagesModeratorService maxReceivedMessagesModeratorService;

    public TestChatModerator(MaxMemberModeratorService maxMemberModeratorService, MaxSentMessagesModeratorService maxSentMessagesModeratorService, MaxReceivedMessagesModeratorService maxReceivedMessagesModeratorService) {
        this.maxMemberModeratorService = maxMemberModeratorService;
        this.maxSentMessagesModeratorService = maxSentMessagesModeratorService;
        this.maxReceivedMessagesModeratorService = maxReceivedMessagesModeratorService;
    }

    @Override
    public boolean moderate(Chat chat) {
        return maxMemberModeratorService.isMemberCountExceeded(chat) ||
                maxSentMessagesModeratorService.isMaxMessagesSent(chat) ||
                maxReceivedMessagesModeratorService.isMaxMessagesReceived(chat);
    }
}
