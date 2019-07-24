package com.his.service;

import com.his.model.ForgotPassModel;
import com.his.model.LoginModel;

public interface LoginService {

	String checkCredintials(LoginModel loginModel) throws Exception;

	String sendForgottenEmail(ForgotPassModel forgotpass);

}
