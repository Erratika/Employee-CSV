package com.sparta.AlphaTeam.DataManagement;

import com.sparta.alphateam.DataManagement.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeConverter {
    public List<Employee> convertStringToEmployees(List<String> input) throws ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        for (String line : input) {
            String[] delimitedResult = line.split(",");
            employees.add(new Employee(Integer.parseInt(delimitedResult[0]),
                    delimitedResult[1],
                    delimitedResult[2],
                    delimitedResult[3],
                    delimitedResult[4],
                    delimitedResult[5],
                    delimitedResult[6],
                    parseDate(delimitedResult[7]),
                    parseDate(delimitedResult[8]),
                    Integer.parseInt(delimitedResult[9])));

        }
        return employees;
    }
    private Date parseDate(String string) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("d/M/yyyy");
        return parser.parse(string);
    }
}
