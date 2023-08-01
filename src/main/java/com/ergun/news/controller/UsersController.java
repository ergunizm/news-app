package com.ergun.news.controller;

import com.ergun.news.business.abstracts.UserService;
import com.ergun.news.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private UserService service;
    public UsersController(UserService userService){
        service = userService;
    }

    @GetMapping()
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @PostMapping()
    public void addUser(@Valid @RequestBody User user){
        service.addUser(user);
    }

    @DeleteMapping()
    public void deleteUser(@RequestBody int id){
        service.deleteUser(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exc){
        Map<String, String> validationErrors = new HashMap<String, String>();

        for(FieldError fieldError : exc.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationErrors;
    }
}
