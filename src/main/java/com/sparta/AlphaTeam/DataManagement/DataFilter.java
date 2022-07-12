package com.sparta.AlphaTeam.DataManagement;

import java.sql.Date;
import java.util.List;

public class DataFilter {

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

    public boolean filterInvalidDate(Employee employee){
        if(employee.getDateOfBirth().before(employee.getJoinDate())){
            return true;
        }else{
            if(employee.getDateOfBirth().before(new Date(19031231))) {
                return true;
            }else{
                return false; //valid dates
            }
        }
    }

    public boolean filterDuplictes(Employee employee, List<Employee> list){
        if(list.contains(employee)){
            return true;
        }
        return false;
    }

}
