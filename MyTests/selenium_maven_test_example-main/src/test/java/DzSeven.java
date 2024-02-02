public class DzSeven {
    public static void main(String[] args) {
      pi();
      random();
    }
    public static void pi(){
        final double PI = 3.14;
        System.out.println("Значение числа π равно "+ PI);
    }
    public static void random(){
        float minValue = 1;
        float maxValue = 100;
        float randomValue = minValue + (float) (Math.random() * (maxValue - minValue + 0.01));
        System.out.println("Искомое число равно "+ randomValue);
    }
}
