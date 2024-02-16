package Code.AnotherPackage;

public class DzElevenMethods {
    public static void first() {
        System.out.println("Я помню чудное мгновение");
        System.out.println("Передо мной явилась ты");
        System.out.println("Как мимолетное видение");
        System.out.println("Как гений чистой красоты!");
    }
    public static void second() {
        String word1 = "Java";
        String word2 = "лучший";
        String word3 = "язык";
        String word4 = "программирования";
        System.out.println(String.join(" ",word1,"-",word2,word3,word4,"!"));
    }
    public static void third(){
        String textLang = "Обожаю изучать новые языки";
        System.out.println(textLang.substring(textLang.indexOf("изучать")));
        System.out.println(textLang.substring(textLang.indexOf("изучать"), textLang.indexOf("новые")));
            }
    public static void fourth() {
        String textIndex = "Домашнее задание не проблема";
        System.out.println(textIndex.indexOf("не"));
        System.out.println(textIndex.lastIndexOf("не"));
    }
    }

