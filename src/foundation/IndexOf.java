package foundation;

public class IndexOf {

    public static void main(String[] args) {
        String str1 = "Hello, world!";
        String str2 = "world!";
        System.out.println(str1.indexOf(str2)); // Output: 7
        System.out.println(str1.indexOf("not present")); // Output: -1
        System.out.println(str2.indexOf(str1)); // Output: 7
    }

}
