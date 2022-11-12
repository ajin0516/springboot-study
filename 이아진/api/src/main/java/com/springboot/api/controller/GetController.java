package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {

    @GetMapping(value = "name")
    public String getName() {
        return "ajin";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping("/request1")
    public String gerRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam int age){
        return name + " " + email + " " + age;
    }

    @GetMapping("/request2")
    public String gerRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // /request1 보다 코드의 양 줄어듦
    @GetMapping("/request3")
    public String gerRequestParam3(MemberDto memberDto){
        return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getAge();

    }
}
