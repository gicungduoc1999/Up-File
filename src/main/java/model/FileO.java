package model;

public class FileO {
	private String name ;
	private String extension ;
	private String url ;
	
	
	
	
	
	public FileO() {
		
		// TODO Auto-generated constructor stub
	}
	public FileO(String name, String extension, String url) {
		
		this.name = name;
		this.extension = extension;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
