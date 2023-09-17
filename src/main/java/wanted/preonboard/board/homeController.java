package wanted.preonboard.board;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @Value("${spring.datasource.username}")
    String name;

    @GetMapping("/")
    public String test(){
        System.out.println("Test3");
        return "Hello CI/CD : " + name;
    }

}
