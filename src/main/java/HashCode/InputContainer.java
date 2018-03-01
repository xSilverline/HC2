package HashCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputContainer {
    List<Ride> rides = new ArrayList<>();
    int vehicles;
    int rows;
    int columns;
    int num_of_rides;
    int bonus;
    int steps;

    public void loadInput(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line = bufferedReader.readLine();
            String[] params = line.split(" ");

            rows = Integer.parseInt(params[0]);
            columns = Integer.parseInt(params[1]);
            vehicles = Integer.parseInt(params[2]);
            num_of_rides = Integer.parseInt(params[3]);
            bonus = Integer.parseInt(params[4]);
            steps = Integer.parseInt(params[5]);

            Ride r;
            while((line = bufferedReader.readLine()) != null) {
                String[] ride = line.split(" ");
                r = new Ride(
                        Integer.parseInt(ride[0]), //start x
                        Integer.parseInt(ride[1]), //start y
                        Integer.parseInt(ride[2]), //end x
                        Integer.parseInt(ride[3]), //end y
                        Integer.parseInt(ride[4]), //start
                        Integer.parseInt(ride[5]) //end
                        );
                rides.add(r);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args) {
        InputContainer inputContainer = new InputContainer();
        inputContainer.loadInput("C:\\Users\\Jonasz\\hc\\out\\production\\hc\\resources\\a_example.in");

        Solver solver = new Solver(inputContainer.steps);
        solver.findSolution(inputContainer.rides, inputContainer.num_of_rides, inputContainer.vehicles);
    }
}
