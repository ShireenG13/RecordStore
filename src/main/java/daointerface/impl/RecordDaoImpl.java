package daointerface.impl;

import daointerface.RecordDao;
import model.Records;
import utility.ConnectionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl extends ConnectionDAO implements RecordDao {
    @Override
    public List<Records> getAllRecords() {
        try{
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from records");

            List recordList = new ArrayList();

            while (rs.next()) {
                Records r = new Records();
                r.setCatalogNum(rs.getInt("CatalogNum"));
                r.setRecordName(rs.getString("recordName"));
                recordList.add(r);
            }
            return recordList;

        } catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        }
        return null;
    }

    @Override
    public void saveRecord(List<Records> recordsList) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            for (Records r : recordsList) {
                String sqlQuery = "insert into records(catalogNum, recordName) values (?,?)";
                PreparedStatement prepStmt = connection.prepareStatement(sqlQuery);
                prepStmt.setInt(1, r.getCatalogNum());
                prepStmt.setString(2, r.getRecordName());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteRecord(int id) {
        return false;
    }

    @Override
    public boolean updateRecord(Records records, int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE ");
        }
    }
}
