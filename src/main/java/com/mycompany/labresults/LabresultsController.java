package com.mycompany.labresults;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LabresultsController {
    @Autowired
    private LabresultsService service3;


    @GetMapping("/Labresults")
    public String showLabresultsList(Model model) {
        List<Labresults> listLabresults = service3.listall();
        model.addAttribute("listLabresults", listLabresults);
        return "Labresults";
    }

    @GetMapping("/Labresults/new")
    public String showNewLabresultsForm(Model model) {
        model.addAttribute("labresults", new Labresults());
        model.addAttribute("pageTitle", "Niewe info toevoegen");
        return "LabresultsForm";
    }
    @PostMapping("/Labresults/save")
    public String saveLabresults(Labresults labresults, RedirectAttributes ra){
        service3.save(labresults);
        ra.addFlashAttribute("message","De nieuwe informatie is opgeslagen.");
        return "redirect:/Labresults";
    }
    @GetMapping("/Labresults/edit/{id}")
    public String showLabresultsEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try{
            Labresults labresults= service3.get(id);
            model.addAttribute("labresults",labresults);
            model.addAttribute("pageTitle","Info bewerken(ID:"+id+")");
            return "LabresultsForm";

        }catch (LabresultsNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/Labresults";
        }

    }
    @GetMapping("Labresults/delete/{id}")
    public String deleteLabresults(@PathVariable("id")Integer id,RedirectAttributes ra){
        try{
            service3.delete(id);
            ra.addFlashAttribute("message","De informatie van ID"+id+"is verwijderd");
        }
        catch (LabresultsNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/Labresults";
    }

}


