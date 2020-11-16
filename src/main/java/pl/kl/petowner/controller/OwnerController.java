package pl.kl.petowner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.petowner.service.OwnerService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/owner")
public class OwnerController {

    private final OwnerService ownerService;
}
