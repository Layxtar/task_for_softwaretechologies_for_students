package org.softwaretechnologies;

public class SugarCofe implements CofeInterface {
    private final CofeInterface baseCofe;

    public SugarCofe(CofeInterface baseCofe) {
        this.baseCofe = baseCofe;
    }

    @Override
    public int getCost() {
        return baseCofe.getCost() + 20;
    }

    @Override
    public String description() {
        return baseCofe.description() + " + sugar";
    }
}
/**
 * Создайте класс MilkCofe, поддерживающий интерфейс CofeIntrface
 * к стоимости базового напитка добавьте 20.
 * к описанию добавьте " + sugar"
 */
