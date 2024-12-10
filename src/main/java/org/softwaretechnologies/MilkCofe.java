package org.softwaretechnologies;

public class MilkCofe implements CofeInterface {
    private final CofeInterface baseCofe;

    public MilkCofe(CofeInterface baseCofe) {
        this.baseCofe = baseCofe;
    }

    @Override
    public int getCost() {
        return baseCofe.getCost() + 10;
    }

    @Override
    public String description() {
        return baseCofe.description() + " + milk";
    }
}
/**
 * Создайте класс MilkCofe, поддерживающий интерфейс CofeIntrface
 * к стоимости базового напитка добавьте 10.
 * к описанию добавьте " + milk"
 */
