/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model.autogenerate.test;

import java.io.IOException;
import org.civmmo.model.autogenerate.Generator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattysek
 */
public class GeneratorTest {
    
    public GeneratorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestGenerator() throws IOException
    {
        Generator.Generate();
        assertTrue(true);
    }
    
}
