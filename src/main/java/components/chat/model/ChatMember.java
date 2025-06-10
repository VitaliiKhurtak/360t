package components.chat.model;

public class ChatMember {
    private String name;

    public ChatMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ChatMember setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
