package com.sparta.AlphaTeam.DataManagement;

import java.sql.Date;
import java.util.List;

public class DataFilter {

    public boolean filterMissing(Employee employee){
        if(employee.getId() == null){

        }
        return true;
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
