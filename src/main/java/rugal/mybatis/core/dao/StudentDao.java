package rugal.mybatis.core.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rugal.mybatis.core.entity.Student;
import rugal.mybatis.core.mapper.StudentMapper;

@Repository
public class StudentDao
{

    @Autowired
    private StudentMapper studentMapper;

    /**
     * Returns the list of all Student instances from the database.
     * <p>
     * @return the list of all Student instances from the database.
     */
    public List<Student> selectAll()
    {
        return studentMapper.selectAll();
    }

    /**
     * Returns a Student instance from the database.
     * <p>
     * @param id primary key value used for lookup.
     * @return A Student instance with a primary key value equals to pk. null if there is no matching row.
     */
    public Student selectById(String id)
    {
        return studentMapper.findByID(id);
    }

    /**
     * Updates an instance of Student in the database.
     * <p>
     * @param contact the instance to be updated.
     */
    public void update(Student contact)
    {
        studentMapper.update(contact);
    }

    /**
     * Insert an instance of Student into the database.
     * <p>
     * @param contact the instance to be persisted.
     */
    public void insert(Student contact)
    {
        studentMapper.insert(contact);
    }

    /**
     * Delete an instance of Student from the database.
     * <p>
     * @param id primary key value of the instance to be deleted.
     */
    public void delete(String id)
    {
        studentMapper.delete(id);
    }
}
