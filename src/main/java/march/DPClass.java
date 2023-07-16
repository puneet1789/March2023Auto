package march;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import march.utils.LoadExternalDataUtility;

public class DPClass {
//
//	
//	 @DataProvider
//	  public Object[][] dp() {
//	    return new Object[][] {
//	       { 1, "a" },
//	       { 2, "b" },
//	       { 3, "c" }
//	    };
//	  }
//	
//	 @DataProvider(name = "data2")
//	  public Object[][] dp2() {
//	    return new Object[][] {
//	       { 1, "a", "Row1" },
//	       { 2, "b", "Row2" },
//	       { 3, "c", "Row3" }
//	    };
//	  }
//	 @DataProvider(name = "data3")
//	  public Object[][] dp3() {
//	    return new Object[][] {
//	       { 1, "a", "Row1" , "col4"},
//	       { 2, "b", "Row2" , "col4" },
//	       { 3, "c", "Row3" , "col4" }
//	    };
//	  }
//	 
	 @DataProvider(name = "testDataProvider")
	  public Object[][] testDataProvider(Method m) {
		 Object[][] testData = null;
		if (m.getName().equals("test1")) {
		 testData = new Object[][] {
				       { 1, "a" },
				       { 2, "b" },
				       { 3, "c" }
				    };
		} else if (m.getName().equals("test2")) {
			testData = new Object[][] {
					{ 1, "a", "Row1" },
			       { 2, "b", "Row2" },
			       { 3, "c", "Row3" }
			    };
		} else if (m.getName().equals("test3")) {
			testData =  new Object[][] {
			       { 1, "a", "Row1" , "col4"},
			       { 2, "b", "Row2" , "col4" },
			       { 3, "c", "Row3" , "col4" }
			    };
		}
		 return testData;
	 }
	 
	 
	 /// Apache POI ---- dependency/Lib/Jar
	 
	 @DataProvider(name = "externalData")
	  public Object[][] externalTestDataProvider(Method m) {
		 Object[][] testData = new Object[5][2];
		 Map<String, List<List<String>>> testDataComplete = new HashMap<String, List<List<String>>>();
		 String path = "C:\\Users\\Hp\\OneDrive\\Desktop\\DemoExceFileForTestData.xlsx";
		 
		 try {
			 LoadExternalDataUtility lec = new LoadExternalDataUtility(path);
			 testDataComplete = lec.testData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<List<String>> sheetData = testDataComplete.get("Login");
		 for (int i = 0; i < 5; i++) {
			 for (int j = 0; j< 2; j++) {
				 testData[i][j] =  sheetData.get(i).get(j);
			 }
		 }
		 
		 
		 return testData;
	 }
	 
	 
}
