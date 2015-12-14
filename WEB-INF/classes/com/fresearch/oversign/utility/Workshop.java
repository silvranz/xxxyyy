package com.fresearch.oversign.utility;

import com.fresearch.oversign.data.StringResponse;
import com.fresearch.oversign.parameter.workspace.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;

public class Workshop {
	private String projectBasePath = "D:\\Programming\\xampp\\htdocs\\";
	private String templatePath = "D:\\Programming\\xampp\\tomcat\\webapps\\template\\";
	private String pageName = "";
	private String currentDir = "";
	private String css = "";
	private String script = "";
	private String homepage = "";
	List closableTag = Arrays.asList("div", "button");
	
	public Workshop(){}
	
	public void GenerateProject(StoreParam storeParam) throws IOException
	{
		try{
			initProject(storeParam.getHomepage());
			generateView(storeParam.getPages());
		}
		catch(IOException e){
			throw e;
		}
	}
	
	public void initProject(String projectName) throws IOException{
		createDirectory(projectName);
		currentDir = projectName+"\\";
		try{
			copyTemplateLibrary(projectName);
		}
		catch(IOException e){
			throw e;
		}
	}
	public void generateView(List<Page> pages) throws IOException
	{
		String content = "";
		try{
			for(Page page:pages){
				//reset
				css = "";
				script = "";
				content = createNewContentPage(page);
				if(page.getIs_homepage()){
					homepage = page.getId();
					pageName = "index.php";
				}
				else{
					pageName = page.getId()+".php";
				}
				createView(pageName,content);
			}
		}
		catch(IOException e){
			throw e;
		}
	}
	public String createNewContentPage(Page page) throws IOException{
		String template = "";
		try{
			template = FileUtils.readFileToString(new File(templatePath+"template.php"));
			script = FileUtils.readFileToString(new File(templatePath+"main.js"));
			css = createCssString(page.getAttribute());
			String header = createHeaderString(page.getHeader());
			String content = createContentString(page.getElements());
			String footer = createFooterString(page.getFooter());
			createView(page.getId()+".css",css);
			createView(page.getId()+".js",script);
			template = template.replace("$title", page.getName());
			template = template.replace("$style", "<link href='"+page.getId()+".css' rel='stylesheet'></link>");
			template = template.replace("$script", "<script src='"+page.getId()+".js' type='text/javascript'></script>");
			template = template.replace("$header", header);
			template = template.replace("$content", content);
			template = template.replace("$footer", footer);
			return template;
		}
		catch(IOException e){
			throw e;
		}
	}
	public String createCssString(Attribute attribute){
		Style style = attribute.getStyle();
		String cssContainer = "";
		cssContainer += "body{"+
						"display:"+style.getDisplay()+";"+
						"background:"+(style.getBackground_color() != null && !style.getBackground_color().isEmpty()?style.getBackground_color():style.getBackground())+";"+
						"}";
		return cssContainer;
	}
	public String createHeaderString(Header header) throws IOException{
		try{
			css += ".header{"+
					"background-color:"+header.getBackground_color()+";"+
					"border-bottom-color:"+header.getBorder_bottom_color()+";"+
					"border-bottom-style:"+header.getBorder_bottom_style()+";"+
					"border-bottom-width:"+header.getBorder_bottom_width()+";"+
					"height:"+header.getHeight()+";"+
					"width:"+header.getWidth()+";"+
					"}";
			String template = FileUtils.readFileToString(new File(templatePath+"header.php"));
			return template;
		}
		catch(IOException e){
			throw e;
		}
	}
	public String createContentString(List<Element> elements) throws IOException{	
		try{	
			String template = FileUtils.readFileToString(new File(templatePath+"content.php"));
			ElementStyle tempStyle = new ElementStyle();
			String tempElemntEvents = "";
			String tempHtml = "";
			for(Element element:elements){
				if(element.getHtml()!= null && !element.getHtml().isEmpty()){
					tempHtml =element.getHtml(); 
					System.out.print(tempHtml);
					tempHtml =tempHtml.replace(element.getTag(),element.getTag()+" id='"+element.getId()+"'"); 					
					System.out.println(element.getTag()+" => "+tempHtml);
					template+=tempHtml;
				}
				else{
					String elementString = "<"+element.getTag()+
											" id='"+element.getId()+"'"+
											" class='"+element.getAttribute().getClasses()+"'"+
											(element.getTag() == "img"?" src='"+element.getAttribute().getSrc()+"'":"")+
											(closableTag.contains(element.getTag())?" ></"+element.getTag()+">":" />");
					template += elementString;
				}
				tempStyle = element.getAttribute().getStyle();
				css += "#"+element.getId()+"{"+
						"pointer-events:"+tempStyle.getPointer_events()+";"+
						"display:"+tempStyle.getDisplay()+";"+
						"left:"+tempStyle.getLeft()+";"+
						"top:"+tempStyle.getTop()+";"+
						"position:"+tempStyle.getPosition()+";"+
						"width:"+tempStyle.getWidth()+";"+
						"height:"+tempStyle.getHeight()+";"+
						"}";
				tempElemntEvents += createScriptString(element.getEvents(),element.getId());
			}
			script = script.replace("//listener", tempElemntEvents);
			return template;
		}
		catch(IOException e){
			throw e;
		}
	}
	public String createScriptString(List<Event> events,String elementId){
		String scriptContainer = "";
		for(Event event:events){
			scriptContainer+="$('#"+elementId+"').on('"+event.get_triggerOn()+"',function(e){"+
								"location.href = '"+(event.getAdditional_params().getPageid().equals(homepage)?"index":event.getAdditional_params().getPageid())+".php';"+
								"})";
		}
		return scriptContainer;
	}
	public String createFooterString(Footer footer) throws IOException{
		try{
			css += ".footer{"+
					"background-color:"+footer.getBackground_color()+";"+
					"border-top-color:"+footer.getBorder_top_color()+";"+
					"border-top-style:"+footer.getBorder_top_style()+";"+
					"border-top-width:"+footer.getBorder_top_width()+";"+
					"height:"+footer.getHeight()+";"+
					"width:"+footer.getWidth()+";"+
					"}";
			String template = FileUtils.readFileToString(new File(templatePath+"footer.php"));
			return template;
		}
		catch(IOException e){
			throw e;
		}
	}
	public void createView(String filename,String content) throws IOException{
		try{		
			File file = new File(projectBasePath+currentDir+filename);
			if (file.createNewFile()){
				System.out.println("File is created!");
			}else{
				System.out.println("File already exists.");
			}
			FileUtils.writeStringToFile(file, content);
		}
		catch(IOException e){
			throw e;
		}
	}
	public void createDirectory(String dirName)
	{	
		// ex: "C:\\Directory2\\Sub2\\Sub-Sub2"
		File file = new File(projectBasePath+dirName);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
	public void copyTemplateLibrary(String projectName) throws IOException{
		try{
			//copy jquery
			String template = FileUtils.readFileToString(new File(templatePath+"jquery.js"));
			createView("jquery.js",template);
			// end copy jquery
		}
		catch(IOException e){
			throw e;
		}
	}
}
