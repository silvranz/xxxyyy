package com.fresearch.oversign.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import com.fresearch.oversign.data.StringResponse;
import com.sun.jersey.core.header.FormDataContentDisposition;

public class Upload {
	private String projectBasePath = "\\var\\www\\html\\";//server
	private String imagePath = "\\var\\www\\uploadImage\\";//server
	//private String projectBasePath = "D:\\Programming\\xampp\\htdocs\\";//local
	//private String imagePath = "D:\\Programming\\xampp\\tomcat\\webapps\\uploadImage\\";//local
	
	public Upload(){}
	
	public void uploadImage(InputStream fileInputStream,String fileName) throws IOException{
		String targetPath = imagePath+fileName;
		try
		{
			OutputStream out = new FileOutputStream(new File(
					targetPath));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(targetPath));
			while ((read = fileInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
