package org.example;

import java.util.*;

public class RoundRobin extends Scheduler {
    @Override
    public void process() {
        this.getPcbs().sort(Comparator.comparing(Process::getArrivalTime));


        List<Process> processes = HelperMethods.deepCopy(this.getPcbs());
        int time = processes.getFirst().getArrivalTime();
        int timeQuantum = this.getTimeQuantum();

        while(!processes.isEmpty()) {
            Process process = processes.getFirst();
            int bt = (Math.min(process.getBurstTime(), timeQuantum));
            this.getTimeline().add(new Event(process.getProcessName(), time, bt + time));
            time += bt;
            processes.removeFirst();

            //update burst time and place back in procces queue in the corrrect place
            if (process.getBurstTime() > timeQuantum){
                process.setBurstTime(process.getBurstTime() - timeQuantum);
                for (int i = 0; i < processes.size(); i++){
                    if (processes.get(i).getArrivalTime() > time){
                        processes.add(i, process);
                        break;
                    }else if (i == processes.size() - 1){
                        processes.add(process);
                        break;
                    }
                }
            }
        }

        Map map = new HashMap();

        for (Process process : this.getPcbs()){
            map.clear();

            for (Event event : this.getTimeline()){
                if (event.getProcessName().equals(process.getProcessName())){
                    if(map.containsKey(event.getProcessName())){
                        int waiting = event.getStartingTime() - (int) map.get(event.getProcessName());
                        process.setWaitingTime(waiting + process.getWaitingTime());
                    }else {
                        process.setWaitingTime(event.getStartingTime() - process.getArrivalTime());
                    }

                    map.put(event.getProcessName(), event.getFinishTime());
                }
            }
            process.setTurnAroundTime(process.getWaitingTime()+process.getBurstTime());
        }
    }
}
