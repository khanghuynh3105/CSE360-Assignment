/** 
 * Author: Khang Huynh
 * Class ID: kphuynh1
 * Assignment 2
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
	 * If the list was initially full, then increase the size by 50% so there will be room.
	 * Increment the count as needed.
	 * @param element
	 */
	public void add(int element) {
		
		if (count == list.length) //increases the current list's size by 50% if it is full
			newSize(3 * count / 2);
		
		for (int i = count; i > 0; i--) //right-shifts remaining element(s)
			list[i] = list[i-1];
		
		list[0] = element;
		count++;
	}
	
	/**
	 * Method which removes the parameter if in the list. 
	 * The other values in the list may need to be moved down. 
	 * Adjust the count as needed.
	 * If the list has more than 25% empty places, the decrease the size of the list.
	 * The list cannot be reduced to less than 1 entry.
	 * @param element
	 */
	public void remove(int element) {
		int location = search(element);
		
		if (location != -1) {
			for (int i = location; i < count - 1; i++)
				list[i] = list[i+1]; //left-shifts remaining element(s)
		}
		
		count--;
		
		if (count < 3 * list.length / 4) //if the current list has more than 25% empty places, decrease the list's size
			newSize(count);
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
	/**
	 * Method which appends the parameter to the end of the list.
	 * If the list was full, then increase the size by 50% so there will be room.
	 * Increment the count.
	 */
	public void append(int element) {
		if (count == list.length) //increases the current list's size by 50% if it is full
			newSize(3 * count / 2);
		
		list[count] = element; //appends the parameter to the end of the current list
		count++;
	}
	
	/**
	 * Method which returns the first element in the list.
	 * If there are no elements in the list, then return -1.
	 */
	public int first() {
		int result = list[0];
		
		if (count == 0)
			result = -1;
		
		return result;
	}
	
	/**
	 * Method which returns the last element in the list.
	 * If there are no elements in the list, then return -1.
	 */
	public int last() {
		int result = list[list.length - 1];
		
		if (count == 0)
			result = -1;
		
		return result;
	}
	
	/**
	 * Method which returns the current number of possible locations in the list.
	 * @return
	 */
	public int size() {
		return list.length;
	}
	
	/**
	 * This method changes the size of the current array based on the input new size.
	 */
	public void newSize(int newSize) {
		int newArr[] = new int[newSize];
		
		for (int i = 0; i < newSize && i < count; i++) //copy current array's element(s) to the resized array 
			newArr[i] = list[i];
		
		list = newArr; //replaces the old array with the resized one
		
		if (newSize < count)
			count = newSize;
	}
}