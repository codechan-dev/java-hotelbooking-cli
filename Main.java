import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Food implements Serializable {
    int itemno;
    int quantity;   
    float price;
    
    Food(int itemno, int quantity) {
        this.itemno = itemno;
        this.quantity = quantity;
        switch(itemno) {
            case 1: price = quantity * 50; break;
            case 2: price = quantity * 60; break;
            case 3: price = quantity * 70; break;
            case 4: price = quantity * 30; break;
            default: price = 0; break;
        }
    }
}

class Singleroom implements Serializable {
    String name;
    String contact;
    String gender;   
    ArrayList<Food> food = new ArrayList<>();

    Singleroom() {
        this.name = "";
    }

    Singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

class Doubleroom extends Singleroom implements Serializable { 
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom() {
        this.name = "";
        this.name2 = "";
    }

    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        super(name, contact, gender);
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

class NotAvailable extends Exception {
    @Override
    public String toString() {
        return "Not Available!";
    }
}

class Holder implements Serializable {
    Doubleroom[] luxuryDoublerooms = new Doubleroom[10]; // Luxury
    Doubleroom[] deluxeDoublerooms = new Doubleroom[20]; // Deluxe
    Singleroom[] luxurySinglerooms = new Singleroom[10]; // Luxury
    Singleroom[] deluxeSinglerooms = new Singleroom[20]; // Deluxe
}

class Hotel {
    static Holder hotelOb = new Holder();
    static Scanner sc = new Scanner(System.in);

