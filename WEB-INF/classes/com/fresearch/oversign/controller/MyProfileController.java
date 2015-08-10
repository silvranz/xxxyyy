package com.fresearch.oversign.controller;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.data.MyProfileObj;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.model.MyProfileModel;
import com.fresearch.oversign.parameter.MyProfileParam;

public class MyProfileController {
	public static ArrayList<MyProfileObj> GetProfile_C(MyProfileParam myprofileparam)throws Exception {
		ArrayList<MyProfileObj> mpo = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			MyProfileModel mpm= new MyProfileModel();
			String userid = myprofileparam.getUserID();
			//String search = ForumSearchParam.getSearch();
			mpo=mpm.GetProfile_M(connection,userid);
		}
		catch (Exception e) {
			throw e;
		}
		return mpo;
	}
}