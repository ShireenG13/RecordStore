package service;
import daointerface.RecordDao;
import daointerface.impl.RecordDaoImpl;
import model.Records;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordService {
    private final RecordDao recordDao;

    public RecordService() {
        this.recordDao = new RecordDaoImpl();
    }
    public void getAllRecords() {
        List<Records> records = recordDao.getAllRecords();
        System.out.println("All Records");

        for (Records record : records) {
            System.out.println("Catalog Number: " + record.getCatalogNum()+ "Name:"+ record.getRecordName());
        }
    }

    public void save() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Records> recordList = new ArrayList<>();
        System.out.println("Enter the number of records to add: ");
        int numberOfRecords = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRecords; i++) {
            Records record = new Records();
            System.out.println("Enter the catalog number for the record: " + (i+1)+ ":");
            record.setCatalogNum(Integer.parseInt(scanner.nextLine()));
            System.out.println("Enter the record name for the record: " + (i+1)+ ":");
            record.setRecordName(scanner.nextLine());
            recordList.add(record);
        }
        recordDao.saveRecord(recordList);
        System.out.println("Records saved successfully");
    }

}
