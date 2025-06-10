package components.chat_moderator.moderators;

import components.chat.model.Chat;

public interface MaxReceivedMessagesModeratorService {
    boolean isMaxMessagesReceived(Chat chat);
}
