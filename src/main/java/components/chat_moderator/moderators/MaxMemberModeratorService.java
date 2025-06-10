package components.chat_moderator.moderators;

import components.chat.model.Chat;

public interface MaxMemberModeratorService {
    boolean isMemberCountExceeded(Chat chat);
}
