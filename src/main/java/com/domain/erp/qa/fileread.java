package com.domain.erp.qa;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class fileread  {
	
Properties p=new Properties();


public static void main(String[] args) throws IOException {
	Properties p=new Properties();
	FileReader file=new FileReader("src/test/resources/config.prperties.txt");
	p.load(file);

	String result=p.getProperty("test");
	System.out.println(result);
	
	}}

