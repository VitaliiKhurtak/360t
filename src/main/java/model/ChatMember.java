package model;

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
}
