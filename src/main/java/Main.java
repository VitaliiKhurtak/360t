import model.Chat;
import service.ChatInitializer;
import service.impl.ChatRunnerServiceImpl;
import service.impl.TestChatInitializer;

public class Main {
    public static void main(String[] args) {
        ChatInitializer chatInitializer = new TestChatInitializer();
        Chat chat = chatInitializer.initializeChat();

        new ChatRunnerServiceImpl().addChat(chat).startChat(chat.getId());
    }
}
