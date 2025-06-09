package service;

import model.Chat;

public interface ChatListener {
    void listen(Chat chat);
    boolean isListening();
}
