package rugal.sample.core.entity;

/**
 *
 * @author Rugal Bernstein
 */
public class Student {

    public static final String TABLE_NAME = "student";

    private Integer id;

    private String name;

    private ClassRoom classRoom;

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

}
