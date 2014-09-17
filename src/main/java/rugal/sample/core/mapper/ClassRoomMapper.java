package rugal.sample.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import rugal.sample.core.entity.ClassRoom;
import rugal.sample.core.entity.Student;

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
    @Results(value =
    {
        @Result(id = true, property = "id", column = "crid", javaType = Integer.class),
        @Result(property = "name", column = "name", javaType = String.class),
        @Result(property = "students", column = "crid", javaType = Student.class, many = @Many(
                select = "rugal.sample.core.mapper.StudentMapper.findByClassRoom"))
    })
    @Many
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
