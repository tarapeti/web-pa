package com.codecool.web.model;

import java.util.Objects;

public class Signature {

    private final int proId;
    private final int deckId;
    private final int gripId;
    private final int truckId;
    private final int wheelId;

    public Signature(int proId, int deckId, int gripId, int truckId, int wheelId) {
        this.proId = proId;
        this.deckId = deckId;
        this.gripId = gripId;
        this.truckId = truckId;
        this.wheelId = wheelId;
    }

    public int getProId() {
        return proId;
    }

    public int getDeckId() {
        return deckId;
    }

    public int getGripId() {
        return gripId;
    }

    public int getTruckId() {
        return truckId;
    }

    public int getWheelId() {
        return wheelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Signature signature = (Signature) o;
        return getProId() == signature.getProId() &&
                getDeckId() == signature.getDeckId() &&
                getGripId() == signature.getGripId() &&
                getTruckId() == signature.getTruckId() &&
                getWheelId() == signature.getWheelId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProId(), getDeckId(), getGripId(), getTruckId(), getWheelId());
    }
}
