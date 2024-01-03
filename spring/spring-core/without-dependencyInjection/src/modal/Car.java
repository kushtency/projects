package modal;

public class Car {
    private Engine engine;

    // without DI
    public Car(){
        this.engine = new Engine();
    }

    public String showHorsePower() {
        return String.valueOf(engine.getHorsePower());
    }
}
