package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    // http://localhost:9090
    @GetMapping("/")
    public String slashPage() {

        System.out.println("Inside homePage");

        return "home";
    }

    @GetMapping("/home")
    public String homePage() {

        System.out.println("Inside homePage");

        return "home";
    }

    // http://localhost:9090
    @GetMapping("/login")
    public String loginPage() {

        System.out.println("Inside loginPage");

        return "login";
    }

    // http://localhost:9090/customer
    @GetMapping("/customer")
    public String customerPage() {

        System.out.println("Inside customerPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "customer";
    }

    // http://localhost:9090/customer_no_thymeleaf
    @GetMapping("/customer_no_thymeleaf")
    public String customer_no_thymeleafPage() {

        System.out.println("Inside customer_no_thymeleafPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "customer_no_thymeleaf";
    }

    // http://localhost:9090/reservation
    @GetMapping("/reservation")
    public String reservationPage() {

        System.out.println("Inside reservationPage");

        return "reservation";
    }

    // http://localhost:9090/contact
    @GetMapping("/contact")
    public String contactPage() {

        System.out.println("Inside contactPage");

        return "contact";
    }

    // http://localhost:9090/blog
    @GetMapping("/blog")
    public String blogPage() {

        System.out.println("Inside blogPage");

        return "blog";
    }

    // http://localhost:9090/room
    @GetMapping("/room")
    public String roomPage() {

        System.out.println("Inside roomPage");

        return "room";
    }
}

