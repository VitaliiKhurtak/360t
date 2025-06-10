package components.chat.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ChatMessage {
    private final UUID chatId;
    private final ChatMember sender;
    private final ChatMember receiver;
    private final String message;
    private final LocalDateTime postedAt;

    private ChatMessage(UUID chatId, ChatMember sender, ChatMember receiver, String message) {
        this.chatId = chatId;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.postedAt = LocalDateTime.now();
    }

    public UUID getChatId() {
        return chatId;
    }

    public ChatMember getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public ChatMember getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "chatId=" + chatId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", message='" + message + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }

    public static ChatMessageBuilder builder() {
        return new ChatMessageBuilder();
    }

    public static class ChatMessageBuilder {
        private UUID chatId;
        private ChatMember sender;
        private ChatMember receiver;
        private String message;
        private LocalDateTime postedAt;

        public ChatMessageBuilder chatId(UUID chatId) {
            this.chatId = chatId;
            return this;
        }

        public ChatMessageBuilder sender(ChatMember sender) {
            this.sender = sender;
            return this;
        }

        public ChatMessageBuilder receiver(ChatMember receiver) {
            this.receiver = receiver;
            return this;
        }

        public ChatMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(chatId, sender, receiver, message);
        }
    }
}
