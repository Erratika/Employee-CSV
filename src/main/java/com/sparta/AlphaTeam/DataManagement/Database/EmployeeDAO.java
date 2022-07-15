package com.sparta.AlphaTeam.DataManagement.Database;

import com.sparta.AlphaTeam.DataManagement.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*"CREATE TABLE `employees`" +
        " (`id` int NOT NULL," +
        "`prefix` varchar(10) DEFAULT NULL," +
        "`first_name` varchar(45) DEFAULT NULL," +
        "`middle_initial` char(1) DEFAULT NULL," +
        "`last_name` varchar(45) DEFAULT NULL," +
        "`gender` char(1) DEFAULT NULL," +
        "`email` varchar(45) DEFAULT NULL," +
        "`date_of_birth` date DEFAULT NULL," +
        "`date_of_joining` date DEFAULT NULL," +
        "`salary` int DEFAULT NULL," +
        " PRIMARY KEY (`id`)," +
        " UNIQUE KEY `email_UNIQUE` (`email`))" +
        " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 " +
        "COLLATE=utf8mb4_0900_ai_ci";*/
public class EmployeeDAO implements DAO<Employee> {

	List<Employee> employeeList = new ArrayList<>();

	public List<Employee> getAll() {
		Connection connection = ConnectionFactory.getConnection();
		try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees ")
		) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeeList.add(new Employee(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4).charAt(0),
								rs.getString(5),
								rs.getString(6).charAt(0),
								rs.getString(7),
								new java.util.Date(rs.getDate(8).getTime()),
								new java.util.Date(rs.getDate(9).getTime()),
						rs.getInt(10))
				);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return employeeList;
	}

	@Override
	public void add(Employee employee) {
		Connection connection = ConnectionFactory.getConnection();
		try (PreparedStatement statement = connection.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)")) {
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getPrefix());
			statement.setString(3, employee.getfName());
			statement.setString(4, employee.getmName().toString());
			statement.setString(5, employee.getlName());
			statement.setString(6, employee.getGender().toString());
			statement.setString(7, employee.getEmail());
			statement.setDate(8, new Date(employee.getDateOfBirth().getTime()));
			statement.setDate(9, new Date(employee.getJoinDate().getTime()));
			statement.setInt(10, employee.getSalary());
			statement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Optional<Employee> get(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees where id == (?)")) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.getResultSet();
			return Optional.of(new Employee(
					resultSet.getInt(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getString(4).charAt(0),
					resultSet.getString(5),
					resultSet.getString(6).charAt(0),
					resultSet.getString(7),
					new java.util.Date(resultSet.getDate(8).getTime()),
					new java.util.Date(resultSet.getDate(9).getTime()),
					resultSet.getInt(10)));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
