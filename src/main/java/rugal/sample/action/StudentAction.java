package rugal.sample.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rugal Bernstein
 */
@Controller
public class StudentAction
{

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object index()
    {
        return "{\"name\":\"Rugal Bernstein}\"";

    }
}
