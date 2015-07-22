package com.fresearch.oversign;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.*;

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