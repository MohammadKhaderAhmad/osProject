package com.example.os_proj;

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;

public class main {
    public static double attOneIterationFCFS = 0;
    public static double attOneIterationSRTF = 0;
    public static double attOneIterationRR = 0;
    public static double attOneIterationMLFQ = 0;
    public static double awtOneIterationFCFS = 0;
    public static double awtOneIterationSRTF = 0;
    public static double awtOneIterationRR = 0;
    public static double awtOneIterationMLFQ = 0;
    public static double attHundredIterationsFCFS = 0;
    public static double attHundredIterationsSRTF = 0;
    public static double attHundredIterationsRR = 0;
    public static double attHundredIterationsMLFQ = 0;
    public static double awtHundredIterationsFCFS = 0;
    public static double awtHundredIterationsSRTF = 0;
    public static double awtHundredIterationsRR = 0;
    public static double awtHundredIterationsMLFQ = 0;
    public static double attThousandIterationsFCFS = 0;
    public static double attThousandIterationsSRTF = 0;
    public static double attThousandIterationsRR = 0;
    public static double attThousandIterationsMLFQ = 0;
    public static double awtThousandIterationsFCFS = 0;
    public static double awtThousandIterationsSRTF = 0;
    public static double awtThousandIterationsRR = 0;
    public static double awtThousandIterationsMLFQ = 0;
    public static double attTenThousandIterationsFCFS = 0;
    public static double attTenThousandIterationsSRTF = 0;
    public static double attTenThousandIterationsRR = 0;
    public static double attTenThousandIterationsMLFQ = 0;
    public static double awtTenThousandIterationsFCFS = 0;
    public static double awtTenThousandIterationsSRTF = 0;
    public static double awtTenThousandIterationsRR = 0;
    public static double awtTenThousandIterationsMLFQ = 0;
    public static double attHundredThousandIterationsFCFS = 0;
    public static double attHundredThousandIterationsSRTF = 0;
    public static double attHundredThousandIterationsRR = 0;
    public static double attHundredThousandIterationsMLFQ = 0;
    public static double awtHundredThousandIterationsFCFS = 0;
    public static double awtHundredThousandIterationsSRTF = 0;
    public static double awtHundredThousandIterationsRR = 0;
    public static double awtHundredThousandIterationsMLFQ = 0;

    public static void main(String[] args) {
        oneIteration();
        hundredIterations();
        thousandIterations();
        tenThousandIterations();
        hundredThousandIterations();

        System.out.println();
        System.out.println("################################################ FCFS #######################################################");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Iteration", "1","100", "1000", "10000", "100000");
        printOutputATT(attOneIterationFCFS, attHundredIterationsFCFS, attThousandIterationsFCFS,
                attTenThousandIterationsFCFS, attHundredThousandIterationsFCFS);
        printOutputAWT(awtOneIterationFCFS, awtHundredIterationsFCFS,
                awtThousandIterationsFCFS, awtTenThousandIterationsFCFS, awtHundredThousandIterationsFCFS);

        System.out.println();
        System.out.println("################################################ SRTF #######################################################");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Iterations", "1", "100", "1000", "10000", "100000");
        printOutputATT(attOneIterationSRTF, attHundredIterationsSRTF,
                attThousandIterationsSRTF, attTenThousandIterationsSRTF, attHundredThousandIterationsSRTF);
        printOutputAWT(awtOneIterationSRTF, awtHundredIterationsSRTF,
                awtThousandIterationsSRTF, awtTenThousandIterationsSRTF, awtHundredThousandIterationsSRTF);

        System.out.println();
        System.out.println("################################################ RR #######################################################");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Iterations", "1", "100", "1000", "10000", "100000");
        printOutputATT(attOneIterationRR, attHundredIterationsRR,
                attThousandIterationsRR, attTenThousandIterationsRR, attHundredThousandIterationsRR);
        printOutputAWT(awtOneIterationRR, awtHundredIterationsRR,
                awtThousandIterationsRR, awtTenThousandIterationsRR, awtHundredThousandIterationsRR);

        System.out.println();
        System.out.println("################################################ MLFQ #######################################################");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Iterations", "1", "100", "1000", "10000", "100000");
        printOutputATT(attOneIterationMLFQ, attHundredIterationsMLFQ,
                attThousandIterationsMLFQ, attTenThousandIterationsMLFQ, attHundredThousandIterationsMLFQ);
        printOutputAWT(awtOneIterationMLFQ, awtHundredIterationsMLFQ,
                awtThousandIterationsMLFQ, awtTenThousandIterationsMLFQ, awtHundredThousandIterationsMLFQ);
    }

