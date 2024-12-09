package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Integer.MAX_VALUE;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Money равны, если одинаковый тип валют и одинаковое число денег до 4 знака после запятой.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @param o объект для сравнения
     * @return true - равно, false - иначе
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        if (type != money.type) return false;
        if (amount == null || money.amount == null) return amount == money.amount;
        BigDecimal thisScaled = amount.setScale(4, RoundingMode.HALF_UP);
        BigDecimal otherScaled = money.amount.setScale(4, RoundingMode.HALF_UP);
        return thisScaled.equals(otherScaled);
    }

    /**
     * Формула:
     * (Если amount null 10000, иначе количество денег округленные до 4х знаков * 10000) + :
     * если USD , то 1
     * если EURO, то 2
     * если RUB, то 3
     * если KRONA, то 4
     * если null, то 5
     * Если amount округленный до 4х знаков * 10000 >= (Integer.MaxValue - 5), то хеш равен Integer.MaxValue
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @return хеш код по указанной формуле
     */
    @Override
    public int hashCode() {
        int typeHash = switch (type) {
            case USD -> 1;
            case EURO -> 2;
            case RUB -> 3;
            case KRONA -> 4;
            default -> 5; // Если type == null
        };
        if (amount == null) {
            return 10000 + typeHash;
        }
        BigDecimal scaledAmount = amount.setScale(4, RoundingMode.HALF_UP);
        long scaledValue = scaledAmount.multiply(BigDecimal.valueOf(10000)).longValue();
        if (scaledValue >= (long) MAX_VALUE - 5) {
            return MAX_VALUE;
        }
        return (int) scaledValue + typeHash;
    }

    /**
     * Верните строку в формате
     * Тип_ВАЛЮТЫ: количество.XXXX
     * Тип_валюты: USD, EURO, RUB или KRONA
     * количество.XXXX - округленный amount до 4х знаков.
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Если тип валюты null, то вернуть:
     * null: количество.XXXX
     * Если количество денег null, то вернуть:
     * Тип_ВАЛЮТЫ: null
     * Если и то и то null, то вернуть:
     * null: null
     *
     * @return приведение к строке по указанному формату.
     */
    @Override
    public String toString() {
        String typeString = (type == null) ? "null" : type.toString();
        String amountString = (amount == null) ? "null" : amount.setScale(4, RoundingMode.HALF_UP).toString();
        return typeString + ": " + amountString;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyType getType() {
        return type;
    }

    public static void main(String[] args) {
        Money money = new Money(MoneyType.EURO, BigDecimal.valueOf(10.00012));
        Money money1 = new Money(MoneyType.USD, BigDecimal.valueOf(10.5000));
        System.out.println(money1.toString());
        System.out.println(money1.hashCode());
        System.out.println(money.equals(money1));
    }
}

