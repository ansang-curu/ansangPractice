package ysedu.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ysedu.practice.Dto.PageDto;
import ysedu.practice.Dto.SupDto;
import ysedu.practice.Service.SupService;

@Controller
@RequestMapping("/sups")
public class SupContoller {
    @Autowired
    SupService supService;

    @GetMapping("/create")
    public String create(){
        return  "/sup/create-sup";
    }
    //    삽입 기능 구현
    @PostMapping
    @ResponseBody
    public void createSup(@RequestBody SupDto supDto){
        supService.createSup(supDto);
    }

    //    한개 조회 상세페이지
    @GetMapping("/{id}")
    public String selectSup(@PathVariable("id")int id, Model model){
        try{
            SupDto supDto= supService.selectSupById(id);
            model.addAttribute("fruit",supDto);
        }catch (IllegalStateException e){
            model.addAttribute("message",e.getMessage());
            return "errorId";
        }
        return "detail";
    }
    // 상품 목록
//    요청url형식 : /fruits?page=1&limit=10
    @GetMapping
    public String selectSups(@RequestParam(name = "page",defaultValue = "1")int page,
                              @RequestParam(name = "limit",defaultValue = "3")int limit,
                              Model model){
        PageDto pageDto= supService.selectsups(page,limit);
        model.addAttribute("pageDto",pageDto);
        return "itemsList";
    }
    // 삭제 기능
    @GetMapping("/{id}/delete")
    public String deleteSup(@PathVariable("id") int id){
        supService.deleteSup(id);
        System.out.println("삭제완료");

        return  "redirect:/fruits";
    }
    //    수정 기능
    @GetMapping("/{id}/update")

    public String updateSup(@PathVariable("id") int id,Model model){
        try {
            SupDto supDto = supService.selectSupById(id);
            model.addAttribute("sup", supDto);
        }catch (IllegalStateException e){
            model.addAttribute("message",e.getMessage());
            return "errorId";
        }
        return "update";
    }
    @PostMapping("/{id}/update")
    @ResponseBody
    public  void updateItem(@RequestBody SupDto supDto){
        supService.updateSup(supDto);
    }
}
