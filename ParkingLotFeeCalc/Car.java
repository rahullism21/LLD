package ParkingLotFeeCalc;

public class Car extends Vehicle{
    private static final double HOURLY_RATE=50;

    public Car(String numPlate){
        super(numPlate);
    }

    @Override
    public double getHourlyRate(){
        return HOURLY_RATE;
    }

}
