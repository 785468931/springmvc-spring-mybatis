package rugal.sample.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import rugal.sample.core.entity.ClassRoom;

/**
 *
 * @author Rugal Bernstein
 */
public interface ClassRoomMapper
{

    String TABLE_NAME = "class_room";

    @Select("SELECT * FROM " + TABLE_NAME)
    List<ClassRoom> selectAll();

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    ClassRoom getByID(Integer id);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE name LIKE '%${name}%' ")
    List<ClassRoom> findByName(@Param(value = "name") String name);

    @Update("UPDATE " + TABLE_NAME + " SET name = #{name} WHERE id = #{id}")
    void update(ClassRoom bean);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO " + TABLE_NAME + "(name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ClassRoom bean);
}
