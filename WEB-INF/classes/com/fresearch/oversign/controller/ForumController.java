package com.fresearch.oversign.controller;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.data.PopularHashtagObj;
import com.fresearch.oversign.data.HotThreadObj;
import com.fresearch.oversign.data.ForumSearchObj;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.model.ForumModel;
import com.fresearch.oversign.parameter.ForumSearchParam;

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

	public ArrayList<HotThreadObj> GetHotThread_C()throws Exception {
		ArrayList<HotThreadObj> ht = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			ForumModel fm= new ForumModel();
			ht=fm.GetHotThread_M(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return ht;
	}
	public static ArrayList<ForumSearchObj> GetForumSearch_C(ForumSearchParam forumsearchparam)throws Exception {
		ArrayList<ForumSearchObj> fs = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			ForumModel fm= new ForumModel();
			ForumSearchParam fsp = new ForumSearchParam();
			String search = fsp.getSearch();
			//String search = ForumSearchParam.getSearch();
			fs=fm.GetForumSearch_M(connection,search);
		}
		catch (Exception e) {
			throw e;
		}
		return fs;
	}
}