import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) throws Exception {
        // read test file and add each line to testCases arrayList
        String curDirectory = System.getProperty("user.dir");
        File testFile = new File(curDirectory, "TestCases.txt");
        Scanner txtScanner = new Scanner(testFile);
        ArrayList<String> testCases = new ArrayList<String>();
        while (txtScanner.hasNextLine()) {
            String line = txtScanner.nextLine();
            testCases.add(line);
        }
        txtScanner.close();

        Scanner scn = new Scanner(System.in);

        System.out.print("Which input do you wish to test? 1 is custom input, 2 is the data from the given text file. (1,2): ");
        String response = scn.nextLine();
        if (response.equals("1")) {
            System.out.print("Enter Process List: ");
            String processString = scn.nextLine();
            Cycle test = new Cycle(processString);
            System.out.println(test.calculateCycle());
        }
        else if (response.equals("2")) {
            for (int i=0; i<testCases.size(); i++) {
                Cycle test = new Cycle(testCases.get(i));
                System.out.println(test.calculateCycle()+"\n");
            }
        }
        scn.close();
        System.out.println("End of the program");
    }
}
