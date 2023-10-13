package k22ug;

public class PrioritySchedulingProcess {


    }

    Structure PROCESS:
        id: integer
        priority: integer
        burstTime: integer
        arrivalTime: integer
        waitTime: integer = 0
        turnaroundTime: integer = 0

        List<PROCESS> processList
        List<PROCESS> readyQueue
        List<PROCESS> completedQueue

        Function SortByPriorityAndArrival(readyQueue):
        Sort readyQueue first by priority (higher value indicates higher priority)
        If two processes have the same priority, sort them by arrivalTime.

        MAIN:
        // Initialization
        Load processes into processList

        currentTime = 0

        WHILE processList is not empty OR readyQueue is not empty:
        // Add processes to the readyQueue if their arrivalTime <= currentTime
        FOR each process in processList:
        IF process.arrivalTime <= currentTime:
        Add process to readyQueue
        Remove process from processList

        IF readyQueue is not empty:
        SortByPriorityAndArrival(readyQueue)

        currentProcess = first item in readyQueue
        currentProcess.waitTime = currentTime - currentProcess.arrivalTime
        currentProcess.turnaroundTime = currentProcess.waitTime + currentProcess.burstTime

        currentTime += currentProcess.burstTime

        Move currentProcess from readyQueue to completedQueue

        ELSE:
        // If no processes are in the readyQueue, increment the currentTime
        currentTime += 1

            END WHILE