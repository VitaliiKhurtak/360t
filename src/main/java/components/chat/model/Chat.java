package components.chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chat {
    private final UUID id;
    private final List<ChatMember> members;

    public Chat() {
        this.id = UUID.randomUUID();
        this.members = new ArrayList<>();
    }

    public List<ChatMember> getMembers() {
        return members;
    }

    public Chat addMember(ChatMember member) {
        this.members.add(member);
        return this;
    }

    public UUID getId() {
        return id;
    }
}
