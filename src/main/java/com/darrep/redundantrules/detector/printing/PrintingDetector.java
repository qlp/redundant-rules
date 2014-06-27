package com.darrep.redundantrules.detector.printing;

import java.util.Collections;
import java.util.List;

import com.darrep.redundantrules.detector.RedundantRuleDetector;
import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;

public class PrintingDetector
implements RedundantRuleDetector {
	@Override
	public List<Rule> detectRundantRules(RuleList ruleList) {
        System.out.println("ruleList = " + ruleList);
        
        for (int ruleIndex = 0; ruleIndex < ruleList.size(); ruleIndex++) {
            System.out.println("rule[" + ruleIndex + "] = " + ruleList.getRule(ruleIndex));
        }
        
        return Collections.emptyList();
	}
}
