package assignment.core;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;


public class guiTool extends Main {

    private JButton selectButton;
    private JPanel panel1;
    private JPanel MenuPanel;
    private JPanel AddStaffPanel;
    private JPanel ListStaffDetailsPanel;
    private JPanel AddCustomerPanel;
    private JPanel DeleteCustomerPanel;
    private JPanel AddBookingPanel;
    private JPanel AddOrderPanel;
    private JPanel AddOrderOfBookingPanel;
    private JPanel ListCustomerDetailsPanel;
    private JPanel DisplayCustomerLastBookingPanel;
    private JPanel ListAllOrderPanel;
    private JPanel ListCustomerOrdersPanel;
    private JPanel ListAllTheStaffPanel;
    private JPanel ListAllTheCustomersPanel;
    private JPanel ListAllStaffSalaryPanel;
    private JPanel SeniorPanel;
    private JPanel JuniorPanel;
    private JPanel DeleteStaff;
    private JPanel StaffListPanel;
    private JPanel AddOnlineOrderPanel;
    private JPanel AddResOrderPanel;
    private JComboBox menuOp;
    private JTextField grossYearlySalary;
    private JButton addSeniorButton;
    private JTextField juniorSalary;
    private JTextField juniorEndDate;
    private JButton addJuniorButton;
    private JTextField staffDeleteID;
    private JButton deleteStaffButton;
    private JTextField seniorReg;
    private JTextField seniorDob;
    private JComboBox staffRole;
    private JButton Proceed;
    private JComboBox seniorGender;
    private JTextField seniorName;
    private JTextField juniorName;
    private JComboBox juniorGender;
    private JTextField juniorDob;
    private JTextField juniorReg;
    private JTextField customerName;
    private JComboBox customerGender;
    private JTextField customerDob;
    private JTextField customerCreditCard;
    private JButton addCustomerButton;
    private JTextField customerDeleteID;
    private JButton deleteCustomerButton;
    private JTextField bookingCustomerID;
    private JTextField bookingDate;
    private JTextField bookingOrderDate;
    private JTextField bookingTableNo;
    private JTextField bookingOrderDetails;
    private JTextField bookingExtraNotes;
    private JButton makeBookingButton;
    private JTextField onlineID;
    private JComboBox orderTypeBox;
    private JButton nextButton;
    private JTextField customerReg;
    private JTextField onlineDate;
    private JTextField onlineDetails;
    private JTextField onlineNotes;
    private JTextField onlineCredit;
    private JTextField onlineJuniorID;
    private JButton orderButton;
    private JTextField inResDate;
    private JTextField inResID;
    private JTextField inResDetails;
    private JTextField inResNotes;
    private JTextField inResOrderDate;
    private JTextField inResTableNo;
    private JButton addOrderButton;
    private JTextField lastBookID;
    private JButton getButton;
    private JPanel GetDetails;
    private JLabel lastBookCustID;
    private JLabel lastBookingID;
    private JLabel lastBookDate;
    private JPanel StaffDetails;
    private JTextField staffDetailID;
    private JButton getStaffButton;
    private JLabel staffDetailsID;
    private JLabel staffDetailsName;
    private JLabel staffDetailsRole;
    private JLabel staffDetailsDob;
    private JLabel staffDetailsGender;
    private JPanel customerDetails;
    private JTextField customerDetailsID;
    private JButton getCustomerButton;
    private JLabel custID;
    private JLabel custName;
    private JLabel custGender;
    private JLabel custDob;
    private JPanel OrderOfBookingPanel;
    private JTextField addOrderOfBookingCustomerID;
    private JButton nextButton1;
    private JTextField orderOfBookOrderDate;
    private JTextField orderOfBookTableNo;
    private JTextField orderOfBookDetails;
    private JTextField orderOfBookExtra;
    private JButton AddOrderOfBookingButton;
    private JTextField orderOfBookBookingID;
    private JPanel OnlineOrders;
    private JPanel InRestaurant;
    private JComboBox orderType;
    private JButton DisplayButton;
    private JButton getButton1;
    private JTextField customerOrderBookID;
    private JTextField CustomerOrderCustomerID;
    private JPanel orderDetailsPanel;
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JMenuItem loadItem;
    private JMenuItem exitItem;
    private JMenuItem saveItem;
    private JFileChooser fileChooser;
    private File loadFile;
    private JScrollPane staffTableContainer;
    private JScrollPane customerTableContainer;
    private JScrollPane staffSalaryTableContainer;
    private JScrollPane orderTableContainer;
    private JScrollPane resOrderTableContainer;
    private JScrollPane customerOrderTableContainer;

