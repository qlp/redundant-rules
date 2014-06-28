package com.darrep.redundantrules.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Rule
implements Iterable<ValueList> {
	private Map<Variable, ValueList> valueListByVariable = new HashMap<>();
	
	public void add(Value value) {
		assert value != null;
		
		Variable variable = value.getVariable();
		ValueList valueList = valueListByVariable.get(variable);
		
		if (valueList == null) {
			valueList = new ValueList(variable);
			
			valueListByVariable.put(variable, valueList);
		}
		
		valueList.addValue(value);
	}
	
	@Override
	public Iterator<ValueList> iterator() {
		return valueListByVariable.values().iterator();
	}
	
	@Override
	public String toString() {
		return "Rule:" + valueListByVariable.values().toString();
	}
}
