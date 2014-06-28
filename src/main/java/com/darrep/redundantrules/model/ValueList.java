package com.darrep.redundantrules.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ValueList
implements Iterable<Value> {
	private final Variable variable;
	private final Set<Value> values = new HashSet<>();
	
	public ValueList(Variable variable) {
		assert variable != null;
		
		this.variable = variable;
	}
	
	void addValue(Value value) {
		values.add(value);
	}
	
	@Override
	public Iterator<Value> iterator() {
		return values.iterator();
	}
	
	@Override
	public String toString() {
		return "ValueList of " + variable + " with " + values.size() + " values";
	}
}
