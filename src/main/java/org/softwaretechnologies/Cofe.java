package org.softwaretechnologies;

public class Cofe implements CofeInterface {
    private static final int BASE_COST = 50;
    private static final String BASE_DESCRIPTION = "only cofe";

    @Override
    public int getCost() {
        return BASE_COST;
    }

    @Override
    public String description() {
        return BASE_DESCRIPTION;
    }
}
/**
 * Создайте класс Cofe, поддерживающий интерфейс CofeIntrface
 * стоимость базового напитка равна 50.
 * описание "only cofe"
 */

