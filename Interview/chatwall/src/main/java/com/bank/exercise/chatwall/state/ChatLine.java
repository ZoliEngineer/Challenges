package com.bank.exercise.chatwall.state;

public class ChatLine implements Comparable<ChatLine> {


    private final User user;
    private final String line;
    private final long timeOfPost;

    public ChatLine(User user, String line, long timeOfPost) {
        this.user = user;
        this.line = line;
        this.timeOfPost = timeOfPost;
    }

    public String getLine() {
        return line;
    }

    public long getTimeOfPost() {
        return timeOfPost;
    }

    @Override
    public int compareTo(ChatLine counter) {
        return Long.compare(this.timeOfPost, counter.getTimeOfPost());
    }

    @Override
    public String toString() {
        return ChatLineFormatter.format(user.getName(), line, timeOfPost, System.currentTimeMillis(), true);
    }


}
