package dev.campbell.repos;

import dev.campbell.models.Duelist;
import dev.campbell.models.TradeMarket;
import dev.campbell.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TradeRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public ArrayList<TradeMarket> viewAllTrades (){

        ArrayList<TradeMarket> tradeMarket = new ArrayList<>();

        try(Connection conn = cu.getConnection() ) {

            String sql = "select * from trades";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                TradeMarket td = new TradeMarket();

                td.setTradeId(rs.getInt("id"));
                td.setCreatorId(rs.getInt("creator_id"));
                td.setCreatorName(rs.getString("creator_name"));
                td.setRequestedCard(rs.getString("requested_card"));
                td.setOfferId(rs.getInt("offerer_id"));
                td.setOffererName(rs.getString("offerer_name"));
                td.setOfferRequestedCard(rs.getString("offerer_trade"));

                tradeMarket.add(td);
            }

            return tradeMarket;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }

    public boolean createTrade (Duelist d, String cardname){

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into trades values (default, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getId());
            ps.setString(2, d.getFirstName());
            ps.setString(3, cardname);

            boolean complete= ps.executeUpdate() != 0;
            System.out.println("Trade created successfully!");

            return complete;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    public TradeMarket getByTradeID (int id) throws SQLException{

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from trades where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TradeMarket tm = new TradeMarket(
                        rs.getInt("id"),
                        rs.getInt("creator_id"),
                        rs.getString("creator_name"),
                        rs.getString("requested_card"),
                        rs.getInt("offerer_id"),
                        rs.getString("offerer_name"),
                        rs.getString("offerer_trade")
                );
                return tm;
            }

        }


        return null;
    }

    public boolean respondToTrade(Duelist d, TradeMarket tm, String cardname){

        try (Connection conn = cu.getConnection()){

            String sql = "update trades set offerer_id = ?, offerer_name = ?, offerer_trade = ? where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getId());
            ps.setString(2, d.getFirstName());
            ps.setString(3, cardname);
            ps.setInt(4, tm.getTradeId());

            boolean complete= ps.executeUpdate() != 0;
            System.out.println("Offer request made successfully!");

            return complete;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void deleteTrade(TradeMarket tm){

        try (Connection conn = cu.getConnection()){

            String sql = "delete from trades where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tm.getTradeId());

            ps.executeQuery();

            System.out.println("Trade deleted!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}
