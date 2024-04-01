package com.example.os_proj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJopFirst {

    public static int currentTime = 0;
    public static int totalTurnaroundTime = 0;
    public static int totalWaitingTime = 0;
    public static double averageTurnaroundTime;
    public static double averageWaitingTime;
    public static PriorityQueue<Process> heap = new PriorityQueue<>(Comparator.comparingInt(Process::getRemainingBurstTime));
    // __________________________________________________________________________________________________________________________
    public static void schedulingAlgorithm(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));
        int size = processes.size();

        for(Process process : processes)
            process.setRemainingBurstTime(process.getBurstTime());

        applySRT(processes);

        averageTurnaroundTime = (double) totalTurnaroundTime/size;
        averageWaitingTime = (double) totalWaitingTime/size;
    }
    // __________________________________________________________________________________________________________________________
    private static void addToQueue(ArrayList<Process> list) {
        while(!list.isEmpty() && list.get(0).getArrivalTime() <= currentTime)
            heap.add(list.remove(0));
    }
    // __________________________________________________________________________________________________________________________
    private static void applySRT(ArrayList<Process> list){
        while (!list.isEmpty() || !heap.isEmpty()) {
            addToQueue(list);

            if (!heap.isEmpty()) {
                Process currentProcess = heap.poll();
                currentTime += 1;
                currentProcess.setRemainingBurstTime(currentProcess.getRemainingBurstTime() - 1);

                if (currentProcess.getRemainingBurstTime() == 0) {
                    currentProcess.setFinishTime(currentTime);
                    currentProcess.setProcessTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());
                    currentProcess.setProcessWaitingTime(currentProcess.getProcessTurnaroundTime() - currentProcess.getBurstTime());
                    totalTurnaroundTime += currentProcess.getProcessTurnaroundTime();
                    totalWaitingTime += currentProcess.getProcessWaitingTime();
                }
                else
                    heap.add(currentProcess);
            }
            else
                currentTime++;
        }
    }

}
