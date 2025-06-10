package components.chat_moderator.moderators;

import components.chat.model.Chat;

public interface MaxSentMessagesModeratorService {
    boolean isMaxMessagesSent(Chat chat);
}
