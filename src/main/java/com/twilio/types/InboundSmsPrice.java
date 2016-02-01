package com.twilio.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

public class InboundSmsPrice {
    public enum Type {
        LOCAL("local"),
        MOBILE("mobile"),
        NATIONAL("national"),
        TOLLFREE("toll free");

        private final String value;

        Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Type forValue(final String value) {
            return value == null ? null : Type.valueOf(value.toUpperCase());
        }
    }

    private final double basePrice;
    private final double currentPrice;
    private final Type type;

    @JsonCreator
    public InboundSmsPrice(@JsonProperty("base_price") final double basePrice,
                           @JsonProperty("current_price") final double currentPrice,
                           @JsonProperty("type") final Type type) {
        this.basePrice = basePrice;
        this.currentPrice = currentPrice;
        this.type = type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InboundSmsPrice other = (InboundSmsPrice) o;
        return Objects.equals(this.basePrice, other.basePrice) &&
               Objects.equals(this.currentPrice, other.currentPrice) &&
               Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.basePrice, this.currentPrice, this.type);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("base_price", basePrice)
                .add("current_price", currentPrice)
                .add("type", type)
                .toString();
    }
}
