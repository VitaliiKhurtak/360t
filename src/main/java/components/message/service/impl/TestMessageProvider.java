package components.message.service.impl;

import components.chat.model.ChatMessage;
import components.message.service.MessageListener;
import components.message.service.MessageProvider;

public class TestMessageProvider implements MessageProvider {
    private final MessageListener listener;

    public TestMessageProvider(MessageListener listener) {
        this.listener = listener;
    }

    @Override
    public void sendMessage(ChatMessage message) {
        listener.notify(message.getChatId(), message);
    }
}
