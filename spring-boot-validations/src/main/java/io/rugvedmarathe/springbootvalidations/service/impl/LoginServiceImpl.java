package io.rugvedmarathe.springbootvalidations.service.impl;

import io.rugvedmarathe.springbootvalidations.exception.ValidationException;
import io.rugvedmarathe.springbootvalidations.model.User;
import io.rugvedmarathe.springbootvalidations.repository.UserRepository;
import io.rugvedmarathe.springbootvalidations.service.ILoginService;
import io.rugvedmarathe.springbootvalidations.vo.GenericResponse;
import io.rugvedmarathe.springbootvalidations.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public GenericResponse login(LoginVO loginVO) {
        String errors = loginVO.validate();

        if(!errors.equalsIgnoreCase("[]")){
            throw new ValidationException(errors);
        }

        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setStatus(HttpStatus.OK.name());
        genericResponse.setData(UUID.randomUUID());
        return genericResponse;
    }

    @Override
    public GenericResponse signUp(User user) {
        User newUser = userRepository.save(user);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setStatus(HttpStatus.CREATED.name());
        genericResponse.setData(newUser);
        return genericResponse;
    }
}
