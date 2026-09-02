// Superclass
class Vehicle {
    String brand;
    int maxSpeed;
    void start() {
        System.out.println("Vehicle started");
    }
    void stop() {
        System.out.println("Vehicle stopped");
    }
    }
    // Subclass
    class Car extends Vehicle {
    int numDoors;
    void playMusic() {
        System.out.println("Playing music");
    }
}


