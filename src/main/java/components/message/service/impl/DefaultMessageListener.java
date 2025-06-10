package components.message.service.impl;

import components.chat.model.ChatMessage;
import components.chat.service.ChatHistoryService;
import components.message.service.MessageConsumer;
import components.message.service.MessageListener;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultMessageListener implements MessageListener {
    private final Map<UUID, MessageConsumer> consumers;
    private final ChatHistoryService chatHistoryService;

    public DefaultMessageListener(ChatHistoryService chatHistoryService) {
        this.chatHistoryService = chatHistoryService;
        this.consumers = new ConcurrentHashMap<>();
    }

    @Override
    public void listen(UUID chatId, MessageConsumer consumer) {
        consumers.put(chatId, consumer);
    }

    @Override
    public void notify(UUID chatId, ChatMessage message) {
        chatHistoryService.updateHistoryByMessage(message);
        consumers.get(chatId).consume(message);
        System.out.println("Message sent: " + message);
    }
}
