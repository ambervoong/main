package seedu.address.model.entity.worker;

import seedu.address.model.entity.PhoneNumber;
import seedu.address.model.entity.Sex;
import seedu.address.model.person.Name;

/**
 * Represents a Worker in Mortago.
 * Guarantees: name, sex, dateOfBirth, dateJoined, and designation are guaranteed to be present.
 */
public class Worker {
    private final Name name;     // NOTE: Name details not yet finalised.
    private final Sex sex;
    private final String dateOfBirth;  // NOTE: Date details not yet finalised.
    private final String dateJoined;
    private WorkerIdentificationNumber workerIdentificationNumber;
    private PhoneNumber phoneNumber;
    private Designation designation;
    private EmploymentStatus employmentStatus;

    public Worker(Name name, Sex sex, String dateOfBirth, String dateJoined, Designation designation) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
        this.designation = designation;
    }
}
