package Assignment;
//----------------------------------------------
// Assignment (One)
// © Your Name
// Written by: (include your name and student id)
//----------------------------------------------
import java.util.Scanner;

public class ComputerStore {

    public static void main(String[] args) {
        Scanner kb = new Scanner( System.in );

        System.out.println( "Welcome to Shadan and Behnaz computer's store!" );
        System.out.print( "Please enter the maximum number of computers the store can create: " );
        int maxNumber = kb.nextInt();
        Computer[] computerArray = new Computer[ maxNumber ];
        int numOfAdd = 0;
        int remaining = maxNumber;
        String brand;
        String model;
        double price;
        int menuInput= -1;
        boolean flage = true;
        Computer c= null;


        //Prompt user to input data up to exit step
        do {
            switch (menuInput) {
                case 1:
                   while (checkPassword()) {
                        System.out.println( "How many computers do you want to add?" );
                        numOfAdd = kb.nextInt();
                        if (numOfAdd > remaining) {
                            System.out.println( "Error!There are only " + remaining + "empty slots available.Can not add " + numOfAdd + "computer(s)!" );
                            continue;
                        } else {
                            for (int i = 0; i < numOfAdd; i++) {
                                System.out.println( "Computer " + i + 1 + " - Enter the brand:" );
                                brand = kb.next();
                                System.out.println( "Computer " + i + 1 + " - Enter the model:" );
                                model = kb.next();
                                System.out.println( "Computer " + i + 1 + " - Enter the price:" );
                                price = kb.nextDouble();
                                 c = new Computer( brand, model, price );
                                computerArray[ i ] = c;

                                remaining--;


                            }

                            System.out.println( "Successfully added " + numOfAdd + " computer(s)" );
                            System.out.println("======================================");
                            break;
                        }
                    }

                   break;


                case 2:
                    while (flage && checkPassword() ) {

                       if(c ==null)  {
                           System.out.println("There is no inventory to edit go to option 1 if you wish to add.");
                           break;
                       }

                        System.out.println( "Which computer do you like to edit? [1 -" + c.numberOfCreatedComputer() + " or enter 5 to exit:" );
                        int computerNumber = kb.nextInt();


                        if (computerNumber >= 1 && computerNumber <= maxNumber) {
                            int computerIndex = computerNumber - 1;
                            Computer computerToUpdate = computerArray[ computerIndex ];



                            if (computerToUpdate != null) {
                                System.out.println( "Computer # :" + computerNumber );
                                System.out.println( "brand # :" + computerToUpdate.getBrand() );
                                System.out.println( "Model # :" + computerToUpdate.getModel() );
                                System.out.println( "SN # :" + computerToUpdate.getSerialNumber() );
                                System.out.println( "price:" + computerToUpdate.getPrice() );


                                int updateChoice =-1;
                                do {

                                    switch (updateChoice) {
                                        case 1:
                                            System.out.print( "Enter the new brand: " );
                                            String newBrand = kb.next();
                                            computerToUpdate.setBrand( newBrand );
                                            break;
                                        case 2:
                                            System.out.print( "Enter the new model: " );
                                            String newModel = kb.next();
                                            computerToUpdate.setModel( newModel );
                                            break;
                                        case 3:
                                            System.out.print( "Enter the new price: $" );
                                            double newPrice = kb.nextDouble();
                                            computerToUpdate.setPrice( newPrice );
                                            break;

                                        case 4:
                                            System.out.print( "Enter the new price: $" );
                                            Long newSerialNum = kb.nextLong();
                                            computerToUpdate.setPrice( newSerialNum );
                                            break;

                                        case 5:
                                            System.out.println( "Exiting update menu." );
                                            System.out.println("=======================");
                                            flage = false;
                                            break;


                                        default:
                                            if (updateChoice!=-1) {
                                                System.out.println( "Invalid choice. Please enter a number between 1 and 5." );
                                            }
                                    }

                                    if (updateChoice >= 1 && updateChoice <= 4) {
                                        // Display updated information
                                        System.out.println( "\nUpdated information for Computer #" + computerNumber + ":" );
                                        System.out.println( computerToUpdate.toString() );
                                    }



                                 // Display update menu
                                    System.out.println( "What information would you like to change?" );
                                    System.out.println( "1. Brand" );
                                    System.out.println( "2. Model" );
                                    System.out.println( "3. Serial Number (SN)" );
                                    System.out.println( "4. Price" );
                                    System.out.println( "5. Quit" );
                                    System.out.print( "Enter your choice: " );
                                    updateChoice = kb.nextInt();



                                } while (updateChoice  < 6);
                            } else {
                                System.out.println("There is no inventory to edit go to option 1 if you wish to add.");
                                System.out.println("===========================================");
                                break;

                            }
                        } else {
                            System.out.println("This computer number  does not exist in the store ");
                            System.out.println("===========================================");
                            break;
                        }

                    }
                    break;

                case 3:
                    System.out.println( " Enter a brand name :" );
                    String br = kb.next();
                    findComputersBy( br, numOfAdd, computerArray );

                    break;

                case 4:
                    System.out.println( " Enter your desired price :" );
                    double pr = kb.nextDouble();
                    findCheaperThan(pr, numOfAdd,  computerArray);

                   break;

                case 5:
                    System.out.println( "We are glad you visited our store, Looking forward to seeing you again ");

                    System.exit( 0);

                default :
                    System.out.println("Invalid input, reenter your choice.");

            }
            System.out.println( "What do you want to do?" );
            System.out.println( "\t" + "1. Enter new computers (password required)" );
            System.out.println( "\t" + "2. Change information of a computer (password required" );
            System.out.println( "\t" + "3. Display all computers by a specific brand" );
            System.out.println( "\t" + "4. Display all computers under a certain a price." );
            System.out.println( "\t" + "5. Quit" );
            System.out.println( "Please enter your choice" );
            menuInput = kb.nextInt();

        }



        while (menuInput < 6);


    }

    public static boolean checkPassword() {
        Scanner kb = new Scanner( System.in );
        int numberOfWrongPass = 0;
        String password = "password";
        for (int i = 0; i < 3; i++) {
            System.out.print( "Please enter your password: " );
            String inputPass = kb.next();
            if (inputPass.equals( password )) {
                return true;
            } else {
                numberOfWrongPass++;
                System.out.print( "You have " + ( 3 - numberOfWrongPass ) + " tries left!   " );
            }
        }
        return false;
    }

    public static void findComputersBy(String br,int numOfAdd, Computer[] computerArray) {
        for (int i = 0; i < numOfAdd ; i++) {

            if (br.equals(computerArray[ i ].getBrand())) {

                System.out.println(computerArray[i]);
                System.out.println("============================");

            }
            else{
                System.out.println(" There is no computer with this brand in the store.");
            }
        }
    }
    public static void findCheaperThan(double pr,int numOfAdd, Computer[] computerArray) {
        for (int i = 0; i <numOfAdd ; i++) {

            if (pr > computerArray[ i ].getPrice()){
                System.out.println(computerArray[i]);
                System.out.println("============================");
            }
            else{
                System.out.println(" There is no computer cheaper than " +  pr +"$ in the store.");
                System.out.println("==============================");
            }

        }
    }
}