package service.impl;

import components.chat.model.Chat;
import components.chat.model.ChatMessage;
import components.message.service.FakeMessageService;
import components.message.service.MessageProvider;
import service.TestChatService;

public class TestChatServiceImpl implements TestChatService, Runnable {
    private final MessageProvider messageProvider;
    private final FakeMessageService fakeMessageService;

    private final Chat chat;
    private boolean isRunning = true;

    public TestChatServiceImpl(Chat chat, MessageProvider messageProvider, FakeMessageService fakeMessageService) {
        this.chat = chat;
        this.messageProvider = messageProvider;
        this.fakeMessageService = fakeMessageService;
    }

    /**
     * send fake message from initiator every second, can be interrupted if unregistered from provider, then while loop ends
     */
    @Override
    public void run() {
        while (isRunning) {
            try {
                messageProvider.sendMessage(getMessage());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                isRunning = false;
            }
        }
    }

    @Override
    public Thread getThread() {
        return new Thread(this);
    }

    private ChatMessage getMessage() {
        return ChatMessage.builder()
                .chatId(chat.getId())
                .sender(chat.getMembers().get(0))
                .receiver(chat.getMembers().get(1))
                .message(fakeMessageService.getFakeMessage())
                .build();
    }
}
