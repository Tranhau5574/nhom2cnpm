package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.security.service.User_UserDetails_Service;

@Controller
public class LoginController {

    @Autowired
    User_UserDetails_Service userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

        @RequestMapping(value = "/sign-out", method = RequestMethod.GET)
    public String signOut(HttpServletRequest request) {
        request.getSession().removeAttribute("jwtResponse");
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void saveUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("userpassword", request.getParameter("password"));
        session.setAttribute("user", request.getParameter("user"));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, Model model){
        String rawUsername = request.getParameter("username");
        String rawPassword = request.getParameter("password");
        try {
            if(userService.findByUsername(rawUsername).isPresent()){
                throw new Exception("Đã tồn tại người dùng, vui lòng chọn tên đăng nhập khác");
            }
            User newUser = new User();
            newUser.setUsername(rawUsername);
            newUser.setPassword(rawPassword);

            Set<Role> roles = new HashSet<>();
            Role roleClient = new Role();
            roleClient.setName("ROLE_CLIENT");
            roles.add(roleClient);
            newUser.setRoles(roles);
            userService.save(newUser);

            model.addAttribute("message", "Tao tai khoan thanh cong");
            return "login";
        }
        catch (Exception e){
            model.addAttribute("message", e.getMessage());
            return "register";
        }
    }
}

