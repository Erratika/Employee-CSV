package com.sparta.AlphaTeam.DataManagement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EmployeeConverter {
	/**
	 *
	 * @param input
	 * @return
	 * @throws ParseException
	 * @throws IndexOutOfBoundsException
	 */
	public static List<Employee> convertStringsToEmployees(List<String> input) throws ParseException, IndexOutOfBoundsException {
		ArrayList<Employee> employees = new ArrayList<>();
		for (String line : input) {
			String[] delimitedResult = line.split("[,\n]");
			int id;

			//TODO Check with others how best to handle null integers and Characters.
			try {
				id = Integer.parseInt(delimitedResult[0]);
			} catch (NumberFormatException e) {
				id = 0;
			}
			String prefix = delimitedResult[1];
			String fName = delimitedResult[2];

			char mInitial;
			try {
				mInitial = delimitedResult[3].charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				throw new StringIndexOutOfBoundsException();
			}

			String lName = delimitedResult[4];

			char gender;
			try {
				gender = delimitedResult[5].charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				throw new StringIndexOutOfBoundsException();
			}
			String email = delimitedResult[6];
			Date dateOfBirth = parseDate(delimitedResult[7]);
			Date joinDate = parseDate(delimitedResult[8]);
			int salary;
			try {
				salary = Integer.parseInt(delimitedResult[9]);
			} catch (NumberFormatException e) {
				salary = 0;
			}
			employees.add(new Employee(id, prefix, fName, mInitial, lName, gender, email, dateOfBirth, joinDate, salary));
		}
		return employees;
	}

	private static Date parseDate(String string) throws ParseException {
		SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		return parser.parse(string);
	}
}
