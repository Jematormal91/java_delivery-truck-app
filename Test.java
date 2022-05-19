import java.util.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jeanelle Torres on 12/04/2021
 */

public class Test{
    
    
    //create five instances of Letter and Package
    public static void main(String[] args){
        
        Letter l1,l2,l3,l4,l5;
        Package p1,p2,p3,p4,p5;
        
        l1 = new Letter("Christmas card");
        l2 = new Letter ("wedding invitation");
        l3 = new Letter ("Birthday card");
        l4 = new Letter ("penpal update letter");
        l5 = new Letter ("letter from home to son");
        
        Item p1_contents = new Item ();
        p1_contents.setName("Jeanelle");
        p1_contents.setDescription("dog toys");
        
        List<Item> p1_item = new ArrayList<>();
        p1_item.add(p1_contents);
        Item [] p1Arr = p1_item.toArray(new Item[0]);
        
        p1 = new Package (p1Arr);
        
        Item p2_contents = new Item ();
        p2_contents.setName("Jeannette");
        p2_contents.setDescription("care package");
        
        List<Item> p2_item = new ArrayList<>();
        p2_item.add(p2_contents);
        Item [] p2Arr = p2_item.toArray(new Item[0]);
        
        p2 = new Package (p2Arr);

        Item p3_contents = new Item ();
        p3_contents.setName("Mary");
        p3_contents.setDescription("graduation supplies");
        
        List<Item> p3_item = new ArrayList<>();
        p3_item.add(p3_contents);
        Item [] p3Arr = p3_item.toArray(new Item[0]);
        
        p3 = new Package (p3Arr);
        
        Item p4_contents = new Item ();
        p4_contents.setName("Susan");
        p4_contents.setDescription("Amazon order");
        
        List<Item> p4_item = new ArrayList<>();
        p4_item.add(p4_contents);
        Item [] p4Arr = p4_item.toArray(new Item[0]);
        
        p4 = new Package (p4Arr);
        
        Item p5_contents = new Item ();
        p5_contents.setName("John");
        p5_contents.setDescription("medicine");
        
        List<Item> p5_item = new ArrayList<>();
        p5_item.add(p5_contents);
        Item [] p5Arr = p5_item.toArray(new Item[0]);
        
        p5 = new Package (p5Arr);  
        
        l1.setAddress("123 Riverside Dr.");
        l2.setAddress("11 Mckinley Ave.");
        l3.setAddress("140 Neptune St.");
        l4.setAddress("33 Stars Hollow rd.");
        l5.setAddress("200 Santa Monica Blvd.");
        
        
        p1.setAddress("40 Jupiter St.");
        p2.setAddress("3500 Santa Monica Blvd.");
        p3.setAddress("1900 Wilcox Ave.");
        p4.setAddress("400 N. Face Dr.");
        p5.setAddress("11 Robinson Dr.");

        
        //creating delivery truck object
        DeliveryTruck delivery = new DeliveryTruck();
        
        //load letters to delivery truck
        delivery.load(l1);
        delivery.load(l2);
        delivery.load(l3);
        delivery.load(l4);
        delivery.load(l5);
        //load packages to delivery truck
        delivery.load(p1);
        delivery.load(p2);
        delivery.load(p3);
        delivery.load(p4);
        delivery.load(p5);
        
        
        System.out.println(delivery.toString());
        
        System.out.println("The letters and packages will be delivered to the following addresses:\n" + 
            l1.getAddress() + "\n" + l2.getAddress() +"\n" +l3.getAddress() +"\n" + l4.getAddress() +"\n" + l5.getAddress() +"\n" +
                p1.getAddress() +"\n" + p2.getAddress() +"\n" + p3.getAddress() +"\n" + p4.getAddress() +"\n" + p5.getAddress());
    }
}    
   

//class item with given parameter
class Item{
   private String name;
   private String description;

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
   
   @Override
   public String toString(){
       return contents;
   }
   
}


// class Package inherits the Mail class
class Package extends Mail{
  
   Item[] items;

   public Item[] getItems() {
       return this.items;
    }
     
   public Package(){}
//   
   public Package(Item[] items){
       this.items = items;
   }
   @Override
   public String toString(){
       for (Item i: items){
       return i.toString();
       }
       
   }

}

//class DeliveryTruck
class DeliveryTruck {
   // Mail type array of maxsize 10
   Mail[] mails = new Mail[10];
   
   public DeliveryTruck(){

   }
   
   
   void load(Mail mail) {

//        find next available spot
    
    
        
       for(int i=0;i<mails.length;i++)
       {
           if (mails[i] == null){
               mails[i] = mail;
               break;
           }
    }
       
 
   }
   @Override
   public String toString(){
       
       return "There are " + mails.length+ " letters and packages are to be delivered:\n" + "5 letters and 5 pakcages as follows:\n" +
               Arrays.toString(mails);
   }
}
