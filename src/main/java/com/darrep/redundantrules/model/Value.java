package com.darrep.redundantrules.model;

public class Value {
	private Variable variable;
	private int id;
	
	Value(Variable variable, int id) {
		assert variable != null;
		assert id >= 0;
		
		this.variable = variable;
		this.id = id;
	}
	
	public Variable getVariable() {
		return variable;
	}
	
	@Override
	public String toString() {
		return "val-" + id;
	}
	
	// --------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}
}
