package com.main.servicedashboardmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
public class NewServiceDashboardApplication {

    @GetMapping("/")
    public String dashboard(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://my-json-server.typicode.com/NeeleshCfc/responseTime/db";

        ResponseList responseList = restTemplate.getForObject(url, ResponseList.class);

        for (ResponseObject responseObject : responseList.getResponses()) {
            String name = responseObject.getName();
            int responseTime = responseObject.getResponseTime();
            int requestCount = responseObject.getRequestCount();
            String colour;
            if (responseTime > 300) {
                colour = "Red";
            }   else if (responseTime < 300 && responseTime > 100){
                colour = "Amber";
            }   else {
                colour = "Green";
            }
        }

        model.addAttribute("responses", responseList.getResponses());
        model.addAttribute("url", url);

        return "dashboard";
    }

    public static void main(String[] args) {
        SpringApplication.run(NewServiceDashboardApplication.class, args);
    }
}
