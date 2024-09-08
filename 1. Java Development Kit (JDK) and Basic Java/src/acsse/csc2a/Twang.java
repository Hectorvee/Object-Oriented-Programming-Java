package acsse.csc2a;

public class Twang {
    public static void main(String[] args) {

        validateCommandLineArgument(args);

        int numOfLoops = Integer.parseInt(args[0]);
        String[] arrOutput = new String[numOfLoops];

        for (int i = 0; i<numOfLoops; i++) {
            int num = i+1;
            if (num%3==0 && num%5==0) {
                arrOutput[i] = "Harp";
            } else if (num%3==0) {
                arrOutput[i] = "BANJO";
            } else if (num%5==0) {
                arrOutput[i] = "GUITAR";
            } else {
                arrOutput[i] = String.valueOf(num);
            }
        }

        outputArray(arrOutput);
    }

    // Function to validate the argument passed in the command line
    public static void validateCommandLineArgument(String[] args) {
        if (args.length == 0) {
            System.err.println("Error. No command-line argument provided.");
            System.exit(1);
        }
    }

    // Function to output the array elements
    public static void outputArray(String[] args) {
        for (String out: args) {
            System.out.println(out);
        }
    }
}
