package com.fresearch.oversign.controller;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.data.PopularHashtagObj;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.model.ForumModel;

public class ForumController {
	public ArrayList<PopularHashtagObj> GetPopularHashtag_C()throws Exception {
		ArrayList<PopularHashtagObj> pho = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			ForumModel fm= new ForumModel();
			pho=fm.GetPopularHashtag_M(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return pho;
	}
}