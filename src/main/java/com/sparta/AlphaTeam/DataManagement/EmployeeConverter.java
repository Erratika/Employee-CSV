package com.sparta.AlphaTeam.DataManagement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeConverter {
    public static List<Employee> convertStringsToEmployees(List<String> input) throws ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        for (String line : input) {
            String[] delimitedResult = line.split("[,\n]");
            try {
                int id = Integer.parseInt(delimitedResult[0]);
            }catch (NumberFormatException e){
                //TODO Handle
            }
            String prefix = delimitedResult[1];
            String fName = delimitedResult[2];

            //TODO what if char is null?
            Character mInitial = delimitedResult[3].charAt(0);

            String lName = delimitedResult[4];
            Character gender = delimitedResult[5].charAt(0);
            String email = delimitedResult[6];
            Date dateOfBirth = parseDate(delimitedResult[7]);
            Date joinDate = parseDate(delimitedResult[8]);
            try{
                Integer salary = Integer.parseInt(delimitedResult[9]);
            }catch (NumberFormatException e){
                //TODO handle
            }
            employees.add(new Employee(id,prefix,fName,mInitial,lName,gender,email,dateOfBirth,joinDate,salary));
        }
        return employees;
    }
    private static Date parseDate(String string) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        return parser.parse(string);
    }
}
