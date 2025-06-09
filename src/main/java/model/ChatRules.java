package model;

public class ChatRules {
    private final int maxMembers;
    private final int maxSentMessages;
    private final int maxReceivedMessages;

    private ChatRules(int maxMembers, int maxSentMessages, int maxReceivedMessages) {
        this.maxMembers = maxMembers;
        this.maxSentMessages = maxSentMessages;
        this.maxReceivedMessages = maxReceivedMessages;
    }

    public static ChatRulesBuilder builder() {
        return new ChatRulesBuilder();
    }

    public static class ChatRulesBuilder {
        private int maxMembers;
        private int maxSentMessages;
        private int maxReceivedMessages;

        public ChatRulesBuilder maxMembers(int maxMembers) {
            this.maxMembers = maxMembers;
            return this;
        }

        public ChatRulesBuilder maxSentMessages(int maxSentMessages) {
            this.maxSentMessages = maxSentMessages;
            return this;
        }

        public ChatRulesBuilder maxReceivedMessages(int maxReceivedMessages) {
            this.maxReceivedMessages = maxReceivedMessages;
            return this;
        }

        public ChatRules build() {
            return new ChatRules(maxMembers, maxSentMessages, maxReceivedMessages);
        }
    }
}
