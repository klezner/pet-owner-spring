package pl.kl.petowner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.model.Pet;
import pl.kl.petowner.model.Race;
import pl.kl.petowner.service.PetService;

import java.util.Optional;

@Controller
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping("/form")
    public String getGradeForm(Model model, @RequestParam("ownerId") Long ownerId) {
        model.addAttribute("addedPet", new Pet());
        model.addAttribute("allRaces", Race.values());
        model.addAttribute("ownerId", ownerId);
        return "pet_form";
    }

    @PostMapping("")
    public String submitPet(Pet pet, @RequestParam("ownerId") Long ownerId) {
        Optional<Owner> ownerOptional = petService.findOwnerById(ownerId);
        if (ownerOptional.isPresent()) {
            pet.setOwner(ownerOptional.get());
            petService.save(pet);
        }
        return "redirect:/owner/" + ownerId;
    }
}
