import java.util.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jeanelle Torres on 11/30/2021
 */

public class Test{
    
    
    //create five instances of Letter and Package
    public static void main(String[] args){
        
    Letter letter_1 = new Letter ("Christmas card");
    letter_1.setAddress("123 Riverside Dr.");

    Letter letter_2 = new Letter ("wedding invitation");
    letter_2.setAddress("11 Mckinley Ave.");
    
    Letter letter_3 = new Letter ("Birthday card");
    letter_3.setAddress("140 Neptune St.");
    
    Letter letter_4 = new Letter ("penpal update letter");
    letter_4.setAddress("33 Stars Hollow rd.");
    
    Letter letter_5 = new Letter ("letter from home to son");
    letter_5.setAddress("200 Santa Monica Blvd.");
    
    
    Item[] items = new Item [5];
    Item package_1 = new Item ();
    package_1.setName("Jeanelle");
    package_1.setDescription("dog toys");
    items[0] = package_1;

    Item package_2 = new Item ();
    package_2.setName("Jeanette");
    package_2.setDescription("care package");
    items[1] = package_2;
    
    Item package_3 = new Item ();
    package_3.setName("Mary");
    package_3.setDescription("graduation supplies");
    items[2] = package_3;
    
    Item package_4 = new Item ();
    package_4.setName("Susan");
    package_4.setDescription("Amazon order");
    items[3] = package_4;
    
    Item package_5 = new Item ();
    package_5.setName("John");
    package_5.setDescription("medicine");
    items[4] = package_5;
    
    Package packages = new Package (items);
    packages.setAddress("delivering within the continental US");
    

    DeliveryTruck delivery = new DeliveryTruck();
    delivery.load(letter_1);
    delivery.load(letter_2);
    delivery.load(letter_3);
    delivery.load(letter_4);
    delivery.load(letter_5);
    delivery.load(packages);

    System.out.println(delivery.toString());
    
    System.out.println("Packages " + packages.getAddress() + ":");
    for(Item i : items){
        System.out.println(i);
    }
    System.out.println("\nLetters:\n");
    System.out.println(letter_1.toString());
    System.out.println(letter_2.toString());
    System.out.println(letter_3.toString());
    System.out.println(letter_4.toString());
    System.out.println(letter_5.toString());
    }
}

//class item with given parameter
class Item{
   private String name;
   private String description;
   
   public Item(){
   }
//   public Item(String name, String description){
//       this.name = name;
//       this.description = description;
//   }
   
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getDescription() {
       return description;
   }
   public void setDescription(String description) {
       this.description = description;
   }
   @Override
   public String toString() {
       return getDescription() + " for " + getName();
   }

}

//abstract class Mail with given parameter
abstract class Mail{
   private String address;
   
   public String getAddress()
   {
       return this.address;
   }
   public void setAddress(String address){
       this.address = address;
   }
}

// class Letter who inherit the Mail class
class Letter extends Mail {
   private String contents;
   
   public Letter(String contents){
       this.contents = contents;
   }
   public String getContents(){
       return this.contents;
   }
   @Override
   public String toString(){
       return getContents() + " to be delivered at " + getAddress();
   }
}


// class Package inherits the Mail class
class Package extends Mail{
  
   Item[] items;
  
   public Item[] getItems() {
       for (Item i : items){
           System.out.println(i);
       }
    }
    
   
   public Package(){}
//   
   public Package(Item[] items){
       this.items = items;
   }
//   
   @Override
   public String toString(){
       
    return "Sending packages to " + getAddress() + " that contains: ";
    
    }
}

//class DeliveryTruck
class DeliveryTruck {
   // Mail type array of maxsize 10
   Mail[] mails = new Mail[10];
   
   public DeliveryTruck(){}

   void load(Mail mail) {
       try {
//        find next available spot
       int i = 0;
       for(i=0;i<mails.length;i++)
       {
           if(mails[i]!=null)
           {
               i++;
           }
           else break;
       }
      
       mails[i] = mail;
      
   } catch (Exception ignore) {}
}
   @Override
   public String toString() {
       return "There are 5 letters and 5 packages as follows:\n"; 
   }
  
}



