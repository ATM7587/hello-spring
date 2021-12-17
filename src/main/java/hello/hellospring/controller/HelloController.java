package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 위에는 반드시 정의해줘야 함
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 /hello 라는 주소로 들어올 때, 아래의 hello 메서드를 호출한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // 기본적으로 resources/templates 밑의 파일을 찾음(이 경우에는 hello.html)
    }

    @GetMapping("hello-mvc") // 웹 어플리케이션에서 /hello-mvc 라는 주소로 들어올 때, 아래의 hello 메서드를 호출한다.
    public String helloMvc(@RequestParam("name") String name, Model model) { // 주소창에서 name 값을 입력하면, name이 그 값으로 변경
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // Body 부분에 해당 데이터를 직접 넣겠다는 뜻 (html 코드 안에 삽입해서 화면을 보여주는 것이 아닌 데이터 자체를 보여줌)
    public String helloString(@RequestParam("name")  String name) {
        return "hello " + name; // 예 : "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { // static class로 만들 시 class 안에서 새로운 class를 사용할 수 있음
        private String name;

        public String getName() { // name 데이터를 꺼낼 때
            return name;
        }

        public void setName(String name) {  // name 데이터를 집어넣을 때 (흰색 : 입력받은 name의 value, 보라색 :
            this.name = name;
        }
    }
}
