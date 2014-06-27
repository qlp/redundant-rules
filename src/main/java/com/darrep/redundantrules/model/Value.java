package com.darrep.redundantrules.model;

public class Value {
	private Variable variable;
	private int index;
	
	Value(Variable variable, int index) {
		assert variable != null;
		assert index >= 0;
		
		this.variable = variable;
		this.index = index;
	}
	
	public Variable getVariable() {
		return variable;
	}
	
	public int getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		return "val-" + index;
	}
	
	// --------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result
				+ ((variable == null) ? 0 : variable.hashCode());
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
		Value other = (Value) obj;
		if (index != other.index)
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}
}
