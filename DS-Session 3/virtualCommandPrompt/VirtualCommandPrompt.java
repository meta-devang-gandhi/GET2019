package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Represent the virtual command prompt.
 */
public class VirtualCommandPrompt 
{
   private Directory rootDirectory;
   private Directory currentDirectory;
   private Directory foundDirectory;
   private List<Directory> directorylist = new ArrayList<Directory>();
   int horizontalSpace=0;
   String path = "R:\\";
   
    public VirtualCommandPrompt() 
    {
	    rootDirectory =  new Directory("R", new Date(), null, path);
	    currentDirectory = rootDirectory; 
	}
    
    /**
     * Create a new directory.
     * For mkdir command.
     * @param directoryName
     */
    public boolean createDirectory(String directoryName)
    {
    	try
    	{
	    	if(directoryName == null)
	    	{
	    		System.out.println("invalid Syntex");
	    	}
	    	else if(isDirectoryPresent(directoryName, currentDirectory))
	    	{
	    		System.out.println("Directory already exits");
	    		return false;
	    	}
	    	else
	    	{
	    		Directory newDirectory = new Directory(directoryName, new Date(), currentDirectory, path);
	    		currentDirectory.addSubfolder(newDirectory);
	    		System.out.println("Directory Sussesfully created");
	    		return true;
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return false;
    }
    
    /**
     * Change the current directory.
     * For cd command. 
     * @param directoryName
     */
    public Directory changeDirectory(String directoryName)
    {
    	try
    	{
	    	if(directoryName == null)
	    	{
	    		System.out.println("Invalid Systex");
	    	}
	    	else if(isDirectoryPresent(directoryName, currentDirectory))
	    	{ 
	    		currentDirectory = foundDirectory;
	    		addPath();
	    		System.out.println("Now you are on this directory : "+currentDirectory.getDirectoryName());
	    		return currentDirectory;
	    	}
	    	else
	    	{
	    		System.out.println("Directory not found.");
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return currentDirectory;
    }
    
    /**
     * Move to parent directory of current directory.
     */
    public Directory backToParentDirectory()
    {
    	try
    	{
	    	if(currentDirectory == rootDirectory)
	    	{
	    		System.out.println("Now you are on root directory");
	    	}
	    	else
	    	{
	    		currentDirectory = currentDirectory.getParentOfDirectory();
	    		removePath();
	    		return currentDirectory;	
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return currentDirectory;
    } 
    
    /**
     * Show the all sub folder name and creation time of current directory.
     */
     public void listOfAllDirectory()
     {
    	 try
    	 {
	    	 List<Directory> subFolders = currentDirectory.getSubFolderList();
	    	 if(subFolders.size() == 0)
	    	 {
	    		 System.out.println("don't found any folder on current directory");
	    	 }
	    	 else
	    	 {
	    		 for(Directory directory : subFolders)
	    		 {
	    			 System.out.println(directory.getDirectoryName() +" "+directory.getCreationTime());
	    		 }
	    		 
	    		 System.out.println("Total Folder :" + subFolders.size());
	    	 }
    	 }
    	 catch(Exception e)
     	{
     		System.out.println(e);
     	}
     }
     
     /**
      * Check the directory name from the current directory
      * @param directoryToBeCheck
      * @return
      */
     public List<Directory> find(String directoryToBeCheck) 
     {	 
    	try
    	{
	 		if(directoryToBeCheck==null) 
	 		{
	 			System.out.println("Incorrect syntax for find !");
	 			return null;
	 		}
	 		
	 		updateListOfDirectoriesFound(directoryToBeCheck,currentDirectory);
	 		try
	 		{
	 			if(directorylist.size() == 0)
	 			{
	 				throw new Exception("Directory not found");
	 			}
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 		}
	 		
	 		return directorylist;
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
		return directorylist;	
 	}  
     
 	/**
 	 * Method print the tree structure of the root directory.
 	 */
     public void getTree()
     {
    	 Directory directory = rootDirectory;
 		if(directory.getSubFolderList().size()==0) 
 		{
 			System.out.println("No tree structure is there !");
 			return;
 		} 
 		else 
 		{
 			printDirectoryTree(directory,"\u2514","\u2502");
 		}
 	}

     /**
      * Method print the directory name and unicode.
      * @param directory
      * @param hiphen Unicode
      * @param slash  Unicode
      */
 	private void printDirectoryTree(Directory directory,String hiphen, String slash) 
 	{
 		try
 		{
	 		System.out.print(slash);
	 		for(int i=0; i<horizontalSpace;i++) 
	 		{
	 			System.out.print("  ");
	 		}
	 		
	 		horizontalSpace += directory.getSubFolderList().size();
	 		
	 		if(directory.getSubFolderList().size()==0) 
	 		{
	 			horizontalSpace=0;
	 			return;
	 		} 
	 		else 
	 		{
	 			for(Directory val : directory.getSubFolderList()) 
	 			{
	 				System.out.println(slash+hiphen+val.getDirectoryName());	
	 				printDirectoryTree(val,"\u2502","\u2500");
	 			}
	 		}
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
 	}
    
 	/**
     * Find the directory inside directory.
     * @param directoryName
     * @param directory
     */
	private void updateListOfDirectoriesFound(String directoryName,Directory directory) 
	{
		try
		{
	 		if(directoryName == directory.getDirectoryName()) 
	 		{
	 			directorylist.add(directory);
	 		} 
	 		else 
	 		{
	 			for (Directory directoryObj : directory.getSubFolderList()) 
	 			{
	 				updateListOfDirectoriesFound(directoryName, directoryObj);
	 			}
	 		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 	
    /**
     * Check the directory name is present on current directory or not.
     * @param directoryName
     * @param currentDirectory
     * @return true if directory name is not same else false.
     */
    private boolean isDirectoryPresent(String directoryName, Directory currentDirectory)
    {
    	try
    	{
	         for(Directory directory : currentDirectory.getSubFolderList())
	         {
	        	 if(directoryName == directory.getDirectoryName())
	        	 {
	        		 foundDirectory = directory;
	        		 return true;
	        	 }
	         }
	        	 
	    	return false;
    	}
    	catch(Exception e)
 		{
 			System.out.println(e);
 		}
    	
    	return false;
    } 
    
    //Method to add path when we change directory.
    private void addPath()
    {
    	path += currentDirectory.getDirectoryName() + "\\";
    	System.out.println(path.length());
    }
    
    //Method to remove current path when we move out to parent directory.
    private void removePath()
    {
    	int length = path.length(), index = length - 2;
    	while(path.charAt(index) != '\\')
    	{
    		index--;
    	}
    	
    	path = path.substring(0, index);	
    }
}