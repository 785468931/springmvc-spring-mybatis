package rugal.sample.core.service.impl;

import rugal.sample.core.service.ClassRoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rugal.sample.core.entity.ClassRoom;
import rugal.sample.core.mapper.ClassRoomMapper;

@Repository
@Transactional
public class ClassRoomServiceImpl implements ClassRoomService
{

    @Autowired
    private ClassRoomMapper classRoomMapper;

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClassRoom> selectAll()
    {
        return classRoomMapper.selectAll();
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public ClassRoom getById(Integer id)
    {
//        throw new RuntimeException();//This is for rollback test
        return classRoomMapper.getByID(id);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void update(ClassRoom contact)
    {
        classRoomMapper.update(contact);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void save(ClassRoom contact)
    {
        classRoomMapper.insert(contact);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    public void deleteById(Integer id)
    {
        classRoomMapper.delete(id);
    }

    /**
     *
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClassRoom> findByName(String name)
    {
        return classRoomMapper.findByName(name);
    }
}
