package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class ShortestJobFirst extends Scheduler{

    @Override
    public void process(){
        //sort pcbs by arrival time
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
            //sort available processes by burst time
            availableProcesses.sort(Comparator.comparing((Process::getBurstTime)));
            Process currentProcess = availableProcesses.getFirst();
            this.getTimeline().add(new Event(currentProcess.getProcessName(), time, time + currentProcess.getBurstTime()));
            time += currentProcess.getBurstTime();

            //delete the process queue
            for (int i = 0;  i < processes.size(); i++){
                if(processes.get(i).getProcessName().equals(currentProcess.getProcessName())){
                    processes.remove(i);
                    break;
                }
            }
        }

        for (Process pcb: this.getPcbs()){
            pcb.setWaitingTime(this.getEvent(pcb).getStartingTime() - pcb.getArrivalTime());
            pcb.setTurnAroundTime(pcb.getWaitingTime() + pcb.getBurstTime());
        }
    }
}
