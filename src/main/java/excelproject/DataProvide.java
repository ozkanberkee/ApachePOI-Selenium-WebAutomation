package excelproject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class DataProvide {
	DataFormatter formatter = new DataFormatter();

	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
		FileInputStream fis = null;
		XSSFWorkbook wb = null;
		try {
			fis = new FileInputStream("C:\\wufoo\\wufoo_upload.xlsx");
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			Object data[][] = new Object[rowCount - 1][colCount];

			for (int i = 0; i < rowCount - 1; i++) {
				row = sheet.getRow(i + 1);

				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					data[i][j] = formatter.formatCellValue(cell);
				}
			}

			return data;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		FormTest formTest = new FormTest();
		DataProvide dataProvider = new DataProvide();
		Object[][] testData = dataProvider.getData();
		for (Object[] data : testData) {
			formTest.fillForm(data[0].toString(), data[1].toString(), data[2].toString(), data[3].toString(),
					data[4].toString(), data[5].toString(), data[6].toString(), data[7].toString(), data[8].toString(),
					data[9].toString(), data[10].toString()

			);
		}
		System.exit(1);

	}
}
