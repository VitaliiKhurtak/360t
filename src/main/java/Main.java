import components.chat.model.Chat;
import components.chat.service.ChatHistoryService;
import components.chat.service.ChatInitializer;
import components.chat.service.impl.ChatHistoryServiceImpl;
import components.chat.service.impl.TestChatInitializer;
import components.chat_moderator.moderators.MaxMemberModeratorService;
import components.chat_moderator.moderators.MaxReceivedMessagesModeratorService;
import components.chat_moderator.moderators.MaxSentMessagesModeratorService;
import components.chat_moderator.moderators.impl.DefaultModeratorService;
import components.chat_moderator.service.ChatModerator;
import components.chat_moderator.service.ChatRulesService;
import components.chat_moderator.service.impl.ChatRulesServiceImpl;
import components.chat_moderator.service.impl.TestChatModerator;
import components.chat_provider.service.ChatProvider;
import components.chat_provider.service.ChatRegister;
import components.chat_provider.service.impl.AtLeastOneActiveChatProvider;
import components.chat_provider.service.impl.TestChatRegister;
import components.message.service.FakeMessageService;
import components.message.service.MessageConsumer;
import components.message.service.MessageListener;
import components.message.service.MessageProvider;
import components.message.service.impl.DefaultMessageListener;
import components.message.service.impl.FakeMessageServiceImpl;
import components.message.service.impl.TestMessageConsumer;
import components.message.service.impl.TestMessageProvider;
import service.TestChatService;
import service.impl.TestChatServiceImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        initChatProvider().init().startChats();
    }

    private static ChatProvider initChatProvider() throws InterruptedException {
        ChatRulesService chatRulesService = new ChatRulesServiceImpl();
        ChatHistoryService chatHistoryService = new ChatHistoryServiceImpl();
        ChatInitializer chatInitializer = new TestChatInitializer(chatRulesService, chatHistoryService);
        Chat chat = chatInitializer.initializeChat();
        Thread chatThread = initMessageServices(chat, chatHistoryService);
        ChatRegister chatRegister = new TestChatRegister(chat, chatThread);
        ChatModerator chatModerator = initChatModerator(chatRulesService, chatHistoryService);

        return new AtLeastOneActiveChatProvider(chatRegister, chatModerator);
    }

    private static Thread initMessageServices(Chat chat, ChatHistoryService chatHistoryService) {
        MessageListener messageListener = new DefaultMessageListener(chatHistoryService);
        MessageProvider messageProvider = new TestMessageProvider(messageListener);
        MessageConsumer messageConsumer = new TestMessageConsumer(messageProvider);
        messageListener.listen(chat.getId(), messageConsumer);

        FakeMessageService fakeMessageService = new FakeMessageServiceImpl();
        TestChatService testChatService =  new TestChatServiceImpl(chat, messageProvider, fakeMessageService);

        return testChatService.getThread();
    }

    private static ChatModerator initChatModerator(ChatRulesService chatRulesService, ChatHistoryService chatHistoryService) {
        MaxMemberModeratorService maxMemberModeratorService = new DefaultModeratorService(chatRulesService, chatHistoryService);
        MaxSentMessagesModeratorService maxSentMessagesModeratorService = new DefaultModeratorService(chatRulesService, chatHistoryService);
        MaxReceivedMessagesModeratorService maxReceivedMessagesModeratorService = new DefaultModeratorService(chatRulesService, chatHistoryService);

        return new TestChatModerator(maxMemberModeratorService, maxSentMessagesModeratorService, maxReceivedMessagesModeratorService);
    }
}
