package spring.web.Controller;

import Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    private String getBandiera(){
        RestTemplate restTemplate = new RestTemplate();
        Standard standard = standardService.getRandom();
        String code = standard.getCode();
        String value = standard.getValue();
        /*
        String url = "https://restcountries.com/v3.1/alpha/" + code;
        System.out.println(url);
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

         */

        return String.format("{\"code\":\"%s\", \"value\":\"%s\"}", code, value);

    }
}
