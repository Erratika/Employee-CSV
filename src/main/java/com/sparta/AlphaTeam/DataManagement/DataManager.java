package com.sparta.AlphaTeam.DataManagement;

import com.sparta.AlphaTeam.DataManagement.Database.DAO;
import com.sparta.AlphaTeam.DataManagement.Database.DatabaseInit;
import com.sparta.AlphaTeam.DataManagement.Database.EmployeeDAO;
import com.sparta.AlphaTeam.core.Timer;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private File chosenFile;
    private int threadCount;
    private List <String> dataString=new ArrayList<>();
    private List <Employee> unsortedRecords=new ArrayList<>();
    private List <Employee> cleanRecords=new ArrayList<>();
    private List <Employee> allDirtyRecords=new ArrayList<>();
    private List <Employee> missingValueRecords=new ArrayList<>();
    private List <Employee> invalidDateRecords=new ArrayList<>();
    private List <Employee> duplicatedRecords=new ArrayList<>();
    private List<Employee> fetchedRecords= new ArrayList<>();
    private Thread[] threads;
    private long timeTaken;

    public DataManager() {
    }

    public void setupDatabase(){
        DatabaseInit.makeTable();
    }
    public void createThreads(){
        CustomThreadFactory customThreadFactory=new CustomThreadFactory();
      //  threads[] = customThreadFactory.customThreadFactory(threadCount,cleanRecords);
    }
    public void addToDatabase(){
        setupDatabase();
        Timer timer = new Timer();
        timer.start();
        for (Thread t : threads){
            t.start();
        }
        for (Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        timeTaken=timer.stop();
    }
    public void getEmployeeFromDatabase(){
        DAO dataAccess = new EmployeeDAO();
        fetchedRecords=dataAccess.getAll();
    }
    // --------------------- testing adding to database
    public void addAllToDatabase(){
        DAO dataAccess = new EmployeeDAO();
        DatabaseInit.makeTable();
        for (Employee e : cleanRecords){
            dataAccess.add(e);
        }

    }



    public void sortUnsortedRecords(){
        DataFilter dataFilter= new DataFilter();
        boolean isDirty = false;
        for (Employee e : unsortedRecords) {
            isDirty = false;

            try {if (dataFilter.filterInvalidData(e)){
                invalidDateRecords.add(e);
                isDirty=true;}
            } catch (ParseException ex) {
                ex.printStackTrace();}

            if (dataFilter.filterMissing(e)){
                missingValueRecords.add(e);
                isDirty=true;
            }

            if (dataFilter.filterDuplictes(e,cleanRecords)){
                duplicatedRecords.add(e);
                isDirty=true;
            }

            if (isDirty){
                allDirtyRecords.add(e);
            }
            else {
                cleanRecords.add(e);
            }
        }
    }

    public void convertStringListToEmployee(List<String> inputList){
        try {
            unsortedRecords=EmployeeConverter.convertStringsToEmployees(inputList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //---------------------GETTERS AND SETTERS------------------
    public List<Employee> getFetchedRecords() {
        return fetchedRecords;
    }

    public void setFetchedRecords(List<Employee> fetchedRecords) {
        this.fetchedRecords = fetchedRecords;
    }
    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }
    public File getChosenFile() {
        return chosenFile;
    }

    public void setChosenFile(String filePath) {
        this.chosenFile = new File(filePath);
    }

    public List<String> getDataString() {
        return dataString;
    }

    public void setDataString(List<String> dataString) {
        this.dataString = dataString;
    }
    public List<Employee> getAllDirtyRecords() {
        return allDirtyRecords;
    }

    public List<Employee> getCleanRecords() {
        return cleanRecords;
    }
    public List<Employee> getMissingValueRecords(){
        return missingValueRecords;
    }

    public List<Employee> getDuplicatedRecords() {
        return duplicatedRecords;
    }

    public List<Employee> getInvalidDateRecords() {
        return invalidDateRecords;
    }
    public List<Employee> getUnsortedRecords(){
        return unsortedRecords;
    }

    public void setUnsortedRecords(List<Employee> unsortedRecords) {
        this.unsortedRecords = unsortedRecords;
    }

    public void setAllDirtyRecords(List<Employee> allDirtyRecords) {
        this.allDirtyRecords = allDirtyRecords;
    }

    public void setCleanRecords(List<Employee> cleanRecords) {
        this.cleanRecords = cleanRecords;
    }

    public void setDuplicatedRecords(List<Employee> duplicatedRecords) {
        this.duplicatedRecords = duplicatedRecords;
    }

    public void setInvalidDateRecords(List<Employee> invalidDateRecords) {
        this.invalidDateRecords = invalidDateRecords;
    }

    public void setMissingValueRecords(List<Employee> missingValueRecords) {
        this.missingValueRecords = missingValueRecords;
    }
}
