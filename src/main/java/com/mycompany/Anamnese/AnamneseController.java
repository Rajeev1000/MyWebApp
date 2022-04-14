package com.mycompany.Anamnese;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import java.util.*;



@Controller
public class AnamneseController {

    @Autowired
    private AnamneseService service5;

    @GetMapping("/Anamnese")
    public String showAnamneseList(Model model){
        List<Anamnese> listAnamnese=service5.listall();
        model.addAttribute("listAnamnese",listAnamnese);
        return "Anamnese";
    }
    @GetMapping("/Anamnese/new")
    public String showNewAnamneseForm(Model model){
        model.addAttribute("anamnese",new Anamnese());
        model.addAttribute("pageTitle","Nieuwe anamnese patiënt toevoegen");
        return "AnamneseForm";
    }
    @PostMapping("/Anamnese/save")
    public  String saveAnamnese(Anamnese anamnese, RedirectAttributes ra){
        service5.save(anamnese);
        ra.addFlashAttribute("message","De anamnese is opgeslagen.");
        return "redirect:/Anamnese";
    }
    @GetMapping("/Anamnese/edit/{id}")
    public String showAnamneseEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try{
            Anamnese anamnese=service5.get(id);
            model.addAttribute("anamnese",anamnese);
            model.addAttribute("pageTitle","Anamnese info bewerken(ID:"+id+ ")");
            return "AnamneseForm";
        }catch (AnamneseNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:Anamnese";
        }
    }
    @GetMapping("/Anamnese/delete/{id}")
    public String deleteAnamnese(@PathVariable("id")Integer id, RedirectAttributes ra)
    {
        try{
            service5.delete(id);
            ra.addFlashAttribute("message","De anamnese van ID"+id+"is verwijderd.");

        }catch (AnamneseNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
        }
        return"redirect:/Anamnese";
    }
    @RequestMapping("/Anamnese")
    public String Anamnese() {
        return "Anamnese";
    }


}