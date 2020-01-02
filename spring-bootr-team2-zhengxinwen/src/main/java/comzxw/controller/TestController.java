package comzxw.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
    @RequestMapping("/test10")
    public String sayName(){
        return "欢迎你来学习springboot10000";
    }
}
