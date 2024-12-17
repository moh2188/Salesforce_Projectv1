package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="loginDDT")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\LoginDDT.xlsx"; //getting excel file from testData
		
		Excelutility xlutil=new Excelutility(path); //creating obj for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];// created for two dimensional array to store excel data
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata; //returning two dimentional array
	}
	
	@DataProvider(name="registerData")
	public String [][] getRegisterData() throws IOException
	{
		String path=".\\testData\\Account_RegisterDDT.xlsx"; //getting excel file from testData
		
		Excelutility xlutil=new Excelutility(path); //creating obj for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];// created for two dimensional array to store excel data
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata; //returning two dimentional array
	}
}
