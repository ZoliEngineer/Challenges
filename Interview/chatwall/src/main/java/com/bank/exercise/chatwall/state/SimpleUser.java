package com.bank.exercise.chatwall.state;

import java.util.HashSet;
import java.util.Set;

public class SimpleUser implements User {

    private final String name;

    private final Set<User> subscriptions = new HashSet<>();

    public SimpleUser(String name) {
        this.name = name;
        subscriptions.add(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void subscribe(User user) {
        subscriptions.add(user);
    }

    @Override
    public Set<User> getSubscriptions() {
        return subscriptions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleUser)) return false;

        SimpleUser that = (SimpleUser) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
