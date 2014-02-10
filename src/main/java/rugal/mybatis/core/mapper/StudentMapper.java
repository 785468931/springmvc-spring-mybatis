package rugal.mybatis.core.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import rugal.mybatis.core.entity.Student;

/**
 *
 * @author Rugal Bernstein
 */
public interface StudentMapper
{

    @Select("SELECT * FROM student")
    List<Student> selectAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findByID(String id);

    @Select("SELECT * FROM student WHERE name like concat(#{name},'%')")
    Student findByName(String name);

    @Update("UPDATE student SET name = #{name} WHERE id = #{id}")
    void update(Student bean);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(String id);

    @Insert("INSERT INTO student (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student bean);
}
