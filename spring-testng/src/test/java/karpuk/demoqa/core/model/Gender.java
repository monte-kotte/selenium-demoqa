package karpuk.demoqa.core.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private int position;

    public int getPosition() {
        return position;
    }

}
