package rugal.mybatis.action;

import java.util.HashMap;
import org.junit.Test;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rugal
 */
public class TestActionTest extends MockTestBase
{

    @Autowired
    private TestAction testAction;

    @Test
    public void parameterTest()
    {
        // do with method like public String findOwner(@PathVariable String ownerId, Model model)
        request.setMethod(HttpMethod.GET.name());
        ModelAndView mv = null;

        Class<?>[] parameterTypes = new Class<?>[0];
        try {
            mv = handlerAdapter.handle(request, response, new HandlerMethod(testAction, "index", parameterTypes));
            System.out.println("Rugal Bernstein");
        } catch (NoSuchMethodException ex) {
            getLogger(TestActionTest.class.getName()).error(null, ex);
        } catch (Exception ex) {
            getLogger(TestActionTest.class.getName()).error(null, ex);
        }
    }

//    @Test
    public void pathVariableTest()
    {
        // do with method like public String findOwner(@PathVariable String ownerId, Model model)
        request.setMethod(HttpMethod.GET.name());
        ModelAndView mv = null;

        HashMap<String, String> pathVariablesMap = new HashMap<>(5);
        pathVariablesMap.put("id", "200926630722");
        request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, pathVariablesMap);
        Class<?>[] parameterTypes = new Class<?>[1];
        parameterTypes[0] = String.class;
        try {
            mv = handlerAdapter.handle(request, response, new HandlerMethod(testAction, "resolve", parameterTypes));
        } catch (NoSuchMethodException ex) {
            getLogger(TestActionTest.class.getName()).error(null, ex);
        } catch (Exception ex) {
            getLogger(TestActionTest.class.getName()).error(null, ex);
        }
    }
}
