package jmetal.metaheuristics.singleObjective.geneticAlgorithm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import jmetal.core.Algorithm;
import jmetal.core.Operator;
import jmetal.core.Problem;
import jmetal.core.SolutionSet;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import jmetal.operators.crossover.CrossoverFactory;
import jmetal.operators.mutation.MutationFactory;
import jmetal.operators.selection.SelectionFactory;
import jmetal.problems.singleObjective.HrReseources;
import jmetal.util.JMException;

public class HrReseourcesGA_main {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, JMException, ClassNotFoundException {
		Problem problem; // The problem to solve
		Algorithm algorithm; // The algorithm to use
		Operator crossover; // Crossover operator
		Operator mutation; // Mutation operator
		Operator selection; // Selection operator

		HashMap parameters; // Operator parameters

		String problemName = "/Users/EliasK/Work/Dev/Workspace/SBSE/usa13509.tsp.txt";

		problem = new HrReseources("Binary", problemName);

		algorithm = new gGA(problem) ;

		// Algorithm params
		algorithm.setInputParameter("populationSize", 100);
		algorithm.setInputParameter("maxEvaluations", 100000);

		// Mutation and Crossover for Real codification
		parameters = new HashMap();
		parameters.put("probability", 0.95);
		crossover = CrossoverFactory.getCrossoverOperator("TwoPointsCrossover", parameters);
		// crossover = CrossoverFactory.getCrossoverOperator("PMXCrossover");

		parameters = new HashMap();
		parameters.put("probability", 0.2);
		mutation = MutationFactory.getMutationOperator("SwapMutation", parameters);

		/* Selection Operator */
		parameters = null;
		selection = SelectionFactory.getSelectionOperator("BinaryTournament", parameters);

		/* Add the operators to the algorithm */
		algorithm.addOperator("crossover", crossover);
		algorithm.addOperator("mutation", mutation);
		algorithm.addOperator("selection", selection);

		/* Execute the Algorithm */
		long initTime = System.currentTimeMillis();
		SolutionSet population = algorithm.execute();
		long estimatedTime = System.currentTimeMillis() - initTime;
		System.out.println("Total time of execution: " + estimatedTime);

		/* Log messages */
		System.out.println("Objectives values have been writen to file FUN");
		population.printObjectivesToFile("FUN");
		System.out.println("Variables values have been writen to file VAR");
		population.printVariablesToFile("VAR");
	}
}
