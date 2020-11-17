package pl.kl.petowner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public String deletePet(@RequestParam("id") Long id) {
        Optional<Pet> petOptional = petService.findPetById(id);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            petService.deleteById(id);
            return "redirect:/owner/" + pet.getOwner().getId();
        }
        return "redirect:/owner";
    }

    @GetMapping("/edit/{id}")
    public String editPet(Model model, @PathVariable(name = "id") Long id) {
        Optional<Pet> petOptional = petService.findPetById(id);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            model.addAttribute("addedPet", pet);
            model.addAttribute("allRaces", Race.values());
            model.addAttribute("ownerId", pet.getOwner().getId());
            return "pet_form";
        }
        return "redirect:/owner";
    }
}
