package com.example.login11;

import com.example.login11.config.auth.CustomOAuth2User;
import com.example.login11.model.MyUserDetails;
import com.example.login11.model.User;
import com.example.login11.model.UserService;
import com.example.login11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

        //userService.processOAuthPostLogin(oauthUser.getEmail());

        response.sendRedirect("");

        // process logics with customer

        super.onLogoutSuccess(request, response, authentication);
    }
}

