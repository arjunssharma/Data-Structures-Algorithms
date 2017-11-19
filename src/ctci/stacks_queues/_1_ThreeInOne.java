package ctci.stacks_queues;

import java.util.EmptyStackException;

public class _1_ThreeInOne {
	
	//stack number 0, 1, 2
	private int noOfStacks = 3;
	private int stackCapacity;
	private int values[];
	private int sizes[];
	
	public _1_ThreeInOne(int stackSize) {
		this.stackCapacity = stackSize;
		values = new int[stackCapacity * noOfStacks];
		sizes = new int[noOfStacks];
	}
	
	public void push(int stackNumber, int item) throws Exception{
		if(isFull(stackNumber)) {
			throw new Exception("Stack number " + stackNumber + " is full");
		}
		sizes[stackNumber]++;
		values[indexOfTop(stackNumber)] = item;
	}
	
	public int peek(int stackNumber) throws EmptyStackException{
		if(isEmpty(stackNumber)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNumber)];
	}

	public int pop(int stackNumber) throws EmptyStackException{
		if(isEmpty(stackNumber)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNumber);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNumber]--;
		return value;
	}
	
	public boolean isEmpty(int stackNumber) {
		return sizes[stackNumber] == 0;
	}
	
	public boolean isFull(int stackNumber) {
		return sizes[stackNumber] == stackCapacity;
	}
		
	public int indexOfTop(int stackNumber) {
		int offset = stackNumber * stackCapacity;
		int size = sizes[stackNumber];
		return offset + size - 1;
		
	}
	
	//Test
	public static void main(String args[]) throws Exception {
		_1_ThreeInOne object = new _1_ThreeInOne(3);
		object.push(0, 1);
		object.push(0, 2);
		object.push(0, 3);
		
		object.push(1, 4);
		object.push(1, 5);
		object.push(1, 6);
		
		object.push(2, 7);
		object.push(2, 8);
		object.push(2, 9);
		
		System.out.println(object.peek(0));
		System.out.println(object.peek(1));
		System.out.println(object.peek(2));
		
		System.out.println(object.pop(0));
		System.out.println(object.pop(0));
		System.out.println(object.pop(0));
		System.out.println(object.pop(0));
	}
}