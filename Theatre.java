import java.io.*; // The library java.io contain the necessary to read and write in a file
import java.util.ArrayList; // The ArrayList library is  imported here to later use in the program
import java.util.InputMismatchException; // This exception is imported to be used in the main()
import java.util.Scanner; // The scanner is used to read the inputs of the users

public class Theatre {

    // 3 Arrays filled with 0's are created to simulate the rows and seats of the theatre
    public static int[] seatsRow1 = new int[12];
    public static int[] seatsRow2 = new int[16];
    public static int[] seatsRow3 = new int[20];

    // The ArrayList of tickets is created to store the tickets information
    static ArrayList<Ticket> tickets = new ArrayList<>();

    static void buy_ticket(){
        /*
        This function has the purpose of buying the tickets, asks the information of hte tickets suck as the row, seat
        name, last name, email and price to then store everything in the ArrayList tickets, and also modify the values
        of the 3 arrays created at the beginning of the program.
         */
        try {
            // The row and seat inputs are asked
            Scanner input = new Scanner(System.in);

            System.out.println("Select a row: ");
            int row = input.nextInt();

            System.out.println("Select a seat: ");
            int seat = input.nextInt();

            // To skip an issue occurred on the nest input section I had to re-call the method input.nextLine(); to skip a line
            input.nextLine();

            // Row 1 is selected
            if (row == 1) {
                if (seatsRow1[seat - 1] == 0) { // If the seat is not occupied
                    seatsRow1[seat - 1] = 1;    // The value in the list is changed to 0

                    // The values for the class Person are asked here
                    System.out.println("Enter your first name: ");
                    String name = input.nextLine();

                    System.out.println("Enter your last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Enter your email: ");
                    String email = input.nextLine();

                    System.out.println("Enter the price of the ticket: ");
                    double price = input.nextDouble();

                    System.out.println("You bought the seat!");

                    Person person = new Person(name, lastName, email); // The values are taken by Person
                    Ticket ticket = new Ticket(row, seat, price, person); // Ticket gets the rest of the values and Person
                    tickets.add(ticket); // Then the ticket created gets stored in the ArrayList tickets

                } else {
                    System.out.println("Seat is occupied"); // In case the row and seat are taken this is printed
                }
                // The same functionality is applied for the 3 rows
                // Row 2 is selected
            } else if (row == 2) {
                if (seatsRow2[seat - 1] == 0) {
                    seatsRow2[seat - 1] = 1;
                    System.out.println("Enter your first name: ");
                    String name = input.nextLine();

                    System.out.println("Enter your last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Enter your email: ");
                    String email = input.nextLine();

                    System.out.println("Enter the price of the ticket: ");
                    double price = input.nextDouble();

                    System.out.println("You bought the seat!");

                    Person person = new Person(name, lastName, email);
                    Ticket ticket = new Ticket(row, seat, price, person);
                    tickets.add(ticket);

                } else {
                    System.out.println("Seat is occupied");
                }
                // Row 3 is selected
            } else if (row == 3) {
                if (seatsRow3[seat - 1] == 0) {
                    seatsRow3[seat - 1] = 1;
                    System.out.println("Enter your first name: ");
                    String name = input.nextLine();

                    System.out.println("Enter your last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Enter your email: ");
                    String email = input.nextLine();

                    System.out.println("Enter the price of the ticket: ");
                    double price = input.nextDouble();

                    System.out.println("You bought the seat!");

                    Person person = new Person(name, lastName, email);
                    Ticket ticket = new Ticket(row, seat, price, person);
                    tickets.add(ticket);

                } else {
                    System.out.println("This seat is occupied");
                }
            } else { // If the row number inserted is incorrect this else statement will run
                System.out.println("The row or seat number selected is incorrect, check well your options");
            }
        } catch (ArrayIndexOutOfBoundsException e){ //If the seat number is incorrect this catch will run
            System.out.println("The row or seat number selected is incorrect, check well your options");
            // Never both cases will run at the same time
        }
    }

