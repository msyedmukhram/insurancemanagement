package com.test.insurance.controller;

import com.test.insurance.model.Insurance;
import com.test.insurance.model.User;
import com.test.insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Home {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @PostMapping("/")
    public String getInsuranceData(@RequestParam(value="mobileNumber",required=false) String mobileNumber, Model model){
        System.out.println("mobile number is "+mobileNumber);
        User user = userRepository.findByMobileNumber(mobileNumber);
        if(user != null){
            List<Insurance> insurances = user.getInsurances();
            System.out.println("user name "+user.getName());
            System.out.println("user email "+user.getEmailId());
            System.out.println("user insurance "+user.getInsurances());
            model.addAttribute("user",user);
            model.addAttribute("insurance",insurances);
        }

        return "home";
    }



}
