package spinoza.compagnie.policlinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spinoza.compagnie.policlinic.Appointment;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @GetMapping("/current")
    public String appointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment";


    }

    @PostMapping
    public String processAppointment(@Valid  Appointment appointment, Errors errors){
        if(errors.hasErrors()){
            return "appointment";
        }
        log.info("Appointment submitted:" + appointment);
        return  "redirect:/";

    }
}
