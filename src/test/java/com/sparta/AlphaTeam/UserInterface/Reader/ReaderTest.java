package com.sparta.AlphaTeam.UserInterface.Reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import com.sparta.AlphaTeam.DataManagement.Employee;
import com.sparta.AlphaTeam.DataManagement.Database.EmployeeDAO;

class ReaderTest {

    File tempFile_1, tempFile_2;

    @Test
    void FileFetchedProperly() throws IOException {

        File file = new File("test.txt");

        FileWriter writer = new FileWriter(file);
        writer.append("abcd\n");
        writer.append("abcd\n");
        writer.append("abcd\n");
        writer.append("abcd\n");
        writer.close();

        List<String> employeeStringList = new ArrayList<>();

        employeeStringList = Reader.readFile(file.getAbsolutePath());

        System.out.println(employeeStringList.size() + ": size");

        assertTrue(employeeStringList.size() != 0);
        file.delete();

    }

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    /* executed before every test: create temporary files */
    @Before
    public void setUpTest() {
        try {
            tempFile_1 = tempFolder.newFile("file1_unit_test.txt");
            tempFile_2 = tempFolder.newFile("file2_unit_test.txt");
        } catch (IOException ioe) {
            System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
        }
    }

    @Test
    public void writeDataToTempfiles() {

        // write out data to the test files
        try {
            FileWriter unitFileTemp_fileWriter_1 = new FileWriter(tempFile_1);
            BufferedWriter unitFileTemp_bufferedWriter_1 = new BufferedWriter(unitFileTemp_fileWriter_1);
            unitFileTemp_bufferedWriter_1.write("content for file1");
            unitFileTemp_bufferedWriter_1.close();

            FileWriter unitFileTemp_fileWriter_2 = new FileWriter(tempFile_2);
            BufferedWriter unitFileTemp_bufferedWriter_2 = new BufferedWriter(unitFileTemp_fileWriter_2);
            unitFileTemp_bufferedWriter_2.write("content for file2");
            unitFileTemp_bufferedWriter_2.close();
        } catch (IOException ioe) {
            System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
        }

        assertTrue(tempFile_1.exists());
        assertTrue(tempFile_2.isFile());

        assertEquals(tempFile_1.length(), 17L);
        assertEquals(tempFile_1.length(), tempFile_2.length());

        assertTrue(tempFile_1.getAbsolutePath().endsWith("file1_unit_test.txt"));
    }

    File f = new File("newFile.txt");
    List<String> strList = null;

    @Test
    void addtoTheListTest() throws IOException {

        strList.add("newString");
        strList.add("newString2\n");
        strList.add("newString3\n");

        BufferedWriter bfwriter = new BufferedWriter(new FileWriter(f));
        bfwriter.append((CharSequence) strList);
        bfwriter.close();

    }

    @Test
    void getFromTheListTest() {

        Reader read = new Reader();
        List<String> tempList = read.readFile(f.getAbsolutePath());

        assertTrue(tempList.size() > 0);

    }

}