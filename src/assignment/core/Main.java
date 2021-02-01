package assignment.core;

import java.text.ParseException;
import java.util.*;

/**
 * @author Yusuf Gökberk Keptiğ
 * @version 1.0
 * */


public class Main {
    static PopulateData populateData;         //Creates populateData object

    static {
        try {
            populateData = new PopulateData();         //Populates Data
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Staff> staffList = populateData.getStaffList();  //Makes staff list which gets list from data we populated
    static ArrayList<Customer> customerList = populateData.getCustomerList();  //Makes staff list which gets list from data we populated

    /**
     * This is the main class method.
     *
     * @param args String[] args
     */
    public static void main(String[] args) {

        guiTool myFrame = new guiTool();

    }
}