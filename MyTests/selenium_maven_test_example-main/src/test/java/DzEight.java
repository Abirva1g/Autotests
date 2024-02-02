public class DzEight {
    public static void main(String[] args) {
        type();
        System.out.println();
        preobrazovanie();
    }
    public static void type() {
        short chislo = 7778;
        float tochka = 876.351f;
        String stroka = "Игорь";
        boolean bool = true;

            System.out.println("Значение целочисленной переменной - " + chislo);
            System.out.println("Значение переменной c плавающей точкой - " + tochka);
            System.out.println("Значение строковой переменной - " + stroka);
            System.out.println("Значение логической переменной - " + bool);
            System.out.print("Значения символьной переменной - ");
        char[] symvol = {'n', 'y'};
        for (char a : symvol) {
            System.out.print(a);
        }
    }
    public static void preobrazovanie() {
        float tochka = 876.351f;
        short chislo = 7778;
        String str = "" + chislo;
        System.out.println(str);
        int tochka1 =  (int)tochka;
        System.out.println(tochka1);
    }
}



