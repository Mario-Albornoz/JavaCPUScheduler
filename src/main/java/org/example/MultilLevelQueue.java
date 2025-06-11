package org.example;

import java.util.*;

public class MultilLevelQueue extends Scheduler{
    @Override
    public void process(){
        this.getPcbs().sort(Comparator.comparing(Process::getArrivalTime));


        //create the different queues
        Map<Integer, List<Process>> priorityMap = new HashMap<>();
        //sort processes into the different queues
        for (Process process: this.getPcbs()){
            int priority = process.getPriorityLevel();
            priorityMap.computeIfAbsent(priority, k -> new ArrayList<>()).add(process);
        }
        //assign scheduling algorithm to each queue
        for (Map.Entry<Integer, List<Process>> entry : priorityMap.entrySet()){
            int priority = entry.getKey();
            List<Process> queue = entry.getValue();

            Scheduler scheduler;
            if (priority == 1){

                scheduler = new PriorityNonPreemptive();
            }
            else if (priority == 2){
                scheduler = new PriorityNonPreemptive();
            }
            else if (priority == 3){
                scheduler = new RoundRobin();
                scheduler.setTimeQuantum(2);
            }
            else{
                //commonly used for batch processes
                scheduler = new FirstComeFirstServed();
            }
            scheduler.setPcbs(queue);
            scheduler.process();
            this.getTimeline().addAll(scheduler.getTimeline());
        }

    }
}
