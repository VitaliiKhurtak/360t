package components.chat_provider.service;

/**
 * Provider functionality as while loop that runs all chats and moderate them by rules.
 * If rules are exceeded, chat is closed.
 */
public interface ChatProvider {
    /**
     * start a new Thread to go through all chats every minute
     * @return ChatProvider to call startChats
     * @throws InterruptedException
     */
    ChatProvider init() throws InterruptedException;

    /**
     * start all chat threads
     */
    void startChats();
}
