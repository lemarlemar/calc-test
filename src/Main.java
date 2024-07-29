import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc (input));
        scanner.close();
    }

    private static String calc (String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Строка не является   математической операцией");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Операнды должны быть в диапазоне от 1 до 10");
        }

        char operation = parts[1].charAt(0);
        switch (operation) {
            case '+':
                return Integer.toString(a + b) ;
            case '-':
                return Integer.toString(a - b);
            case '*':
                return Integer.toString(a * b);
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return Integer.toString(Math.floorDiv(a, b));
            default:
                throw new IllegalArgumentException("Неправильный оператор");
        }
    }
}
