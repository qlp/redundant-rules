package com.darrep.redundantrules.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleList 
implements Iterable<Rule> {
	private List<Rule> rules = new ArrayList<>();
	
	public void add(Rule rule) {
		assert rule != null;
		
		rules.add(rule);
	}
	
	public Iterator<Rule> iterator() {
		return rules.iterator();
	}
	
	@Override
	public String toString() {
		return "RuleList with " + rules.size() + " rules";
	}
}