    public static void oneIteration() {
        ArrayList<Process> processes = new ArrayList<>();

        buildProcesses(processes);
        FirstComeFirstServe.schedulingAlgorithm(processes);
        attOneIterationFCFS = roundToTwoDecimalPlaces(FirstComeFirstServe.averageTurnaroundTime);;
        awtOneIterationFCFS = roundToTwoDecimalPlaces(FirstComeFirstServe.averageWaitingTime);

        buildProcesses(processes);
        ShortestJopFirst.schedulingAlgorithm(processes);
        attOneIterationSRTF = roundToTwoDecimalPlaces(ShortestJopFirst.averageTurnaroundTime);
        awtOneIterationSRTF = roundToTwoDecimalPlaces(ShortestJopFirst.averageWaitingTime);

        buildProcesses(processes);
        RoundRobin.schedulingAlgorithm(processes);
        attOneIterationRR = roundToTwoDecimalPlaces(RoundRobin.averageTurnaroundTime);
        awtOneIterationRR = roundToTwoDecimalPlaces(RoundRobin.averageWaitingTime);

        buildProcesses(processes);
        MultiLevelFeedbackQueue.schedulingAlgorithm(processes);
        attOneIterationMLFQ = roundToTwoDecimalPlaces(MultiLevelFeedbackQueue.averageTurnaroundTime);
        awtOneIterationMLFQ = roundToTwoDecimalPlaces(MultiLevelFeedbackQueue.averageWaitingTime);

        reset();
    }

    private static double roundToTwoDecimalPlaces(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedNumber = decimalFormat.format(value);
        return Double.parseDouble(formattedNumber);
    }

    public static void hundredIterations() {
        ArrayList<Process> processes = new ArrayList<>();

        for(int i = 1; i <= 100; i++) {
            buildProcesses(processes);
            FirstComeFirstServe.schedulingAlgorithm(processes);
            attHundredIterationsFCFS += FirstComeFirstServe.averageTurnaroundTime;
            awtHundredIterationsFCFS += FirstComeFirstServe.averageWaitingTime;

            buildProcesses(processes);
            ShortestJopFirst.schedulingAlgorithm(processes);
            attHundredIterationsSRTF += ShortestJopFirst.averageTurnaroundTime;
            awtHundredIterationsSRTF += ShortestJopFirst.averageWaitingTime;

            buildProcesses(processes);
            RoundRobin.schedulingAlgorithm(processes);
            attHundredIterationsRR += RoundRobin.averageTurnaroundTime;
            awtHundredIterationsRR += RoundRobin.averageWaitingTime;

            buildProcesses(processes);
            MultiLevelFeedbackQueue.schedulingAlgorithm(processes);
            attHundredIterationsMLFQ += MultiLevelFeedbackQueue.averageTurnaroundTime;
            awtHundredIterationsMLFQ += MultiLevelFeedbackQueue.averageWaitingTime;

            reset();
        }

        attHundredIterationsFCFS = roundToTwoDecimalPlaces(attHundredIterationsFCFS/100);
        awtHundredIterationsFCFS = roundToTwoDecimalPlaces(awtHundredIterationsFCFS/100);

        attHundredIterationsSRTF = roundToTwoDecimalPlaces(attHundredIterationsSRTF/100);
        awtHundredIterationsSRTF = roundToTwoDecimalPlaces(awtHundredIterationsSRTF/100);

        attHundredIterationsRR = roundToTwoDecimalPlaces(attHundredIterationsRR/100);
        awtHundredIterationsRR = roundToTwoDecimalPlaces(awtHundredIterationsRR/100);

        attHundredIterationsMLFQ = roundToTwoDecimalPlaces(attHundredIterationsMLFQ/100);
        awtHundredIterationsMLFQ = roundToTwoDecimalPlaces(awtHundredIterationsMLFQ/100);
    }

