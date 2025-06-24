package com.SentinelStream.service;

import org.springframework.stereotype.Service;

@Service
public class RuleService {

    public String evaluateRules(String input) {
        return "Evaluated result for: " + input;
    }
}
