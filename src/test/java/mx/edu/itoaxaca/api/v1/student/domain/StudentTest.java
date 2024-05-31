package mx.edu.itoaxaca.api.v1.student.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    void testCreateStudent() {
        Student temp = StudentMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateStudentWithNullValue() {
        Student temp = new Student();
        assertNull(temp.getId());
    }

    @Test
    void testCompareStudent() {
        Student temp = StudentMother.random();
        Student temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Student student = StudentMother.random();
        assertTrue(student.toString().contains(student.getId().toString()));
    }

    @Test
    void testNotCompareStudent() {
        Student temp = StudentMother.random();
        Student temp2 = StudentMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Student student = new Student();

        UUID uuid = UUID.randomUUID();
        student.setId(uuid);
        assertInstanceOf(UUID.class, student.getId());
    }

    @Test
    void testTimestamps() {
        Student student = StudentMother.random();
        var studentAssert = new WithTimestampsTest<Student>();
        studentAssert.assertWithTimestamp(student);

        Student student2 = student;
        studentAssert.assertEqualsTimestamps(student, student2);
    }

}
