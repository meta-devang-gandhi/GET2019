package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LcmTest {
	 private int inputNumber1;
	 private int inputNumber2;
	 private int expectedResult;
	 private HcfLcm lcmHCF;
	 
	 @Before
	 public void initialize() {
		 lcmHCF = new HcfLcm();
	 }
	 
	 public LcmTest(int inputNumber1, int inputNumber2, Integer expectedResult) {
	      this.inputNumber1 = inputNumber1;
	      this.inputNumber2 = inputNumber2;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { 9,12, 36 },
	         { 10,4, 20 },
	         { 10,0, 0	 },
	         { 34,50, 850 },
	         { 0,2, 0 }
	      });
	   }
	   
	   @Test
	   public void testLCM() {
		   System.out.print(inputNumber1+" and " + inputNumber2);
		   System.out.println();
	       assertEquals(expectedResult, 
	       lcmHCF.lcmOfTwoNo(inputNumber1, inputNumber2));
	   } 
}
