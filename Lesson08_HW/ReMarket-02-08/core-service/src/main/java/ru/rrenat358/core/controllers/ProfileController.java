package ru.rrenat358.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.core.ProfileDto;
import ru.rrenat358.core.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final UserService userService;
    @GetMapping
    public ProfileDto getCurrentUserInfo(Principal principal) {
//         User user = userService.findAllByUsername(principal.getName());
        return new ProfileDto(
                principal.getName()
        );
    }


    //============================================================
    // saveNewUser
/*
    @GetMapping
    public ProfileDto getCurrentUserInfo(Principal principal) {
         Optional<User> user = userService.findByUsername(principal.getName());
        return new ProfileDto(
                user.get().getUsername(), user.get().getPassword(), user.get().getEmail()
        );
    }
*/





}
