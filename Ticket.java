public class Ticket {
    // The constructors are defined in here
    int row;
    int seat;
    double price;
    Person person;

    public Ticket(int row, int seat, double price, Person person){
        // This method receives the values and stores them inside of the constructors
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public void print(){
        // This method prints the values of this class
        System.out.println("»--Ticket--«");
        System.out.println("Name: "+ person.getFirst_name());
        System.out.println("Surname: "+ person.getSurname());
        System.out.println("Email: "+ person.getEmail());
        System.out.println("Row: " + getRow());
        System.out.println("Seat: " + getSeat());
        System.out.println("Price: £" + getPrice());
        System.out.println("");
    }

    public int getRow() {
        return row;
    } // This method returns the value of the constructor row

    public int getSeat() {return seat;} // This method returns the value of the constructor seat

    public double getPrice() {
        return price;
    } // This method returns the value of the constructor price
}
