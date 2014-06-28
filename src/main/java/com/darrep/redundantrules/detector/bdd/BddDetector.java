package com.darrep.redundantrules.detector.bdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.JFactory;

import com.darrep.redundantrules.detector.RedundantRuleDetector;
import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;
import com.darrep.redundantrules.model.Value;
import com.darrep.redundantrules.model.Variable;

public class BddDetector
implements RedundantRuleDetector {
	
	private static final int NUMBER_OF_NODES = 10 * 1024 * 1024;
	private static final double CACHE_SIZE_RATIO = 0.1;
	private static final int CACHE_SIZE = (int)(NUMBER_OF_NODES * CACHE_SIZE_RATIO);
	private static final int VARIABLE_GROWTH_COUNT = 10;

	private BDDFactory factory = JFactory.init(NUMBER_OF_NODES, CACHE_SIZE);
	private Map<Value, BDD> bddForValue = new HashMap<>();
	private BDD bddCombinedRules = null;

	@Override
	public List<Rule> detectRundantRules(RuleList ruleList) {
    	List<Rule> result = new ArrayList<>();
    	
    	for (Rule rule : ruleList) {
     		
    		BDD bddRule = null;
    		
    		for (Map.Entry<Variable, Set<Value>> valuesForVariable : rule) {
        		BDD bddVariable = null;
  
        		for (Value value : valuesForVariable.getValue()) {
        			BDD bddValue = bddValueForValue(value);
        			
    				if (bddVariable != null) {
    					bddVariable = bddVariable.or(bddValue); 
    				} else {
    					bddVariable = bddValue;
    				}
        		}
    			
        		if (bddVariable != null) {
	    			if (bddRule != null) {
    					BDD newRule = bddRule.and(bddVariable);
	    				bddRule = newRule;
	    			} else {
	    				bddRule = bddVariable;
	    			}
        		}
    		}
    		
			if (bddRule == null) {
				bddRule = factory.one();
			}
			
    		if (bddCombinedRules != null) {
    			BDD newBddCombinedRules = bddCombinedRules.or(bddRule);
    			
    			if (newBddCombinedRules.equals(bddCombinedRules)) {
	    			result.add(rule);
    				System.out.print("REDUNDANT: " + rule);
    			}
    			
    			bddCombinedRules = newBddCombinedRules;    			
    		} else {
    			bddCombinedRules = bddRule;
    		}
    	}
     
       	return result;
    }

	private BDD bddValueForValue(Value value) {
		BDD bddValue = bddForValue.get(value);
		
		if (bddValue == null) {
			if (factory.varNum() == bddForValue.size()) {
				factory.extVarNum(VARIABLE_GROWTH_COUNT);
			}
			
			bddValue = factory.ithVar(bddForValue.size());
			
			bddForValue.put(value, bddValue);
		}
		return bddValue;
	}
}
