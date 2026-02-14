package ParkingLotFeeCalc;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

import java.util.stream.Collectors;

public class ParkingLotSystem {
    private final ConcurrentHashMap<String, Vehicle> vehiclMap = new ConcurrentHashMap<>();

    public void parkVehicle(Vehicle v){
        vehiclMap.put(v.getNumPlate(), v);
    }

    public double calcFee(String numPlate){

            Vehicle v= vehiclMap.get(numPlate);
            Duration duration = Duration.between(v.getEntryTime(), LocalDateTime.now());
            long hours = duration.toHours();
            double fees= v.getHourlyRate()*(hours>1?hours:1);
            if(hours>10){
                fees=fees-(0.15*fees);
            }
            return fees;
    }
           

    public void unparlVehicle(String numPlate){
        try {
                if(!vehiclMap.containsKey(numPlate)){
                throw new NoSuchElementException("Vehicle with Number Plate : "+numPlate+" not present in Lot.");
            }
            else{
                double fees =calcFee(numPlate);
                vehiclMap.remove(numPlate);
                System.out.println("Vehicle Unparked and fees is : "+fees);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Vehicle> getParkVehiclesbyType(Class< ? extends Vehicle> type){
        return vehiclMap.values()
                        .stream().filter(v->type.isInstance(v))
                        .sorted(Comparator.comparing(Vehicle::getEntryTime))
                        .collect(Collectors.toList());
    }

}
