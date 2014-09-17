package rugal.sample.core.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import rugal.sample.core.entity.ClassRoom;

/**
 *
 * @author Rugal Bernstein
 */
public interface ClassRoomService
{

    /**
     *
     * {@inheritDoc }
     */
    void deleteById(Integer id);

    /**
     *
     * {@inheritDoc }
     */
    @Transactional(readOnly = true)
    List<ClassRoom> findByName(String name);

    /**
     *
     * {@inheritDoc }
     */
    @Transactional(readOnly = true)
    ClassRoom getById(Integer id);

    /**
     *
     * {@inheritDoc }
     */
    void save(ClassRoom contact);

    /**
     *
     * {@inheritDoc }
     */
    @Transactional(readOnly = true)
    List<ClassRoom> selectAll();

    /**
     *
     * {@inheritDoc }
     */
    void update(ClassRoom contact);

}
