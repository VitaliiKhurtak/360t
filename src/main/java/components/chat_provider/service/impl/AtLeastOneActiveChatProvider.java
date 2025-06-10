package components.chat_provider.service.impl;

import components.chat.model.Chat;
import components.chat_moderator.service.ChatModerator;
import components.chat_provider.service.ChatProvider;
import components.chat_provider.service.ChatRegister;

public class AtLeastOneActiveChatProvider implements ChatProvider, Runnable {
    private final ChatRegister chatRegister;
    private final ChatModerator chatModerator;

    public AtLeastOneActiveChatProvider(ChatRegister chatRegister, ChatModerator chatModerator) {
        this.chatRegister = chatRegister;
        this.chatModerator = chatModerator;
    }

    @Override
    public ChatProvider init() throws InterruptedException {
        new Thread(this).start();
        return this;
    }

    @Override
    public void startChats() {
        chatRegister.getChatThreads().forEach(Thread::start);
    }

    private void processChat(Chat chat) {
        boolean moderated = chatModerator.moderate(chat);
        System.out.printf("Chat %s is %s%n", chat.getId(), moderated ? "moderated" : "still running");
        if (moderated) {
            chatRegister.unregister(chat);
        }
    }

    @Override
    public void run() {
        while (!chatRegister.isEmpty()) {
            try {
                chatRegister.getChats().forEach(this::processChat);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
