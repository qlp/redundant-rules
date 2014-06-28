package com.darrep.redundantrules.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Rule
implements Iterable<Map.Entry<Variable, Set<Value>>> {
	private Map<Variable, Set<Value>> valuesByVariable = new HashMap<>();
	
	public void add(Value value) {
		assert value != null;
		
		Set<Value> valuesOfVariable = valuesByVariable.get(value.getVariable());
		
		if (valuesOfVariable == null) {
			valuesOfVariable = new HashSet<>();
			
			valuesByVariable.put(value.getVariable(), valuesOfVariable);
		}
		
		valuesOfVariable.add(value);
	}
	
	public Set<Value> getValueOfVariable(Variable variable) {
		assert variable != null;
		
		Set<Value> values = valuesByVariable.get(variable);
		
		Set<Value> result;
		if (values == null) {
			result = Collections.emptySet();
 		} else {
 			result = Collections.unmodifiableSet(values);
 		}
		
		return result;
	}

	@Override
	public Iterator<Entry<Variable, Set<Value>>> iterator() {
		return valuesByVariable.entrySet().iterator();
	}
	
	@Override
	public String toString() {
		return "Rule:" + valuesByVariable.toString();
	}
}
