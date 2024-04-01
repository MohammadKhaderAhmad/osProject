package com.example.os_proj;

import java.util.*;
public class FirstComeFirstServe {

    public static final Queue<Process> queue = new LinkedList<>();
    public static int currentTime = 0;
    public static int totalTurnaroundTime = 0;
    public static int totalWaitingTime = 0;
    public static double averageTurnaroundTime;
    public static double averageWaitingTime;
    // __________________________________________________________________________________________________________________________
    public static void schedulingAlgorithm(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));
        int size = processes.size();

        for(Process process : processes)
            process.setRemainingBurstTime(process.getBurstTime());

        while(!processes.isEmpty()) {
            addToQueue(processes);
            applyFCFS(processes);
        }

        averageTurnaroundTime = (double)totalTurnaroundTime/size;
        averageWaitingTime = (double)totalWaitingTime/size;
    }
    // __________________________________________________________________________________________________________________________
    private static void addToQueue(ArrayList<Process> list) {
        while(!list.isEmpty() && list.get(0).getArrivalTime() <= currentTime)
            queue.add(list.remove(0));

        if(!list.isEmpty() && queue.isEmpty())
            currentTime++;
    }
    // __________________________________________________________________________________________________________________________
    private static void applyFCFS(ArrayList<Process> list){
        while (!queue.isEmpty()) {

            Process currentProcess = queue.poll();
            currentTime += currentProcess.getRemainingBurstTime();

            currentProcess.setFinishTime(currentTime);
            currentProcess.setProcessTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());
            currentProcess.setProcessWaitingTime(currentProcess.getProcessTurnaroundTime() - currentProcess.getBurstTime());
            totalTurnaroundTime += currentProcess.getProcessTurnaroundTime();
            totalWaitingTime += currentProcess.getProcessWaitingTime();
        }
    }

}
