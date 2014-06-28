package com.darrep.redundantrules.detector;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.darrep.redundantrules.generator.SimpleRuleListGenerator;
import com.darrep.redundantrules.generator.SimpleVariableListGenerator;
import com.darrep.redundantrules.model.Rule;
import com.darrep.redundantrules.model.RuleList;

public abstract class AbstractDetectorTest 
{
    private static final int SMALL_NUMBER_OF_VARIABLES = 5;
    private static final int SMALL_DOMAIN_SIZE = 5;
    private static final int SMALL_NUMBER_OF_RULES = 5;

    private static final int MEDIUM_NUMBER_OF_VARIABLES = 7;
    private static final int MEDIUM_DOMAIN_SIZE = 7;
    private static final int MEDIUM_NUMBER_OF_RULES = 10;

    private static final int LARGE_NUMBER_OF_VARIABLES = 10;
    private static final int LARGE_DOMAIN_SIZE = 100;
    private static final int LARGE_NUMBER_OF_RULES = 1000;

	private RedundantRuleDetector detector;
	
    private static RuleList smallRuleList;
    private static RuleList mediumRuleList;
    private static RuleList largeRuleList;
    
    @BeforeClass
    public static void initRules() {
        smallRuleList = SimpleRuleListGenerator.get().generate(
        	SimpleVariableListGenerator.get().generate(SMALL_NUMBER_OF_VARIABLES, SMALL_DOMAIN_SIZE),
        	SMALL_NUMBER_OF_RULES);

        mediumRuleList = SimpleRuleListGenerator.get().generate(
        	SimpleVariableListGenerator.get().generate(MEDIUM_NUMBER_OF_VARIABLES, MEDIUM_DOMAIN_SIZE),
        	MEDIUM_NUMBER_OF_RULES);

        largeRuleList = SimpleRuleListGenerator.get().generate(
        	SimpleVariableListGenerator.get().generate(LARGE_NUMBER_OF_VARIABLES, LARGE_DOMAIN_SIZE),
        	LARGE_NUMBER_OF_RULES);
    }
    
    @Before
    public void before() {
    	detector = newDetector();
    }
    
    @Test(timeout=10000)
    public void testWithinTimeWithSmallRuleList() {
    	detectRundantRules(smallRuleList);
    }
    
    @Test(timeout=10000)
    public void testWithinTimeWithMediumRuleList() {
    	detectRundantRules(mediumRuleList);
    }
    
    @Test(timeout=10000)
    public void testWithinTimeWithLargeRuleList() {
    	detectRundantRules(largeRuleList);
    }

    protected List<Rule> detectRundantRules(RuleList ruleList) {
    	return detector.detectRundantRules(ruleList);
    }
    
    protected abstract RedundantRuleDetector newDetector();
}
