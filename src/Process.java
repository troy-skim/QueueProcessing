public class Process {
    private String processNum;  // P1, P2, P3
    private boolean A = false;  // if A exists
    private boolean B = false;  // if B exists
    private boolean C = false;  // if C exists

    // constructor
    public Process(String process) {
        String[] values = process.split("[(),]");   // split process line with (),
        this.processNum = values[0];    // P1, P2, P3
        for (int i=1; i<values.length; i++) {
            if (values[i].equals("A")) this.A = true;
            else if (values[i].equals("B")) this.B = true;
            else if (values[i].equals("C")) this.C = true;
        }
    }

    public String getProcessNum() {
        return this.processNum;
    }

    public boolean getA() {
        return this.A;
    }

    public boolean getB() {
        return this.B;
    }

    public boolean getC() {
        return this.C;
    }
}