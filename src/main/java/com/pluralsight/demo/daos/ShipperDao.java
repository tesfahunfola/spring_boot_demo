package com.pluralsight.demo.daos;

import com.pluralsight.demo.models.Shipper;
import com.pluralsight.demo.models.Shipper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
@Component
public class ShipperDao {
    private DataSource dataSource;

    public ShipperDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    

    // get all shippers
    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shippers");
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()) {
                int id = resultSet.getInt("ShipperID");
                String name = resultSet.getString("CompanyName");
                String phone = resultSet.getString("Phone");
                Shipper shipper = new Shipper(id, name, phone);
                shippers.add(shipper);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return shippers;
    }
    public List<Shipper> getShipperByName(String name) {
        List<Shipper> shippers = new ArrayList<>();

        String query = "SELECT ShipperID, CompanyName, Phone FROM Shippers WHERE CompanyName LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + name + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ShipperID");
                    String companyName = resultSet.getString("CompanyName");
                    String phone = resultSet.getString("Phone");
                    shippers.add(new Shipper(id, companyName, phone));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return shippers;
    }
}
