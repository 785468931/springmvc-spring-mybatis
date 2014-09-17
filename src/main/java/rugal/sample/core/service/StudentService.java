package rugal.sample.core.service;

import java.util.List;
import rugal.sample.core.entity.Student;

/**
 *
 * @author Rugal Bernstein
 */
public interface StudentService
{

    /**
     * Delete an instance of Student from the database.
     * <p>
     * @param id primary key value of the instance to be deleted.
     */
    void deleteById(Integer id);

    /**
     * Insert an instance of Student into the database.
     * <p>
     * @param contact the instance to be persisted.
     */
    void save(Student contact);

    /**
     * Returns the list of all Student instances from the database.
     * <p>
     * @return the list of all Student instances from the database.
     */
    List<Student> selectAll();

    /**
     * Returns a Student instance from the database.
     * <p>
     * @param id primary key value used for lookup.
     * @return A Student instance with a primary key value equals to pk. null if there is no matching row.
     */
    Student getById(Integer id);

    /**
     * Updates an instance of Student in the database.
     * <p>
     * @param contact the instance to be updated.
     */
    void update(Student contact);

    /**
     *
     * @param name
     * @return
     */
    List<Student> findByName(String name);

    /**
     *
     * @param id
     * @return
     */
    List<Student> findByClassRoom(Integer id);

}
