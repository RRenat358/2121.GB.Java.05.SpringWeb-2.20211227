package ru.rrenat358.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.api.core.ProfileDto;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @GetMapping
    public ProfileDto getCurrentUserInfo(@RequestHeader String username) {
//         User user = userService.findAllByUsername(principal.getName());
        return new ProfileDto(username);
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
