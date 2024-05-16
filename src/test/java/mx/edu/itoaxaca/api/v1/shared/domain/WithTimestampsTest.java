package mx.edu.itoaxaca.api.v1.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class WithTimestampsTest<T extends WithTimestamps> {

    public void assertWithTimestamp(T withTimestamps) {
        CreatedAt createdAt = CreatedAtMother.random();
        withTimestamps.setCreatedAt(createdAt);
        assertEquals(createdAt.toString(), withTimestamps.getCreatedAt().toString());

        UpdatedAt updatedAt = UpdatedAtMother.random();
        withTimestamps.setUpdateAt(updatedAt);
        assertEquals(updatedAt.toString(), withTimestamps.getUpdateAt().toString());
    
        DeletedAt deletedAt = DeletedAtMother.random();
        withTimestamps.setDeletedAt(deletedAt);
        assertEquals(deletedAt.toString(), withTimestamps.getDeletedAt().toString());

        assertInstanceOf(Integer.class, withTimestamps.hashCode());
    }

    public void assertEqualsTimestamps(T withTimestamps,T withTimestamps2){
        assertEquals(withTimestamps, withTimestamps2);
    }
}
