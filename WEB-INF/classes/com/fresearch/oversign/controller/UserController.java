package com.fresearch.oversign.controller;
import java.sql.Connection;
import com.fresearch.oversign.data.LoginObject;
import com.fresearch.oversign.model.UserModel;
import com.fresearch.oversign.parameter.RegisterParam;
import com.fresearch.oversign.parameter.LoginParam;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.utility.Encryption;

public class UserController {
	public String Register(RegisterParam registerParam)throws Exception {
		String responseRegister = "Error";
		Encryption passwordEncryptor = new Encryption();
		if(registerParam.getPassword().equals(registerParam.getConfirmPass())){			
			try {
				Database database= new Database();
				Connection connection = database.Get_Connection();
				UserModel userModel= new UserModel();
				String userEmail = registerParam.getEmail();
				String userPassword = registerParam.getPassword();
				userPassword = passwordEncryptor.PasswordEncription(userEmail,userPassword);
				responseRegister = userModel.Registration(connection,userEmail,userPassword);
			}
			catch (Exception e) {
				throw e;
			}
		}
		return responseRegister;
	}
	public String Login(LoginParam loginParam)throws Exception{
		String responseLogin = "Error";
		Encryption passwordEncryptor = new Encryption();
		LoginObject loginResult = new LoginObject();
		try{
			Database database = new Database();
			Connection connection = database.Get_Connection();
			UserModel userModel = new UserModel();
			String userEmail = loginParam.getEmail();
			String userPassword = loginParam.getPassword();
			userPassword = passwordEncryptor.PasswordEncription(userEmail,userPassword);
			loginResult = userModel.Login(connection,userEmail,userPassword);
			if(loginResult.getUserID() == -1){
				responseLogin = "Username or password wrong";
			}
			else{
				responseLogin = "Login success";
			}
		}
		catch(Exception e){
			throw e;
		}
		return responseLogin;
	}
}