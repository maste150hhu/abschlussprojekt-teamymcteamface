package mops.foren.infrastructure.web.controller;

import mops.foren.applicationservices.UserService;
import mops.foren.infrastructure.web.Account;
import mops.foren.infrastructure.web.KeycloakService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.security.RolesAllowed;

@Controller
@SessionScope
@RolesAllowed({"ROLE_studentin", "ROLE_orga"})
@RequestMapping("/foren/profile")
public class ProfileController {

    UserService userService;
    KeycloakService keycloakService;

    /**
     * Constructor for the ProfileController.
     *
     * @param userService     - UserService (ApplicationService)
     * @param keycloakService - KeycloakService (Infrastructure Service)
     */
    public ProfileController(UserService userService, KeycloakService keycloakService) {
        this.userService = userService;
        this.keycloakService = keycloakService;
    }

    @GetMapping
    public String profile() {
        return "profile";
    }

    /**
     * Adds the account object to each request.
     * Image and roles have to be added in the future.
     *
     * @param token - KeycloakAuthenticationToken
     * @return Keycloak Account
     */
    @ModelAttribute("account")
    public Account addAccountToTheRequest(KeycloakAuthenticationToken token) {
        if (token == null) {
            return null;
        }

        return this.keycloakService.createAccountFromPrincipal(token);
    }
}
