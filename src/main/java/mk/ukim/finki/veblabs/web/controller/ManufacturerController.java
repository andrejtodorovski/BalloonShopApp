package mk.ukim.finki.veblabs.web.controller;

import mk.ukim.finki.veblabs.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String viewManufacturers(@RequestParam(required = false) String error, Model model) {
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }model.addAttribute("manufacturers",manufacturerService.findAll());
        return "listManufacturers";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String country,
                              @RequestParam String address){
        manufacturerService.save(name,country,address);
        return "redirect:/manufacturers";
    }
    @GetMapping("/add")
    public String getAddForm(@RequestParam(required = false) String error, Model model){
        return "add-manufacturer";
    }
}
