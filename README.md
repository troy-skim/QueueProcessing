# Queue Processing

A queue processing program using data structures such as Queue and Linked Lists. <br />

## Folder Structure

    .
    ├── bin                          # Compiled/executable files
    │   ├── Cycle.class              
    │   ├── LinkedeQueue.class        
    │   ├── PartA.class             
    │   ├── PartB.class           
    │   ├── Process.class           
    │   ├── Queue.class            
    │   └── SingilyLinkedList.class    
    ├── src                            # Source files
    │   ├── Cycle.java                 # Used to count cycles and process queues  
    │   ├── LinkedeQueue.java          # Copied from the textbook
    │   ├── PartA.java                 # Driver program #1
    │   ├── PartB.java                 # Driver program #2
    │   ├── Process.java               # Represents each process (squares)
    │   ├── Queue.java                 # Copied from the textbook
    │   └── SingilyLinkedList.java     # Copied from the textbook
    ├── lib                            # External libraries and dependencies (not included)
    ├── LICENSE.txt                    # Apache Commons Licence
    └── README.md 

## How it works

The program simulates the operating system's selection of processes to send to the CPU. <br />
Each process will requre 1 or more resources A, B, and C. <br />
If the resource is available, the process is started. <br />
If any resource is unavailable, the process waits one cycle. <br />
It takes one cycle for a process to be finished. <br />
Every process must wait until all the previous processes have been started. <br />

## Input Format

P1(A);P2(B);P3(B,C);P4(C);P5(A,B,C); P6(B,C) ;P7(A);P8(A);P9(B);P10(C) <br />

## Part A and B

Part A prompts user to either select 1 or 2: <br />
If user selects 1, the user can test the queue processing with custom input.  <br />
If user selects 2, the program uses TestCases.txt from the root and prints out the results. <br />
<br />
Part B randomly generates 20 processes. At the end of each cycle, the program add 2 more process to the end (resources selected by random). <br />
The program prints the number of cycles to empty the list of processes, until it reaches cycle 1000. <br />
The program also prints the length of the list of processes every 100th cycle. 
