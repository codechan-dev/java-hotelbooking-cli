# 🏨 Hotel Management System

This is a simple hotel management system implemented in Java. It provides basic functionalities for managing rooms, bookings, food orders, and checkouts in a hotel.

## 🚀 Features

- **Room Features Display**: View features of different room types including the number of beds, availability of AC, free breakfast, and charges per day.
- **Room Availability Check**: Check the availability of rooms of different types.
- **Room Booking**: Book rooms of different types. Double rooms require details for two customers.
- **Food Ordering**: Order food for rooms from a menu, specifying the quantity.
- **Checkout**: Check out from rooms, generating a bill for the stay and any food ordered.

## 📝 Usage

1. **Compile**: Compile the Java files using any Java compiler.
2. **Run**: Execute the compiled Main class to start the hotel management system.
3. **Follow Instructions**: Follow the on-screen instructions to perform various tasks such as viewing room features, checking availability, booking rooms, ordering food, and checking out.
4. **Backup**: The system automatically saves the hotel's state to a file named "backup" using serialization. This ensures that the data is preserved between program executions.

## 📂 Files

- **Main.java**: Contains the main class with the entry point for the program.
- **Hotel.java**: Implements the hotel management functionalities.
- **Write.java**: Implements a thread for writing the hotel's state to a backup file.
- **Holder.java**: Contains classes for holding hotel data.
- **Food.java**: Represents food items.
- **Singleroom.java**: Represents single rooms.
- **Doubleroom.java**: Represents double rooms.

## ⚙️ Requirements

- Java Development Kit (JDK) installed on your system.

## 🤝 Contributing

Contributions are welcome! If you find any bugs or want to add new features, feel free to open an issue or submit a pull request.

## 📄 License

This project is licensed under the [MIT License](LICENSE).
