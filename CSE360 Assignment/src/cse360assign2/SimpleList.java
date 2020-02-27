/** 
 * Author: Khang Huynh
 * Class ID: kphuynh1
 * Assignment 1
 * <p>
 * This Java class simulates a simple list based on an array of maximum 10 integers 
 * along with several methods working on it.
 */

package cse360assign2;

public class SimpleList {
	
	/**
	 * Declare variables
	 */
	private int list[];
	private int count;
	
	/**
	 * Default constructor which creates an array to hold 10 integers and sets count to 0
	 */
	public SimpleList() {
		count = 0;
		list = new int[10];
	}
	
	/**
	 * Method which adds the parameter to the list at the beginning (index = 0). 
	 * Move all the other integers in the list over so there is room. 
	 * If the list was full, then the last element “falls off” the list. 
	 * Increment the count as needed
	 * @param element
	 */
	public void add(int element) {
		while (count < 10) {
			if (count == 0)
				list[count] = element;		
			
			else {
				for (int i = count; i >= 0; i--) //right-shifts array
					list[i+1] = list[i];
			}
			
			list[0] = element;
			count++;
		}
		
		list[count-1] = 0;
		
		for (int i = count; i >= 0; i--)
			list[i+1] = list[i]; //right-shifts array
		
		list[0] = element;
		count++;
	}
	
	/**
	 * Method which removes the parameter if in the list. 
	 * The other values in the list may need to be moved down. 
	 * Adjust the count as needed
	 * @param element
	 */
	public void remove(int element) {
		int location = search(element);
		
		if (location != -1) {
			for (int i = location; i < count - 1; i++)
				list[i] = list[i+1]; //left-shifts array
		}
		
		count--;
	}
	
	/**
	 * Method which returns the number of elements stored in the list
	 * @return
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Method which returns the location of the parameter in the list. 
	 * If the parameter is not in the list, then return -1
	 * @param element
	 * @return
	 */
	public int search(int element) {
		int location = -1;
		
		for (int i = 0; i < count; i++) {
			if (list[i] == element)
				location = i;
		}

		return location;
	}
	
	/**
	 * Method which returns the list as a String. 
	 * The elements must be separated by a space. 
	 * This means there is not space after the last integer
	 */
	public String toString() {
		String str = "";
		
		for (int i = 0; i < count; i++) {
			str += list[i];
			
			if (i != count - 1)
				str += " ";
		}
			
		return str;
	}
}