package org.example.kicksim.model;

public enum MatchDurations {
    ONE_SECOND(1),
    TWO_SECONDS(2),
    THREE_SECONDS(3);

    private final Integer second;

    MatchDurations(Integer second){
        this.second = second;
    }

    public Integer getSecond(){
        return second;
    }
}
