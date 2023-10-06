/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        
     // Test Case 1: Code is not written by yourself, but is publicly available with proper citation
        assertTrue("Expected true: publicly-available code with proper citation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
        
        // Test Case 2: Code is not written by yourself, is required for the assignment, and written as coursework
        assertTrue("Expected true: non-self-written required code written as coursework",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));
        
        // Test Case 5: Code is not written by yourself, is required for the assignment, but not written as coursework
        assertFalse("Expected false: non-self-written required code not written as coursework",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, false));
    }
}