public class App {
    public static void main(String[] args) {
        // singleton
        Car GT = Car.getCar();
        Car GTR = Car.getCar();

        // prototype
        SuperCar P1 = new SuperCar();
        SuperCar ZONDA = new SuperCar();

        System.out.println(GT);
        System.out.println(GTR);
        System.out.println(P1);
        System.out.println(ZONDA);
    }
}
