package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DatabaseManager;
import com.database.model.JobHeadModel;

public class JobHeadDao {

    private static final String JOB_HEAD_QUERY =
            "SELECT * FROM tr_job_head WHERE tr_customer_id = ?";

    private JobHeadDao() {
    }

    public static JobHeadModel getDataFromJobHead(int trCustomerId) {

        JobHeadModel jobHeadModel = null;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(JOB_HEAD_QUERY)) {

            ps.setInt(1, trCustomerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    jobHeadModel = new JobHeadModel(
                            rs.getInt("id"),
                            rs.getString("job_number"),
                            rs.getInt("tr_customer_id"),
                            rs.getInt("tr_customer_product_id"),
                            rs.getInt("mst_service_location_id"),
                            rs.getInt("mst_platform_id"),
                            rs.getInt("tr_warrenty_status_id"),
                            rs.getInt("mst_oem_id")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobHeadModel;
    }
}