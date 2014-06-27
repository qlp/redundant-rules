package com.darrep.redundantrules.detector;

import java.util.List;

import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;

public interface RedundantRuleDetector {
	public List<Rule> detectRundantRules(RuleList ruleList);
}
