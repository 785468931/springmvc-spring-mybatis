package rugal.sample.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
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
public interface StudentMapper
{

    String TABLE_NAME = "student";

    @Select("SELECT * FROM " + TABLE_NAME)
    List<Student> selectAll();

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    @Results(value =
    {
        @Result(property = "classRoom", column = "crid", javaType = ClassRoom.class,
                one = @One(select = "rugal.sample.core.mapper.ClassRoomMapper.getByID"))
    })
    Student getByID(Integer id);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE name LIKE '%${name}%' ")
    List<Student> findByName(@Param(value = "name") String name);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE crid = ${crid}")
    List<Student> findByClassRoom(@Param(value = "crid") Integer crid);

    @Update("UPDATE " + TABLE_NAME + " SET name = #{name} WHERE id = #{id}")
    void update(Student bean);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO " + TABLE_NAME + "(name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student bean);
}
