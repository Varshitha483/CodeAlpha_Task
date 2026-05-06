package inheritance2;

// Parent Class
public class Animal {
	public void sound() {
		System.out.println("Animal will make the sound.");
	}
}

// We have three child class - Dog, Cat, Cow

class Dog extends Animal{                            // If public is used before Dog(class) then we have to create a separate class.
	public void sound() {
		System.out.println("Dog Barks");
	}
}

class Cat extends Animal{
	public void sound() {
		System.out.println("Cat meows");
	}
}

class Cow extends Animal{
	public void sound() {
		System.out.println("Cow moos");
	}
}