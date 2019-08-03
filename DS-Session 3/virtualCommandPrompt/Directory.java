package virtualCommandPrompt;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Directory 
{
   private Date time;
   private String name;
   private List<Directory> subFolderList = new LinkedList<Directory>();
   private Directory parentOfDirectory;
   
   public Directory(String directoryName, Date creationTime, Directory parentDirectory )
   {
	   this.time = creationTime;
	   this.name = directoryName;
	   this.parentOfDirectory = parentDirectory;
   }
	
	public Date getCreationTime() 
	{
		return time;
	}

	public String getDirectoryName()
	{
		return name;
	}

	public List<Directory> getSubFolderList() {
		return subFolderList;
	}
	
	public void addSubfolder(Directory subfolder) {
		subFolderList.add(subfolder);
	}
	

	public Directory getParentOfDirectory() {
		return parentOfDirectory;
	}
}
