import java.util.ArrayList;

/**
 * Cycle class to process processes
 */
public class Cycle {
    private LinkedQueue<Process> queue;
    private int cycle;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;

    // constructor for part A
    public Cycle(String processString) {
        cycle = 0;
        queue = new LinkedQueue<>();
        String[] processList = processString.split("[# ;]+");
        for (String string:processList) {
            Process process = new Process(string);
            queue.enqueue(process);
        }
    }

    // constructor @override for part B
    public Cycle() {
        cycle = 0;
        queue = new LinkedQueue<>();
        for (int i=0; i<20; i++) {
            queue.enqueue(randomProcess(i));
        }
    }

    public Process randomProcess(int i) {
        int a = -1; int b = -1; int c = -1;
        while (true) {
            a = (int)(Math.random()*2);
            b = (int)(Math.random()*2);
            c = (int)(Math.random()*2);
            if (a!=0 || b!=0 || c!=0) {break;}
        }
        String temp = "";
        switch (a+""+b+""+c) {
            case "100":
                temp = "P"+(i+1)+"(A)";
                break;
            case "010":
                temp = "P"+(i+1)+"(B)";
                break;
            case "001":
                temp = "P"+(i+1)+"(C)";
                break;
            case "110":
                temp = "P"+(i+1)+"(A,B)";
                break;
            case "101":
                temp = "P"+(i+1)+"(A,C)";
                break;
            case "111":
                temp = "P"+(i+1)+"(A,B,C)";
                break;
            case "011":
                temp = "P"+(i+1)+"(B,C)";
                break;
        }
        Process process = new Process(temp);
        return process;
    }

    // part B
    public void countCycle() {
        boolean endCycle = false;
        boolean initial = true;
        Process cur = queue.dequeue();
        int processNum = 19;

        while (!queue.isEmpty()||endCycle==true) {
            if (endCycle) {
                A = false; B = false; C = false; // clean processes
                cycle++;
                for (int i=0; i<2; i++) {
                    processNum++;
                    Process process = randomProcess(processNum);
                    queue.enqueue(process);
                }
                if (cycle%100==0) {
                    System.out.println("Length of processes at cycle "+cycle+": "+queue.size());
                }
                if (cycle==1000) {break;}
            }

            if (initial) {initial=false;}
            else if (!endCycle) {
                cur = queue.dequeue();
            }
            
            if (cur.getA() && A) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getA() && !A) {A=true;}

            if (cur.getB() && B) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getB() && !B) {B=true;}

            if (cur.getC() && C) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getC() && !C) {C=true;}

            endCycle = false;
        }
    }

    // part A
    public int calculateCycle() {
        boolean endCycle = false;
        boolean initial = true;
        ArrayList<String> running = new ArrayList<>();
        Process cur = queue.dequeue();

        while (!queue.isEmpty()||endCycle==true) {
            if (endCycle) {
                A = false; B = false; C = false; // clean processes
                System.out.println("Cycle "+(cycle+1)+": "+running.toString());
                running.clear();
                cycle++;
            }

            if (initial) {initial=false;}
            else if (!endCycle) {
                cur = queue.dequeue();
            }
            
            if (cur.getA() && A) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getA() && !A) {A=true;}

            if (cur.getB() && B) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getB() && !B) {B=true;}

            if (cur.getC() && C) {
                endCycle = true;
                continue; // end cycle
            }
            else if (cur.getC() && !C) {C=true;}

            endCycle = false;
            running.add(cur.getProcessNum());
        }
        if (running.isEmpty()) {running.add(cur.getProcessNum());}
        System.out.println("Cycle "+(cycle+1)+": "+running.toString());
        return cycle+1;
    }
}