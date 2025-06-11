package org.example;


// simulate Process execution by prociding the  CPU burst to simulate how a real pbc would behave
//of course in real life the scheduler doesn't know the burst in advance but it estimates them depending on the algorithm used

public class Process {
    public String processName;
    public int arrivalTime;
    public int burstTime;
    public int turnAroundTime;
    public int waitingTime;
    public int priorityLevel;


    public Process(String processName, int arrivalTime, int burstTime, int priorityLevel, int turnAroundTime, int waitingTime) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priorityLevel = priorityLevel;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
    }

    public Process(String processName, int arrivalTime, int burstTime, int priorityLevel) {
        this(processName, arrivalTime, burstTime, priorityLevel, 0, 0);
    }

    public Process(String processName, int arrivalTime, int burstTime) {
        this(processName, arrivalTime, burstTime, 0, 0, 0);
    }


    public String getProcessName() {
        return processName;
    }


    public Integer getArrivalTime() {
        return arrivalTime;
    }


    public Integer getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(Integer burstTime) {
        this.burstTime = burstTime;
    }


    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public Integer getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(Integer turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    @Override
    public String toString(){
        return processName;
    }
}
