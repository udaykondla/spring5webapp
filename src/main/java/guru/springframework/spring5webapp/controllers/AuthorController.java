package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthtorRepository;

@Controller
public class AuthorController {

    private final AuthtorRepository authtorRepository;

    public AuthorController(AuthtorRepository authtorRepository) {
        this.authtorRepository = authtorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authtorRepository.findAll());
        return "authors/list";
    }
}
