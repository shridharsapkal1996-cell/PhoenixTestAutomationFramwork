package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DatabaseManager;
import com.database.model.CustomerAddressDBModel;

public class CustomerAddressDao {

    private static final String CUSTOMER_ADDRESS_QUERY = """
            SELECT id,
                   flat_number,
                   apartment_number,
                   street_number,
                   landmark,
                   area,
                   pincode,
                   country,
                   state
            FROM tr_customer_address
            WHERE id = ?
            """;

    private CustomerAddressDao() {
    }

    public static CustomerAddressDBModel getCustomerAddressData(int customerAddressId) {

        CustomerAddressDBModel customerAddressDBModel = null;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(CUSTOMER_ADDRESS_QUERY)) {

            ps.setInt(1, customerAddressId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    customerAddressDBModel = new CustomerAddressDBModel(
                            rs.getInt("id"),
                            rs.getString("flat_number"),
                            rs.getString("apartment_number"),
                            rs.getString("street_number"),
                            rs.getString("landmark"),
                            rs.getString("area"),
                            rs.getString("pincode"),
                            rs.getString("country"),
                            rs.getString("state")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerAddressDBModel;
    }
}