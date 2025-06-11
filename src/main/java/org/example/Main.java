package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------First Come First Served----------------");
        FirstComeFirstServed();
        System.out.println("-----------------Shortest Job First (non-preemptive) ----------------");
        ShortestJobFirst();
        System.out.println("-----------------Round Robin (preemptive) ----------------");
        RoundRobin();
        System.out.println("-----------------Priority-Non-preemptive----------------");
        PriorityNonPreemptive();
        System.out.println("-----------------Multi level queue---------------");
        MultiLevelQueue();

    }

    public static void FirstComeFirstServed (){
        Scheduler firstComeFirstServed = new FirstComeFirstServed();
        firstComeFirstServed.add(new Process("P1", 2,3));
        firstComeFirstServed.add(new Process("P2", 3,5));
        firstComeFirstServed.add(new Process("P3", 5,3));
        firstComeFirstServed.add(new Process("P4", 4,6));
        firstComeFirstServed.process();
        display(firstComeFirstServed);
    }

    public static void ShortestJobFirst(){
        Scheduler shortestJobFirst = new ShortestJobFirst();
        shortestJobFirst.add(new Process("P1", 2,5));
        shortestJobFirst.add(new Process("P2", 5,3));
        shortestJobFirst.add(new Process("P3", 3,6));
        shortestJobFirst.add(new Process("P4", 9,1));
        shortestJobFirst.process();
        display(shortestJobFirst);
    }

    public static void RoundRobin(){
        Scheduler roundRobin = new RoundRobin();
        roundRobin.add(new Process("P1", 2,5));
        roundRobin.add(new Process("P2", 5,3));
        roundRobin.add(new Process("P3", 3,6));
        roundRobin.add(new Process("P4", 9,1));
        roundRobin.process();
        display(roundRobin);

    }

    public static void PriorityNonPreemptive(){
        Scheduler priorityNonPreemptive = new PriorityNonPreemptive();
        priorityNonPreemptive.add(new Process("P1", 2,5, 5));
        priorityNonPreemptive.add(new Process("P2", 5,3, 3));
        priorityNonPreemptive.add(new Process("P3", 3,6, 2));
        priorityNonPreemptive.add(new Process("P4", 3,1, 1));
        priorityNonPreemptive.add(new Process("P1.2", 2,5, 5));
        priorityNonPreemptive.add(new Process("P2.2", 5,3, 3));
        priorityNonPreemptive.add(new Process("P3.2", 3,6, 2));
        priorityNonPreemptive.add(new Process("P4.2", 3,1, 1));
        priorityNonPreemptive.process();
        display(priorityNonPreemptive);
    }

    public static void MultiLevelQueue(){
        Scheduler multiLevelQueue = new MultilLevelQueue();
        multiLevelQueue.add(new Process("P1", 2,5, 5));
        multiLevelQueue.add(new Process("P2", 5,3, 3));
        multiLevelQueue.add(new Process("P3", 3,6, 2));
        multiLevelQueue.add(new Process("P4", 3,1, 1));
        multiLevelQueue.add(new Process("P5", 2,5, 5));
        multiLevelQueue.add(new Process("P6", 5,3, 3));
        multiLevelQueue.add(new Process("P7", 3,6, 2));
        multiLevelQueue.add(new Process("P8", 3,1, 1));
        multiLevelQueue.add(new Process("P9", 2,5, 5));
        multiLevelQueue.add(new Process("P10", 5,3, 3));
        multiLevelQueue.add(new Process("P11", 3,6, 2));
        multiLevelQueue.add(new Process("P12", 3,1, 1));
        multiLevelQueue.process();
        display(multiLevelQueue);
    }


    public static void display(Scheduler object)
    {
        System.out.println("Process\tAT\tBT\tWT\tTAT");

        for (Process row : object.getPcbs())
        {
            System.out.println("\t" + row.getProcessName() + "\t" + row.getArrivalTime() + "\t" + row.getBurstTime() + "\t" + row.getWaitingTime() + "\t" + row.getTurnAroundTime());
        }


        List<Event> GrantTimeline = object.getTimeline();

        for (Event event : GrantTimeline) {
            System.out.println(event.getStartingTime());
            System.out.println("|  " + event.getProcessName());
        }
        System.out.print(GrantTimeline.getLast().getFinishTime()+ "\n");

        System.out.println("\n\nAverage WT: " + object.getAverageWaitingTime() + "\nAverage TAT: " + object.getAverageTurnAroundTime());

    }
}