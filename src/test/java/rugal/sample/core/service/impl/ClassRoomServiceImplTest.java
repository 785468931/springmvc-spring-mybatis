package rugal.sample.core.service.impl;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import rugal.JUnitSpringTestBase;
import rugal.sample.core.entity.ClassRoom;
import rugal.sample.core.service.ClassRoomService;

/**
 *
 * @author rugal
 */
public class ClassRoomServiceImplTest extends JUnitSpringTestBase
{

    @Autowired
    private ClassRoomService service;

    public ClassRoomServiceImplTest()
    {
    }

    @Test
    public void testGetById()
    {
        System.out.println("getById");
        Integer id = 1;
        ClassRoom result = service.getById(id);
//        System.out.println(result.getStudents().size());
    }

//    @Test
    public void testSave()
    {
        System.out.println("save");
        ClassRoom contact = null;
        ClassRoomServiceImpl instance = new ClassRoomServiceImpl();
        instance.save(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    @Test
    public void testDeleteById()
    {
        System.out.println("deleteById");
        Integer id = null;
        ClassRoomServiceImpl instance = new ClassRoomServiceImpl();
        instance.deleteById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    @Test
    public void testFindByName()
    {
        System.out.println("findByName");
        String name = "";
        ClassRoomServiceImpl instance = new ClassRoomServiceImpl();
        List<ClassRoom> expResult = null;
        List<ClassRoom> result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
