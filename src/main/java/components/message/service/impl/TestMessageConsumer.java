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

    /**
     * checks if message is sent by initiator and sends reply
     */
    @Override
    public void consume(ChatMessage message) {
        boolean isSenderInitiator = TestChatInitializer.INITIATOR_NAME.equals(message.getSender().getName());
        if (isSenderInitiator) {
            messageProvider.sendMessage(getReply(message));
        }
    }

    /**
     * reply received message with incremented message count
     * @param message
     * @return same message but reversed receiver and sender and incremented message count
     */
    private ChatMessage getReply(ChatMessage message) {
        return ChatMessage.builder()
                .chatId(message.getChatId())
                .sender(message.getReceiver())
                .receiver(message.getSender())
                .message(String.format("%s. %s", ++messageCount, message.getMessage()))
                .build();
    }
}
