package rugal.sample.core.service.impl;

import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import rugal.JUnitSpringTestBase;
import rugal.sample.core.entity.ClassRoom;
import rugal.sample.core.service.ClassRoomService;

/**
 *
 * @author rugal
 */
public class ClassRoomServiceImplTest extends JUnitSpringTestBase {

    @Autowired
    private ClassRoomService service;

    public ClassRoomServiceImplTest() {
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        Integer id = 1;
        ClassRoom result = service.getById(id);
        System.out.println(result.getStudents().size());
    }

    @Test
    @Ignore
    public void testSave() {
        System.out.println("save");
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("Computer Science");
        service.save(classRoom);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer id = null;
        ClassRoomServiceImpl instance = new ClassRoomServiceImpl();
        instance.deleteById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Computer";
        List<ClassRoom> list = service.findByName(name);
        System.out.println(list.size());
    }

}
