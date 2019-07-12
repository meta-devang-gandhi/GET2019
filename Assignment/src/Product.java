import java.util.Scanner;
public class Product {

	// variable defined for productlsit
	 private int[] itemID = new int[100];
	   private String[] itemName = new String[100];
	 
	   private int[] itemPrice = new int[100];
	   private int count=0;
	   
	    //variable defined for Cart item
	    private int[] idOfItem = new int[100];
	    private int[] itemQuantity = new int[100];
	    private int count1=0;
	    
	    
	   Scanner sc = new Scanner(System.in);
	   Product()
	   {
		   ProductList();
	   }
	   
	   //method for add all item 
	   public void ProductList()
	   {
		   addList(1, "item1", 20);
		   addList(2, "item2", 40);
		   addList(3, "item3", 120);
		   addList(4, "item4", 200);
		   addList(5, "item5", 80);
		   showProductList();
	   }
	   
	   

	   //product add on list
	   public void addList(int id, String name, int price)
	   {
		   itemID[count]=id;
		   itemName[count]=name;
		   itemPrice[count]=price;
		   
		   count+=1;
	   }
	   
	   //show the product list
	   public void showProductList()
	   {
		    System.out.println("PRoduct List");
		    System.out.println("ProductId\t \t Name \t \t Price");
		      for(int countItem=0; countItem<count; countItem++)  
		    		  System.out.println(itemID[countItem]+"\t  \t"+itemName[countItem]+"\t \t"+itemPrice[countItem]);
		 
		      System.out.println();
		  
	   }
	   
	   
	   // method for add product into cart
	   
	   public void addToCart()
	   {
		   	int ProductID;
		   	int Quantity;
		   	
		   	char Choice= 'y';
		   	
		   	while(Choice== 'y')
		   	{
		   		System.out.println("enter the product id which you want to add into cart");
		   		ProductID = sc.nextInt();
		   		
		   		System.out.println("enter the product Qantity");
		   		Quantity = sc.nextInt();
		   	
		   		 idOfItem[count1] = ProductID;
		   		 itemQuantity[count1] = Quantity;
		   		 
		   		 
		   	   count1++;
		   	 System.out.println("Do you want to add more items ?(y/n)");
		     Choice =sc.next().charAt(0); 
		   	}
		   	showCartItem();
		   	showChoiceMenu();
		   	
	   }
	   
	   
	   // method use for show the cart product
	   public void showCartItem()
	   {
		   System.out.println(" Cart Item List");
		    System.out.println("ItemId\t \t Name \t \t Quantity \t \t Price");
		      for(int countItem=0; countItem<count1; countItem++)
		      {
		    	  if(itemQuantity[countItem] > 0)
		    	  {
		    	    int storeItemId = idOfItem[countItem];
		    		  System.out.println(idOfItem[countItem]+"\t  \t"+itemName[storeItemId-1]+"\t \t"+itemQuantity[countItem]+"\t \t\t"+itemPrice[storeItemId-1]);
		    	  }
		    	  
		      }
		      System.out.println();
		      showChoiceMenu();
	   }
	   
	   // method used for removing product from  cart
	   
	   public void removeFromCart()
	   {
			int ProductID;
			char Choice= 'y';
			while(Choice== 'y')
		   	{
		   		System.out.println("enter the product Id which you want to remove into cart");
		   		ProductID = sc.nextInt();
		   		
		    	 for(int countItem=0; countItem<count1; countItem++)
			   	 {
			   		 if(idOfItem[countItem]== ProductID)
			   		 {
			   			 itemQuantity[countItem] = 0;
			   			 break;
			   		 }
			   	 }
			   	 System.out.println("Do you want to remove more items ?(y/n)");
			     Choice = sc.next().charAt(0);
			   	}
			   	showCartItem();
			   	showChoiceMenu();
		   	}	
	   
	  //update product Quantity
	   
	   public void updateProductQuantity()
	   {
		   int ProductID;
		   int Quantity;
			char Choice= 'y';
			while(Choice== 'y')
		   	{
		   		System.out.println("enter the product id which you want to change quantity into cart");
		   		ProductID = sc.nextInt();
		   		System.out.println("enter the product Qantity");
		   		Quantity = sc.nextInt();
		    	 for(int countItem=0; countItem<=count1; countItem++)
			   	 {
			   		 if(idOfItem[countItem]== ProductID)
			   		 {
			   			 itemQuantity[countItem] = Quantity;
			   			 break;
			   		 }
			   	 }
			   	 System.out.println("Do you want to update more items ?(y/n)");
			     Choice = sc.next().charAt(0);
			   	}
			   	showCartItem();
			   	showChoiceMenu();
	   }
	   
	   // generate Bill
	   
	   public void generateBill()
	   {
		   int totalAmount=0,costPerItem;
		   System.out.println("   BILL    ");
		    System.out.println("ItemId\t \t Name \t \t Quantity \t \t Price \t \t Amount");
		      for(int countItem=0; countItem<count1; countItem++)
		      {
		    	  if(itemQuantity[countItem] > 0)
		    	  {
		    		int id = idOfItem[countItem]; // id variable take for finding index no of product 
		    		  costPerItem =itemPrice[id-1]*itemQuantity[countItem];
		    		  totalAmount+=costPerItem;
		    		  System.out.println(idOfItem[countItem]+"\t \t"+itemName[id-1]+"\t \t"+itemQuantity[countItem]+"\t \t\t"+itemPrice[id-1]+"\t\t "+costPerItem);
		    		  
		    		  
		    	  }
		      }
		     
		      System.out.println("TOTAL AMOUNT = "+totalAmount);
		      System.out.println("\n");
		      showChoiceMenu();
	   }
	   
	   // for select option for method 
	   private void showChoiceMenu() {
	        System.out.println("Enter your choice\n1.Add item to cart\n 2.Show cart item \n 3.remove any item \n 4.update quantity  \n 5. proceed to bill \n 6. Exit");
	        int Choice = sc.nextInt();
	        switch (Choice) {
	            case 1:
	                addToCart();
	                break;
	            case 2 :
	            	showCartItem();
	            case 3:
	                removeFromCart();
	                break;
	            case 4:
	                updateProductQuantity();
	                break;
	            case 5:
	                generateBill();
	                break;
	           
	            case 7:
	            	System.out.println("Thank you for shopping");
	            	break;
	            default:
	                System.out.println("Incorrect choice...");
	        }
	    }
}
