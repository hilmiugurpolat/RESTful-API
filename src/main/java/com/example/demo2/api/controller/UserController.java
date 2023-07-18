package com.example.demo2.api.controller;

import com.example.demo2.api.model.User;
import com.example.demo2.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController //=>Anotasyon: Sınıfın bir REstful Apı kontrolcüsü olduğunu belirtir.
public class UserController {

    @Autowired //=>Anotasyon: UserService sınıfının bağımlılığının otomatik olarak enjekte deildiğini gösterir.
    public UserService userService;

    @GetMapping("/user") //=> Http get isteği ile user endpointine gelen istekleri bu metoda yönlendirir.
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        return user.orElse(null); // veya gerekli işlemi gerçekleştirin
    }


    @PostMapping("/user") //=> Http post isteği ile user endpointine gelen istekleri bu metoda yönlendirir.
    public User createUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.saveUser(user);
    }

    @DeleteMapping("/user")
    public void delete(@RequestParam Integer id)
    {
        userService.deleteUser(id);
    }



   @RequestMapping("/user/{id}")
   public User Updateuser(@PathVariable Integer id, @RequestBody User user)
   {
       System.out.println(user.toString());
       Optional<User> existingUser= userService.getUser(id);
       if(existingUser.isPresent())
       {
           User updatedUser=existingUser.get();
           updatedUser.setName(user.getName());
           updatedUser.setEmail(user.getEmail());

           return userService.saveUser(updatedUser);

       }
       else {
        System.out.println("user no found: "+ id);

       }


       return user;
   }

}