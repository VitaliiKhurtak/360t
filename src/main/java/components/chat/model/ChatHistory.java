package components.chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChatHistory {
    private final UUID chatId;
    private final ConcurrentLinkedQueue<ChatMessage> messages;
    private final Map<ChatMember, List<ChatMessage>> memberHistory;

    public ChatHistory(UUID chatId) {
        this.chatId = chatId;
        this.memberHistory = new ConcurrentHashMap<>();
        this.messages = new ConcurrentLinkedQueue<>();
    }

    public UUID getChatId() {
        return chatId;
    }

    public ConcurrentLinkedQueue<ChatMessage> getMessages() {
        return messages;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
        memberHistory.computeIfAbsent(message.getReceiver(), k -> new ArrayList<>()).add(message);
    }

    public List<ChatMessage> getMemberHistory(ChatMember member) {
        return memberHistory.computeIfAbsent(member, k -> new ArrayList<>());
    }
}
