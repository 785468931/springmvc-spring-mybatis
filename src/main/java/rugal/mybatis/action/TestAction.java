package rugal.mybatis.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rugal Bernstein
 */
@Controller
public class TestAction
{

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object index()
    {
        return "{Rugal:Bernstein}";
    }
}
