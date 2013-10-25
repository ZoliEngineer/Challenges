package com.bank.exercise.chatwall;

public class ChatLineFormatter {
    private static final long MILLIS_IN_MINUTE = 60_000;
    private static final long MILLIS_IN_SECOND = 1_000;
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    private static final String SEPARATOR = " - ";

    public static String format(final String userName, final String line, final long timeOfPost, final long currentTime,
            boolean withUser) {
        final long elapsedTimeInMillis = currentTime - timeOfPost;
        final boolean isOverMinute = isOverMinute(elapsedTimeInMillis);

        final long elapsedTimeInProperUnit = isOverMinute ? (elapsedTimeInMillis / MILLIS_IN_MINUTE)
                : (elapsedTimeInMillis / MILLIS_IN_SECOND);

        return buildLineString(userName, line, withUser, isOverMinute, elapsedTimeInProperUnit);
    }

    private static String buildLineString(final String userName, final String line, boolean withUser,
            final boolean isOverMinute, final long elapsedTimeInProperUnit) {
        StringBuilder builder = new StringBuilder();

        if (withUser) {
        builder.append(userName);
            builder.append(SEPARATOR);
        }
        builder.append(line);
        builder.append(" (");
        builder.append(elapsedTimeInProperUnit);
        builder.append(" ");
        builder.append(isOverMinute ? MINUTE : SECOND);
        if (elapsedTimeInProperUnit > 1) {
            builder.append('s');
        }
        builder.append(" ago)");

        return builder.toString();
    }


    private static boolean isOverMinute(long millis) {
        return millis >= MILLIS_IN_MINUTE;
    }


}
