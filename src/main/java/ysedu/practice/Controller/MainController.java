package ysedu.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ysedu.practice.Dto.FruitDto;
import ysedu.practice.Service.MainService;

@Controller
@RequestMapping("/fruits")
public class MainController {
    @Autowired
    MainService mainService;
//    크리에잇 기능 구현
    @PostMapping
    @ResponseBody
    public void createItem(@RequestBody FruitDto fruitDto){
        mainService.createItem(fruitDto);
    }
//크리에잇 홈페이지
    @GetMapping("/create")
    public String createPage(){
        return  "create-fruit";
    }



}