    static void captureCustomerDetails(int roomType, int roomNumber) {
        String name, contact, gender, name2 = null, contact2 = null, gender2 = "";

        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();

        if (roomType < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (roomType) {
            case 1:
                hotelOb.luxuryDoublerooms[roomNumber] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotelOb.deluxeDoublerooms[roomNumber] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                hotelOb.luxurySinglerooms[roomNumber] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotelOb.deluxeSinglerooms[roomNumber] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Invalid room type");
                break;
        }
    }

    static void bookRoom(int roomType) {
        int roomNumber;
        System.out.println("\nChoose room number from available rooms:");

        try {
            switch (roomType) {
                case 1:
                    displayAvailableRooms(hotelOb.luxuryDoublerooms);
                    roomNumber = sc.nextInt() - 1;
                    if (hotelOb.luxuryDoublerooms[roomNumber] != null) throw new NotAvailable();
                    break;
                case 2:
                    displayAvailableRooms(hotelOb.deluxeDoublerooms);
                    roomNumber = sc.nextInt() - 11;
                    if (hotelOb.deluxeDoublerooms[roomNumber] != null) throw new NotAvailable();
                    break;
                case 3:
                    displayAvailableRooms(hotelOb.luxurySinglerooms);
                    roomNumber = sc.nextInt() - 31;
                    if (hotelOb.luxurySinglerooms[roomNumber] != null) throw new NotAvailable();
                    break;
                case 4:
                    displayAvailableRooms(hotelOb.deluxeSinglerooms);
                    roomNumber = sc.nextInt() - 41;
                    if (hotelOb.deluxeSinglerooms[roomNumber] != null) throw new NotAvailable();
                    break;
                default:
                    System.out.println("Invalid room type");
                    return;
            }
            captureCustomerDetails(roomType, roomNumber);
            System.out.println("Room booked successfully!");
        } catch (NotAvailable e) {
            System.out.println("Room not available");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    static void displayAvailableRooms(Object[] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                System.out.print((i + 1) + ",");
            }
        }
        System.out.print("\nEnter room number: ");
    }

    static void displayRoomFeatures(int roomType) {
        switch (roomType) {
            case 1:
                System.out.println("Luxury Double Room:\nNumber of double beds: 1\nAC: Yes\nFree breakfast: Yes\nCharge per day: 4000");
                break;
            case 2:
                System.out.println("Deluxe Double Room:\nNumber of double beds: 1\nAC: No\nFree breakfast: Yes\nCharge per day: 3000");
                break;
            case 3:
                System.out.println("Luxury Single Room:\nNumber of single beds: 1\nAC: Yes\nFree breakfast: Yes\nCharge per day: 2200");
                break;
            case 4:
                System.out.println("Deluxe Single Room:\nNumber of single beds: 1\nAC: No\nFree breakfast: Yes\nCharge per day: 1200");
                break;
            default:
                System.out.println("Invalid room type");
                break;
        }
    }

    static void checkRoomAvailability(int roomType) {
        int availableRooms = 0;

        switch (roomType) {
            case 1:
                availableRooms = countAvailableRooms(hotelOb.luxuryDoublerooms);
                break;
            case 2:
                availableRooms = countAvailableRooms(hotelOb.deluxeDoublerooms);
                break;
            case 3:
                availableRooms = countAvailableRooms(hotelOb.luxurySinglerooms);
                break;
            case 4:
                availableRooms = countAvailableRooms(hotelOb.deluxeSinglerooms);
                break;
            default:
                System.out.println("Invalid room type");
                return;
        }
        System.out.println("Number of rooms available: " + availableRooms);
    }

    static int countAvailableRooms(Object[] rooms) {
        int count = 0;
        for (Object room : rooms) {
            if (room == null) {
                count++;
            }
        }
        return count;
    }

    static void generateBill(int roomNumber, int roomType) {
        double amount = 0;
        String[] foodItems = {"Sandwich", "Pasta", "Noodles", "Coke"};

        System.out.println("\n*******\n  Bill\n*******");

        switch (roomType) {
            case 1:
                amount += 4000;
                printRoomCharge(4000);
                printFoodCharges(hotelOb.luxuryDoublerooms[roomNumber].food, foodItems, amount);
                break;
            case 2:
                amount += 3000;
                printRoomCharge(3000);
                printFoodCharges(hotelOb.deluxeDoublerooms[roomNumber].food, foodItems, amount);
                break;
            case 3:
                amount += 2200;
                printRoomCharge(2200);
                printFoodCharges(hotelOb.luxurySinglerooms[roomNumber].food, foodItems, amount);
                break;
            case 4:
                amount += 1200;
                printRoomCharge(1200);
                printFoodCharges(hotelOb.deluxeSinglerooms[roomNumber].food, foodItems, amount);
                break;
            default:
                System.out.println("Invalid room type");
                return;
        }

        System.out.println("\nTotal Amount: " + amount);
    }

    static void printRoomCharge(double charge) {
        System.out.println("Room Charge: " + charge);
    }

    static void printFoodCharges(ArrayList<Food> foodList, String[] foodItems, double amount) {
        System.out.println("\nFood Charges:");
        System.out.println("===============");
        System.out.println("Item     Quantity  Price");
        System.out.println("-------------------------");
        for (Food food : foodList) {
            amount += food.price;
            System.out.printf("%-10s %5d %10.2f%n", foodItems[food.itemno - 1], food.quantity, food.price);
        }
    }

    static void orderFood(int roomNumber, int roomType) {
        int itemNumber, quantity;

        System.out.println("\nMenu:\n1.Sandwich - Rs.50\n2.Pasta - Rs.60\n3.Noodles - Rs.70\n4.Coke - Rs.30\n");
        System.out.print("Enter item number: ");
        itemNumber = sc.nextInt();
        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();

        Food food = new Food(itemNumber, quantity);
        
        switch (roomType) {
            case 1:
                hotelOb.luxuryDoublerooms[roomNumber].food.add(food);
                break;
            case 2:
                hotelOb.deluxeDoublerooms[roomNumber].food.add(food);
                break;
            case 3:
                hotelOb.luxurySinglerooms[roomNumber].food.add(food);
                break;
            case 4:
                hotelOb.deluxeSinglerooms[roomNumber].food.add(food);
                break;
            default:
                System.out.println("Invalid room type");
                return;
        }
        System.out.println("Food ordered successfully!");
    }

    static void checkout(int roomNumber, int roomType) {
        switch (roomType) {
            case 1:
                if (hotelOb.luxuryDoublerooms[roomNumber] != null) {
                    generateBill(roomNumber, 1);
                    hotelOb.luxuryDoublerooms[roomNumber] = null;
                    System.out.println("Checkout successful");
                } else {
                    System.out.println("Room not booked yet");
                }
                break;
            case 2:
                if (hotelOb.deluxeDoublerooms[roomNumber] != null) {
                    generateBill(roomNumber, 2);
                    hotelOb.deluxeDoublerooms[roomNumber] = null;
                    System.out.println("Checkout successful");
                } else {
                    System.out.println("Room not booked yet");
                }
                break;
            case 3:
                if (hotelOb.luxurySinglerooms[roomNumber] != null) {
                    generateBill(roomNumber, 3);
                    hotelOb.luxurySinglerooms[roomNumber] = null;
                    System.out.println("Checkout successful");
                } else {
                    System.out.println("Room not booked yet");
                }
                break;
            case 4:
                if (hotelOb.deluxeSinglerooms[roomNumber] != null) {
                    generateBill(roomNumber, 4);
                    hotelOb.deluxeSinglerooms[roomNumber] = null;
                    System.out.println("Checkout successful");
                } else {
                    System.out.println("Room not booked yet");
                }
                break;
            default:
                System.out.println("Invalid room type");
                return;
        }
    }
}

class Write implements Runnable {
    Holder hotelHolder;

