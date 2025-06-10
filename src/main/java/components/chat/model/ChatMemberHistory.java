package components.chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ChatMemberHistory {
    private final ChatMember member;
    private final Map<UUID, List<ChatMessage>> history;

    public ChatMemberHistory(ChatMember member) {
        this.member = member;
        this.history = new ConcurrentHashMap<>();
    }

    public ChatMember getMember() {
        return member;
    }

    public Map<UUID, List<ChatMessage>> getHistory() {
        return history;
    }

    public void addMessage(UUID chatId, ChatMessage message) {
        history.computeIfAbsent(chatId, k -> new ArrayList<>()).add(message);
    }
}
