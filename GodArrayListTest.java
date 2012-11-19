package com.salesforce.arraylist;

import com.salesforce.util.ShittyTestUtil;

public class GodArrayListTest {

	public void testInitialization() {
		GodArrayList<String> list = new GodArrayList<String>(3);
		
		ShittyTestUtil.assertEquals(list.size(), 3, "List initialization failed");
		for(int i = 0; i < 3; i++)
			list.add("Message #" + i);
		
		for(int i = 0; i < 3; i++) 
			ShittyTestUtil.assertTrue(list.get(i) == null, "Element #" + i + " is other than null");
		
		for(int i = 3; i < 6; i++) 
			ShittyTestUtil.assertEquals(list.get(i), "Message #" + (i-3), "Element " + i + " failed");
	}
	
	public void testAddElement() {
		GodArrayList<String> list = new GodArrayList<String>(5);
		
		ShittyTestUtil.assertEquals(list.size(), 5, "List initialization failed");	
		ShittyTestUtil.assertTrue(list.add("test string") == true, "List add(elem) method failed");
		ShittyTestUtil.assertEquals(list.get(5), "test string", "List add(elem) test failed");
		ShittyTestUtil.assertEquals(list.size(), 6, "List is wrong size");	
	}
	
	public void testRemoveMiddleElement() {
		GodArrayList<String> list = new GodArrayList<String>(3);
		
		ShittyTestUtil.assertEquals(list.size(), 3, "List initialization failed");
		for(int i = 0; i < 3; i++)
			list.add("Message #" + i);
	
		ShittyTestUtil.assertEquals(list.size(), 6, "List is wrong size");
		list.remove(3);
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		
		for(int i = 0; i < 3; i++) 
			ShittyTestUtil.assertTrue(list.get(i) == null, "Element #" + i + " is other than null");
		
		for(int i = 3; i < 5; i++) 
			ShittyTestUtil.assertEquals(list.get(i), "Message #" + (i-2), "Element " + i + " failed");
	}
	
	public void testAddingMiddleElement() {
		GodArrayList<String> list = new GodArrayList<String>(5);
		
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		ShittyTestUtil.assertTrue(list.add(3, "test string") == true, "List add(index, elem) method failed");
	
		for(int i = 0; i < 3; i++) 
			ShittyTestUtil.assertTrue(list.get(i) == null, "Element #" + i + " is other than null");
		ShittyTestUtil.assertEquals(list.get(3), "test string", "Element 3 failed");
		for(int i = 4; i < 5; i++) 
			ShittyTestUtil.assertTrue(list.get(i) == null, "Element " + i + " failed");
	}
	
	public void testRemovingObject() {
		GodArrayList<String> list = new GodArrayList<String>(5);
		
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		list.add(3, "test string");
		ShittyTestUtil.assertTrue(list.remove("test string"), "List didn't remove element");
		ShittyTestUtil.assertEquals(list.size(), 5, "List element removal failed");
	}
	
	public void testSetMethod() {
		GodArrayList<String> list = new GodArrayList<String>(5);
		
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		ShittyTestUtil.assertTrue(list.set(4, "test string") == null, "Set method failed");
		ShittyTestUtil.assertEquals(list.get(4), "test string", "Set method test failed");
	}
	
	public void testEnsureCapacityMethod() {
		GodArrayList<String> list = new GodArrayList<String>(5);
		
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		list.ensureCapacity(3);
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		list.ensureCapacity(6);
		ShittyTestUtil.assertEquals(list.size(), 6, "List is wrong size");
	}
	
	public void testRemoveRange() {
		GodArrayList<String> list = new GodArrayList<String>(7);
		for(int i = 0; i < list.size(); i++) {
			list.set(i, "insert #" + i);
		}
		list.removeRange(2, 4);
		ShittyTestUtil.assertEquals(list.size(), 5, "List is wrong size");
		for(int i = 0; i < 2; i++) {
			ShittyTestUtil.assertEquals(list.get(i), "insert #" + i, "RemoveRange method test failed");
		}
		for(int i = 2; i < list.size(); i++) {
			ShittyTestUtil.assertEquals(list.get(i), "insert #" + (i+2), "RemoveRange method test failed");
		}
	}
}
