package com.example.cukraszda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class MessageController {
    @Autowired
    private com.example.cukraszda.messageRepo messageRepo;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute("message") messages message, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {


            String username = authentication.getName();

            users user = (users) customUserDetailsService.loadUserByUsername(username);
            int userId = user.getId();
            message.setUser(user);
            message.setTitle(message.getTitle());
            message.setContent(message.getContent());
            messageRepo.save(message);
            return "main";
        } else {
            message.setUser(null);
            message.setTitle(message.getTitle());
            message.setContent(message.getContent());
            messageRepo.save(message);
            return "index";
        }

    }
}
