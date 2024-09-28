package homework.modul2.homework5.ex1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Вор
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws IllegalAccessException,
            NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = bank.getClass();
        Field field = clazz.getDeclaredField("money");
        field.setAccessible(true);
        BigDecimal valueBefore = (BigDecimal) field.get(bank);
        this.money = this.money.add(valueBefore);
        Method method = clazz.getDeclaredMethod("setMoney", BigDecimal.class);
        method.setAccessible(true);
        method.invoke(bank, BigDecimal.ZERO);
        BigDecimal valueAfter = (BigDecimal) field.get(bank);
    }

    @Override
    public String toString() {
        return "Thief{" +
               "money=" + money +
               '}';
    }
}
