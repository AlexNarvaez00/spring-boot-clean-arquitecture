package mx.edu.itoaxaca.api.v1.teacher.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    void testCreateTeacher() {
        Teacher temp = TeacherMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateTeacherWithNullValue() {
        Teacher temp = new Teacher();
        assertNull(temp.getId());
    }

    @Test
    void testCompareTeacher() {
        Teacher temp = TeacherMother.random();
        Teacher temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Teacher teacher = TeacherMother.random();
        assertTrue(teacher.toString().contains(teacher.getId().toString()));
    }

    @Test
    void testNotCompareTeacher() {
        Teacher temp = TeacherMother.random();
        Teacher temp2 = TeacherMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Teacher teacher = new Teacher();

        UUID uuid = UUID.randomUUID();
        teacher.setId(uuid);
        assertInstanceOf(UUID.class, teacher.getId());
    }

    @Test
    void testTimestamps() {
        Teacher teacher = TeacherMother.random();
        var teacherAssert = new WithTimestampsTest<Teacher>();
        teacherAssert.assertWithTimestamp(teacher);

        Teacher teacher2 = teacher;
        teacherAssert.assertEqualsTimestamps(teacher, teacher2);
    }

}
