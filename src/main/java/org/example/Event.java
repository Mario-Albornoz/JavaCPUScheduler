package org.example;

public class Event {
    public final String processName;
    public final int startingTime;
    public int finishTime;

    public Event(String processName, int startingTime, int finishTime){
        this.processName = processName;
        this.startingTime = startingTime;
        this.finishTime = finishTime;
    }

    public String getProcessName() {
        return processName;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getStartingTime() {
        return startingTime;
    }
}
