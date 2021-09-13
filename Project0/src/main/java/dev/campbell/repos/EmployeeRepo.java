package dev.campbell.repos;

import dev.campbell.errors.invalidloginException;
import dev.campbell.errors.usernameException;
import dev.campbell.models.Duelist;
import dev.campbell.utils.ConnectionUtil;
import dev.campbell.models.Employee;
import dev.campbell.errors.noduelistavailableException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepo {

    ConnectionUtil cu =ConnectionUtil.getConnectionUtil();

    public boolean create(Employee employee) throws usernameException {

        try (Connection conn = cu.getConnection()){

            String sql = "insert into employees values (default, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUsername());
            ps.setString(4, employee.getPassword());
            ps.setString(5, employee.getTitle());

            boolean complete= ps.executeUpdate() != 0;

            System.out.println("Employee created successfully.");

            return complete;

        } catch (SQLException e) {
            throw new usernameException();
        }

    }

    public Employee getbyUsername(String username, String password) throws invalidloginException {

        try (Connection conn = cu.getConnection()){

            String sql = "select * from employees where username = ? and password = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("title")
                );
                return emp;

            } else {
                throw new invalidloginException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Duelist getDuelist () throws noduelistavailableException {

        try (Connection conn = cu.getConnection()){

            String sql = "select * from duelists where available = true order by random() limit 1;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Duelist u = new Duelist (
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("deck_name"),
                        rs.getString("deck_type"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("available")
                );
                return u;
            } else {
                throw new noduelistavailableException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



}
