package com.sparta.AlphaTeam.DataManagement;
import com.sparta.AlphaTeam.DataManagement.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class EmployeeTests {
    SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");

    Employee employee;
    @BeforeEach
    void setUp() throws ParseException {
        employee = new Employee(21920, "Miss", "Kira", 'G', "Coke", 'F', "kira.coke@spartaglobal.com"
                ,(parser.parse("11/03/1999")), (parser.parse("06/20/2022")), 21000);
    }

    @Test
    public void getCorrectData() throws ParseException {
        Assertions.assertTrue(employee.getEmail().equals("kira.coke@spartaglobal.com"));
        Assertions.assertTrue(employee.getId() == 21920);
        Assertions.assertTrue(employee.getfName().equals("Kira"));
        Assertions.assertTrue(employee.getDateOfBirth().equals(parser.parse("11/03/1999")));
        Assertions.assertTrue(employee.getJoinDate().equals(parser.parse("06/20/2022")));
        Assertions.assertTrue(employee.getSalary() == 21000);
        Assertions.assertTrue(employee.getGender().equals('F'));
        Assertions.assertTrue(employee.getlName().equals("Coke"));
        Assertions.assertTrue(employee.getmName().equals('G'));
        Assertions.assertTrue(employee.getPrefix().equals("Miss"));
    }

    @Test
    public void setCorrectData() throws ParseException {
        employee.setfName("Sara");
        Assertions.assertTrue(employee.getfName().equals("Sara"));
        employee.setGender('M');
        Assertions.assertTrue(employee.getGender().equals('M'));
        employee.setDateOfBirth(parser.parse("10/11/1997"));
        Assertions.assertTrue(employee.getDateOfBirth().equals(parser.parse("10/11/1997")));
        employee.setId(18290);
        Assertions.assertTrue(employee.getId() == 18290);
    }
}
