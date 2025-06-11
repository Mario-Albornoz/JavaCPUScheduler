package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler {
    public int timeQuantum;
    public List<Process> pcbs;
    public final List<Event> timeline;


    public Scheduler () {
        pcbs = new ArrayList<>();
        timeline = new ArrayList<>();
        this.timeQuantum = 1;
    }

    public void add(Process pcb){
        pcbs.add(pcb);
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

     public int getTimeQuantum(){
        return timeQuantum;
     }

    public List<Process> getPcbs() {
        return pcbs;
    }

    public void setPcbs(List<Process> pbcs){
        this.pcbs = pbcs;
    }

    public List<Event> getTimeline() {
        return timeline;
    }

    public Event getEvent(Process pcb){
        for (Event event: timeline){
            if (pcb.getProcessName().equals(event.getProcessName())){
                return event;
            }
        }
        return null;
    }

    public double getAverageWaitingTime()
    {
        double avg = 0.0;

        for (Process process : pcbs)
        {
            avg += process.getWaitingTime();
        }

        return avg / pcbs.size();
    }

    public double getAverageTurnAroundTime()
    {
        double avg = 0.0;

        for (Process process : pcbs)
        {
            avg += process.getTurnAroundTime();
        }

        return avg / pcbs.size();
    }

    public abstract void process();
}
