package com.example.cukraszda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired private userRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/registration")
    public String saveUser(@ModelAttribute users user, RedirectAttributes redirectAttributes) {
        for(users user2: userRepo.findAll()) {
            if(user2.getUsername().equals(user.getUsername()) && user2.getEmail().equals(user.getEmail())) {
                redirectAttributes.addFlashAttribute("message", "Ezzel a felhasználónévvel és címmel már van dolgozó.");
                return "index";
            }
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setUsername(user.getUsername());
        user.setRole("ROLE_USER");
        userRepo.save(user);
        return "index";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute users user, RedirectAttributes redirectAttributes) {
        for(users user2: userRepo.findAll()) {
            if(user2.getUsername().equals(user.getUsername()) && passwordEncoder.matches(user.getPassword(), user2.getPassword())) {
                return "main";
            }
        }
        return "index";
    }
}
