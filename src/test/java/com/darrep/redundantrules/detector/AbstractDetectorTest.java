package com.darrep.redundantrules.detector;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.darrep.redundantrules.generator.SimpleRuleListGenerator;
import com.darrep.redundantrules.generator.SimpleVariableListGenerator;
import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;
import com.darrep.redundantrules.model.VariableList;

public abstract class AbstractDetectorTest 
{
    private static final int NUMBER_OF_VARIABLES = 10;
    private static final int DOMAIN_SIZE = 100;
    private static final int NUMBER_OF_RULES = 1000;
    
	private final RedundantRuleDetector detector;
	
    private static RuleList ruleList;
    
    @BeforeClass
    public static void initRules() {
    	VariableList variableList = SimpleVariableListGenerator.get().generate(NUMBER_OF_VARIABLES, DOMAIN_SIZE);
        ruleList = SimpleRuleListGenerator.get().generate(variableList, NUMBER_OF_RULES);
    }
    
    public AbstractDetectorTest(RedundantRuleDetector detector)
    {
        this.detector = detector;
    }
    
    @Test(timeout=10000)
    public void testWithinTime() {
    	detectRundantRules();
    }

    protected List<Rule> detectRundantRules() {
    	return detector.detectRundantRules(ruleList);
    }
}
