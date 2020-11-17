package pl.kl.petowner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.service.OwnerService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("")
    public String getOwners(Model model) {
        model.addAttribute("listOfOwners", ownerService.findAll());
        return "owner_list";
    }

    @GetMapping("/form")
    public String getOwnerForm(Model model) {
        model.addAttribute("addedOwner", new Owner());
        return "owner_form";
    }

    @PostMapping("")
    public String submitOwner(Owner owner) {
        ownerService.save(owner);
        return "redirect:/owner";
    }

    @GetMapping("{id}")
    public String getOwner(Model model, @PathVariable(name = "id") Long id) {
        Optional<Owner> ownerOptional = ownerService.findById(id);
        if (ownerOptional.isPresent()) {
            model.addAttribute("detailedOwner", ownerOptional.get());
            return "owner_details";
        }
        return "redirect:/owner";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable(name = "id") Long id) {
        ownerService.deleteById(id);
        return "redirect:/owner";
    }

    @GetMapping("/edit/{id}")
    public String editOwner(Model model, @PathVariable(name = "id") Long id) {
        Optional<Owner> ownerOptional = ownerService.findById(id);
        if (ownerOptional.isPresent()) {
            model.addAttribute("addedOwner", ownerOptional.get());
            return "owner_form";
        }
        return "redirect:/owner";
    }
}
