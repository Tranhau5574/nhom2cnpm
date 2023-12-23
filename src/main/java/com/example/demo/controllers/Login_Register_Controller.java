package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.security.service.RoleService;
import com.example.demo.security.service.User_UserDetails_Service;

@Controller
public class Login_Register_Controller {

    @Autowired
    RoleService roleService;

    @Autowired
    User_UserDetails_Service user_UserDetails_Service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
            return "login";
    }

    @RequestMapping(value = "/logincheck", method = RequestMethod.GET)
    public String checkLogin(HttpServletRequest request, Model model){
        
        Integer error = Integer.parseInt(request.getParameter("error"));
        if(error == 1) {
            model.addAttribute("message", "Đăng nhập thất bại, thử lại");
            return "login";
        }
        else {
            HttpSession session = request.getSession();
            String currentUserName = ((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
            User currentUser = (user_UserDetails_Service.findByUsername(currentUserName)).get(); 
            session.setAttribute("currentUser", currentUser);
            if((currentUser.getRoles()).size() == 1){
                if(currentUser.getRoles().iterator().next().getName() == "ROLE_ADMIN"){
                    return "redirect:/admin";
                }
                return "redirect:/";
            }
            else{
                return "chooseRole";
            }
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/";
    }

    @RequestMapping(value = "/logout-success", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("currentUser");
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(){
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, Model model){
        String rawUsername = request.getParameter("username");
        String rawPassword = request.getParameter("password");
        try {
            if(user_UserDetails_Service.findByUsername(rawUsername).isPresent()){
                throw new Exception("Đã tồn tại người dùng, vui lòng chọn tên đăng nhập khác");
            }
            User newUser = new User();
            newUser.setUsername(rawUsername);
            newUser.setPassword(rawPassword);

            Set<Role> roles = new HashSet<>();
            Role roleClient = roleService.findByName("ROLE_CLIENT");
            roles.add(roleClient);
            newUser.setRoles(roles);
            user_UserDetails_Service.save(newUser);

            model.addAttribute("message", "Tạo tài khoản thành công");
            return "login";
        }
        catch (Exception e){
            model.addAttribute("message", e.getMessage());
            return "register";
        }
    }
}

