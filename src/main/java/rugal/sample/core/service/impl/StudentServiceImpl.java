package rugal.sample.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rugal.sample.core.entity.Student;
import rugal.sample.core.mapper.StudentMapper;
import rugal.sample.core.service.StudentService;

@Repository
@Transactional
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private StudentMapper studentMapper;

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> selectAll()
    {
        return studentMapper.selectAll();
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public Student getById(Integer id)
    {
//        throw new RuntimeException();//This is for rollback test
        return studentMapper.getByID(id);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> findByClassRoom(Integer id)
    {
//        throw new RuntimeException();//This is for rollback test
        return studentMapper.findByClassRoom(id);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void update(Student contact)
    {
        studentMapper.update(contact);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void save(Student contact)
    {
        studentMapper.insert(contact);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void deleteById(Integer id)
    {
        studentMapper.delete(id);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> findByName(String name)
    {
        return studentMapper.findByName(name);
    }
}
