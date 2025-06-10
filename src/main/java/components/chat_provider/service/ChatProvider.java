package components.chat_provider.service;

public interface ChatProvider {
    ChatProvider init() throws InterruptedException;

    void startChats();
}
