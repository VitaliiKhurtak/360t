package components.message.service.impl;

import components.message.service.FakeMessageService;

public class FakeMessageServiceImpl implements FakeMessageService {
    @Override
    public String getFakeMessage() {
        return String.format("%s %s %s %s.", getRandomString(NOUNS), getRandomString(VERBS), getRandomString(SUBJECT), getRandomString(TIME));
    }

    private String getRandomString(String[] strings) {
        return strings[getRandomNumber(0, strings.length)];
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
