package com.sparta.AlphaTeam.DataManagement;
import com.sparta.AlphaTeam.UserInterface.UserManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class DataFilterTests {
    SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
    DataFilter dataFilter;
    List <Employee> list;

    public DataFilterTests() throws ParseException {
    }

    @BeforeEach
    void setUp(){dataFilter = new DataFilter();}
    Employee missing = new Employee(-1,  "Miss", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee invalid1 = new Employee(123127,  "Miss", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("1103199")), (parser.parse("06202022")), 21000);
    Employee invalid2 = new Employee(123918,  "Miss", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee invalid3 = new Employee(213917,  "Miss", "Kira", 'G', "Coke", 'F', "kcoker@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee clean = new Employee(290333, "Miss", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee clean2 = new Employee(79820, "Miss", "Lira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee clean3 =  new Employee(902321, "Mr", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);
    Employee clean4 =  new Employee(78291, "Miss", "Suzy", 'G', "Coke", 'F', "scoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 22000);
    Employee clean5 =  new Employee(87782, "Mr", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);

    Employee duplicate1= new Employee(290333, "Mr", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);

    Employee duplicate2= new Employee(12830, "Mr", "Kira", 'G', "Coke", 'F', "kcoke@spartaglobal.com"
            ,(parser.parse("11031999")), (parser.parse("06202022")), 21000);

    @Test
    public void missingTest(){
        Assertions.assertTrue(dataFilter.filterMissing(missing));
        missing.setEmail(null);
        Assertions.assertTrue(dataFilter.filterMissing(missing));
    }
    @Test
    public void invalidTest() throws ParseException {
        Assertions.assertTrue(dataFilter.filterInvalidData(invalid1));
        Assertions.assertTrue(dataFilter.filterInvalidData(invalid2));
        Assertions.assertTrue(dataFilter.filterInvalidData(invalid3));
    }
    @Test
    public void duplicatesTest(){
        Assertions.assertTrue(dataFilter.filterDuplictes(duplicate1, list));
        Assertions.assertTrue(dataFilter.filterDuplictes(duplicate2,list));
    }
    @Test
    public void cleanTests() throws ParseException {
        list.add(clean);
        list.add(clean2);
        list.add(clean3);
        Assertions.assertFalse(dataFilter.filterMissing(clean));
        Assertions.assertFalse(dataFilter.filterInvalidData(clean));
        Assertions.assertFalse(dataFilter.filterDuplictes(clean4, list));
        Assertions.assertFalse(dataFilter.filterDuplictes(clean5, list));
    }
}
