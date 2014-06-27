package com.darrep.redundantrules.model;

import java.util.ArrayList;
import java.util.List;

public class VariableList {
	private List<Variable> variables = new ArrayList<>();
	
	public void add(Variable variable) {
		assert variable != null;
		
		variables.add(variable);
	}
	
	public int size() {
		return variables.size();
	}
	
	public Variable getVariable(int index) {
		assert index >=0 && index < variables.size();
		
		return variables.get(index);
	}
	
	@Override
	public String toString() {
		return "variableList with variables " + variables;
	}
}
