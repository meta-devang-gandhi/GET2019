package virtualCommandPrompt;

import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		VirtualCommandPrompt obj = new VirtualCommandPrompt();
		obj.createDirectory("1");
		obj.createDirectory("2");
		obj.createDirectory("3");
		obj.changeDirectory("2");
		
		obj.createDirectory("4");
		obj.createDirectory("5");
		obj.changeDirectory("5");
		obj.createDirectory("6");
		obj.createDirectory("7");
		obj.backToParentDirectory();
		obj.listOfAllDirectory();
		obj.getTree();
		List<Directory> abc= obj.find("7");
		System.out.println("----");
		for(Directory abc1 : abc)
		{
			System.out.println(abc1.getDirectoryName() +"---"+abc1.getCreationTime() +"---"+ abc1.getDirectoryPath());
		}		
	}

}
