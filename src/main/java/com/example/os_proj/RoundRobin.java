package com.example.os_proj;

import java.util.*;

public class RoundRobin {

    public static final Queue<Process> queue = new LinkedList<>();
    public static int currentTime = 0;
    public static int totalTurnaroundTime = 0;
    public static int totalWaitingTime = 0;
    public static double averageTurnaroundTime;
    public static double averageWaitingTime;
    public static final int quantum = 20;
    // __________________________________________________________________________________________________________________________
    public static void schedulingAlgorithm(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));
        int size = processes.size();

        for(Process process : processes)
            process.setRemainingBurstTime(process.getBurstTime());

        while(!processes.isEmpty() || !queue.isEmpty()) {
            addToQueue(processes);
            applyRR(processes);

            while(!processes.isEmpty() && queue.isEmpty()) {
                currentTime++;
                addToQueue(processes);
            }
        }

        averageTurnaroundTime = (double) totalTurnaroundTime/size;
        averageWaitingTime = (double) totalWaitingTime/size;
    }
    // __________________________________________________________________________________________________________________________
    private static void addToQueue(ArrayList<Process> list) {
        while(!list.isEmpty() && list.get(0).getArrivalTime() <= currentTime)
            queue.add(list.remove(0));
    }
    // __________________________________________________________________________________________________________________________
    private static void applyRR(ArrayList<Process> list){
        while (!queue.isEmpty()) {
          // addToQueue(list);

            Process currentProcess = queue.poll();

            int executionTime = Math.min(currentProcess.getRemainingBurstTime(), quantum);
            currentProcess.setRemainingBurstTime(currentProcess.getRemainingBurstTime() - executionTime);
            currentTime += executionTime;

            if(currentProcess.getRemainingBurstTime() == 0){
                currentProcess.setFinishTime(currentTime);
                currentProcess.setProcessTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());
                currentProcess.setProcessWaitingTime(currentProcess.getProcessTurnaroundTime() - currentProcess.getBurstTime());
                totalTurnaroundTime += currentProcess.getProcessTurnaroundTime();
                totalWaitingTime += currentProcess.getProcessWaitingTime();
            }
            else {
                addToQueue(list);
                queue.add(currentProcess);
            }

            while(!list.isEmpty() && queue.isEmpty()) {
                currentTime++;
                addToQueue(list);
            }
        }
    }

}
