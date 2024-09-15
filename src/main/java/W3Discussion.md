```java
public class Dog {
    private int age = 0;                // age is given in years, the default value is 0
    private String name = "Fido";       // default name is Fido

    Dog(String firstName, int firstAge) {
        name = firstName;
        age = firstAge;
        
        if (age < 0) {
            age = 0;
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void haveBirthdayParty() {
        age = age + 1;
        System.out.println("Happy birthday " + name + "! You are now " + age + " years old!");
    }

    public void printInfo() {
        System.out.println("This dog's name is " + name + " and he's " + age + " years old!");
    }
}
```
1. Can you create a new dog without specifying its name? Why or why not?
2. Is there any possible situation where a new Dog object uses its default name value? Can you explain how to reach that situation?
3. Which of the Dog class's methods are accessors? Which ones are mutators?
4. Can you use the methods provided to make a dog younger? (In other words, can you set age to a lower value than it already was?)
5. What are the lowest and highest possible age values that a Dog object can have?
Complete the main method below by writing code underneath each comment (assume your program has access to the Dog class).

1. No, I can't because there is only one constructor which includes a name parameter.
2. Yes, add a default constructor, `Dog(){}`.
3. `getAge()` and `getName()` are accessors. `setName()` is mutators.
4. No I can't because there is no any mutator about set age.
5. Zero is the lowest age for the dog, and the highest age depend on `int` which should be 2,147,483,647 (signed 32-bit). 

```java
public static void main(String[] args) {
    
    // Create a new Dog object. You can give it any name you want, but the age must be 3
    Dog dog = new Dog("Tom Cat",3);

    // Call the printInfo method to print the dog's information
    dog.printInfo();

    // Call the haveBirthdayParty method so the dog becomes 4 years old
    dog.haveBirthdayParty();
}
```
