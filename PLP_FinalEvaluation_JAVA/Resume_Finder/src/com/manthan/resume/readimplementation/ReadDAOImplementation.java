package com.manthan.resume.readimplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.manthan.resume.bean.Resumebean;

public class ReadDAOImplementation implements ReadDAO {

	@Override
	public Resumebean PDFRead(File file, String searchfile) throws IOException {

		Resumebean resume_bean = new Resumebean();

		PDDocument document = PDDocument.load(file);

		//Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();

		//Retrieving text from PDF document
		String text = pdfStripper.getText(document);

		String lineText = text.replaceAll("\n", " ").replaceAll("\r", " ").toLowerCase();

		if(lineText.contains(searchfile)) 
		{
			resume_bean.setName(file.getName());
			resume_bean.setFile_name(file.getName());
			String email = null;

			String[] arr = lineText.split(" ");

			for(String s:arr) {
				String patternString1 ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
				Pattern pattern = Pattern.compile(patternString1);
				Matcher matcher = pattern.matcher(s);


				while(matcher.find()) {
					email = matcher.group();
				}
				resume_bean.setEmail(email);
			}
		}
		//Closing the document
		try {
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resume_bean;
	}

	@Override public Resumebean DOCRead(File file, String searchfile){

		Resumebean resume_bean = new Resumebean();

		try {
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			
			String text = extractor.getText();
			
			//System.out.println(text);
			
			String lineText = text.replaceAll("\n", " ").replaceAll("\r", " ").toLowerCase();
			
			//System.out.println(newText);
			
			if(lineText.contains(searchfile)) {
				String[] array = lineText.split(" ");
				String email=null;
				
				for(String string : array) 
				{
					//System.out.println("1526348");
					Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
					Matcher matcher = pattern.matcher(string);

					while(matcher.find())
					{
						email = matcher.group();
						//System.out.println("Email" + email);
					}

				}

				resume_bean.setName(file.getName());
				resume_bean.setFile_name(file.getName());
				resume_bean.setEmail(email);
				
				//System.out.println(resume_bean.getName());
				
			}
			// Closing the document
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return resume_bean; 
	}

}
