package com.darrep.redundantrules.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;
import com.darrep.redundantrules.model.Variable;
import com.darrep.redundantrules.model.VariableList;

public class SimpleRuleListGenerator {
	private static final SimpleRuleListGenerator instance = new SimpleRuleListGenerator();
	
	private Random random;
	
	private SimpleRuleListGenerator() {
		random = new Random();
	}
	
	public static SimpleRuleListGenerator get() {
		return instance;
	}
	
	public RuleList generate(VariableList variableList, int ruleCount) {
		RuleList result = new RuleList();
		
		for (int ruleIndex = 0; ruleIndex < ruleCount; ruleIndex++) {
			Rule rule = new Rule();
			
			for (int variableIndex = 0; variableIndex < variableList.size(); variableIndex++) {
				Variable variable = variableList.getVariable(variableIndex);
				
				int valuesToAdd = random.nextInt(variable.getDomainSize());
				
				List<Integer> valuesToSelect = new ArrayList<>();
				for (int valueIndex = 0; valueIndex < variable.getDomainSize(); valueIndex++) {
					valuesToSelect.add(valueIndex);
				}
				
				for (int valuesAdded = 0; valuesAdded < valuesToAdd; valuesAdded++) {
					int valueToAdd = valuesToSelect.get(random.nextInt(valuesToSelect.size()));
					
					rule.add(variable.getDomainValue(valueToAdd));
				}
			}
			
			result.add(rule);
		}
		
		return result;
	}
}
