package components.message.service.impl;

import components.chat.model.ChatMessage;
import components.chat.service.impl.TestChatInitializer;
import components.message.service.MessageConsumer;
import components.message.service.MessageProvider;

public class TestMessageConsumer implements MessageConsumer {
    private static Integer messageCount = 0;

    private final MessageProvider messageProvider;

    public TestMessageConsumer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void consume(ChatMessage message) {
        boolean isSenderInitiator = TestChatInitializer.INITIATOR_NAME.equals(message.getSender().getName());
        if (isSenderInitiator) {
            messageProvider.sendMessage(getReply(message));
        }
    }

    private ChatMessage getReply(ChatMessage message) {
        return ChatMessage.builder()
                .chatId(message.getChatId())
                .sender(message.getReceiver())
                .receiver(message.getSender())
                .message(String.format("%s. %s", ++messageCount, message.getMessage()))
                .build();
    }
}
