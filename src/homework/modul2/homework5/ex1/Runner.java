package homework.modul2.homework5.ex1;

import java.lang.reflect.*;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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

        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> constructorBank = bankClass.getDeclaredConstructor(BigDecimal.class);
        constructorBank.setAccessible(true);
        Bank bank = constructorBank.newInstance(new BigDecimal(1500));

        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> constructorThief = thiefClass.getDeclaredConstructor();
        constructorThief.setAccessible(true);
        Thief thief = constructorThief.newInstance();
        Method methodThief = null;
        for (Method method : thiefClass.getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().equals("stealMoney")) {
                methodThief = method;
                System.out.println("ифчик " + methodThief);
            }
        }
        methodThief.invoke(thief, bank);
        System.out.println(bank);
        System.out.println(thief);
    }
}
