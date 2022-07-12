package com.sparta.AlphaTeam.DataManagement;

import com.sparta.AlphaTeam.DataManagement.Employee;

public class DataFilter {

    public boolean filterMissing(Employee employee){
return false;
    }

    public boolean filterInvalidDate(Employee employee){
return false;
        //invalid data:
        //if birth date is before join date
        //if birth date is before 1904
    }

    public boolean filterDuplictes(){
return false;
    }

}
