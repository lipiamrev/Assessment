package com.manthan.resume.readimplementation;

import java.io.File;
import java.io.IOException;

import com.manthan.resume.bean.Resumebean;

public interface ReadDAO {
	
	public Resumebean PDFRead(File file, String searchfile) throws IOException;
	
	public Resumebean DOCRead(File file, String searchfile);

}
