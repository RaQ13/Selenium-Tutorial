package znajdowanie.elementow;

public class SubstringTest {
    public static void main(String[] args) {
        String test = "username";
//        String substring = test.substring(test.length()-'ame'.length());
//        String substring = test.substring(5); // ame
        String substring = test.substring(test.length()-4); //zwraca 4 ostatnie litery (name)
        System.out.println(substring);
    }
}
