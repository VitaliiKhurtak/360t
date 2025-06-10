package components.chat.service.impl;

import components.chat.model.Chat;
import components.chat.model.ChatHistory;
import components.chat.model.ChatMember;
import components.chat.model.ChatRules;
import components.chat.service.ChatHistoryService;
import components.chat.service.ChatInitializer;
import components.chat_moderator.service.ChatRulesService;

public class TestChatInitializer implements ChatInitializer {
    private final static Integer MAX_MEMBERS = 2;
    private final static Integer MAX_SENT_MESSAGES = MAX_MEMBERS * 10;
    private final static Integer MAX_RECEIVED_MESSAGES = MAX_MEMBERS * 10;
    public final static String INITIATOR_NAME = "Initiator";
    public final static String RECEIVER_NAME = "Receiver";

    private final ChatRulesService chatRulesService;
    private final ChatHistoryService chatHistoryService;

    public TestChatInitializer(ChatRulesService chatRulesService, ChatHistoryService chatHistoryService) {
        this.chatRulesService = chatRulesService;
        this.chatHistoryService = chatHistoryService;
    }

    @Override
    public Chat initializeChat() {
        Chat chat = new Chat()
                .addMember(new ChatMember(INITIATOR_NAME))
                .addMember(new ChatMember(RECEIVER_NAME));

        chatRulesService.addRules(chat.getId(), getChatRules());
        chatHistoryService.addHistory(chat.getId(), new ChatHistory(chat.getId()));
        return chat;
    }

    private ChatRules getChatRules() {
        return ChatRules.builder()
                .maxMembers(MAX_MEMBERS)
                .maxSentMessages(MAX_SENT_MESSAGES)
                .maxReceivedMessages(MAX_RECEIVED_MESSAGES)
                .build();
    }
}
