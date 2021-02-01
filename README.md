# Restaurant-Management-Application
The aim of this project is to create a graphical user interface to the application and also store/retrieve the data in external binary
files. 

# Aims and Objectives

In this assignment, you need to create a graphical user interface to this application. In
this interface application will need to make sure that all the methods given in the RestManApp
class has a graphical user interface interaction. It need to choose appropriate Swing
components to implement the user interface. Make sure that you used at least the
following Swing components: JFrame, JButton, JLabel, JMenu, JMenuItem, JFileChooser, JPanel, JTextArea, JTextField, JCombobox, JScrollPane, JTable. The
overall requirements can be summarised as follows:
• When the application starts,it will need to ensure that you show the relevant
options to the user – all the tasks they can complete with this application.
• It need to make sure that you have used all the relevant components for entry. 

# Requirements and Explanations of Methods

The overall requirements are based on this class diagram, which is also summarised
below:
• The main application called ResManApp will be used to maintain information
about staff and customers. ResManApp will also have the main method and will
provide the overall interaction with the application. Therefore, this class should
include the main method where an instance of this class is constructed and the
menu of commands is displayed to the user. The required methods are as follows. 
o menu(): This method will display the interaction menu to the user;
o addStaff(): This method will add new staff to the list of Staff maintained;
o deleteStaff(): This method will be used to delete a staff.
o listStaffDetails(): This method will display the details of a staff (In the
previous assignment, this was referred as getStaffDetails).
o addCustomer(): This method will add a customer.
o deleteCustomer(): This method will delete a customer.
o addBooking(): This method will receive the details of a customer and
create a booking for that customer. The method needs to also get the
relevant booking details.
o listCustomerDetails(): This method will display a customer details (In
the previous assignment, this was called getCustomerDetails).
o displayCustomerLastBooking(): This method will display the most
recent booking done by the customer.
o listCustomerOrders(): This method will display the orders made by a
particular customer (In the previous assignment, this was referred as
getCustomerOrder).
o listStaff(): This method will list all the staff.
o listCustomer(): This method will list all the customer.
o exit(): This method should terminate the program.
o addOrder(): This method will get the details of a customer and an order,
and will create an order for that customer. In this case, the order type
has to be specified, if it is online then an online order should be created.
If it is being done within the restaurant, then it should be an
InRestrOrder.
o listAllSaffSalary(): This method will display the salary details of all
staff in the application. Depending on whether the staff is junior or
senior, the salary calculation will be done via getSalary() method
specified in the interface as follows:
§ If the staff is a seniorthen the monthly salary is calculated as
follows: for every year who has been a staff (currentDateStartDate to find the number of years) who gets %10 increment
on the grossSalaryYearly. This will be divided by 12. For
example, if the employee is working for 2 years and the
grossSalaryYearly is 12000, then he will have a salary of 1200 per month. This is because he received 1200 for the first year
and 1200 for the second year as increments.
§ If the Staff is a junior, then the monthlySalary value will be
displayed.
o listAllOrder(): This method will display all online and in restaurant
orders that have been made. This will display all the orders made within
the rest. and their associated bookings (if it exists). Please note that an
in restaurant order can be made without a booking.
o addOrderOfBooking(): This method will get the details of a customer
and a booking, and will create an order for that customer and booking.
Payment interface has a method called “processPayment()”. Since in this
a gui-project, we are not actually going to process payments, it just need to
implement it in a simple way to display a message on the screen.

# UML-Diagram

![alt text](https://i.imgur.com/W6VMU6T.png)

