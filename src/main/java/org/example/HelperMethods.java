package org.example;

import java.util.ArrayList;
import java.util.List;

public class HelperMethods {
        public static List<Process> deepCopy(List<Process> oldList)
        {
            List<Process> newList = new ArrayList<>();

            for (Process pcb : oldList)
            {
                newList.add(new Process(pcb.getProcessName(), pcb.getArrivalTime(), pcb.getBurstTime(), pcb.getPriorityLevel()));
            }

            return newList;
        }
}
