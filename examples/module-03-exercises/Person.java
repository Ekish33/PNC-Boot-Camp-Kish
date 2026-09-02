
public class Person {
    private String name; private int age;
    public Person(String name, int age){
        this.name = name; this.age = age;
    }
    public void introduce(){
        System.out.println("Hi i am" + name + "and i am" +age + "years old");
    }
    public int getAge() { return age;}
}
