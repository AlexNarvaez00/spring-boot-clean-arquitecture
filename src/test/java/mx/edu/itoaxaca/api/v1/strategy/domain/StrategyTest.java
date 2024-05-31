package mx.edu.itoaxaca.api.v1.strategy.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    @Test
    void testCreateStrategy() {
        Strategy temp = StrategyMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateStrategyWithNullValue() {
        Strategy temp = new Strategy();
        assertNull(temp.getId());
    }

    @Test
    void testCompareStrategy() {
        Strategy temp = StrategyMother.random();
        Strategy temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Strategy strategy = StrategyMother.random();
        assertTrue(strategy.toString().contains(strategy.getId().toString()));
    }

    @Test
    void testNotCompareStrategy() {
        Strategy temp = StrategyMother.random();
        Strategy temp2 = StrategyMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Strategy strategy = new Strategy();

        UUID uuid = UUID.randomUUID();
        strategy.setId(uuid);
        assertInstanceOf(UUID.class, strategy.getId());
    }

    @Test
    void testTimestamps() {
        Strategy strategy = StrategyMother.random();
        var strategyAssert = new WithTimestampsTest<Strategy>();
        strategyAssert.assertWithTimestamp(strategy);

        Strategy strategy2 = strategy;
        strategyAssert.assertEqualsTimestamps(strategy, strategy2);
    }

}
