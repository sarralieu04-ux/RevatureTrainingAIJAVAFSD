public class Car extends Vehicle {
    private double InsuranceChargePerDay;

    public Car (int vehicleNumber, String model, double ratePerDay, int days, double insuranceChargePerDay) {
        super(vehicleNumber, model, ratePerDay, days);
        this.InsuranceChargePerDay = insuranceChargePerDay;
    }
    
    @Override
    public double calculateRent() {
        return super.calculateRent() + (this.InsuranceChargePerDay * this.Days);
    }
}
