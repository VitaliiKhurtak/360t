package components.chat.model;

public class ChatRules {
    private final Integer maxMembers;
    private final Integer maxSentMessages;
    private final Integer maxReceivedMessages;

    private ChatRules(Integer maxMembers, Integer maxSentMessages, Integer maxReceivedMessages) {
        this.maxMembers = maxMembers;
        this.maxSentMessages = maxSentMessages;
        this.maxReceivedMessages = maxReceivedMessages;
    }

    public static ChatRulesBuilder builder() {
        return new ChatRulesBuilder();
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }

    public Integer getMaxSentMessages() {
        return maxSentMessages;
    }

    public Integer getMaxReceivedMessages() {
        return maxReceivedMessages;
    }

    public static class ChatRulesBuilder {
        private Integer maxMembers;
        private Integer maxSentMessages;
        private Integer maxReceivedMessages;

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
