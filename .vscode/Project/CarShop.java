import java.util.ArrayList;
import java.util.List;

public class CarShop {
    
    List<Car> cars = new ArrayList<>();
    double sum;
    
    public void rentACar(Car car, String name, int lisence, int age) {
        if(age > 18) {
            if(car.isAvailable()) {
                cars.add(car);
            } else {
                System.out.println("Car already rented!");
            }
        } else {
            System.out.println("Minor bro");
        }
    }

    public void showAvailable() {

        List<String> availablecars = new ArrayList<>();
        if(MotorCycle.rentable) {
            availablecars.add("MotorCycle");
        } else if(Van.rentable) {
            availablecars.add("Van");
        } else if(PrivateCar.rentable) {
        availablecars.add("Private Car");
        }
        
        if(availablecars.isEmpty()) {
            System.out.println("No available cars!");
        } else{
        System.out.println(availablecars);
        }
    }

    public double calcMoney() {
        for(Car car : cars) {
            sum = sum + car.calcDailyPrice();
        }
        return sum;
    }
    

    


}
