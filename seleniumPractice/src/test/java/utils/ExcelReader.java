package utils;

import builders.LoginDetailsBuilder;
import builders.SignUpDetailsBuilder;
import entities.LoginDetails;
import entities.SignUpDetails;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;


/**
 * Created by manjunatha-lap on 12/02/2017.
 */
public class ExcelReader
{
    Workbook workbook;
    Sheet loginDetailsSheet;
    Sheet signUpDetailsSheet;

    public ExcelReader(String testData)
    {
//        File src = new File(testData + ".xlsx");
//
//        FileInputStream fis= null;
//        try {
//            fis = new FileInputStream(src);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            XSSFWorkbook wb=new XSSFWorkbook(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String excelFilePath = testData + ".xlsx";
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(excelFilePath);

        try {
            workbook = WorkbookFactory.create(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


        loginDetailsSheet = workbook.getSheet("loginDetails");
        signUpDetailsSheet = workbook.getSheet("signUpDetails");
    }

    private int getCellNumberWithHeader(Sheet sheet, String header) {

        int NumberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int cellNumber = 0; cellNumber < NumberOfCells; cellNumber++) {
            if (sheet.getRow(0).getCell(cellNumber).toString().equalsIgnoreCase(header))
                return cellNumber;
        }

        throw new RuntimeException("No cell found for header: " + header);
    }

    private Row readDataRow(Sheet fromSheet, String dataId) {
        Iterator<Row> rowIterator = fromSheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getCell(0).getStringCellValue().equalsIgnoreCase(dataId))
                return row;
        }
        throw new RuntimeException("No data found with this identifier: " + dataId);
    }

    private Cell getCellData(Sheet fromSheet, Row dataRow, String header) {
        return dataRow.getCell(getCellNumberWithHeader(fromSheet, header), Row.CREATE_NULL_AS_BLANK);
    }

    public SignUpDetails getSignUpDetails(String signUpDetailsID) {
        Row rowData = readDataRow(signUpDetailsSheet, signUpDetailsID);
        Cell cellData = getCellData(signUpDetailsSheet, rowData, "firstName");
        cellData.setCellType(Cell.CELL_TYPE_STRING);
        String FirstName = cellData.getStringCellValue();
        String LastName = getCellData(signUpDetailsSheet, rowData, "lastName").getStringCellValue();
        String EmailID = getCellData(signUpDetailsSheet, rowData, "emailID").getStringCellValue();
        String Password = getCellData(signUpDetailsSheet, rowData, "password").getStringCellValue();
        String ConfirmPassword = getCellData(signUpDetailsSheet, rowData, "confirmPassword").getStringCellValue();

        return new SignUpDetailsBuilder()
                .withFirstName(FirstName).withLastName(LastName).withEmail(EmailID)
                .withPassword(Password).withConfirmPassword(ConfirmPassword).build();
    }

    public LoginDetails getLoginDetails(String loginDetailsID)
    {
        Row rowData = readDataRow(loginDetailsSheet, loginDetailsID);
        Cell cellData = getCellData(loginDetailsSheet, rowData, "emailID");
        cellData.setCellType(Cell.CELL_TYPE_STRING);
        String LoginID = cellData.getStringCellValue();
        String Password = getCellData(loginDetailsSheet, rowData, "password").getStringCellValue();

        return new LoginDetailsBuilder().withLoginID(LoginID).withPassword(Password).build();
    }
}