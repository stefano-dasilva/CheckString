package spring.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import service.Interface.StandardService;

@RestController
public class GameRestController {

    @Autowired
    StandardService standardService;

    @RequestMapping(
            path={"/randomcountry"},
            method= {RequestMethod.GET},
            produces = {"application/json"}
    )
    private String getBandiera(){
        RestTemplate restTemplate = new RestTemplate();
        String code = standardService.getRandom().getCode();
        String url = "https://restcountries.com/v3.1/alpha/" + code;
        String result = restTemplate.getForObject(url, String.class);
        return result;


    }
}
