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
            path={"randomcountry2"},
            method = {RequestMethod.GET},
            produces ={MediaType.APPLICATION_JSON_VALUE}
    )
    private  String getBandiera2(){

        Standard standard1 = standardService.getRandom();
        String code1 = standard1.getCode();
        String value1 = standard1.getValue();

        Standard standard2 = standardService.getRandom();
        String code2 = standard2.getCode();
        String value2 = standard2.getValue();

        Standard standard3 = standardService.getRandom();
        String code3 = standard2.getCode();
        String value3 = standard2.getValue();

        Standard standard4 = standardService.getRandom();
        String code4 = standard2.getCode();
        String value4 = standard2.getValue();

        return String.format("{\"code1\":\"%s\", \"value1\":\"%s\", " +
                        "\"code2\":\"%s\", \"value2\":\"%s\", " +
                        "\"code3\":\"%s\", \"value3\":\"%s\", " +
                        "\"code4\":\"%s\", \"value4\":\"%s\"}",
                code1, value1, code2, value2, code3, value3, code4, value4);

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
