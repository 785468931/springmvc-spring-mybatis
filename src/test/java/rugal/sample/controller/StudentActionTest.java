package rugal.sample.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import rugal.ControllerClientSideTestBase;

/**
 *
 * @author rugal
 */
public class StudentActionTest extends ControllerClientSideTestBase
{

    @Autowired
    private StudentController studentAction;

    public StudentActionTest()
    {
    }

    @Test
    public void testRegisterStudent() throws Exception
    {
        System.out.println("registerStudent");
        this.mockMvc.perform(post("/student")
            .content("{\"id\":\"3\",\"name\":\"tenjin\",\"age\":\"23\"}")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        System.out.println("Rugal Bernstein");
    }

}
