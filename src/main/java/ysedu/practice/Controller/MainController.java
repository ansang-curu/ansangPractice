package ysedu.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ysedu.practice.Dto.FruitDto;
import ysedu.practice.Service.MainService;

import java.util.List;

@Controller
@RequestMapping("/fruits")
public class MainController {
    @Autowired
    MainService mainService;

//크리에잇 홈페이지
    @GetMapping("/create")
    public String createPage(){
        return  "create-fruit";
    }

//    삽입 기능 구현
    @PostMapping
    @ResponseBody
    public void createItem(@RequestBody FruitDto fruitDto){
        mainService.createItem(fruitDto);
    }

//    한개 조회 상세페이지
    @GetMapping("/{id}")
    public String selectFruit(@PathVariable("id")int id, Model model){
        FruitDto fruitDto= mainService.selectItemById(id);
        model.addAttribute("fruit",fruitDto);
        return "detail";
    }
// 상품 목록
    @GetMapping
    public String selectItems(Model model){
        List<FruitDto> items = mainService.selectItems();
        model.addAttribute("items",items);
        return "itemsList";
    }


}
