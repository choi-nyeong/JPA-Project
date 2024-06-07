package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // hello라는 url로 오면 이 컨트롤러가 호출됨
    public String hello(Model model) { // 컨트롤러에서 model에 데이터를 담고 view에 넘길 수 있음
        model.addAttribute("data", "hello!!!!");
        return "hello"; // 화면이름. hello만 써도 뒤에 .html이 붙음
    }

}
