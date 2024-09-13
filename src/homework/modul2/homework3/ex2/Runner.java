package homework.modul2.homework3.ex2;

import homework.modul2.homework3.ex2.fortune.FortuneTelling;
import homework.modul2.homework3.ex2.person.Person;

public class Runner {
    public static void main(String[] args) {
        FortuneTelling<String> chamomile = arg -> arg.length() % 2 == 0;
        FortuneTelling<Person> fortuneteller = person -> (person.getAge() + person.getHeight()) > 210;

        boolean check1 = chamomile.check("Кантимир");
        boolean check2 = chamomile.check("Aleksandr_Chg");
        boolean check3 = fortuneteller.check(new Person(45, 172));
        boolean check4 = fortuneteller.check(new Person(20, 190));
    }
}
