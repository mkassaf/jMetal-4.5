package edu.birzeit.searchbased.assiagments;

import java.io.FileNotFoundException;
import java.io.IOException;

import jmetal.metaheuristics.singleObjective.geneticAlgorithm.TSPGA_main;
import jmetal.util.JMException;

public class Assiagment_1 {

	public Assiagment_1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			for (int i = 21; i < 30; i++) {
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
