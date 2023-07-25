# Java 'passed by Value' or 'Passed by reference'

First, what does pass by value and pass by reference mean?

1. Pass by value:
The method parameter values are copied to another variable and then the copied object is passed to the method. The method uses the copy.

2. Pass by reference:
An alias or reference to the actual parameter is passed to the method. The method accesses the actual parameter.

Everything in Java is passed by value. In case of an array (which is nothing but an Object), the array reference is passed by value (just like an object reference is passed by value).

When you pass an array to other method, actually the reference to that array is copied.

Any changes in the content of array through that reference will affect the original array.
But changing the reference to point to a new array will not change the existing reference in original method.
See this post: Is Java "pass-by-reference" or "pass-by-value"?

See this working example:
```java

public static void changeContent(int[] arr) {

// If we change the content of arr.
arr[0] = 10;  // Will change the content of array in main()
}

public static void changeRef(int[] arr) {
// If we change the reference
arr = new int[2];  // Will not change the array in main()
arr[0] = 15;
}

public static void main(String[] args) {
int [] arr = new int[2];
arr[0] = 4;
arr[1] = 5;

    changeContent(arr);

    System.out.println(arr[0]);  // Will print 10.. 
  
    changeRef(arr);

    System.out.println(arr[0]);  // Will still print 10.. 
                                 // Change the reference doesn't reflect change here..
}
```


Take another example:
```java
public static void main(String[] args) {
    Dog aDog = new Dog("Max");
    Dog oldDog = aDog;

    // we pass the object to foo
    foo(aDog);
    // aDog variable is still pointing to the "Max" dog when foo(...) returns
    aDog.getName().equals("Max"); // true
    aDog.getName().equals("Fifi"); // false
    aDog == oldDog; // true
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // change d inside of foo() to point to a new Dog instance "Fifi"
    d = new Dog("Fifi");
    d.getName().equals("Fifi"); // true
}
```


Read more about it.