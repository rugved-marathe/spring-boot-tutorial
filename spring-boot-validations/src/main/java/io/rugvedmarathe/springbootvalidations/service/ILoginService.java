package io.rugvedmarathe.springbootvalidations.service;

import io.rugvedmarathe.springbootvalidations.model.User;
import io.rugvedmarathe.springbootvalidations.vo.GenericResponse;
import io.rugvedmarathe.springbootvalidations.vo.LoginVO;

public interface ILoginService {

    GenericResponse login(LoginVO loginVO);

    GenericResponse signUp(User user);
}
