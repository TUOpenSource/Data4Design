package com.Data4Design.webapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteRestExample {

    private String type;
    private ValueRestExample value;

    public QuoteRestExample() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ValueRestExample getValue() {
        return value;
    }

    public void setValue(ValueRestExample value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}