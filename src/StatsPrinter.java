import java.math.BigDecimal;

public class StatsPrinter {

    public static void print(Stats s, boolean full) {
        if (full) {
            System.out.println("Полная статистика");
            System.out.printf("Целые: %d%n", s.intCount);
            if (s.intCount > 0) {
                System.out.printf("Минимальное: %s%n", s.intMin);
                System.out.printf("Максимальное: %s%n", s.intMax);
                System.out.printf("Сумма: %s%n", s.intSum);
                System.out.printf("Среднее: %s%n",
                        new BigDecimal(s.intSum).divide(BigDecimal.valueOf(s.intCount), 10, BigDecimal.ROUND_HALF_UP));
            }
            System.out.printf("Вещественные: %d%n", s.floatCount);
            if (s.floatCount > 0) {
                System.out.printf("Минимальное: %s%n", s.floatMin);
                System.out.printf("Максимальное: %s%n", s.floatMax);
                System.out.printf("Сумма: %s%n", s.floatSum);
                System.out.printf("Среднее: %s%n",
                        s.floatSum.divide(BigDecimal.valueOf(s.floatCount), 10, BigDecimal.ROUND_HALF_UP));
            }
            System.out.printf("Строки: %d%n", s.strCount);
            if (s.strCount > 0) {
                System.out.printf("Самая короткая: %d%n", s.strMinLen);
                System.out.printf("Самая длинная: %d%n", s.strMaxLen);
            }
        } else {
            System.out.println("Краткая статистика");
            System.out.printf("Целые: %d%n", s.intCount);
            System.out.printf("Вещественные: %d%n", s.floatCount);
            System.out.printf("Строки: %d%n", s.strCount);
        }
    }
}
