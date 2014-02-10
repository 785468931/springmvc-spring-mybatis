package rugal.mybatis.action;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rugal.mybatis.TestBase;

/**
 *
 * @author Rugal Bernstein
 */
@ContextConfiguration(locations = {"classpath:/springmvc-servlet.xml"})
@WebAppConfiguration
@Ignore
public class ServerSideTestBase extends TestBase
{

    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

}
