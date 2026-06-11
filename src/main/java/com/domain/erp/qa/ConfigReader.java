package com.domain.erp.qa;


	import java.io.*;
	import java.util.Properties;

	public class ConfigReader {

	    private static Properties props = new Properties();

	    static {
	        try {
	            props.load(new FileInputStream(
	                "src/main/resources/config.properties"));
	            System.out.println("Config loaded");
	        } catch (IOException e) {
	            throw new RuntimeException(
	                "Config load failed: " + e.getMessage());
	        }
	    }

	    public static String get(String key) {
	        String value = props.getProperty(key);
	        if (value == null) {
	            throw new RuntimeException(
	                "Key not found: " + key);
	        }
	        return value.trim();
	    }

	    public static int getInt(String key) {
	        return Integer.parseInt(get(key));
	    }

	    public static boolean getBoolean(String key) {
	        return Boolean.parseBoolean(get(key));
	    }

	    public static void main(String[] args) {
	        System.out.println("URL: " + get("baseUrl"));
	        System.out.println("Browser: " + get("browser"));
	        System.out.println("Timeout: " + getInt("timeout"));
	        System.out.println("Environment: " + get("environment"));
	    }
	}

