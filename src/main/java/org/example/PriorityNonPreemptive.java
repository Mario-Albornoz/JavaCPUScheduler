package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityNonPreemptive extends Scheduler{
    @Override
    public void process(){
        this.getPcbs().sort(Comparator.comparing(Process::getArrivalTime));
        List<Process> processes = HelperMethods.deepCopy(this.getPcbs());
        int time = processes.getFirst().getArrivalTime();

        while (!processes.isEmpty()){
            List<Process> availableProcesses = new ArrayList<>();

            for (Process process: processes){
                if (process.getArrivalTime() <= time){
                    availableProcesses.add(process);
                }
            }
            availableProcesses.sort(Comparator.comparing(Process::getPriorityLevel));
            Process process = availableProcesses.getFirst();
            this.getTimeline().add(new Event(process.getProcessName(), time, process.getBurstTime()+time));
            time += process.getBurstTime();

            for(int i = 0; i < processes.size(); i++){
                if (processes.get(i).getProcessName().equals(process.getProcessName())){
                    processes.remove(i);
                    break;
                }
            }
        }

        for (Process process : this.getPcbs()){
            process.setWaitingTime(this.getEvent(process).getStartingTime() - process.getArrivalTime());
            process.setTurnAroundTime(process.getWaitingTime() + process.getBurstTime());
        }
    }
}
