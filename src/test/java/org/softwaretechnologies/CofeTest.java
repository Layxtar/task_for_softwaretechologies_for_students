package org.softwaretechnologies;
import org.junit.jupiter.api.Test;
import org.softwaretechnologies.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CofeTest {
    @Test
    void costCofeWithMilk() {
        CofeInterface cofe = new MilkCofe(new Cofe());
        assertEquals(cofe.getCost(),60);

    }
    @Test
    void costCofeWithMilkSugar() {
        CofeInterface cofe =new SugarCofe(new MilkCofe(new Cofe()));
        assertEquals(cofe.getCost(),80);

    }
}
