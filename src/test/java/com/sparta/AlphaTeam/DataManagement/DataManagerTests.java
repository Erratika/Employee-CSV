package com.sparta.AlphaTeam.DataManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataManagerTests {

    DataManager dataManager;
    List<Employee> cleanList;
    List<Employee> missingList;
    List<Employee> duplicateList;
    List<Employee> invalidList;
    List<Employee> dirtyList;
    List<Employee> unsortedList;
    List<Employee> fetchedList;
    SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
    Employee missing = new Employee(-1,  "Miss", "Kira", 'G', "Coke", 'F',
            "kcoke@spartaglobal.com",(parser.parse("11/03/1999")), (parser.parse("06/20/2022")), 21000);
    Employee invalid = new Employee(123127,  "Miss", "Kira", 'G', "Coke", 'F', "kira.coke@spartaglobal.com"
            ,(parser.parse("11/03/1901")), (parser.parse("06/20/2022")), 21000);
    Employee clean = new Employee(290333, "Miss", "Kira", 'G', "Coke", 'F', "kira.coke@spartaglobal.com"
            ,(parser.parse("11/03/1999")), (parser.parse("06/20/2022")), 21000);

    Employee duplicate= new Employee(290333, "Miss", "Kira", 'G', "Coke", 'F', "kira.coke@spartaglobal.com"
            ,(parser.parse("11/03/1999")), (parser.parse("06/20/2022")), 21000);

    public DataManagerTests() throws ParseException {
    }

    @BeforeEach
    void setUp(){
        dataManager = new DataManager();
        cleanList = new ArrayList<>();
        missingList = new ArrayList<>();
        fetchedList = new ArrayList<>();
        duplicateList = new ArrayList<>();
        invalidList = new ArrayList<>();
        dirtyList = new ArrayList<>();
        unsortedList = new ArrayList<>();
        cleanList.add(clean); missingList.add(missing); invalidList.add(invalid);
        duplicateList.add(duplicate); dirtyList.add(missing); dirtyList.add(invalid);
        dirtyList.add(duplicate); unsortedList.add(clean); unsortedList.add(duplicate);
        unsortedList.add(invalid); unsortedList.add(missing); fetchedList.add(clean);
    }
    @Test
    public void recordsTest(){
        dataManager.setCleanRecords(cleanList);
        dataManager.setAllDirtyRecords(dirtyList);
        dataManager.setMissingValueRecords(missingList);
        dataManager.setInvalidDateRecords(invalidList);
        dataManager.setUnsortedRecords(unsortedList);
        dataManager.setDuplicatedRecords(duplicateList);
        dataManager.setFetchedRecords(fetchedList);
        Assertions.assertEquals(1, dataManager.getCleanRecords().size());
        Assertions.assertEquals(1, dataManager.getMissingValueRecords().size());
        Assertions.assertEquals(1, dataManager.getInvalidDateRecords().size());
        Assertions.assertEquals(3, dataManager.getAllDirtyRecords().size());
        Assertions.assertEquals(4, dataManager.getUnsortedRecords().size());
        Assertions.assertEquals(1, dataManager.getDuplicatedRecords().size());
        Assertions.assertEquals(1, dataManager.getFetchedRecords().size());

    }


    @Test
    public void threadTests(){
        dataManager.setThreadCount(4);
        Assertions.assertEquals(4, dataManager.getThreadCount());
        dataManager.setThreadCount(0);
        Assertions.assertEquals(0, dataManager.getThreadCount());
    }

    @Test
    public void stringTest(){
        List<String> temp = new ArrayList<>();
        temp.add("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,2/1/2008,69294");
        temp.add("178566,Mrs.,Juliette,M,Rojo,F,juliette.rojo@yahoo.co.uk,5/8/1967,6/4/2011,193912");
        temp.add("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,4/4/1980,1/19/2012,123681");
        dataManager.convertStringListToEmployee(temp);
        Assertions.assertEquals(3, dataManager.getUnsortedRecords().size());
    }
}
