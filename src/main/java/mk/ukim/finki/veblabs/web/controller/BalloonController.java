package mk.ukim.finki.veblabs.web.controller;

import mk.ukim.finki.veblabs.exception.NonExistentBalloonException;
import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.service.BalloonService;
import mk.ukim.finki.veblabs.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }
    // model ~ context
    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("balloons",balloonService.listAll());
        return "listBalloons";
    }
    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-form";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        Balloon b = this.balloonService.findById(id).orElseThrow(() -> new NonExistentBalloonException(id));
        model.addAttribute("balloon", b);
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-form";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String desc,
                              @RequestParam Long manufacturer){
        balloonService.create(name,desc,manufacturer);
        return "redirect:/balloons";
    }
}
