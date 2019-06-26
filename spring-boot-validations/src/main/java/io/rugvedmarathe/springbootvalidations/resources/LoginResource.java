package io.rugvedmarathe.springbootvalidations.resources;

import io.rugvedmarathe.springbootvalidations.model.User;
import io.rugvedmarathe.springbootvalidations.service.ILoginService;
import io.rugvedmarathe.springbootvalidations.vo.GenericResponse;
import io.rugvedmarathe.springbootvalidations.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginResource {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> login(@RequestBody LoginVO loginVO){
        return new ResponseEntity<>(loginService.login(loginVO), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<GenericResponse> signUp(@Valid @RequestBody User user){
        return new ResponseEntity<>(loginService.signUp(user), HttpStatus.CREATED);
    }

}
