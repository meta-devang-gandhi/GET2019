package question1;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ExceptionTest
{
	 private HcfLcm hcflcm;	 
	 @Before
	 public void initialize() 
	 {
		 hcflcm = new HcfLcm();
	 }

	 @Test(expected = AssertionError.class)
	 public void splitArrayAE()
	 { 
		 hcflcm.hcfOfTwoNo(-1,0);
	 }
}