    public static void thousandIterations() {
        ArrayList<Process> processes = new ArrayList<>();

        for(int i = 1; i <= 1000; i++) {
            buildProcesses(processes);
            FirstComeFirstServe.schedulingAlgorithm(processes);
            attThousandIterationsFCFS += FirstComeFirstServe.averageTurnaroundTime;
            awtThousandIterationsFCFS += FirstComeFirstServe.averageWaitingTime;

            buildProcesses(processes);
            ShortestJopFirst.schedulingAlgorithm(processes);
            attThousandIterationsSRTF += ShortestJopFirst.averageTurnaroundTime;
            awtThousandIterationsSRTF += ShortestJopFirst.averageWaitingTime;

            buildProcesses(processes);
            RoundRobin.schedulingAlgorithm(processes);
            attThousandIterationsRR += RoundRobin.averageTurnaroundTime;
            awtThousandIterationsRR += RoundRobin.averageWaitingTime;

            buildProcesses(processes);
            MultiLevelFeedbackQueue.schedulingAlgorithm(processes);
            attThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageTurnaroundTime;
            awtThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageWaitingTime;

            reset();
        }

        attThousandIterationsFCFS = roundToTwoDecimalPlaces(attThousandIterationsFCFS/1000);
        awtThousandIterationsFCFS = roundToTwoDecimalPlaces(awtThousandIterationsFCFS/1000);

        attThousandIterationsSRTF = roundToTwoDecimalPlaces(attThousandIterationsSRTF/1000);
        awtThousandIterationsSRTF = roundToTwoDecimalPlaces(awtThousandIterationsSRTF/1000);

        attThousandIterationsRR = roundToTwoDecimalPlaces(attThousandIterationsRR/1000);
        awtThousandIterationsRR = roundToTwoDecimalPlaces(awtThousandIterationsRR/1000);

        attThousandIterationsMLFQ = roundToTwoDecimalPlaces(attThousandIterationsMLFQ/1000);
        awtThousandIterationsMLFQ = roundToTwoDecimalPlaces(awtThousandIterationsMLFQ/1000);
    }

    public static void tenThousandIterations() {
        ArrayList<Process> processes = new ArrayList<>();

        for(int i = 1; i <= 10000; i++) {
            buildProcesses(processes);
            FirstComeFirstServe.schedulingAlgorithm(processes);
            attTenThousandIterationsFCFS += FirstComeFirstServe.averageTurnaroundTime;
            awtTenThousandIterationsFCFS += FirstComeFirstServe.averageWaitingTime;

            buildProcesses(processes);
            ShortestJopFirst.schedulingAlgorithm(processes);
            attTenThousandIterationsSRTF += ShortestJopFirst.averageTurnaroundTime;
            awtTenThousandIterationsSRTF += ShortestJopFirst.averageWaitingTime;

            buildProcesses(processes);
            RoundRobin.schedulingAlgorithm(processes);
            attTenThousandIterationsRR += RoundRobin.averageTurnaroundTime;
            awtTenThousandIterationsRR += RoundRobin.averageWaitingTime;

            buildProcesses(processes);
            MultiLevelFeedbackQueue.schedulingAlgorithm(processes);
            attTenThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageTurnaroundTime;
            awtTenThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageWaitingTime;

            reset();
        }

        attTenThousandIterationsFCFS = roundToTwoDecimalPlaces(attTenThousandIterationsFCFS/10000);
        awtTenThousandIterationsFCFS = roundToTwoDecimalPlaces(awtTenThousandIterationsFCFS/10000);

        attTenThousandIterationsSRTF = roundToTwoDecimalPlaces(attTenThousandIterationsSRTF/10000);
        awtTenThousandIterationsSRTF = roundToTwoDecimalPlaces(awtTenThousandIterationsSRTF/10000);

        attTenThousandIterationsRR = roundToTwoDecimalPlaces(attTenThousandIterationsRR/10000);
        awtTenThousandIterationsRR = roundToTwoDecimalPlaces(awtTenThousandIterationsRR/10000);

        attTenThousandIterationsMLFQ = roundToTwoDecimalPlaces(attTenThousandIterationsMLFQ/10000);
        awtTenThousandIterationsMLFQ = roundToTwoDecimalPlaces(awtTenThousandIterationsMLFQ/10000);
    }

