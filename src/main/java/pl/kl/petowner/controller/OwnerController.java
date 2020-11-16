package pl.kl.petowner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.service.OwnerService;

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
}
