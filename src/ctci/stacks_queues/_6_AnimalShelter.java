package ctci.stacks_queues;

import java.util.LinkedList;

public class _6_AnimalShelter {
	
}

class AnimalQueue {
	
	LinkedList<Dog> dogQueue = new LinkedList<Dog>();
	LinkedList<Cat> catQueue = new LinkedList<Cat>();
	private int order = 0; //for timestamp
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog) {
			dogQueue.add((Dog) a);
		}
		else if(a instanceof Cat) {
			catQueue.add((Cat) a);
		}
	}
	
	public Animal dequeueAny() {
		if(dogQueue.isEmpty())
			return dequeueCats();
		
		if(catQueue.isEmpty())
			return dequeueDogs();
		
		Dog dog = dogQueue.peek();
		Cat cat = catQueue.peek();
		
		if(dog.isOrderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
		
	}
	
	public Dog dequeueDogs() {
		return dogQueue.poll();
	}
	
	public Cat dequeueCats() {
		return catQueue.poll();
	}
}	

abstract class Animal {
	private int order;
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	public boolean isOrderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}