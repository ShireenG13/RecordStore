package daointerface;

import model.Records;

import java.util.List;

import model.Records;

import java.util.List;

    public interface RecordDao {
        List<Records> getAllRecords();
        void saveRecord(List<Records> recordsList);
        boolean deleteRecord(int id);
        boolean updateRecord(Records records, int id);


    }



