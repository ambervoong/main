package seedu.address.model.entity.worker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class WorkerIdentificationNumberTest {

    @Test
    public void constructorWorkerId_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new WorkerIdentificationNumber(null));
    }

    @Test
    public void constructorWorkerId_emptyString_throwsIllegalArgumentException() {
        String invalidId = "";

        assertThrows(IllegalArgumentException.class, () -> new WorkerIdentificationNumber(invalidId));
    }

    @Test
    public void constructorWorkerId_onlySpaces_throwsIllegalArgumentException() {
        String invalidId = "    ";

        assertThrows(IllegalArgumentException.class, () -> new WorkerIdentificationNumber(invalidId));
    }

    @Test
    public void constructorWorkerIdentificationNumber_invalidWorkerId_throwsIllegalArgumentException() {
        String invalidId = "D00000";

        assertThrows(IllegalArgumentException.class, () -> new WorkerIdentificationNumber(invalidId));
    }

    @Test
    void getIdentificationNumber_true() {
        WorkerIdentificationNumber testId = new WorkerIdentificationNumber("W00001");
        assertEquals("W00001", testId.getIdentificationNumber());
    }

    @Test
    void testEquals_self_true() {
        WorkerIdentificationNumber testId = new WorkerIdentificationNumber("W00001");
        WorkerIdentificationNumber otherId = new WorkerIdentificationNumber("W00001");
        assertEquals(testId, testId);
        assertEquals(testId, otherId);
        assertEquals(testId.hashCode(), otherId.hashCode());
    }

    @Test
    void testEquals_differentAndNull_notEqual() {
        WorkerIdentificationNumber testId = new WorkerIdentificationNumber("W00001");
        assertNotEquals(testId, new WorkerIdentificationNumber("W07001"));
        assertNotEquals(testId, null);
    }

    @Test
    void isValidIdentificationNumber() {
        // Null WorkerIdentificationNumber
        assertThrows(NullPointerException.class, () -> WorkerIdentificationNumber.isValidIdentificationNumber(null));

        // Invalid WorkerIdentificationNumbers
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber("")); // empty string
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber(" ")); // spaces only
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber("W34")); // Not enough digits
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber("W34bp2")); // Alphabets in number.
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber("M12278")); // Invalid starting digit
        assertFalse(WorkerIdentificationNumber.isValidIdentificationNumber("@#*(^")); // Not digit

        // Valid WorkerIdentificationNumbers
        assertTrue(WorkerIdentificationNumber.isValidIdentificationNumber("W00004"));
        assertTrue(WorkerIdentificationNumber.isValidIdentificationNumber("W00304"));
        assertTrue(WorkerIdentificationNumber.isValidIdentificationNumber("W09004"));

    }

}
