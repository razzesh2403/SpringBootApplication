package restdemo;

public class SpeedUtils {
    
    public int speed (int distance, int time){
        if(distance < 0 || time <= 0){
            throw new IllegalArgumentException("distance: " + distance
                                                + " time: " + time);
        }      
        return distance/time;
    }
    
    public Double noImplementation(Double d){
    	throw (new UnsupportedOperationException());
    }
}
