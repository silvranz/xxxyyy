package com.fresearch.oversign.controller;
import java.sql.Connection;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.model.UserModel;
import com.fresearch.oversign.parameter.RegisterParam;

public class UserController {
	public String Register(RegisterParam registerParam)throws Exception {
		String responseRegister = "Error";
		if(registerParam.getPassword().equals(registerParam.getConfirmPass())){			
			try {
				Database database= new Database();
				Connection connection = database.Get_Connection();
				UserModel userModel= new UserModel();
				String userEmail = registerParam.getEmail();
				String userPassword = registerParam.getPassword();
				responseRegister = userModel.Registration(connection,userEmail,userPassword);
			}
			catch (Exception e) {
			System.out.println("Controller");
				throw e;
			}
		}
		return responseRegister;
	}
}