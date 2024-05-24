package spring.web.Controller;

import Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.Interface.CheckStringService;
import service.Interface.StandardService;

@RestController
public class GameRestController {

    @Autowired
    StandardService standardService;

    @Autowired
    CheckStringService checkStringService;

    @RequestMapping(
            path={"/randomcountry"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    private String getBandiera(){
        Standard standard = standardService.getRandom();
        String code = standard.getCode();
        String value = standard.getValue();

        return String.format("{\"code\":\"%s\", \"value\":\"%s\"}", code, value);

    }

    @RequestMapping(
            path={"/checkstring"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String getCheckString(@RequestParam("input") String input){

        String  inputStandard = checkStringService.check(input);

        return String.format("{\"inputstandard\":\"%s\"}", inputStandard);

    }
}
