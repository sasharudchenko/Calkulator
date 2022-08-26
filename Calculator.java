import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static int num1;
    public static int num2;
    public static char oper;
    public static String op;
    public static int res;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение от 1 до 10 или от I до X:");
        Scanner s = new Scanner(System.in);
        String virajenie = s.nextLine();

        String[] array = virajenie.split(" ");
        for (int i = 0; i < array.length; i++) {
            try {
                op = array[1].trim();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
            char znak1 = op.charAt(0);
            if (znak1 == ('+')) {
                oper = '+';
            } else if (znak1 == ('-')) {
                oper = '-';
            } else if (znak1 == ('/')) {
                oper = '/';
            } else if (znak1 == ('*')) {
                oper = '*';
            }

        }
        String s1 = array[0].trim();
        String s2 = array[2].trim();
        if (!s1.equals(null) && s2.equals(null)) {
            throw new ArrayIndexOutOfBoundsException("throws Exception //т.к. строка не является математической операцией");
        }

        try {
            String s3 = array[3];
            String s4 = array[4];
            if (s3 != null || s4 != null) {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два" +
                        "операнда и один оператор (+, -, /, *)");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        if (s1.equals("I") || s1.equals("II") || s1.equals("III") || s1.equals("IV") || s1.equals("V") || s1.equals("VI") || s1.equals("VII")
                || s1.equals("VIII") || s1.equals("IX") || s1.equals("X") || s2.equals("I") || s2.equals("II") || s2.equals("III")
                || s2.equals("IV") || s2.equals("V") || s2.equals("VI") || s2.equals("VII") || s2.equals("VIII") || s2.equals("IX")
                || s2.equals("X")) {
            num1 = romanNum(s1);

            num2 = romanNum(s2);

            res = znakOperacii(num1, num2, oper);
            String resRom = convertRomInArab(res);
            try {
                System.out.println("Результат для римских чисел:\n" + convertRomInArab(num1) + " " + oper + " " + convertRomInArab(num2) + " " + "=" + " " + resRom);
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArrayIndexOutOfBoundsException("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        } else {


            try {
                num1 = Integer.parseInt(array[0].trim());
                num2 = Integer.parseInt(array[2].trim());

            } catch (Exception ex) {
            }
            try {
                if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
                    throw new InputMismatchException("Можно ввести числа от 1 до 10");
                }
            } catch (Exception ex) {
                throw new Exception("Можно ввести арабские числа от 1 до 10 или римские числа от I до X");

            }
            res = (znakOperacii(num1, num2, oper));


            System.out.println("Результат для арабских чисел:\n" + num1 + " " + oper + " " + num2 + " " + "=" + " " + res);
        }
    }

    public static int znakOperacii(int num1, int num2, char znak) throws Exception {
        int result = 0;
        switch (znak) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }

    public static String convertRomInArab(int arab) throws ArrayIndexOutOfBoundsException {
        String[] roman = new String[]{
                "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        try {
            String str = roman[arab];
            return str;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
    }

    public static int romanNum(String roman) throws Exception {


        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (IllegalArgumentException ex) {
            throw new Exception("Можно ввести арабские числа от 1 до 10 или римские от I до X");
        }

        return -1;

    }
}
