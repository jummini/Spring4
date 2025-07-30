package com.dw.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sayhello") // Rest API 주소 (기본적으로 소문자 사용)
    public String hello() {
        return "안녕하세요";
    }

    @GetMapping("/sayhello/name") // sayhello/name?name=steve
    public String helloWithName(@RequestParam String name) {
        return "안녕하세요 " + name + "님";
    }

    @GetMapping("/sayhello/id/{id}") // sayhello/id/1234
    public String helloWithId(@PathVariable String id) {
        return "안녕하세요 " + id + "님";
    }
}
