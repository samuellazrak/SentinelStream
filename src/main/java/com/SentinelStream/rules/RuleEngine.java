package com.SentinelStream.rules;

public class RuleEngine {

    public boolean applyRules(String input) {
        return input != null && !input.isBlank();
    }
}
