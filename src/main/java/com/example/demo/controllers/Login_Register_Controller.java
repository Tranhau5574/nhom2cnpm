package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.security.service.User_UserDetails_Service;

@Controller
public class Login_Register_Controller {

    @Autowired
    User_UserDetails_Service userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(@RequestParam Integer error, Model model){
        if(error != null && error == 1) {
            model.addAttribute("message", "Đăng nhập thất bại");
        }
        return "login";
    }

    @RequestMapping(value = "/logout-success", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void saveUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user", request.getParameter("user"));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
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

            model.addAttribute("message", "Tạo tài khoản thành công");
            return "login";
        }
        catch (Exception e){
            model.addAttribute("message", e.getMessage());
            return "register";
        }
    }
}

