package com.sparta.AlphaTeam.DataManagement;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataFilter {

    private static Date parseDate(String string) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        return (Date) parser.parse(string);
    }

    public boolean filterMissing(Employee employee){
        int id = employee.getId();
        int salary = employee.getSalary();
        if((id == -1) || (employee.getPrefix() == null) || (employee.getfName() == null) || (employee.getmName()== null) ||
                (employee.getlName() == null) || (employee.getGender() == null) || (employee.getEmail() == null) || (employee.getDateOfBirth() == null) ||
                (employee.getJoinDate() == null) || (salary == -1)){
            return  true;
        }
        return false;
    }

    public boolean filterInvalidData(Employee employee) throws ParseException {
        Date temp = parseDate("12/31/1999");
        int fName = employee.getfName().length();
        int lName = employee.getlName().length();
        String firstN = employee.getEmail().substring(0, fName);
        String lastN = employee.getEmail().substring(fName+1, lName);
        if(employee.getDateOfBirth().before(employee.getJoinDate())){
            return true;
        }else{
            if(employee.getDateOfBirth().before(temp)){
                return true;
            }else{
                if((!employee.getfName().equals(firstN)) || (!employee.getlName().equals(lName))){ //email doesnt match name
                    return true;
                }
                return false; //valid dates
            }
        }
    }

    public boolean filterDuplictes(Employee employee, List<Employee> list){
        if(list.contains(employee.getlName()) && list.contains(employee.getfName())){
            return true;
        }else{
            if(list.contains(employee.getEmail()) || list.contains(employee)){
                return true;
            }
        }
        return false;
    }

}