    /**Default constructer for */
    guiTool() {
        frame = new JFrame("ResManApp");
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(loadItem.getAction());
        saveItem.addActionListener(saveItem.getAction());
        exitItem.addActionListener(exitItem.getAction());

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        frame.add(panel1);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.setJMenuBar(menuBar);
        frame.setTitle("ResManAPP");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        toggleMenu();



        /*Action Listeners*/

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectButton) {
                    int op = menuOp.getSelectedIndex();
                    operation(op);
                }
            }
        });
        loadItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent select) {
                if (select.getSource() == loadItem) {
                    fileChooser = new JFileChooser("."); //starts with project folder
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    int response = fileChooser.showOpenDialog(null);
                    if(response == JFileChooser.APPROVE_OPTION){
                        loadFile = fileChooser.getSelectedFile();
                        try {
                            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(loadFile));
                            if(loadFile.isFile()){
                                if(loadFile.getName().equals("staffFile.dat")){
                                    Staff staffObject;
                                    do{
                                        staffObject = (Staff)fileIn.readObject();
                                        staffList.add(staffObject);
                                    }while(staffObject != null);

                                }
                                else if(loadFile.getName().equals("customerFile.dat")){
                                    Customer customerObject;
                                    do{
                                        customerObject = (Customer) fileIn.readObject();
                                        customerList.add(customerObject);
                                    }while(customerObject != null);
                                    System.out.println("Customer File loaded successfully!");
                                }
                                else{
                                    System.out.println("Please select 'staffFile.dat' or 'customerFile.dat' !");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(loadItem,"This is not a File!");
                            }
                            fileIn.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            System.out.println("I/O exception found!");
                        } catch (ClassNotFoundException e) {
                            System.out.println("Class not found!");
                        }
                    }
                }
            }
        });
        saveItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent select) {
                if (select.getSource() == saveItem) {
                    try {
                        ObjectOutputStream staffOut = new ObjectOutputStream(new FileOutputStream("staffFile.dat"));
                        ObjectOutputStream customerOut = new ObjectOutputStream(new FileOutputStream("customerFile.dat"));
                        for(int i=0;i<staffList.size();i++){
                            staffOut.writeObject(staffList.get(i));
                        }
                        for(int i=0;i<customerList.size();i++){
                            customerOut.writeObject(customerList.get(i));
                        }
                        JOptionPane.showMessageDialog(saveItem,"Files are saved!");
                        customerOut.close();
                        staffOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        exitItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent select) {
                if (select.getSource() == exitItem) {
                    System.exit(0);
                }
            }
        });


        Proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Proceed) {
                    int role = staffRole.getSelectedIndex();
                    if (role == 0) {
                        SeniorPanel.setVisible(false);
                        JuniorPanel.setVisible(false);
                    }
                    else if (role == 1) {
                        SeniorPanel.setVisible(true);
                        JuniorPanel.setVisible(false);
                    }
                    else if (role == 2) {
                        SeniorPanel.setVisible(false);
                        JuniorPanel.setVisible(true);
                    }
                }
            }
        });
        addSeniorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addSeniorButton){
                    char sGender ='M';
                    try{
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String name = seniorName.getText();
                        String staffDateOfBirth = seniorDob.getText();
                        String staffReg = seniorReg.getText();
                        int gender = seniorGender.getSelectedIndex();
                        if(gender==2){
                            sGender = 'F';
                        }
                        int salary = Integer.parseInt(grossYearlySalary.getText());
                        Date dateOfBirth = dateFormat.parse(staffDateOfBirth);
                        Date regDate = dateFormat.parse(staffReg);
                        staffList.add(new Senior(name,sGender,dateOfBirth,regDate,salary));
                        JOptionPane.showMessageDialog(addSeniorButton, "Senior added successfully!");
                    }catch (ParseException ex){
                        JOptionPane.showMessageDialog(addSeniorButton, "Something Went Wrong!");
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(addSeniorButton,"There are some missing fields");
                    }
                    seniorName.setText("");
                    seniorReg.setText("");
                    seniorDob.setText("");
                    grossYearlySalary.setText("");
                    seniorGender.setSelectedIndex(0);
                }

            }
        });
        addJuniorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addJuniorButton){
                    char sGender ='M';
                    try{
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String name = juniorName.getText();
                        String staffDateOfBirth = juniorDob.getText();
                        String staffReg = juniorReg.getText();
                        int gender = juniorGender.getSelectedIndex();
                        String dateEnd = juniorEndDate.getText();
                        if(gender==2){
                            sGender = 'F';
                        }
                        int salary = Integer.parseInt(juniorSalary.getText());
                        Date dateOfBirth = dateFormat.parse(staffDateOfBirth);
                        Date regDate = dateFormat.parse(staffReg);
                        Date endDate = dateFormat.parse(dateEnd);
                        staffList.add(new Junior(name,sGender,dateOfBirth,regDate,salary,endDate));
                        JOptionPane.showMessageDialog(addJuniorButton, "Junior added successfully!");
                        }catch (ParseException ex){
                            JOptionPane.showMessageDialog(addJuniorButton, "Something Went Wrong!");
                        }catch (RuntimeException runtimeException){
                            JOptionPane.showMessageDialog(addJuniorButton,"There are some missing fields");
                    }
                    juniorName.setText("");
                    juniorReg.setText("");
                    juniorDob.setText("");
                    juniorEndDate.setText("");
                    juniorSalary.setText("");
                    juniorGender.setSelectedIndex(0);
                }
            }
        });
        deleteStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == deleteStaffButton){
                    boolean isDeleted = false;
                    try {
                        int delete = Integer.parseInt(staffDeleteID.getText());
                        for(int i = 0; i < staffList.size(); i++){
                            if(staffList.get(i).getID() == delete){
                                staffList.remove(i);
                                JOptionPane.showMessageDialog(deleteStaffButton, "Staff deleted successfully!");
                                isDeleted = true;
                            }
                        }
                    } catch (RuntimeException run){
                        JOptionPane.showMessageDialog(deleteStaffButton,"There are some missing fields");
                    }

                    if(!isDeleted){
                        JOptionPane.showMessageDialog(deleteStaffButton, "There is no such ID!");
                    }
                    staffDeleteID.setText("");
                }
            }
        });
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addCustomerButton){
                    char cGender ='M';
                    try{
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String name = customerName.getText();
                        String customerDateOfBirth = customerDob.getText();
                        String cardDetails = customerCreditCard.getText();
                        String customerRegDate = customerReg.getText();
                        int gender = customerGender.getSelectedIndex();
                        if(gender==2){
                            cGender = 'F';
                        }
                        Date dateOfBirth = dateFormat.parse(customerDateOfBirth);
                        Date regDate = dateFormat.parse(customerRegDate);
                        customerList.add(new Customer(name,cGender,dateOfBirth,regDate,cardDetails));
                        JOptionPane.showMessageDialog(addCustomerButton, "Customer added successfully!");
                    }catch (ParseException ex){
                        JOptionPane.showMessageDialog(addCustomerButton, "Something Went Wrong!");
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(addCustomerButton,"There are some missing fields");
                    }
                    customerName.setText("");
                    customerReg.setText("");
                    customerDob.setText("");
                    customerCreditCard.setText("");
                    customerGender.setSelectedIndex(0);
                }
            }
        });
        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == deleteCustomerButton){
                    boolean isDeleted = false;
                    try {
                        int delete = Integer.parseInt(customerDeleteID.getText());
                        for(int i = 0; i < customerList.size(); i++){
                            if(customerList.get(i).getID() == delete){
                                customerList.remove(i);
                                JOptionPane.showMessageDialog(deleteCustomerButton, "Customer deleted successfully!");
                                isDeleted = true;
                            }
                        }
                    } catch (RuntimeException run){
                        JOptionPane.showMessageDialog(deleteCustomerButton,"There are some missing fields");
                    }

                    if(!isDeleted){
                        JOptionPane.showMessageDialog(deleteCustomerButton, "There is no such ID!");
                    }
                    customerDeleteID.setText("");
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == nextButton){
                    int op = orderTypeBox.getSelectedIndex();
                    if(op == 1){
                        AddOnlineOrderPanel.setVisible(true);
                        AddResOrderPanel.setVisible(false);
                    }
                    else if(op == 2){
                        AddOnlineOrderPanel.setVisible(false);
                        AddResOrderPanel.setVisible(true);
                    }
                }
            }
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == orderButton){
                    boolean isID= false;SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try{
                        int customerID = Integer.parseInt(onlineID.getText());
                        String onlineDateText = onlineDate.getText();
                        String onlineDetailsText = onlineDetails.getText();
                        String onlineNotesText = onlineNotes.getText();
                        String onlineCreditText = onlineCredit.getText();
                        int onlineJunID = Integer.parseInt(onlineJuniorID.getText());
                        Date orderDate = dateFormat.parse(onlineDateText);
                        boolean iDone=false;
                        for(int i = 0 ; i < customerList.size(); i++){
                            if(customerID == customerList.get(i).getID()){
                                iDone = true;
                                for (int k = 0 ; k < staffList.size();k++ ){
                                    if(onlineJunID == staffList.get(k).getID()){
                                        for (int j =0 ; j < customerList.size();j++){
                                            if(customerList.get(j).getID() == customerID){
                                                isID = true;
                                                customerList.get(j).makeOrder(orderDate,onlineDetailsText,onlineNotesText,onlineCreditText,(Junior)staffList.get(k));
                                                JOptionPane.showMessageDialog(orderButton, "Thank you for your payment. Your transaction is complete and you will receive a receipt by e-mail.");
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        if(!iDone){
                            JOptionPane.showMessageDialog(orderButton,"There is no such ID registered with a customer!");
                        }
                    }catch (ParseException parseException){
                        JOptionPane.showMessageDialog(orderButton,"Something went wrong!");
                    }catch (RuntimeException run){
                        JOptionPane.showMessageDialog(orderButton,"There are some missing fields");
                    }
                    onlineID.setText("");
                    onlineDate.setText("");
                    onlineDetails.setText("");
                    onlineNotes.setText("");
                    onlineCredit.setText("");
                    onlineJuniorID.setText("");
                }
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addOrderButton){
                    boolean isID= false;SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try{
                        int customerID = Integer.parseInt(inResID.getText());
                        String inResDateText = inResDate.getText();
                        String inResDetailsText = inResDetails.getText();
                        String insResOrderNotesText = inResNotes.getText();
                        String inResOrderDateText = inResOrderDate.getText();
                        int tableNoText = Integer.parseInt(inResTableNo.getText());
                        Date orderDate = dateFormat.parse(inResDateText);
                        Date bookDate = dateFormat.parse(inResOrderDateText);
                                for (int j =0 ; j < customerList.size();j++){
                                    if(customerList.get(j).getID() == customerID){
                                        isID = true;
                                        customerList.get(j).makeOrder(bookDate,orderDate,inResDetailsText,insResOrderNotesText,tableNoText);
                                        JOptionPane.showMessageDialog(addOrderButton, "Order added successfully!.");
                                    }
                                }
                    }catch (ParseException parseException){
                        JOptionPane.showMessageDialog(addOrderButton,"Something went wrong!");
                    }catch (RuntimeException run){
                        JOptionPane.showMessageDialog(addOrderButton,"There are some missing fields");
                    }

                    inResID.setText("");
                    inResDate.setText("");
                    inResDetails.setText("");
                    inResNotes.setText("");
                    inResOrderDate.setText("");
                    inResTableNo.setText("");
                }
            }
        });
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == getButton){
                    boolean isID = false;
                    try{
                        int ID = Integer.parseInt(lastBookID.getText());
                        for(int i = 0; i < customerList.size(); i++){
                            if(customerList.get(i).getID() == ID){
                                isID = true;
                                lastBookCustID.setText(String.valueOf(ID));
                                int bookingSize =  customerList.get(i).getBookings().size()-1;
                                lastBookingID.setText(String.valueOf(customerList.get(i).getBookings().get(bookingSize).getBookingID()));
                                lastBookDate.setText(String.valueOf(customerList.get(i).getBookings().get(bookingSize).getBookingDate()));
                                GetDetails.setVisible(true);
                                break;
                            }
                        }
                        if(!isID){
                            JOptionPane.showMessageDialog(getButton,"There is registered with a customer!");
                        }
                    } catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(getButton,"Some fields are missing!");
                    }
                    lastBookID.setText("");
                }
            }
        });
        getStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==getStaffButton){
                    try{
                        int ID = Integer.parseInt(staffDetailID.getText());
                        boolean isID = false;   //flag tells if such ID number is exist or not
                        for(int i = 0; i < staffList.size(); i++){      //searching through staff list
                            if(staffList.get(i).getID() == ID){       //finding ID number in list with given ID
                                try {
                                    StaffDetails.setVisible(true);
                                    isID= true;           //ID is existing
                                    staffDetailsID.setText(String.valueOf(staffList.get(i).getID()));
                                    staffDetailsName.setText(staffList.get(i).getName());
                                    staffDetailsRole.setText(staffList.get(i).getClass().getSimpleName());
                                    staffDetailsGender.setText(String.valueOf(staffList.get(i).getGender()));
                                    staffDetailsDob.setText(String.valueOf(staffList.get(i).getDateOfBirth()));
                                } catch (Exception exception) {
                                    System.out.println("Something went wrong.");
                                }
                            }
                        }
                        if(!isID){
                            JOptionPane.showMessageDialog(getButton,"There is no such ID!");
                        }
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(getStaffButton,"Some fields are missing!");
                    }
                    staffDetailID.setText("");
                }
            }
        });
        getCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == getCustomerButton){
                    boolean isID = false;
                    try {
                        int ID = Integer.parseInt(customerDetailsID.getText());
                        for(int i = 0 ; i < customerList.size() ; i++) {
                            if (ID == customerList.get(i).getID()) {
                                customerDetails.setVisible(true);
                                custID.setText(String.valueOf(customerList.get(i).getID()));
                                custName.setText(customerList.get(i).getName());
                                custGender.setText(String.valueOf(customerList.get(i).getGender()));
                                custDob.setText(String.valueOf(customerList.get(i).getDateOfBirth()));
                                isID = true;
                            }
                            if (isID) {
                                break;
                            }
                        }
                        if(!isID){
                            JOptionPane.showMessageDialog(getCustomerButton,"There is no customer with that ID!");
                        }
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(getCustomerButton,"Some fields are missing!");
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(getCustomerButton,"Something went wrong!");
                    }
                    customerDetailsID.setText("");
                }
            }
        });
        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == makeBookingButton){
                    try{
                        boolean isID = false;SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String orderDetails, extraNotes; int tableNumber;
                        String bookingDateStr, orderDateStr;
                        int ID = Integer.parseInt(bookingCustomerID.getText());
                        for(int i = 0; i < customerList.size(); i++){
                            if(customerList.get(i).getID() == ID){
                                try{
                                    isID = true;
                                    bookingDateStr = bookingDate.getText();
                                    orderDateStr = bookingOrderDate.getText();
                                    tableNumber = Integer.parseInt(bookingTableNo.getText());
                                    orderDetails = bookingOrderDetails.getText();
                                    extraNotes = bookingExtraNotes.getText();
                                    Date tableDate = dateFormat.parse(bookingDateStr);
                                    Date orderDate = dateFormat.parse(orderDateStr);
                                    customerList.get(i).makeBooking(tableDate);
                                    customerList.get(i).getBookings().get(i).makeResOrder(orderDate,orderDetails,extraNotes,tableNumber);
                                    JOptionPane.showMessageDialog(makeBookingButton,"The customer's booking is received successfully!");
                                }catch (ParseException parseException){
                                    JOptionPane.showMessageDialog(makeBookingButton,"Something went wrong!");
                                }
                                catch (InputMismatchException ex) {
                                    JOptionPane.showMessageDialog(makeBookingButton,"Invalid Input!");
                                }
                            }
                        }
                        if(!isID){
                            System.out.println("There is no such ID!");
                        }
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(makeBookingButton,"Some fields are missing!");
                    }
                }
            }
        });
        nextButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == nextButton1){
                    try{
                        boolean isID = false;
                        int ID = Integer.parseInt(addOrderOfBookingCustomerID.getText());
                        for(int i = 0; i < customerList.size(); i++){
                            if(customerList.get(i).getID() == ID){
                                isID = true;
                                OrderOfBookingPanel.setVisible(true);
                            }
                        }
                        if(!isID){
                            JOptionPane.showMessageDialog(nextButton1,"There is no customer with that ID!");
                        }
                        }catch (RuntimeException ex){
                        JOptionPane.showMessageDialog(nextButton1,"Some fields are missing!");
                    }
                }
            }
        });
        AddOrderOfBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == AddOrderOfBookingButton){
                    try{
                        boolean isID = false; SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        int ID = Integer.parseInt(addOrderOfBookingCustomerID.getText());
                        int bookingID = Integer.parseInt(orderOfBookBookingID.getText());
                        for(int i = 0; i < customerList.size(); i++){
                            if(customerList.get(i).getID() == ID){
                                for (int j = 0; j <customerList.get(i).getBookings().size() ; j++) {
                                    if(bookingID == customerList.get(i).getBookings().get(j).getBookingID()) {
                                        isID = true;
                                        String orderDateStr = orderOfBookOrderDate.getText();
                                        int tableNumber = Integer.parseInt(orderOfBookTableNo.getText());
                                        String orderDetails = orderOfBookDetails.getText();
                                        String extraNotes = orderOfBookExtra.getText();
                                        Date orderDate = dateFormat.parse(orderDateStr);
                                        customerList.get(i).getBookings().get(j).makeResOrder(orderDate,orderDetails,extraNotes,tableNumber);
                                        customerList.get(i).getBookings().get(j).getRestrOrder().get(0).processPayment();
                                        JOptionPane.showMessageDialog(AddOrderOfBookingButton,"The customer's order is received successfully!");
                                        break;
                                    }
                                }
                            }
                        }
                    }catch (ParseException ex){
                        JOptionPane.showMessageDialog(AddOrderOfBookingButton,"Something went wrong!");
                    }catch (RuntimeException runtimeException){
                        JOptionPane.showMessageDialog(AddOrderOfBookingButton,"Some fields are missing!");
                    }
                }
            }
        });
        DisplayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == DisplayButton){
                    int op = orderType.getSelectedIndex();
                    if(op == 1){
                        OnlineOrders.setVisible(true);
                        InRestaurant.setVisible(false);
                        listOnlineOrders();
                    }
                    else if(op == 2){
                        OnlineOrders.setVisible(false);
                        InRestaurant.setVisible(true);
                        listResOrders();
                    }
                }
            }
        });
        getButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == getButton1){
                    try{
                        boolean isID = false;
                        resetTable();
                        int ID = Integer.parseInt(CustomerOrderCustomerID.getText());
                        int bookingID = Integer.parseInt(customerOrderBookID.getText());
                        for(int i = 0 ; i < customerList.size() ; i++){
                            if(ID == customerList.get(i).getID()){
                                isID = true;
                                orderDetailsPanel.setVisible(true);
                                listCustomerOrder(ID,bookingID);
                            }
                        }
                        if(!isID){
                            JOptionPane.showMessageDialog(getButton1,"No customer found with that ID!");
                        }
                    }catch (RuntimeException ex){
                        JOptionPane.showMessageDialog(getButton1,"Some fields are missing!");
                    }
                    CustomerOrderCustomerID.setText("");
                    customerOrderBookID.setText("");
                }
            }
        });
    }

    public void operation(int op) {
        if (op == 0) {
            toggleMenu();
        }
        //option 1 Add Staff
        if (op == 1) {
            toggleMenu();
            AddStaffPanel.setVisible(true);
        }//option 2 deletes a Staff
        else if (op == 2) {
            toggleMenu();
            DeleteStaff.setVisible(true);
        }//option 3 list Staff details
        else if (op == 3) {
            toggleMenu();
            ListStaffDetailsPanel.setVisible(true);
        }//option 4 adds Customer
        else if (op == 4) {
            toggleMenu();
            AddCustomerPanel.setVisible(true);
        }//option 5 deletes a customer
        else if (op == 5) {
            toggleMenu();
            DeleteCustomerPanel.setVisible(true);
        }//option 6 adds a booking
        else if(op == 6){
            toggleMenu();
            AddBookingPanel.setVisible(true);
        }
        else if(op == 7){
            toggleMenu();
            AddOrderPanel.setVisible(true);
        }//option 8 receives an order of Booking
        else if(op == 8){
            toggleMenu();
            AddOrderOfBookingPanel.setVisible(true);
        }//option 9 gets customer details
        else if(op == 9){
            toggleMenu();
            ListCustomerDetailsPanel.setVisible(true);
        } //option 10 Display customer last booking
        else if(op == 10){
            toggleMenu();
            DisplayCustomerLastBookingPanel.setVisible(true);
        }//option 11 display all orders
        else if(op == 11){
            toggleMenu();
            ListAllOrderPanel.setVisible(true);
        }//option 12 gets customer's orders
        else if(op == 12){
            toggleMenu();
            ListCustomerOrdersPanel.setVisible(true);
        }//option 13 list Staff
        else if(op == 13){
            toggleMenu();
            StaffListPanel.setVisible(true);
            listStaff();
        }//option 14 list customers
        else if(op == 14){
            toggleMenu();
            ListAllTheCustomersPanel.setVisible(true);
            listCustomer();

        }//option 15 list all staff salary
        else if(op == 15){
            toggleMenu();
            ListAllStaffSalaryPanel.setVisible(true);
            listStaffSalary();
        }
    }

    /**
     * This method set all panels visibility to false except Menu
     * */
    public void toggleMenu(){
        MenuPanel.setVisible(true);
        AddStaffPanel.setVisible(false);
        ListStaffDetailsPanel.setVisible(false);
        AddCustomerPanel.setVisible(false);
        DeleteCustomerPanel.setVisible(false);
        AddBookingPanel.setVisible(false);
        AddOrderPanel.setVisible(false);
        AddOrderOfBookingPanel.setVisible(false);
        ListCustomerDetailsPanel.setVisible(false);
        DisplayCustomerLastBookingPanel.setVisible(false);
        ListAllOrderPanel.setVisible(false);
        ListCustomerOrdersPanel.setVisible(false);
        ListAllTheStaffPanel.setVisible(false);
        ListAllTheCustomersPanel.setVisible(false);
        ListAllStaffSalaryPanel.setVisible(false);
        SeniorPanel.setVisible(false);
        JuniorPanel.setVisible(false);
        DeleteStaff.setVisible(false);
        StaffListPanel.setVisible(false);
        AddOnlineOrderPanel.setVisible(false);
        AddResOrderPanel.setVisible(false);
        GetDetails.setVisible(false);
        StaffDetails.setVisible(false);
        customerDetails.setVisible(false);
        OrderOfBookingPanel.setVisible(false);
        OnlineOrders.setVisible(false);
        InRestaurant.setVisible(false);
        orderDetailsPanel.setVisible(false);
        resetTable();
    }

    /**listStaff method displays every staffs' info with their salary related to their role as a table
     * @see Staff
     */
    public void listStaff(){
        StaffListPanel.setLayout(new BorderLayout());
        JTable StaffTable =new JTable();
        StaffTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel staffTableModel = (DefaultTableModel) StaffTable.getModel();
        staffTableModel.addColumn("Role");
        staffTableModel.addColumn("ID");
        staffTableModel.addColumn("Name");
        staffTableModel.addColumn("Gender");
        staffTableModel.addColumn("Date of Birth");
        for (int i = 0; i < staffList.size(); i++) {
            Object[] objects = {staffList.get(i).getClass().getSimpleName(),staffList.get(i).getID(),staffList.get(i).getName(),staffList.get(i).getGender(),staffList.get(i).getDateOfBirth()};
            staffTableModel.addRow(objects);
        }
        StaffTable.setModel(staffTableModel);
        staffTableContainer = new JScrollPane(StaffTable);
        StaffListPanel.add(staffTableContainer, BorderLayout.SOUTH);

    }
    /**listCustomer method displays every customers' info as a JTable
     * @see Customer
     * */
    public void listCustomer(){
        ListAllTheCustomersPanel.setLayout(new BorderLayout());
        JTable CustomerTable = new JTable();
        CustomerTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel customerTableModel = (DefaultTableModel) CustomerTable.getModel();
        customerTableModel.addColumn("ID");
        customerTableModel.addColumn("Name");
        customerTableModel.addColumn("Gender");
        customerTableModel.addColumn("Date of Birth");
        for (int i = 0; i < customerList.size(); i++) {
            Object[] objects = {customerList.get(i).getID(),customerList.get(i).getName(),customerList.get(i).getGender(),customerList.get(i).getDateOfBirth()};
            customerTableModel.addRow(objects);
        }
        CustomerTable.setModel(customerTableModel);
        customerTableContainer = new JScrollPane(CustomerTable);
        ListAllTheCustomersPanel.add(customerTableContainer, BorderLayout.SOUTH);

    }
    /**listStaff method displays every staffs' info with their salary related to their role as Jtable
     * @see Staff
     */
    public void listStaffSalary(){
        ListAllStaffSalaryPanel.setLayout(new BorderLayout());
        JTable StaffSalaryTable =new JTable();
        StaffSalaryTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel staffSalaryTableModel= (DefaultTableModel) StaffSalaryTable.getModel();
        staffSalaryTableModel.addColumn("Role");
        staffSalaryTableModel.addColumn("ID");
        staffSalaryTableModel.addColumn("Name");
        staffSalaryTableModel.addColumn("Salary");
        for (int i = 0; i < staffList.size(); i++) {
            Object[] objects = {staffList.get(i).getClass().getSimpleName(),staffList.get(i).getID(),staffList.get(i).getName(),staffList.get(i).getSalary()};
            staffSalaryTableModel.addRow(objects);
        }
        StaffSalaryTable.setModel(staffSalaryTableModel);
        staffSalaryTableContainer = new JScrollPane(StaffSalaryTable);
        ListAllStaffSalaryPanel.add(staffSalaryTableContainer, BorderLayout.SOUTH);

    }
    /**listAllOrder Method Displays all online order that has been taken so far as a table
     * @see Customer
     * */
    public void listOnlineOrders(){
        OnlineOrders.setLayout(new BorderLayout());
        JTable OnlineOrderTable = new JTable();
        OnlineOrderTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel orderTableModel = (DefaultTableModel) OnlineOrderTable.getModel();
        orderTableModel.addColumn("Order ID");
        orderTableModel.addColumn("Order Date");
        orderTableModel.addColumn("Order Description");
        orderTableModel.addColumn("Order Notes");
        for(int i = 0; i < customerList.size(); i++) {
            for (int j = 0; j <customerList.get(i).getOrders().size(); j++) {
                Object[] objects = {customerList.get(i).getOrders().get(j).getOrderID(), customerList.get(i).getOrders().get(j).getOrderDate(), customerList.get(i).getOrders().get(j).getOrderDetails(), customerList.get(i).getOrders().get(j).getExtraNotes()};
                orderTableModel.addRow(objects);
            }
        }
        OnlineOrderTable.setModel(orderTableModel);
        orderTableContainer = new JScrollPane(OnlineOrderTable);
        OnlineOrders.add(orderTableContainer, BorderLayout.SOUTH);
    }
    /**listAllOrder Method Displays all restaurant orders that has been taken so far as a table
     * @see Customer
     * */
    public void listResOrders(){
        InRestaurant.setLayout(new BorderLayout());
        JTable resOrderTable = new JTable();
        resOrderTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel resOrderTableModel = (DefaultTableModel) resOrderTable.getModel();
        resOrderTableModel.addColumn("Booking ID");
        resOrderTableModel.addColumn("Order ID");
        resOrderTableModel.addColumn("Order Description");
        resOrderTableModel.addColumn("Order Notes");
        resOrderTableModel.addColumn("Table Number");
        for(int i = 0; i < customerList.size(); i++) {
            for (int j = 0; j <customerList.get(i).getBookings().size(); j++) {
                Object[] objects = {customerList.get(i).getBookings().get(j).getBookingID(),customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getOrderID(), customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getOrderDetails(), customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getExtraNotes(),customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getTableNumber()};
                resOrderTableModel.addRow(objects);
                System.out.println("ok"+i);
            }
        }
        resOrderTable.setModel(resOrderTableModel);
        resOrderTableContainer = new JScrollPane(resOrderTable);
        InRestaurant.add(resOrderTableContainer, BorderLayout.SOUTH);
    }
    /**listCustomerOrders method displays a customer's
     orders with given an ID number and the booking Id as a table
     * @see Customer
     * @see Booking
     * @param ID (int)parameter to find staff's ID number.
     * @param bookingID (int)parameter to get booking ID number.
     */
    public void listCustomerOrder(int ID, int bookingID){
        orderDetailsPanel.setLayout(new BorderLayout());
        JTable CustomerOrderTable = new JTable();
        CustomerOrderTable = new JTable(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        DefaultTableModel customerOrderTableModel = (DefaultTableModel) CustomerOrderTable.getModel();
        customerOrderTableModel.addColumn("Order Details:");
        customerOrderTableModel.addColumn("Order Notes:");
        customerOrderTableModel.addColumn("Table Number:");
        customerOrderTableModel.setRowCount(0);
        for(int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getID() == ID){
                for(int j = 0; j <customerList.get(i).getBookings().size(); j++ ){
                    if(bookingID == customerList.get(i).getBookings().get(j).getBookingID()){
                        Object[] objects = {customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getExtraNotes(),customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getOrderDetails(),customerList.get(i).getBookings().get(j).getRestrOrder().get(j).getTableNumber()};
                        customerOrderTableModel.addRow(objects);
                    }
                }
            }
        }
        CustomerOrderTable.setModel(customerOrderTableModel);
        customerOrderTableContainer = new JScrollPane(CustomerOrderTable);
        orderDetailsPanel.add(customerOrderTableContainer, BorderLayout.SOUTH);

    }

    /**
     * This method reset all tables basically removes from panel
     * */
    public void resetTable(){
        try{
            StaffListPanel.remove(staffTableContainer);
            ListAllTheCustomersPanel.remove(customerTableContainer);
            ListAllStaffSalaryPanel.remove(staffSalaryTableContainer);
            OnlineOrders.remove(orderTableContainer);
            InRestaurant.remove(resOrderTableContainer);
            orderDetailsPanel.remove(customerOrderTableContainer);
        }catch (Exception ex){
            System.out.println("Table is not created yet!");
        }



    }

}