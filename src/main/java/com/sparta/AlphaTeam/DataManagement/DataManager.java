package com.sparta.AlphaTeam.DataManagement;

import java.io.File;
import java.text.ParseException;
import java.util.List;

public class DataManager {


    private File chosenFile;
    private List <String> dataString;
    private List <Employee> unsortedRecords;
    private List <Employee> cleanRecords;
    private List <Employee> allDirtyRecords;
    private List <Employee> missingValueRecords;
    private List <Employee> invalidDateRecords;
    private List <Employee> duplicatedRecords;


    public DataManager() {
    }

    public void setupDatabase(){

    }
    public void convertStringListToEmployee(List<String> inputList){
        try {
            unsortedRecords=EmployeeConverter.convertStringsToEmployees(inputList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void sortData(){
        //filter to populate all missing
        //filter to
    }

    //---------------------GETTERS AND SETTERS------------------
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
