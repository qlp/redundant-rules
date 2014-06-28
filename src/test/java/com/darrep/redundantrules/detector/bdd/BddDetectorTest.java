package com.darrep.redundantrules.detector.bdd;

import com.darrep.redundantrules.detector.AbstractDetectorTest;
import com.darrep.redundantrules.detector.RedundantRuleDetector;

public class BddDetectorTest 
extends AbstractDetectorTest
{
	@Override
	protected RedundantRuleDetector newDetector() {
        return new BddDetector();
    }
}
