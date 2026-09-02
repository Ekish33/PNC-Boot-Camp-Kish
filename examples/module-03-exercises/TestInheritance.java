public class TestInheritance {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); myCar.stop(); // inherited
        myCar.numDoors = 4; // own
        myCar.playMusic();
        myCar.brand = "Toyota"; // inherited
        myCar.maxSpeed = 180;
        System.out.println("Brand: " + myCar.brand);
        System.out.println("Max Speed: " + myCar.maxSpeed);
    }
}

public class TestInheritance {
 public static void main(String[] args) {
 Dog d = new Dog();
 // Inherited fields
 d.name = "Tommy";
 d.age = 3;
 // Own field
 d.breed = "Labrador";
 // Inherited methods
 d.eat(); // from Animal
 d.sleep(); // from Animal
 // Own method
 d.bark(); // from Dog
 }
}