    public static void hundredThousandIterations() {
        ArrayList<Process> processes = new ArrayList<>();

        for(int i = 1; i <= 100000; i++) {
            buildProcesses(processes);
            FirstComeFirstServe.schedulingAlgorithm(processes);
            attHundredThousandIterationsFCFS += FirstComeFirstServe.averageTurnaroundTime;
            awtHundredThousandIterationsFCFS += FirstComeFirstServe.averageWaitingTime;

            buildProcesses(processes);
            ShortestJopFirst.schedulingAlgorithm(processes);
            attHundredThousandIterationsSRTF += ShortestJopFirst.averageTurnaroundTime;
            awtHundredThousandIterationsSRTF += ShortestJopFirst.averageWaitingTime;

            buildProcesses(processes);
            RoundRobin.schedulingAlgorithm(processes);
            attHundredThousandIterationsRR += RoundRobin.averageTurnaroundTime;
            awtHundredThousandIterationsRR += RoundRobin.averageWaitingTime;

            buildProcesses(processes);
            MultiLevelFeedbackQueue.schedulingAlgorithm(processes);
            attHundredThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageTurnaroundTime;
            awtHundredThousandIterationsMLFQ += MultiLevelFeedbackQueue.averageWaitingTime;

            reset();
        }

        attHundredThousandIterationsFCFS = roundToTwoDecimalPlaces(attHundredThousandIterationsFCFS/100000);
        awtHundredThousandIterationsFCFS = roundToTwoDecimalPlaces(awtHundredThousandIterationsFCFS/100000);

        attHundredThousandIterationsSRTF = roundToTwoDecimalPlaces(attHundredThousandIterationsSRTF/100000);
        awtHundredThousandIterationsSRTF = roundToTwoDecimalPlaces(awtHundredThousandIterationsSRTF/100000);

        attHundredThousandIterationsRR = roundToTwoDecimalPlaces(attHundredThousandIterationsRR/100000);
        awtHundredThousandIterationsRR = roundToTwoDecimalPlaces(awtHundredThousandIterationsRR/100000);

        attHundredThousandIterationsMLFQ = roundToTwoDecimalPlaces(attHundredThousandIterationsMLFQ/100000);
        awtHundredThousandIterationsMLFQ = roundToTwoDecimalPlaces(awtHundredThousandIterationsMLFQ/100000);
    }


    // __________________________________________________________________________________________________________________________
    public static void buildProcesses(ArrayList<Process> list){
        Random random = new Random();

        list.add(new Process(1, 0, 25));
        list.add(new Process(2, 0, 160));
        list.add(new Process(3, 0, 120));
        list.add(new Process(4,0, 8));
       // list.add(new Process(5, random.nextInt(100),random.nextInt(96) + 5));
       // list.add(new Process(6, random.nextInt(100), random.nextInt(96) + 5));
       // list.add(new Process(7, random.nextInt(100), random.nextInt(96) + 5));
        //list.add(new Process(8, random.nextInt(100), random.nextInt(96) + 5));
    }
    // __________________________________________________________________________________________________________________________
    public static void reset(){
        FirstComeFirstServe.currentTime = 0;
        FirstComeFirstServe.totalTurnaroundTime = 0;
        FirstComeFirstServe.totalWaitingTime = 0;
        FirstComeFirstServe.averageTurnaroundTime = 0;
        FirstComeFirstServe.averageWaitingTime = 0;
        FirstComeFirstServe.queue.clear();

        ShortestJopFirst.currentTime = 0;
        ShortestJopFirst.totalTurnaroundTime = 0;
        ShortestJopFirst.totalWaitingTime = 0;
        ShortestJopFirst.averageTurnaroundTime = 0;
        ShortestJopFirst.averageWaitingTime = 0;
        ShortestJopFirst.heap.clear();

        RoundRobin.currentTime = 0;
        RoundRobin.totalTurnaroundTime = 0;
        RoundRobin.totalWaitingTime = 0;
        RoundRobin.averageTurnaroundTime = 0;
        RoundRobin.averageWaitingTime = 0;
        RoundRobin.queue.clear();

        MultiLevelFeedbackQueue.currentTime = 0;
        MultiLevelFeedbackQueue.totalTurnaroundTime = 0;
        MultiLevelFeedbackQueue.totalWaitingTime = 0;
        MultiLevelFeedbackQueue.averageTurnaroundTime = 0;
        MultiLevelFeedbackQueue.averageWaitingTime = 0;
        MultiLevelFeedbackQueue.queue1.clear();
        MultiLevelFeedbackQueue.queue2.clear();
        MultiLevelFeedbackQueue.queue3.clear();
    }
    // __________________________________________________________________________________________________________________________
    public static void printOutputATT(double attOne, double attHundred, double attThousand, double attTenThousand, double attHundredThousand){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "ATT", attOne, attHundred, attThousand, attTenThousand, attHundredThousand);
    }

    public static void printOutputAWT(double awtOne, double awtHundred, double awtThousand, double awtTenThousand, double awtHundredThousand){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "AWT", awtOne, awtHundred, awtThousand, awtTenThousand, awtHundredThousand);
    }
}
