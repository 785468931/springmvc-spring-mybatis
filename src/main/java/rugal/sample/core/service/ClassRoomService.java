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
     * @param id
     */
    void deleteById(Integer id);

    /**
     *
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    List<ClassRoom> findByName(String name);

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    ClassRoom getById(Integer id);

    /**
     *
     * @param contact
     */
    void save(ClassRoom contact);

    /**
     *
     * @return
     */
    @Transactional(readOnly = true)
    List<ClassRoom> selectAll();

    /**
     *
     * @param contact
     */
    void update(ClassRoom contact);

}
