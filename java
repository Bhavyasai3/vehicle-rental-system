import java.util.*;
import java.io.*;

//Packages 
package car;
public class Car{
	int kilometersTraveled;
	int hoursTraveled;
	
	public int getKilometersTraveled(){
		return kilometersTraveled;
	}
	
	public void setKilometersTraveled(int kilometersTraveled){
		this.kilometersTraveled = kilometersTraveled;
	}
	
	public int getHoursTraveled(){
		return hoursTraveled;
	}
	
	public void setHoursTraveled(int hoursTraveled){
		this.hoursTraveled = hoursTraveled;
	}
	
	public int calculateTotalCost(int ratePerHour){
		return ratePerHour*hoursTraveled;
	}
}

package bike;
public class Bike{
	int kilometersTraveled;
	int hoursTraveled;
	
	public int getKilometersTraveled(){
		return kilometersTraveled;
	}
	
	public void setKilometersTraveled(int kilometersTraveled){
		this.kilometersTraveled = kilometersTraveled;
	}
	
	public int getHoursTraveled(){
		return hoursTraveled;
	}
	
	public void setHoursTraveled(int hoursTraveled){
		this.hoursTraveled = hoursTraveled;
	}
	
	public int calculateTotalCost(int ratePerHour){
		return ratePerHour*hoursTraveled;
	}
}

package truck;
public class Truck{
	int kilometersTraveled;
	int hoursTraveled;
	
	public int getKilometersTraveled(){
		return kilometersTraveled;
	}
	
	public void setKilometersTraveled(int kilometersTraveled){
		this.kilometersTraveled = kilometersTraveled;
	}
	
	public int getHoursTraveled(){
		return hoursTraveled;
	}
	
	public void setHoursTraveled(int hoursTraveled){
		this.hoursTraveled = hoursTraveled;
	}
	
	public int calculateTotalCost(int ratePerHour){
		return ratePerHour*hoursTraveled;
	}
}

//Main Public Class
public class VehicleRental{
	public static void main(String[] args){
		int age;
		int ratePerHour;
		
		try{
			System.out.println("Enter your age:");
			Scanner sc = new Scanner(System.in);
			age = sc.nextInt();
			
			if(age<18){
				throw new Exception("You are below 18 and cannot rent a vehicle");
			}
			
			System.out.println("Enter your choice: Car, Bike or Truck");
			String choice = sc.next();
			
			System.out.println("Enter the rate per hour");
			ratePerHour = sc.nextInt();
			
			//Multi-threading
			Thread t1 = new Thread(new Runnable(){
				public void run(){
					if(choice.equals("Car")){
						car.Car c = new car.Car();
						c.setKilometersTraveled(10);
						c.setHoursTraveled(5);
						int totalCost = c.calculateTotalCost(ratePerHour);
						System.out.println("Total cost for Car is: "+totalCost);
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					if(choice.equals("Bike")){
						bike.Bike b = new bike.Bike();
						b.setKilometersTraveled(10);
						b.setHoursTraveled(5);
						int totalCost = b.calculateTotalCost(ratePerHour);
						System.out.println("Total cost for Bike is: "+totalCost);
					}
				}
			});
			
			Thread t3 = new Thread(new Runnable(){
				public void run(){
					if(choice.equals("Truck")){
						truck.Truck t = new truck.Truck();
						t.setKilometersTraveled(10);
						t.setHoursTraveled(5);
						int totalCost = t.calculateTotalCost(ratePerHour);
						System.out.println("Total cost for Truck is: "+totalCost);
					}
				}
			});
			
			t1.start();
			t2.start();
			t3.start();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
} 
