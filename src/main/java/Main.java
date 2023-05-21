import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        choiceTaxSystem();
        System.out.println("Работа программы завершена!");
    }

    public static void choiceTaxSystem() {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;

        while (true) {
            printText();
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Введите сумму дохода");
                    earnings += Integer.parseInt(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Введите сумму расхода");
                    spendings += Integer.parseInt(scanner.nextLine());
                    break;

                case 3:
                    int tax15 = TaxSystem.taxEarningsMinusSpendings(earnings, spendings);
                    int tax6 = TaxSystem.taxEarnings(earnings);
                    int result = TaxSystem.compareTax(tax15, tax6);

                    if (result == -1) {
                        System.out.println("Мы советуем Вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax15 + " рублей");
                        System.out.println("Налог на другой системе: " + tax6 + " рублей");
                        System.out.println("Ваша экономия: " + (tax6 - tax15) + " рублей");
                        System.out.println();
                    } else if (result == 1) {
                        System.out.println("Мы советуем Вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax6 + " рублей");
                        System.out.println("Налог на другой системе: " + tax15 + " рублей");
                        System.out.println("Ваша экономия: " + (tax15 - tax6) + " рублей");
                        System.out.println();
                    } else {
                        System.out.println("Налоги на обоих системах равны");
                        System.out.println("Вы можете выбрать любую ситему налогобложения");
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static void printText() {
        System.out.println("Выберите операцию и введите ее номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
        System.out.println("Для завершения работы программы введите end");
    }
}