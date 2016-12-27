package edu.birzeit.searchbased.assiagments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import jmetal.metaheuristics.singleObjective.geneticAlgorithm.TSPGA_main;
import jmetal.util.JMException;

public class Assiagment_1 {

	public Assiagment_1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("MyLogFile.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info("My first log");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	    logger.log(Level.INFO,"test");
		try {
			for (int i = 20; i < 30; i++) {
				String x = String.valueOf(i);
				String[] number = {x};
				TSPGA_main.main(number);
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
