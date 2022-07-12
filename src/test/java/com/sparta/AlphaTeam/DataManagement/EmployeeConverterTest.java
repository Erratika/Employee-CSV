package com.sparta.AlphaTeam.DataManagement;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeConverterTest {
	/**
	 * Test cases.
	 * Valid Varying data.
	 * Missing or empty data ie no data between commas.
	 * Invalid dates.
	 * Invalid emails.
	 * Upper/ lower bound id. Negative ID's
	 * Nulls or end of lines.
	 */

	@Test
	void convertStringsToEmployeesTestValid() {
		List<String> testValidStrings = new ArrayList<>();
		testValidStrings.add("792050,Ms.,Marget,V,Bowden,F,marget.bowden@hotmail.com,23/10/1991,7/8/2015,147396\n");
		assertDoesNotThrow(()->{
			List<Employee> actualEmployees = EmployeeConverter.convertStringsToEmployees(testValidStrings);
			Employee actualEmployee = actualEmployees.get(0);
			assertEquals(792050,actualEmployee.getId());
			assertEquals("Ms.",actualEmployee.getPrefix());
			assertEquals("Marget",actualEmployee.getfName());
			assertEquals("V",actualEmployee.getmName());
			assertEquals("Bowden",actualEmployee.getlName());
			assertEquals("F",actualEmployee.getGender());
			assertEquals("marget.bowden@hotmail.com",actualEmployee.getEmail());
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
			assertEquals(parser.parse("10/23/1991"),actualEmployee.getDateOfBirth());
			assertEquals(parser.parse("7/8/2015"),actualEmployee.getJoinDate());
			assertEquals(147396,actualEmployee.getSalary());
		});

	}
	@Test
	void convertStringsToEmployeesTestInvalidDate() {
		List<String> testValidStrings = new ArrayList<>();
		testValidStrings.add("792050,Ms.,Marget,V,Bowden,F,marget.bowden@hotmail.com,10/23/1991,7/8/2015,147396\n");
		// 10/11/1992
		assertThrows(ParseException.class, ()->{
			List<Employee> actualEmployees = EmployeeConverter.convertStringsToEmployees(testValidStrings);
			Employee actualEmployee = actualEmployees.get(0);
			assertEquals(792050,actualEmployee.getId());
			assertEquals("Ms.",actualEmployee.getPrefix());
			assertEquals("Marget",actualEmployee.getfName());
			assertEquals("V",actualEmployee.getmName());
			assertEquals("Bowden",actualEmployee.getlName());
			assertEquals("F",actualEmployee.getGender());
			assertEquals("marget.bowden@hotmail.com",actualEmployee.getEmail());
			SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
			assertEquals(parser.parse("10/23/1991"),actualEmployee.getDateOfBirth());
			assertEquals(parser.parse("7/8/2015"),actualEmployee.getJoinDate());
			assertEquals(147396,actualEmployee.getSalary());
		});
	}
	@Test
	void convertStringsToEmployeesTestEmpty() {
		List<String> testValidStrings = new ArrayList<>();
		testValidStrings.add(",Ms.,Marget,V,Bowden,,marget.bowden@hotmail.com,,7/8/2015,147396\n");
		assertThrows(ParseException.class, ()->{
			List<Employee> actualEmployees = EmployeeConverter.convertStringsToEmployees(testValidStrings);
			Employee actualEmployee = actualEmployees.get(0);
			assertEquals(0,actualEmployee.getId());
			assertEquals("Ms.",actualEmployee.getPrefix());
			assertEquals("Marget",actualEmployee.getfName());
			assertEquals("V",actualEmployee.getmName());
			assertEquals("Bowden",actualEmployee.getlName());
			assertEquals("F",actualEmployee.getGender());
			assertEquals("marget.bowden@hotmail.com",actualEmployee.getEmail());
			SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
			assertEquals(null,actualEmployee.getDateOfBirth());
			assertEquals(parser.parse("7/8/2015"),actualEmployee.getJoinDate());
			assertEquals(147396,actualEmployee.getSalary());
		});
	}

}