package stringtest;

public class strbuilder {
    //  use string tochararray() method to convert string to char array
    // test string builder
    public static void main(String[] args) {
        String str = "Hello World";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb.toString());
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        // sb.capacity means the string buolder can hold how many characters
        sb.insert(5, "insert");
        System.out.println(sb.toString());
        sb.delete(5, 8);
        System.out.println(sb.toString());
    }
}
