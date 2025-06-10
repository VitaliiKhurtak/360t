package components.message.service;

/**
 * generates fake messages based on arrays with words
 */
public interface FakeMessageService {
    String[] NOUNS = new String[]{"I", "She", "He", "It", "We", "They"};
    String[] VERBS = new String[]{"received", "sent", "will do"};
    String[] SUBJECT = new String[]{"an apple", "a letter", "a lot of sweets", "a glory", "a book"};
    String[] TIME = new String[]{"recently", "now", "at 5 o'clock"};

    String getFakeMessage();
}
