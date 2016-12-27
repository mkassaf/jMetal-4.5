package jmetal.problems.singleObjective;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.BinarySolutionType;
import jmetal.encodings.variable.Binary;
import jmetal.util.JMException;

public class HrReseources extends Problem {

	public int numberOfBugs_;
	public int[][] bugsDetailsMatrix_;

	public HrReseources(String solutionType, String filename) {
		numberOfVariables_ = 50; // number of bugs
		numberOfObjectives_ = 1;
		numberOfConstraints_ = 0;
		problemName_ = "HrReseources";

		solutionType_ = new BinarySolutionType(this);

		length_ = new int[numberOfVariables_];

		try {
			if (solutionType.compareTo("Binary") == 0)
				solutionType_ = new BinarySolutionType(this);
			else {
				throw new JMException("Solution type invalid");
			}
		} catch (JMException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		try {
			readProblem(filename);
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		System.out.println("Number of Bugs : " + numberOfBugs_);
		for (int i = 0; i < length_.length; i++) {
			length_[i] = 3; // variable length
		}

	}

	@Override
	public void evaluate(Solution solution) throws JMException {
		Binary variable;
		int counterOnes;
		int counterZeroes;

		  Binary[] variables = (Binary[]) solution.getDecisionVariables();
		  

	}

	public void readProblem(String fileName) throws IOException {
		Reader inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
	}

}
