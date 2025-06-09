package org.example.CC;

public enum Bounder {

    engLowBound1 (97),
    engLowBound2 (122),
    engUpperBound1(65),
    engUpperBound2 (90),
    rusLowBound1 (1072),
    rusLowBound2 (1103),
    rusUpperBound1 (1040),
    rusUpperBound2 (1071);

    private final int value;

    Bounder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
