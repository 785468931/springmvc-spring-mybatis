package rugal.mybatis.action;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import rugal.mybatis.TestBase;

/**
 *
 * @author Rugal Bernstein
 */
@ContextConfiguration(locations = {"classpath:/springmvc-servlet.xml"})
@Ignore
public class MockTestBase extends TestBase
{

    @Autowired
    public RequestMappingHandlerAdapter handlerAdapter;

    public MockHttpServletRequest request;

    public MockHttpServletResponse response;

    @Before
    public void before()
    {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

}
