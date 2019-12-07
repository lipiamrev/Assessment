package com.manthan.resume.servletsforjsp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manthan.resume.bean.Resumebean;
import com.manthan.resume.readimplementation.*;

@WebServlet("/resumeSearch")

public class SearchResume extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String keyword = request.getParameter("searchfile");

		Resumebean resume_bean = new Resumebean();
		
		List<Resumebean> filelist = new ArrayList<Resumebean>();

		File dir = new File("D:\\UploadResume\\");

		if(dir.isDirectory()){
			File[] listFiles = dir.listFiles();
			
			ReadDAOImplementation read = new ReadDAOImplementation();

			for(File f : listFiles) {
				
				if(f.getName().endsWith(".docx")||f.getName().endsWith(".doc")) {
					resume_bean = read.DOCRead(f, keyword);
				}
				else {
				resume_bean = read.PDFRead(f, keyword);
				}

				if (resume_bean.getFile_name() != null &&
						resume_bean.getName() != null &&
						resume_bean.getEmail() != null ) {
					filelist.add(resume_bean);

				}}

			if (filelist.isEmpty()) {
				request.setAttribute("message", "No records found");
			} else {
				request.setAttribute("filelist", filelist);
			}
			
		}
		request.getRequestDispatcher("./searchResume").forward(request, response);
	}
}


