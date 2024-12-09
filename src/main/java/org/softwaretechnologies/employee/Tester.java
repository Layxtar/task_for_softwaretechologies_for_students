package org.softwaretechnologies.employee;

import java.time.YearMonth;

public class Tester extends Employee {
    public Tester(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getMonthSalary(int month) {
        int daysInMonth = YearMonth.of(java.time.LocalDate.now().getYear(), month).lengthOfMonth();
        return baseSalary * daysInMonth;
    }
}
