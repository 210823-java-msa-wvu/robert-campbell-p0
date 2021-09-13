package dev.campbell.repos;

import dev.campbell.errors.invalidloginException;
import dev.campbell.errors.usernameException;
import dev.campbell.models.Duelist;
import dev.campbell.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DuelistRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    public boolean create(Duelist duelist) throws usernameException {

        try (Connection conn = cu.getConnection()){

            String sql = "insert into duelists values (default, ?, ?, ?, ?, ?, ?, false);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, duelist.getFirstName());
            ps.setString(2, duelist.getLastName());
            ps.setString(3, duelist.getDeckName());
            ps.setString(4, duelist.getDeckType());
            ps.setString(5, duelist.getUsername());
            ps.setString(6, duelist.getPassword());

            boolean complete= ps.executeUpdate() != 0;

            System.out.println("User created successfully.");

            return complete;


        } catch (SQLException e){
            throw new usernameException();
        }

    }

    public Duelist getbyUsername(String username, String password ) throws invalidloginException {

        try (Connection conn = cu.getConnection()){

            String sql = "select * from duelists where username = ? and password = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
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
            }
            else {
                //System.out.println("throwing exception");
                throw new invalidloginException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean updateFirstName(String fname, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set first_name = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updateLastName(String lname, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set last_name = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lname);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updateDeckName(String dname, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set deck_name = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updateDeckType(String dtype, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set deck_type = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dtype);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updateUsername(String uname, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set username = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updatePassword(String pass, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set password = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean updateAvailable(boolean avail, Duelist d){

        try (Connection conn = cu.getConnection()){

            String sql = "update duelists set available = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, avail);
            ps.setInt(2, d.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
