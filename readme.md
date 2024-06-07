
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #343a40;
            margin: 0;
            padding: 20px;
        }
        h1, h2, h3 {
            color: #007bff;
        }
        .feature-list, .class-list, .method-list {
            list-style-type: none;
            padding: 0;
        }
        .feature-list li, .class-list li, .method-list li {
            background: #e9ecef;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
        }
        .section {
            margin-bottom: 20px;
        }
        .sticker {
            font-size: 1.2em;
            margin-right: 5px;
        }
    </style>
</head>
<body>

    <h1>🏨 Hotel Management System</h1>

    <div class="section">
        <h2>📝 Project Overview</h2>
        <p>The Hotel Management System is a console-based Java application designed to manage various operations of a hotel. It provides functionalities such as room booking, food ordering, and checkout, catering to different types of rooms including luxury and deluxe, for both single and double occupancy. The system aims to streamline the management of room reservations, enhance customer experience, and simplify the billing process.</p>
    </div>

    <div class="section">
        <h2>🌟 Features</h2>
        <ul class="feature-list">
            <li>🛏️ <strong>Room Booking</strong>: Book different types of rooms: Luxury Double Rooms, Deluxe Double Rooms, Luxury Single Rooms, and Deluxe Single Rooms. Capture and store customer details for single and double occupancy rooms. Check room availability to avoid double-booking.</li>
            <li>📋 <strong>Room Features Display</strong>: View features and charges for each type of room.</li>
            <li>📅 <strong>Room Availability Check</strong>: Check the current availability status of each type of room.</li>
            <li>🍴 <strong>Food Ordering</strong>: Order food items such as Sandwiches, Pasta, Noodles, and Coke. Add food orders to the room's bill.</li>
            <li>🧾 <strong>Checkout and Billing</strong>: Generate detailed bills including room charges and food charges. Mark rooms as available upon checkout.</li>
            <li>💾 <strong>Data Persistence</strong>: Save the state of all bookings and orders to a file for data recovery and persistence across sessions. Backup mechanism to write the current state to a file and read from it upon startup.</li>
        </ul>
    </div>

    <div class="section">
        <h2>🔧 Technical Details</h2>
        <p><strong>Programming Language:</strong> Java</p>
        <p><strong>Data Persistence:</strong> Serialization for saving and loading the state of hotel room bookings and orders.</p>
        <p><strong>User Interface:</strong> Console-based input and output for user interaction.</p>
        <p><strong>Exception Handling:</strong> Custom exceptions for handling room availability and input validation.</p>
    </div>

    <div class="section">
        <h2>📂 Code Structure</h2>
        <h3>Classes</h3>
        <ul class="class-list">
            <li>🍔 <strong>Food</strong>: Represents food items that can be ordered.</li>
            <li>🏠 <strong>Singleroom</strong> and <strong>Doubleroom</strong>: Represent different types of rooms with customer details.</li>
            <li>🚫 <strong>NotAvailable</strong>: Custom exception for handling unavailable rooms.</li>
            <li>🏢 <strong>Holder</strong>: Holds arrays of different room types.</li>
            <li>🏨 <strong>Hotel</strong>: Contains static methods for room booking, food ordering, checking availability, and generating bills.</li>
            <li>💾 <strong>Write</strong>: Implements `Runnable` for saving the state of the hotel data to a file.</li>
            <li>🚀 <strong>Main</strong>: The main class to run the application, providing a user interface for interacting with the hotel management system.</li>
        </ul>

        <h3>Methods</h3>
        <ul class="method-list">
            <li>✍️ <strong>captureCustomerDetails</strong>: Captures details of customers for booking rooms.</li>
            <li>📖 <strong>bookRoom</strong>: Handles the room booking process.</li>
            <li>📊 <strong>displayAvailableRooms</strong>: Displays currently available rooms.</li>
            <li>🔍 <strong>displayRoomFeatures</strong>: Shows features and prices of different room types.</li>
            <li>🛏️ <strong>checkRoomAvailability</strong>: Checks and displays the number of available rooms for each type.</li>
            <li>💵 <strong>generateBill</strong>: Generates the bill for a room including room and food charges.</li>
            <li>💳 <strong>printRoomCharge</strong>, <strong>printFoodCharges</strong>: Helper methods for bill generation.</li>
            <li>🍴 <strong>orderFood</strong>: Handles the food ordering process.</li>
            <li>🚪 <strong>checkout</strong>: Manages the checkout process and generates the final bill.</li>
        </ul>
    </div>

    <div class="section">
        <h2>🚀 Usage</h2>
        <p>To use the system, compile and run the `Main` class. The user is presented with a menu to choose various operations such as displaying room features, checking room availability, booking rooms, ordering food, and checking out. The system ensures that operations are performed smoothly and provides feedback for invalid inputs or unavailable rooms.</p>
    </div>

    <div class="section">
        <h2>🔧 How to Run</h2>
        <ol>
            <li>📂 <strong>Clone the repository:</strong>
                <pre><code>git clone https://github.com/your-username/hotel-management-system.git</code></pre>
            </li>
            <li>📂 <strong>Navigate to the project directory:</strong>
                <pre><code>cd hotel-management-system</code></pre>
            </li>
            <li>💻 <strong>Compile the Java files:</strong>
                <pre><code>javac Main.java</code></pre>
            </li>
            <li>🚀 <strong>Run the application:</strong>
                <pre><code>java Main</code></pre>
            </li>
        </ol>
    </div>

    <div class="section">
        <h2>🔮 Future Enhancements</h2>
        <ul class="feature-list">
            <li>🌐 Online booking</li>
            <li>💳 Payment integration</li>
            <li>🖥️ Graphical User Interface (GUI)</li>
            <li>📊 Enhanced reporting and analytics</li>
        </ul>
    </div>

</body>
</html>
