public class Pet {
     String type; // Вид питомца
     String name; // Кличка питомца
     int age; // Возраст питомца

    // Конструктор с тремя параметрами
    Pet(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }
  // Конструктор с двумя параметрами
    public Pet(String type, String name) {
        this(type, name, 8);
    }
    // Конструктор с одним параметром
    public Pet(String name) {
        this("Чудо-юдо рыба-кит",name,10);
    }

//Вывод данных на консоль
    public void PetInfo() {
        System.out.printf("Type:%s\tName:%s\tAge:%d\n", type, name, age);
    }
}

