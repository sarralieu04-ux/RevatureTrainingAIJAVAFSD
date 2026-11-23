public class Bike extends Vehicle {
    private double BikeDiscount = 0.10;
    public Bike (int vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days);
    }
    @Override
    public double calculateRent() {
        return super.calculateRent() - (super.calculateRent() * this.BikeDiscount);
    }
}
