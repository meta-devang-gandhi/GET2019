package virtualCommandPrompt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class VirtualCommandPromptTest 
{
	VirtualCommandPrompt command = new VirtualCommandPrompt();
	
	@Before
	public void initialize()
	{
		command.createDirectory("abc1");
		command.createDirectory("abc2");
		command.createDirectory("abc3");
	}
	
	@Test
	public void testmkdir()
	{	
		assertFalse(command.createDirectory("abc1"));
		assertFalse(command.createDirectory("abc2"));
		assertFalse(command.createDirectory("abc3"));
	}
	
	@Test
	public void testcd()
	{
		assertEquals("abc2", command.changeDirectory("abc2").getDirectoryName());
	}
	
	@Test
	public void testbk()
	{
		assertEquals("R", command.backToParentDirectory().getDirectoryName());
	}
	
	@Test
	public void testFind()
	{
		List<Directory> expected = command.find("abc3");
		for(Directory directory : expected)
		{
			assertEquals("R:/", directory.getDirectoryPath());
		}
	}
}