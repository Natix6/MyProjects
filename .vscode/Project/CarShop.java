
import java.util.ArrayList;
import java.util.List;


public class CarShop {
    
    List<Car> cars = new ArrayList<>();
    private double sum;

    public void rentACar(Car car, String name, int lisence, int age) {

        if(age > 18) {
            if(!car.isRented()) {
                cars.add(car);
                car.setCarForRental(true);
            } else {
                System.out.println("This type of car is already rented!");
            }
        } else {
            System.out.println("Minor bro");
        }
    }

    public List<Car> getRentedCars() {
        return cars;
    }

    public double calcMoney() {
        for(Car car : cars) {
            sum = sum + car.calcDailyPrice();
        }
        return sum;
    }
}



