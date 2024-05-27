package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class SyllabusTest {

    @Test
    void testCreateSyllabus() {
        Syllabus temp = SyllabusMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateSyllabusWithNullValue() {
        Syllabus temp = new Syllabus();
        assertNull(temp.getId());
    }

    @Test
    void testCompareSyllabus() {
        Syllabus temp = SyllabusMother.random();
        Syllabus temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Syllabus syllabus = SyllabusMother.random();
        assertTrue(syllabus.toString().contains(syllabus.getId().toString()));
    }

    @Test
    void testNotCompareSyllabus() {
        Syllabus temp = SyllabusMother.random();
        Syllabus temp2 = SyllabusMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Syllabus syllabus = new Syllabus();

        UUID uuid = UUID.randomUUID();
        syllabus.setId(uuid);
        assertInstanceOf(UUID.class, syllabus.getId());
    }

    @Test
    void testTimestamps() {
        Syllabus syllabus = SyllabusMother.random();
        var syllabusAssert = new WithTimestampsTest<Syllabus>();
        syllabusAssert.assertWithTimestamp(syllabus);

        Syllabus syllabus2 = syllabus;
        syllabusAssert.assertEqualsTimestamps(syllabus, syllabus2);
    }

}
