//Central que controla os subsistemas
package Facade;

public class CarFacade {
    private Engine engine;
    private Lights lights;
    private Doors doors;

    public CarFacade() {
        this.engine = new Engine();
        this.lights = new Lights();
        this.doors = new Doors();
    }

    //Ativar os 3 subsistemas em sequência, permite ligar o carro
    public void startCar() {
        doors.lock();
        lights.turnOn();
        engine.start();
        System.out.println("Carro pronto para dirigir!");
    }
}
