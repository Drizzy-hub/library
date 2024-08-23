// BorrowRecordDAO.java
package com.library.dao;

import com.library.config.DatabaseConfig;
import com.library.models.BorrowRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowRecordDAO {

    public void save(BorrowRecord record) throws SQLException {
        String query = "INSERT INTO borrow_records (user_id, book_id, borrow_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, record.getUserId());
            stmt.setInt(2, record.getBookId());
            stmt.setDate(3, new java.sql.Date(record.getBorrowDate().getTime()));
            stmt.executeUpdate();
        }
    }
}
