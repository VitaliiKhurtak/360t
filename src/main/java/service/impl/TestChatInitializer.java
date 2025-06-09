package service.impl;

import model.Chat;
import model.ChatMember;
import model.ChatRules;
import service.ChatInitializer;

public class TestChatInitializer implements ChatInitializer {
    @Override
    public Chat initializeChat() {
        return new Chat(getChatRules())
                .addMember(new ChatMember("Initiator"))
                .addMember(new ChatMember("Receiver"));
    }

    private ChatRules getChatRules() {
        return ChatRules.builder()
                .maxMembers(2)
                .maxSentMessages(10)
                .maxReceivedMessages(10)
                .build();
    }


}
