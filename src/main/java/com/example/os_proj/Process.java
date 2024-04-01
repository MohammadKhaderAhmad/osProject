package com.example.os_proj;

public class Process {

    private final int processID;
    private final int arrivalTime;
    private final int burstTime;
    private int remainingBurstTime;
    private int finishedTime;
    private int processTurnaroundTime;
    private int processWaitingTime;
    // __________________________________________________________________________________________________________________________
    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
    // __________________________________________________________________________________________________________________________
    public int getProcessID() {
        return this.processID;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }

    public void setRemainingBurstTime(int remainingBurstTime) {
        this.remainingBurstTime = remainingBurstTime;
    }

    public int getFinishTime() {
        return finishedTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishedTime = finishTime;
    }

    public int getProcessTurnaroundTime() {
        return processTurnaroundTime;
    }

    public void setProcessTurnaroundTime(int processTurnaroundTime) {
        this.processTurnaroundTime = processTurnaroundTime;
    }

    public int getProcessWaitingTime() {
        return processWaitingTime;
    }

    public void setProcessWaitingTime(int processWaitingTime) {
        this.processWaitingTime = processWaitingTime;
    }

}
