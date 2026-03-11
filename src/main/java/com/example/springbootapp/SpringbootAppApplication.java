package com.example.springbootapp;

import jakarta.websocket.server.PathParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/index")
@CrossOrigin(origins = "http://localhost:9090")
//公共路径 '/index'
public class SpringbootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAppApplication.class, args);
    }
//    接口访问名称
    @RequestMapping("/hello")
    public String hello(){
            return "hello world";
    }
//    @GetMapping
//    public String index(){
//        return "GET无参请求";
//    }

    @GetMapping("/{id}")
    public String index(@PathVariable Long id){
        System.out.printf("ID=%s\n",id);
        return "带参数get请求";
    }

    @GetMapping
    public String index(@RequestParam Long id,@RequestParam String name){
        System.out.printf("ID=%s,name=%s",id,name);
        return "GET普通传参请求";
    }
    @PostMapping
    public String save(@RequestBody Map<String,String> map){
        System.out.printf(map.toString());
        return "POST请求接受成功";
    }

}