    static void print_seating_area() {
        /*
        This function has the purpose of printing the seating area in a very specific structure and also show the
        seats that are taken and the ones that are free.
         */
        System.out.println("        ***********");
        System.out.println("        *  STAGE  *");
        System.out.println("        ***********");

        // First Row
        System.out.print("       "); // This is to create space
        for (int i = 0; i < seatsRow1.length; i++) { // The for loop goes through the list
            if (seatsRow1[i] == 0) { // If the value is 0 it prints a 0
                System.out.print("0");
            } else { //  If the value is anything else (in this case a 1) an X is printed
                System.out.print("X");
            }
            if (i == 5){  // In the middle of the list a space is printed
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        // The code is the same for each row

        System.out.print("     ");
        for (int i = 0; i < seatsRow2.length; i++) {
            if (seatsRow2[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
            if (i == 7){
                System.out.print(" ");
            }
        }
        System.out.println(" ");

        System.out.print("   ");
        for (int i = 0; i < seatsRow3.length; i++) {
            if (seatsRow3[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
            if (i == 9){
                System.out.print(" ");
            }
        }
        System.out.println(" ");

    }

    static void cancel_ticket() {
        /*
        This function has the purpose of cancel a ticket that has been bought, when this happens, the value taken from
        any of the 3 lists of seats is changed back to a 0 representing an unoccupied seat, also the ticket created
        gets taken away from the list tickets
         */
        try {
            Scanner input = new Scanner(System.in);
            // The row and seat numbers are asked here
            System.out.println("Select a row: ");
            int row = input.nextInt();

            System.out.println("Select a seat: ");
            int seat = input.nextInt();

            // Row 1 is selected
            if (row == 1) {
                if (seatsRow1[seat - 1] == 1) { // if the value of the seat is 1 (taken)
                    seatsRow1[seat - 1] = 0; //  the value is changed to a 0 (unoccupied)
                    System.out.println("You cancel the seat ticket");
                    for (int i = 0; i < tickets.size(); i++) { // Here I used a for loop to go through the Array List tickets
                        if (tickets.get(i).getRow() == row || tickets.get(i).getSeat() == seat) { //In here I ask if the row and seat numbers match any of those values inside the list
                            tickets.remove(i); // If it matches it removes the entire ticket
                            break; // Then this break skips the rest of the tickets
                        }
                    }

                } else {
                    System.out.println("Seat is not occupied"); // If the seat is not occupied this line runs
                }
                // the same functionality is used for the rest of the rows
                // Row 2 is selected
            } else if (row == 2) {
                if (seatsRow2[seat - 1] == 1) {
                    seatsRow2[seat - 1] = 0;
                    System.out.println("You cancel the seat ticket");
                    for (int i = 0; i < tickets.size(); i++) {
                        if (tickets.get(i).getRow() == row || tickets.get(i).getSeat() == seat) {
                            tickets.remove(i);
                            break;
                        }
                    }

                } else {
                    System.out.println("Seat is not occupied");
                }
                // Row 3 is selected
            } else if (row == 3) {
                if (seatsRow3[seat - 1] == 1) {
                    seatsRow3[seat - 1] = 0;
                    System.out.println("You cancel the seat ticket");
                    for (int i = 0; i < tickets.size(); i++) {
                        if (tickets.get(i).getRow() == row || tickets.get(i).getSeat() == seat) {
                            tickets.remove(i);
                            break;
                        }
                    }

                } else {
                    System.out.println("Seat is not occupied");
                }
            } else { // In case the row selected is incorrect this code runs
                System.out.println("The row or seat number selected is incorrect, check well your options");
            }
        } catch(ArrayIndexOutOfBoundsException e){ // In case the seat selected is incorrect this code runs
            System.out.println("The row or seat number selected is incorrect, check well your options");
        }
    }

    static void show_available() {
        /*
        The purpose of this method is to show the availability of the seats using an specific way of displaying them
         */

        // Each row is printed int eh same way
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < seatsRow1.length; i++){ // I use a for loop to go through the list
            if (seatsRow1[i] == 0) { // Only seats that are available (value of 0) are printed
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < seatsRow2.length; i++){
            if (seatsRow2[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < seatsRow3.length; i++){
            if (seatsRow3[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");
    }

    static void save() {
        /*
        The purpose of this method is to create a text file called file.txt and save the values of the seats in 3 lines
        it stores the values 0's and 1's
         */
        try{ // This try statement catches if an error occurred while creating the text file
            FileWriter myWriter = new FileWriter("file.txt"); // The file is created and a writer is created too
            for (int i = 0; i < seatsRow1.length; i++) { // A for loop goes through the first list
                myWriter.write(String.valueOf(seatsRow1[i])); // Then the writer writes inside the text file
            }
            myWriter.write("\n"); // This line skips one line
            // The rest of the files are written inside the text file on the same way
            for (int i = 0; i < seatsRow2.length; i++) {
                myWriter.write(String.valueOf(seatsRow2[i]));
            }
            myWriter.write("\n");

            for (int i = 0; i < seatsRow3.length; i++) {
                myWriter.write(String.valueOf(seatsRow3[i]));
            }
            myWriter.close();
            System.out.println("The seats have been correctly saved in file.txt!");
        } catch (IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    static void load() {
        /*
        This method reads the text file and stores the values in the 3 arrays
         */
        try {
            File file = new File("file.txt");
            Scanner scanner = new Scanner(file); // A scanner is used to read through the text file

            String[] line1 = scanner.nextLine().split(""); // I create a list of strings where the lines are separated using the
                                                                 // .split() method to then append them to lists
            for (int i = 0; i < line1.length; i++) { // For loop goes through the list
                seatsRow1[i] = Integer.parseInt(line1[i]); // Then the values of the list are stored inside the Array as an integer
            }

            String[] line2 = scanner.nextLine().split("");
            for (int i = 0; i < line2.length; i++) {
                seatsRow2[i] = Integer.parseInt(line2[i]);
            }

            String[] line3 = scanner.nextLine().split("");
            for (int i = 0; i < line3.length; i++) {
                seatsRow3[i] = Integer.parseInt(line3[i]);
            }
            scanner.close();
            System.out.println("The seats have been loaded from file.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void show_tickets() {
        /*
        The method sh0w_tickets() prints the contents of the ArrayList tickets. Moreover, this method calculates the
        total to pay adding all the prizes of the tickets
         */
        if (tickets.size() == 0) { // In case there are no tickets this line of code runs
            System.out.println("No tickets have been bought yet");
        } else { // Otherwise this line runs
            double total = 0;
            for (Ticket ticket : tickets) { // This for loops goes through the tickets ArrayList
                ticket.print(); // The method print is called
                total = total + ticket.getPrice(); // the total is calculated
            }
            System.out.println("The total to pay is: £"+ total); // After the total has been calculated, its printed here
        }
    }

    static void sort_tickets() {
        /*
        Te purpose of this method is to create an ArrayList that contains the tickets from the first ArrayList but in this
        list they are sorted from the cheapest ticket to the most expensive
         */
        if (tickets.size() == 0) { // In case there are no tickets bought yet this line runs
            System.out.println("No tickets have been bought yet");
        } else {
            ArrayList<Ticket> ticketsSorted = new ArrayList<>(tickets); // the new ArrayList is filled with th elements of the tickets ArrayList
            int bottom = ticketsSorted.size(); // To sort the elements inside the list I used the bubble sort method taught in class
            Ticket temp;
            boolean exchanged = true;

            while (exchanged) {
                exchanged = false;

                for (int i = 0; i < bottom - 1; i++) {
                    if (ticketsSorted.get(i).getPrice() > ticketsSorted.get(i + 1).getPrice()) {
                        temp = ticketsSorted.get(i);
                        ticketsSorted.set(i, ticketsSorted.get(i + 1));
                        ticketsSorted.set(i + 1, temp);
                        exchanged = true;
                    }
                }
                bottom--;
            }
            // After the elements are sorted the list get printed here
            double total = 0;
            for (Ticket ticket : ticketsSorted) {
                ticket.print();
                total = total + ticket.getPrice();
            }
            System.out.println("The total to pay is: £"+ total);
        }
    }

    public static void main(String[] args){ // The main section of our code runs here
        boolean quit = false;
        System.out.println("Welcome to the New Theatre");
        while(!quit){ //  the flow of the program I use a while loop to keep asking for options, after the option 0 is selected the while loops stops

            // The manu is printed with teh """ method included with the System.out.println()
            System.out.println("""
                -------------------------------------------------
                Please select an option:
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort tickets by price
                    0) Quit
                -------------------------------------------------
                """);
            try{
            System.out.println("Enter a option: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
                switch (option) { // I decided to use an enhanced switch statement that works the same way as a traditional switch but the action inside the cases are more clear
                    case 1 -> buy_ticket();
                    case 2 -> print_seating_area();
                    case 3 -> cancel_ticket();
                    case 4 -> show_available();
                    case 5 -> save();
                    case 6 -> load();
                    case 7 -> show_tickets();
                    case 8 -> sort_tickets();
                    case 0 -> {
                        quit = true;
                    }
                    default -> System.out.println("The option selected is incorrect, select a number between 0 and 8");
                }
            } catch (InputMismatchException e){
                System.out.println("Please insert a number");
            }
        }
    }
}
