import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Marathon {

    public static void main(String[] args) {
        new Marathon().init();
    }

    private void init() {
        int numParticipants = getNumberOfParticipants();
        ArrayList<Runner> runners = new ArrayList<>();

        for (int i = 0; i < numParticipants; i++) {
            String name = JOptionPane.showInputDialog(null, "Enter name of Runner " + (i + 1));
            int time = getTimeFromUser("Enter finishing time of Runner " + (i + 1));
            runners.add(new Runner(name, time));
        }

        Runner fastestRunner = findFastestRunner(runners);

        JOptionPane.showMessageDialog(null, "Fastest Runner: " + fastestRunner.getName() +
                "\nFinishing Time: " + fastestRunner.getTime() + " minutes");

        JOptionPane.showMessageDialog(null, "VU-ID: BC200401858");
    }

    private int getNumberOfParticipants() {
        int numParticipants = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null, "Enter the number of participants:");
                numParticipants = Integer.parseInt(input);
                if (numParticipants > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a number greater than zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
        return numParticipants;
    }

    private int getTimeFromUser(String message) {
        int time = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                time = Integer.parseInt(input);
                if (time > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number for finishing time.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for finishing time.");
            }
        }
        return time;
    }

    private Runner findFastestRunner(ArrayList<Runner> runners) {
        Runner fastestRunner = runners.get(0);
        for (Runner runner : runners) {
            if (runner.getTime() < fastestRunner.getTime()) {
                fastestRunner = runner;
            }
        }
        return fastestRunner;
    }


    private class Runner {
        private String name;
        private int time;
    
        public Runner(String name, int time) {
            this.name = name;
            this.time = time;
        }
    
        public String getName() {
            return name;
        }
    
        public int getTime() {
            return time;
        }
    }
}
