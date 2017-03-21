
import java.util.ArrayList;

/**
 *
 * @author sean
 */
public class ParkingLot {

    ArrayList<Car> lot = new ArrayList<>();

    public boolean isEmpty() {
        if (lot.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void addCar(Car c) {
        if (lot.size() < 200) {
            lot.add(c);
        } else {

        }
    }
    
    public boolean isTimeAvailable(String time){
    if(time.isTimeAvailable){
        return true;
    }else{
        return false;
    }
    }
    

    public void removeCar(Car c) {
        lot.remove(c);
    }

    public boolean isFull() {
        if (lot.size() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTaken(int spot) {
        if (spot.isTaken()){
            return true;
        } else {
            return false;
        }
    }
    
}
