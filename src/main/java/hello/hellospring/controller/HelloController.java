package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 위에는 반드시 정의해줘야 함
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 /hello 라는 주소로 들어올 때, 아래의 hello 메서드를 호출한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // 기본적으로 resources/templates 밑의 파일을 찾음(이 경우에는 hello.html)
    }
}
