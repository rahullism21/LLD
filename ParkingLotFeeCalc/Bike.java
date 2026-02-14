package ParkingLotFeeCalc;

public class Bike extends Vehicle{
    private static final double HOURLY_RATE=20;

        public Bike(String numPlate){
        super(numPlate);
    }

    @Override
    public double getHourlyRate(){
        return HOURLY_RATE;
    }
}
