package spinoza.compagnie.policlinic.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spinoza.compagnie.policlinic.Information;
import spinoza.compagnie.policlinic.Information.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import spinoza.compagnie.policlinic.Consultation;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/information")
public class InformationController {

    @GetMapping()
    public String ShowInformationForm(Model model){

        List<Information> questions = Arrays.asList(

                new Information( "1","YES", Type.MEDICINE),
                new Information("2", "NO",Type.MEDICINE),
                new Information("3","Last Months",Type.OPERATION),
                new Information("4"," Between last 3  and 6 months", Type.OPERATION),
                new Information("5","More than One more", Type.OPERATION),
                new Information( "6","YES", Type.ALLERGY),
                new Information("7", "NO", Type.ALLERGY),
                new Information( "8","YES",Type.VITAMIN),
                new Information("9", "NO", Type.VITAMIN),
                new Information( "10","YES", Type.SPYCHOLOGICALANTECEDANT),
                new Information("11", "NO", Type.SPYCHOLOGICALANTECEDANT)

        );

        Type[] types = Information.Type.values();
        for(Type type :types){
        model.addAttribute(type.toString().toLowerCase(),filterByType(questions ,type));
        }
        model.addAttribute("information" , new Consultation());

        return  "information";
    }
    private List<Information> filterByType(List<Information> questions, Type type) {

        return questions
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

    @PostMapping
    public String processInformation(@Valid @ModelAttribute("information") Consultation information, Errors errors,Model model){
        if (errors.hasErrors()){
            return "information";
        }
        log.info("Processing informaton "+  information );

        return  "redirect:/appointment/current";



    }

}
