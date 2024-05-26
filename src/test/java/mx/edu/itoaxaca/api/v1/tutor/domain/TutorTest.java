package mx.edu.itoaxaca.api.v1.tutor.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class TutorTest {

    @Test
    void testCreateTutor() {
        Tutor temp = TutorMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateTutorWithNullValue() {
        Tutor temp = new Tutor();
        assertNull(temp.getId());
    }

    @Test
    void testCompareTutor() {
        Tutor temp = TutorMother.random();
        Tutor temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Tutor tutor = TutorMother.random();
        assertTrue(tutor.toString().contains(tutor.getId().toString()));
    }

    @Test
    void testNotCompareTutor() {
        Tutor temp = TutorMother.random();
        Tutor temp2 = TutorMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Tutor tutor = new Tutor();

        UUID uuid = UUID.randomUUID();
        tutor.setId(uuid);
        assertInstanceOf(UUID.class, tutor.getId());
    }

    @Test
    void testTimestamps() {
        Tutor tutor = TutorMother.random();
        var tutorAssert = new WithTimestampsTest<Tutor>();
        tutorAssert.assertWithTimestamp(tutor);

        Tutor tutor2 = tutor;
        tutorAssert.assertEqualsTimestamps(tutor, tutor2);
    }

}
