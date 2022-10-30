package com.demo.northwind.api.controllers;

import com.demo.northwind.business.abstracts.UserService;
import com.demo.northwind.core.entities.User;
import com.demo.northwind.core.utilities.results.ErrorDataResult;
import com.demo.northwind.core.utilities.results.ErrorResult;
import com.demo.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(){

    }

    @Autowired
    public UserController(UserService _userService){
        this.setUserService(_userService);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@Valid @RequestParam String email){
        return ResponseEntity.ok(this.userService.findByEmail(email));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError error : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }

        return new ErrorDataResult<Object>(validationErrors, "Validation errors");
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
