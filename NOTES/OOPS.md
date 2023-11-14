### Abstraction:




## Java Generics


# Classes and Objects in Java https://www.geeksforgeeks.org/classes-objects-java/
In Java, classes and objects are basic concepts of Object Oriented Programming (OOPs) that are used to represent real-world concepts and entities.
The class represents a group of objects having similar properties and behavior. 
For example, the animal type Dog is a class while a particular dog named Tommy is an object of the Dog class.
## Objects in java
2 types of objects:
1. Mutable:
   2. Immutable:
       - Immutable classes cannot be changed after construction. So, for example, a Java String is immutable.
       - To make a class immutable, you have to make it final and all the fields private and final. For example the following class is immutable: 
       - ```java
           public final class Person {
    
            private final String name;
            private final int age;
            private final Collection<String> friends;
    
            public Person(String name, int age, Collection<String> friends) {
                this.name = name;
                this.age = age;
                this.friends = new ArrayList(friends);
            }
    
            public String getName() { 
                return this.name;
            }
    
            public int getAge() {
                return this.age;
            }
    
            public Collection<String> getFriends() {
                return Collections.unmodifiableCollection(this.friends);
            }
           }
      ```
      