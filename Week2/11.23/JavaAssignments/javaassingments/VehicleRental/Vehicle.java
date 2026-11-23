import java.util.Scanner;

public class Vehicle {
    protected int VehicleNumber;
    protected String Model;
    protected double RatePerDay;
    protected int Days;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter number of vehicles you want to rent");
        int numVehicles = sc.nextInt();
        sc.nextLine();
        String[][] vehicles = new String[numVehicles][4];

        for (int i = 0; i < numVehicles; i++) {
            System.out.println("Please enter vehicle type (1-Car or 2-Bike): ");
            int vehicleType = sc.nextInt();
            sc.nextLine();

            if (vehicleType == 1) {
                vehicles[i][0] = "Car";
            } else {
                vehicles[i][0] = "Bike";
            }

            System.out.println("Please enter the model: ");
            String model = sc.nextLine();

            System.out.println("Please enter the rate per day: ");
            double ratePerDay = sc.nextDouble();
            sc.nextLine();

            System.out.println("Please enter the number of days: ");
            int days = sc.nextInt();
            sc.nextLine();

            if (vehicleType == 1){
                System.out.println("Please enter the insurance charge per day for the car: ");
                double insuranceChargePerDay = sc.nextDouble();
                sc.nextLine();
            } 
            double rent = calculateRent(ratePerDay, days);

            vehicles[i][1] = model;
            vehicles[i][2] = String.valueOf(ratePerDay);
            vehicles[i][3] = String.valueOf(days);
        }
        for (int i = 0; i < numVehicles; i++) {
            System.out.print("Vehicle Type: " + vehicles[i][0] + " | ");
            System.out.print("Model: " + vehicles[i][1]+ " | ");
            System.out.print("Rate Per Day: " + vehicles[i][2]+ " | ");
            System.out.print("Days: " + vehicles[i][3]+ " | ");
            System.out.println("Total Rent: " + calculateRent(Double.parseDouble(vehicles[i][2]), Integer.parseInt(vehicles[i][3])));
            System.out.print();
        
        }

        sc.close();
    }

    public Vehicle(int vehicleNumber, String model, double ratePerDay, int days) {
        this.VehicleNumber = vehicleNumber;
        this.Model = model;
        this.RatePerDay = ratePerDay;
        this.Days = days;
    }

    public double calculateRent() {
        return this.RatePerDay * this.Days;
    }
}

