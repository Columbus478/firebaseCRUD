package com.example.firebaseCRUD.controller;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.firebaseCRUD.objects.Person;
import com.example.firebaseCRUD.service.FirebaseService;

@ComponentScan
@RestController
public class RestFirebaseCRUDController {
  @Autowired
  FirebaseService firebaseService;

  @RequestMapping("/hello")
  public String testMapping() {
    return "Hello Sam";
  }

  @PostMapping("/createUser")
  public String createUser(@RequestBody Person person)
      throws InterruptedException, ExecutionException {
    return firebaseService.saveUserDetails(person);
  }

  @GetMapping("/getUserDetails")
  public Person getUserDatails(@RequestHeader() String name)
      throws InterruptedException, ExecutionException {
    return firebaseService.getUserDetails(name);
  }

  @PutMapping("/updateUser")
  public String updateUserDetails(@RequestBody Person person)
      throws InterruptedException, ExecutionException {
    return firebaseService.updateUserDetails(person);
  }

  @DeleteMapping("/deleteUser")
  public String deleteUser(@RequestHeader() String name)
      throws InterruptedException, ExecutionException {
    return firebaseService.deleteUser(name);
  }

}
