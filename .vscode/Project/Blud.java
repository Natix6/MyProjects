import java.util.ArrayList;
import java.util.List;

public class Blud {
  public static void main(String[] args) throws Exception {

    CarShop carShop = new CarShop();
    PrivateCar privateCar = new PrivateCar(6767676, "Suzuka", 2019, 6);
    Van van = new Van(12345, "Suzuka", 2019, 6);
    MotorCycle motorCycle = new MotorCycle(12345, "Suzuka", 2019, 6);
    PrivateCar privateCar2 = new PrivateCar(12345, "Suzuka", 2019, 6);

    List<Car> list = new ArrayList<>();
    list.add(privateCar);
    list.add(van);
    list.add(motorCycle);
    list.add(privateCar2);

    for(Car car : list) {
      carShop.rentACar(car, "Nigga", 12, 19);
    }

    
    motorCycle.setKm(10);
    van.setKm(40);
    privateCar.setKm(100);
    System.out.println(carShop.calcMoney());
    System.out.println(carShop.getRentedCars());


  }
}