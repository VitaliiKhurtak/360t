package components.chat.service;

import components.chat.model.Chat;

public interface ChatListener {
    void listen(Chat chat);
    boolean isListening();
}
