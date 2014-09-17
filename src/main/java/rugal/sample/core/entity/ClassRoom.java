package rugal.sample.core.entity;

import java.util.List;

/**
 *
 * @author Rugal Bernstein
 */
public class ClassRoom
{

    private Integer id;

    private String name;

    List<Student> students;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
}
