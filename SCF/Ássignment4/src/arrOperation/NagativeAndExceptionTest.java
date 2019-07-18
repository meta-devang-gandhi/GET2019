package arrOperation;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Test;
import org.junit.Before;

public class NagativeAndExceptionTest
{
	 private ArrOperation arrOperation;	 
	 @Before
	 public void initialize() 
	 {
		 arrOperation = new ArrOperation();
	 }
	 
	 @Test(expected = AssertionError.class)
	 public void maxMirrorAE() 
	 {
		arrOperation.findMaxMirror(new int[]{});
		arrOperation.findMaxMirror(new int[]{-1,2,24,});
	 }
	   
	 @Test(expected = AssertionError.class)
	 public void countClumpsAE()
	 { 
		arrOperation.countClumps(new int[]{});
		arrOperation.countClumps(new int[]{-1,2,24,});
	 }
	   
	 @Test(expected = AssertionError.class)
	 public void fixXYAE()
	 { 
		arrOperation.fixXY(new int[]{}, 0 , 0);
		arrOperation.fixXY(new int[]{-1, 2,3,4,5,2,4}, 2,4);
		arrOperation.fixXY(new int[]{1,2,3,4,5,2,4}, 2,3);
		arrOperation.fixXY(new int[]{1,2,3,4,5}, 6,7);
		arrOperation.fixXY(new int[]{1,2,1,2}, 2,1);
	 }
	   
	 @Test(expected = AssertionError.class)
	 public void splitArrayAE()
	 { 
		 arrOperation.findSplitIndex(new int[]{});
		 arrOperation.countClumps(new int[]{-1,2,24,});
	 }
}