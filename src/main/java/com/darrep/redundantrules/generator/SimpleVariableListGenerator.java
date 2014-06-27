package com.darrep.redundantrules.generator;

import com.darrep.redundantrules.model.Variable;
import com.darrep.redundantrules.model.VariableList;

public class SimpleVariableListGenerator {
	private static final SimpleVariableListGenerator instance = new SimpleVariableListGenerator();
	
	public static SimpleVariableListGenerator get() {
		return instance;
	}
	
	public VariableList generate(int numberOfVariables, int domainSize) {
		VariableList result = new VariableList();

		for (int variableIndex = 0; variableIndex < numberOfVariables; variableIndex++) {
			result.add(new Variable(variableIndex, domainSize));
		}

		return result;
	}
}
