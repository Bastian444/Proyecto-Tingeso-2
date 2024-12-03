package com.tingeso.user.controller;

import com.tingeso.user.entity.UserEntity;
import com.tingeso.user.service.UserService;
import com.tingeso.
import com.tingeso.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
        List<UserEntity> users = userService.getUsers();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<UserEntity> getByRut(@PathVariable("rut") String rut){
        UserEntity user = userService.getByRut(rut);
        if(user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void saveUser(@RequestBody UserEntity user){
        userService.saveUser(user);
    }

    @GetMapping("/delete")
    public void deleteUser(){
        userService.deleteUser();
    }

    @GetMapping("/loans/{rut}")
    public ResponseEntity<List<LoanModel>> getLoans(@PathVariable("rut") String rut) {
        UserEntity user = userService.findByRut(rut);
        if(user == null)
            return ResponseEntity.notFound().build();
        List<LoanModel> loans = userService.getLoans(rut);
        return ResponseEntity.ok(loans);
    }

}