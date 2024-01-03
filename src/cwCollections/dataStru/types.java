package org.example;

public class types {

    public static void main(String[] args) {
        // 1. 使用字符串字面量创建
        String strLiteral = "Hello, World!";
        System.out.println("1. string literal: " + strLiteral);
        // 字符串的方法
        System.out.println("charAt: " + strLiteral.charAt(0));
        System.out.println("toCharArray: " + strLiteral.toCharArray()[0]);
        System.out.println("split切割：" + strLiteral.split(" ")[1]);
        char[] cha = {'a'};
        System.out.println("contains(cha): " + strLiteral.contains(cha.toString()));
        System.out.println("substring(i,j): " + strLiteral.substring(0,5));
        // valueOf
        int number = 42;
        String strValueOf = String.valueOf(number);
        System.out.println("String.valueOf: " + strValueOf);

        // 2. 使用`new`关键字创建
        String strNewKeyword = new String("Hello, World!");
        System.out.println("2. using 'new' keyword: " + strNewKeyword);

        // 3. 通过字符数组创建
        char[] charArray = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        String strCharArray = new String(charArray);
        System.out.println("3. char[]: " + strCharArray);


        // 5. 使用`StringBuilder`或`StringBuffer`的`toString`方法
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append("加在这里");
        stringBuilder.insert(1, "插在这里");
        String strFromBuilder = stringBuilder.toString();
        System.out.println("5. sb.toString();" + strFromBuilder);
        stringBuilder.reverse();
        System.out.println("sb reversed" + stringBuilder);

        // 6. 通过字符串连接
        String strConcatenation = "Hello" + ", " + "World!";
        System.out.println("6. concatenation: " + strConcatenation);

        // 7. 使用`format`方法创建格式化字符串
        String formattedString = String.format("The value of pi is %.2f", Math.PI);
        System.out.println("7. Formatted String: " + formattedString);




        String str = "Hello, World!";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.print(ch + " ");
        }
    }
}


