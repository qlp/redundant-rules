package com.darrep.redundantrules.model;

import java.util.ArrayList;
import java.util.List;

public class Variable {
	private int id;
	private List<Value> domain;
	
	public Variable(int id, int domainSize) {
		assert domainSize > 0;
		
		this.id = id;
		this.domain = new ArrayList<>();
		
		for (int i = 0; i < domainSize; i++) {
			domain.add(new Value(this, i));
		}
	}
	
	public int getDomainSize() {
		return domain.size();
	}
	
	public Value getDomainValue(int index) {
		assert index >= 0 && index < domain.size() : "Index " + index + " out of bounds in " + domain;
				
		return domain.get(index);
	}
	
	@Override
	public String toString() {
		return "Var-" + id;
	}

	// --------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
