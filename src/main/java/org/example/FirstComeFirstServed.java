package org.example;

import java.util.Comparator;
import java.util.List;

public class FirstComeFirstServed extends Scheduler{
    @Override
    public void process(){
        //sort the pcbs by arrival time
        this.getPcbs().sort(Comparator.comparing(Process::getArrivalTime));

        List<Event> timeline = this.getTimeline();

        for (Process pcb: this.getPcbs()){
            if (timeline.isEmpty()) {
                timeline.add(new Event(pcb.getProcessName(), pcb.getArrivalTime(), pcb.getArrivalTime() + pcb.getBurstTime()));
            }
            else{
                Event event = timeline.getLast();
                timeline.add(new Event(pcb.getProcessName(), event.getFinishTime(), pcb.getBurstTime() +event.getFinishTime()));
            }
        }

        for (Process pcb : this.getPcbs()){
            pcb.setWaitingTime(this.getEvent(pcb).getStartingTime() - pcb.getArrivalTime());
            pcb.setTurnAroundTime(this.getEvent(pcb).getFinishTime() - pcb.getArrivalTime());
        }
    }
}
