import java.util.Scanner;
public class Cal {
    public static void main(String[] ard) {
        //1 + 1
        //V - VII
            Converter converter = new Converter();
            String[] actions = {" + ", " - ", " / ", " * "};
            String[] regexActions = {" \\+ ", " - ", " / ", " \\* "};
            Scanner scn = new Scanner(System.in);
            System.out.print("Введите вырожение: ");
            String exp = scn.nextLine();
            //Арифметические действие:
            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }
            // Если не нашли арифметического действия, то завершаем программу
            if (actionIndex == -1) {
                System.out.println("Некоректное вырожение");
                return;
            }
            //"2 - 4".split("-")-> {"2", "4"}
            String[] data = exp.split(regexActions[actionIndex]);
            // Определяем находится ли числа в одной форме
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;
                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);
                } else {
                    // Конвертируем арабские числа из строки в число
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                // Выполняем с числами арифметическое действие
                int result = 0;
                switch (actions[actionIndex]) {
                    case " + ":
                        result = a + b;
                        break;
                    case " - ":
                        result = a - b;
                        break;
                    case " * ":
                        result = a * b;
                        break;
                    case " / ":
                        result = a / b;
                        break;
                    default:
                }
                    // Если число римское, то конвертируем его в арабское
                if (isRoman) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    // Если число было арабским, возвращаем результат в арабском числе
                    System.out.println(result);
                }
            } else {
                System.out.println("Числа должны быть в одном формате");
            }
        }
}

