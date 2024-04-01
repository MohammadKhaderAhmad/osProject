package com.example.os_proj;

import java.util.*;

public class MultiLevelFeedbackQueue {
    public static final Queue<Process> queue1 = new LinkedList<>();
    public static final Queue<Process> queue2 = new LinkedList<>();
    public static final Queue<Process> queue3 = new LinkedList<>();
    private static final int quantum1 = 10;
    private static final int quantum2 = 50;
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

        while(!processes.isEmpty() || !queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty()) {
            addToQueueOne(processes);
            applyQ1(processes);
            applyQ2(processes);
            applyQ3(processes);
        }

        averageTurnaroundTime = (double) totalTurnaroundTime/size;
        averageWaitingTime = (double) totalWaitingTime/size;
    }
    // __________________________________________________________________________________________________________________________
    private static void addToQueueOne(ArrayList<Process> list) {
        while(!list.isEmpty() && list.get(0).getArrivalTime() <= currentTime)
            queue1.add(list.remove(0));

        if(!list.isEmpty() && queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty())
            currentTime++;
    }
    // __________________________________________________________________________________________________________________________
    public static void applyQ1(ArrayList<Process> processes) {
        addToQueueOne(processes);

        while(!queue1.isEmpty()) {
            Process currentProcess = queue1.poll();
            int processQuantumOneExecuting = Math.min(currentProcess.getRemainingBurstTime(), quantum1);

            currentTime += processQuantumOneExecuting;

            currentProcess.setRemainingBurstTime(currentProcess.getBurstTime() - processQuantumOneExecuting);

            if(currentProcess.getRemainingBurstTime() > 0)
                queue2.add(currentProcess);
            else{
                currentProcess.setFinishTime(currentTime);
                currentProcess.setProcessTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());
                currentProcess.setProcessWaitingTime(currentProcess.getProcessTurnaroundTime() - currentProcess.getBurstTime());
                totalTurnaroundTime += currentProcess.getProcessTurnaroundTime();
                totalWaitingTime += currentProcess.getProcessWaitingTime();
            }

            addToQueueOne(processes);
        }
    }
    // __________________________________________________________________________________________________________________________
    public static void applyQ2(ArrayList<Process> processes) {
        while (!queue2.isEmpty()) {
            applyQ1(processes);

            Process currentProcess = queue2.poll();
            assert currentProcess != null;
            int processQuantumTwoExecuting = Math.min(currentProcess.getRemainingBurstTime(), quantum2);

            currentTime += processQuantumTwoExecuting;

            currentProcess.setRemainingBurstTime(currentProcess.getRemainingBurstTime() - processQuantumTwoExecuting);

            if(currentProcess.getRemainingBurstTime() > 0)
                queue3.add(currentProcess);
            else{
                currentProcess.setFinishTime(currentTime);
                totalTurnaroundTime += currentProcess.getFinishTime() - currentProcess.getArrivalTime();
                totalWaitingTime += currentProcess.getFinishTime() - currentProcess.getArrivalTime() - currentProcess.getBurstTime();
            }
        }
    }
    // __________________________________________________________________________________________________________________________
    public static void applyQ3(ArrayList<Process> processes){
        while (!queue3.isEmpty()) {
            applyQ1(processes);
            applyQ2(processes);

            Process currentProcess = queue3.poll();

            assert currentProcess != null;
            currentTime += currentProcess.getRemainingBurstTime();

            currentProcess.setFinishTime(currentTime);
            totalTurnaroundTime += currentProcess.getFinishTime() - currentProcess.getArrivalTime();
            totalWaitingTime += currentProcess.getFinishTime() - currentProcess.getArrivalTime() - currentProcess.getBurstTime();
        }
    }
}