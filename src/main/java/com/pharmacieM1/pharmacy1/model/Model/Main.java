package com.pharmacieM1.pharmacy1.model.Model;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import java.io.File;

public class Main {
	
    public static void main(String[] args) throws Exception {
       
        Tomcat tomcat = new Tomcat();
        
        // Set the port number for the embedded Tomcat server
        tomcat.setPort(8080);
        
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        
        // Get the web application context for your project
        String webAppPath = "http://localhost:8080/produits"; // Replace with the actual path to your web application
        Context context = tomcat.addWebapp("", new File(webAppPath).getAbsolutePath());
        
   
        Tomcat.addServlet(context, "ProduitController", new ProduitController());
        context.addServletMappingDecoded("/produits", "ProduitController");
        
        tomcat.start();
        
        // Wait for the server to initialize
        tomcat.getServer().await();
    }
}