    Write(Holder hotelHolder) {
        this.hotelHolder = hotelHolder;
    }

    @Override
    public void run() {
        try (FileOutputStream fout = new FileOutputStream("backup");
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(hotelHolder);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("backup");
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            Hotel.hotelOb = (Holder) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No backup file found, starting with an empty hotel.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading backup file: " + e.getMessage());
        }

        int choice1, choice2;
        char continueChoice;

        do {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Display room features");
            System.out.println("2. Display room availability");
            System.out.println("3. Book a room");
            System.out.println("4. Order food");
            System.out.println("5. Checkout");

            choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    System.out.println("Choose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    choice2 = sc.nextInt();
                    Hotel.displayRoomFeatures(choice2);
                    break;
                case 2:
                    System.out.println("Choose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    choice2 = sc.nextInt();
                    Hotel.checkRoomAvailability(choice2);
                    break;
                case 3:
                    System.out.println("Choose room type:");
                    System.out.println("1. Luxury Double Room");
                    System.out.println("2. Deluxe Double Room");
                    System.out.println("3. Luxury Single Room");
                    System.out.println("4. Deluxe Single Room");
                    choice2 = sc.nextInt();
                    Hotel.bookRoom(choice2);
                    break;
                case 4:
                    System.out.print("Enter room number: ");
                    choice2 = sc.nextInt();
                    if (choice2 <= 10) {
                        Hotel.orderFood(choice2 - 1, 1);
                    } else if (choice2 <= 30) {
                        Hotel.orderFood(choice2 - 11, 2);
                    } else if (choice2 <= 40) {
                        Hotel.orderFood(choice2 - 31, 3);
                    } else if (choice2 <= 60) {
                        Hotel.orderFood(choice2 - 41, 4);
                    } else {
                        System.out.println("Invalid room number");
                    }
                    break;
                case 5:
                    System.out.print("Enter room number: ");
                    choice2 = sc.nextInt();
                    if (choice2 <= 10) {
                        Hotel.checkout(choice2 - 1, 1);
                    } else if (choice2 <= 30) {
                        Hotel.checkout(choice2 - 11, 2);
                    } else if (choice2 <= 40) {
                        Hotel.checkout(choice2 - 31, 3);
                    } else if (choice2 <= 60) {
                        Hotel.checkout(choice2 - 41, 4);
                    } else {
                        System.out.println("Invalid room number");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("\nContinue: (y/n)");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        Thread writeThread = new Thread(new Write(Hotel.hotelOb));
        writeThread.start();
    }
}
