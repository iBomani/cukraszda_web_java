package com.example.cukraszda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired private userRepo userRepo;

    @GetMapping("/registration")
    public String Registration(Model model) {
        model.addAttribute("user", new users());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute users user, RedirectAttributes redirectAttributes) {
        for(users user2: userRepo.findAll()) {
            if(user2.getUsername().equals(user.getUsername()) && user2.getEmail().equals(user.getEmail())) {
                redirectAttributes.addFlashAttribute("message", "Ezzel a felhasználónévvel és címmel már van dolgozó.");
                return "index";
            }
        }

        user.setPassword(PasswordHash.hashPassword(user.getPassword()));
        userRepo.save(user);
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute users user, RedirectAttributes redirectAttributes) {
        for(users user2: userRepo.findAll()) {
            if(user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(PasswordHash.hashPassword(user.getPassword()))) {
                return "main";
            }
        }
        return "index";
    }
}
