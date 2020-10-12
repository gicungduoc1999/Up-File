package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import model.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	// load file
	@RequestMapping("driver1")
	public String driver(ModelMap model) {

		List<FileO> list = file();

		model.addAttribute("listFile", list);
		return "driver/driver";
	}
	//create file 
	@RequestMapping("create")
	public String create(ModelMap model) {

		File folder = new File("src/main/resources/file/test");
		folder.mkdir();

		
		return "redirect:driver1";
	}
	// up file
	@PostMapping("upFile")
	public String upFile(ModelMap model,@RequestParam("file") MultipartFile file
			,HttpServletRequest request) {
      String p = request.getServletContext().getRealPath(file.getOriginalFilename());
		
		try {
			file.transferTo(new File(p));
			String out ="src/main/resources/file/"+file.getOriginalFilename();
			copy(p, out);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		return "redirect:driver1";
	}
	
	 public void copy(String in,String out) throws IOException {
		 var source = new File(in);
	        var dest = new File(out);

	        try (var fis = new FileInputStream(source);
	             var fos = new FileOutputStream(dest)) {

	            byte[] buffer = new byte[1024];
	            int length;

	            while ((length = fis.read(buffer)) > 0) {

	                fos.write(buffer, 0, length);
	            }
	        }
	    }
	 
	

	public List<FileO> file() {
		List<FileO> listFile = new ArrayList<FileO>();
		File folder = new File("src/main/resources/file");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			FileO f = new FileO();
			// check File
			if (listOfFiles[i].isFile()) {

				String ful = listOfFiles[i].getName() + "";
			
				// check folder

				// get exextension
				String ex = ful.substring(ful.lastIndexOf("."), ful.length());

				if (ex.equals(".mp3")) {
					f.setExtension("mp3");

				} else if (ex.equals(".txt")) {
					f.setExtension("txt");

				} else if (ex.equals(".mp4")) {
					f.setExtension("mp4");

				}
				// get name
				String name = ful.substring(0, ful.lastIndexOf("."));
				f.setName(name);

				listFile.add(f);

			} else if (listOfFiles[i].isDirectory()) {
				
				String name = listOfFiles[i].getName();
				f.setName(name);
				f.setExtension("");
				listFile.add(f);

			}
		}
		return listFile;
	}

}
