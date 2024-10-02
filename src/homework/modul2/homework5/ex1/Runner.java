package homework.modul2.homework5.ex1;

import java.lang.reflect.*;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //Запрещено изменять модификаторы доступа!
        //Практически все будет через рефлексию
        //Создать банк с 1500 денег
        //Создать вора
        //Дописать метод stealMoney у вора так, чтобы он крал все деньги из банка себе
        //(увеличивал у себя деньги и обнулял деньги банка)
        //Вызвать здесь метод stealMoney
        //Распечатать вора и банк

        //Итог:
        //Вор - 1500 денег
        //Банк - 0 денег

        Bank bank = createBank(new BigDecimal(1500));
        Thief thief = createThief();
        takeMoney(bank, thief);

        System.out.println(bank);
        System.out.println(thief);
    }

    /**
     * Создаем свой банк
     */
    public static Bank createBank(BigDecimal money)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> constructorBank = bankClass.getDeclaredConstructor(BigDecimal.class);
        constructorBank.setAccessible(true);
        return constructorBank.newInstance(money);
    }

    /**
     * Создаем своего вора
     */
    public static Thief createThief()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> constructorThief = thiefClass.getDeclaredConstructor();
        constructorThief.setAccessible(true);
        return constructorThief.newInstance();
    }

    /**
     * Получаем доступ к методу вора "стянуть деньги" и используем его
     */
    public static void takeMoney(Bank bank, Thief thief)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Thief> thiefClass = Thief.class;
        Method methodThief = thiefClass.getDeclaredMethod("stealMoney", Bank.class);
        methodThief.setAccessible(true);
        methodThief.invoke(thief, bank);
    }
}
