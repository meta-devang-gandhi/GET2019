package virtualCommandPrompt;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Represent the directory structure.
 */
public class Directory 
{
   private Date time;
   private String name, path;
   private List<Directory> subFolderList = new LinkedList<Directory>();
   private Directory parentOfDirectory;
   
   public Directory(String directoryName, Date creationTime, Directory parentDirectory, String path )
   {
	   this.time = creationTime;
	   this.name = directoryName;
	   this.parentOfDirectory = parentDirectory;
	   this.path = path;
   }
	
   //Return the directory creation time.
	public Date getCreationTime() 
	{
		return time;
	}

	//Return the directory name.
	public String getDirectoryName()
	{
		return name;
	}

	//Return the sub folder list of current directory.
	public List<Directory> getSubFolderList()
	{
		return subFolderList;
	}
	
	//Add the sub folder.
	public void addSubfolder(Directory subfolder) 
	{
		subFolderList.add(subfolder);
	}
	
    //Return the parent directory.
	public Directory getParentOfDirectory() 
	{
		return parentOfDirectory;
	}
	
	//Return the path of directory.
	public String getDirectoryPath()
	{
		return path;
	}
}
