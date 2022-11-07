import java.util.Scanner;

import static java.lang.String.valueOf;

public class Calculator {
    public static void main(String[] args) throws ScanExc {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner scanner = new Scanner((System.in));
        System.out.println("Введите выражение, состоящее из двух натуральных чисел, в арабской или римской системе счисления" +
                " от 1 до 10 включительно и знака операции (+,-,*,/) между ними.\n" +
                "Пример: 2+2.\n" +
                "Пример: II-I.\n" +
                "Нельзя использовать арабские и римские цифры вместе!\n");
        String expression = scanner.nextLine();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (expression.contains(actions[i])) {
                actionIndex = i;

            }
        }

        if (actionIndex == -1) {
            throw new ArrayIndexOutOfBoundsException("Некорректное выражение");
        }


        String[] data = expression.split(regexActions[actionIndex]);
        if (data.length > 2) {
            throw new ArrayIndexOutOfBoundsException("Некорректное выражение");
        }


        boolean isRoman;
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;

            isRoman = converter.isRoman(data[0]);

            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if (a > 10 || b > 10) {
                throw new ScanExc("Некорректное выражение");
            }

            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                if(result > 0) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    throw new NullPointerException("Если выражение записано в римской системе счисления, ответ должен быть больше 0)");
                }
            } else {
                System.out.println(result);
            }
        } else {
            throw new ScanExc("Разные системы счисления");
        }
    }
}
