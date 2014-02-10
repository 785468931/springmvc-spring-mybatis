package rugal.mybatis.core.dao;

import rugal.mybatis.TestBase;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rugal.mybatis.core.entity.Student;
import rugal.mybatis.core.mapper.StudentMapper;

/**
 *
 * @author rugal
 */
public class StudentDaoTest extends TestBase
{

    private static final Logger LOG = LoggerFactory.getLogger(StudentDaoTest.class.getName());

    @Autowired
    private StudentMapper studentMapper;

    public StudentDaoTest()
    {
    }

//    /**
//     * Test of selectAll method, of class StudentDao.
//     */
    @Test
    public void testSelectAll()
    {
        System.out.println("selectAll");
        List<Student> result = studentMapper.selectAll();
        LOG.error("Rugal");
        for (Student student : result) {
            System.out.println(student.getName());
        }
    }
//
//    /**
//     * Test of selectById method, of class StudentDao.
//     */

//    @Test
    public void testSelectById()
    {
        System.out.println("selectById");
        String id = "2";
        Student result = studentMapper.findByID(id);
        System.out.println("Rugal Bernstein");
        System.out.println(result.getName());
    }
//    @Test

//    @Test
    public void testSelectByName()
    {
        System.out.println("SelectByName");
        String name = "Rug";
        Student result = studentMapper.findByName(name);
        System.out.println(result.getName());
//        System.out.println(null != result);
    }
//
//    /**
//     * Test of update method, of class StudentDao.
//     */

//    @Test
    public void testUpdate()
    {
        System.out.println("update");
        String id = "1";
        Student bean = studentMapper.findByID(id);
        System.out.println(bean.getName());
        bean.setName("Ryujin Wrath");
        studentMapper.update(bean);
    }
//
//    /**
//     * Test of insert method, of class StudentDao.
//     */

//    @Test
    public void testInsert()
    {
        System.out.println("insert");
        Student bean = new Student();
        bean.setName("Orochi");
        studentMapper.insert(bean);

    }
//
//    /**
//     * Test of delete method, of class StudentDao.
//     */
//    @Test
//    public void testDelete()
//    {
//        System.out.println("delete");
//        String id = "";
//        StudentDao instance = new StudentDao();
//        instance.delete(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
