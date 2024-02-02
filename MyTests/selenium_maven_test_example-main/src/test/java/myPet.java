public class myPet {
    public static void main(String[] args) {
        // Создание объекта класса Pet с тремя параметрами
        Pet myPet1 = new Pet("Собакен", "Рубик", 5);
        myPet1.PetInfo();
        // Создание объекта класса Pet с двумя параметрами
        Pet myPet2 = new Pet("Кошак", "Зефир");
        myPet2.PetInfo();
        // Создание объекта класса Pet с одним параметром
        Pet myPet3 = new Pet( "Абырвалг");
        myPet3.PetInfo();
    }
}
