public class Program{

    public static void main(String[] args) {

        Person bob = new Person();      // вызов первого конструктора без параметров
        bob.displayInfo();

        Person tom = new Person("Tom"); // вызов второго конструктора с одним параметром
        tom.displayInfo();

        Person sam = new Person("Sam", 25); // вызов третьего конструктора с двумя параметрами
        sam.displayInfo();
    }
}