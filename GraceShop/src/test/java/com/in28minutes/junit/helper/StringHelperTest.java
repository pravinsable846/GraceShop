package com.in28minutes.junit.helper;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class StringHelperTest {

@Test
public void Test() {
	
	StringHelper helper = new StringHelper();
//	String actual = helper.truncateAInFirst2Positions("AACD");
//	String expected ="cd";
	
	assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
	assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
}
}
