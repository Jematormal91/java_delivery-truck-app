# DELIVERY TRUCK

Implement the application that keeps track of package deliveries to consumers. The application consists of the following classes:
* **Item**: Create a class called Item. The class has two-member variables of type String named name and description and provides getter and setter methods for both.
* **Mail (abstract class)**: Implement an abstract class called Mail. The class has a member variable of type String named address and a getter method for it.
* **Letter**: Implement a class called Letter that inherits from Mail. The class has one-member variable of type String and a getter method for it.
* **Package**: Implement a class called Package. The class has one-member variable of type Item[] named items and a getter method for it.
* **DeliveryTruck**: Implement a class called DeliveryTruck with a single member variable of type Mail[] of length 10. Add the following method:
  * **void load(Mail mail)**: This method stores the given mail argument at the next available spot in the member variable.

Create a class called **Test.java**

In main method, creates five instances of **Letter** and **Package** , use your own data. 

Create object of **DeliveryTruck** to load letters and packages.

*Note: Try to think of real delivery truck that has some letters and packages.
The DeliveryTruck class overrides toString() method to display
packages and letters information that includes number of letter and packages.
Item[]*
 
