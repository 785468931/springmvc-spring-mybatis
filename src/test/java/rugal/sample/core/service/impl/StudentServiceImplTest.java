package rugal.sample.core.service.impl;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import rugal.JUnitSpringTestBase;
import rugal.sample.core.entity.Student;
import rugal.sample.core.service.ClassRoomService;
import rugal.sample.core.service.StudentService;

/**
 *
 * @author rugal
 */
public class StudentServiceImplTest extends JUnitSpringTestBase {

    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private StudentService studentService;

    public StudentServiceImplTest() {
    }

    @Test
    @Ignore
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer id = 3;
        studentService.deleteById(id);
    }

    @Test
    @Ignore
    public void testGetById() {
        System.out.println("findById");
        Integer id = 2;
        Student bean = studentService.getById(id);
        System.out.println(bean.getName());
        System.out.println(bean.getClassRoom().getName());

    }

    @Test
    @Ignore
    public void testFindByClassRoom() {
        System.out.println("findByClassRoom");
        Integer id = 1;
        List<Student> beans = studentService.findByClassRoom(id);
        beans.stream().forEach((bean) -> {
            System.out.println(bean.getName());
        });
    }

    @Test
    @Ignore
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Ru";
        List<Student> beans = studentService.findByName(name);
        System.out.println(beans.size());
    }

    @Test
    @Ignore
    public void testSave() {
        System.out.println("save");
        Student bean = new Student();
        bean.setClassRoom(classRoomService.getById(1));
        bean.setName("Tenjin Descend");
        studentService.save(bean);
    }

    @Test
    @Ignore
    public void testUpdate() {
        System.out.println("update");
        Student bean = studentService.getById(4);
        bean.setName("Ryujin Wrath");
        studentService.update(bean);
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    @Transactional
    public void testTransation() {
        System.out.println("save");
        Student bean = new Student();
        bean.setName("Tenjin Descend");
        studentService.save(bean);
        studentService.getById(1);
    }
}
