package question1;

/**
 *class is hold the response of Mylinkedlist class.
 * @param <Type> 
 */
public class Response<Type>
{
	//type of response
   private Type type = null;
   
   //To store the success of method 
   private boolean success ;
   
   // To hold the error message of method.
   private String errorMessage = null;
   
   // To hold the friendly message for user.
   private String friendlyMessage = null;
  
   // Return the type
   public Type getType() 
   {
	  return type;
   }
   
   // Set the type.
    public void setType(Type type) {
    	this.type = type; 
    }

    // Return error message.
	public String getErrorMessage() {
		return errorMessage;
	}
 
	// Set the error message.
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//Return the success.
	public boolean isSuccess() {
		return success;
	}

	// Set the success.
	public void setSuccess(boolean success) {
		this.success = success;
	}

	// Return the friendly message.
	public String getFriendlyMessage() {
		return friendlyMessage;
	}

	// Set the friendly message.
	public void setFriendlyMessage(String friendlyMessage) {
		this.friendlyMessage = friendlyMessage;
	}
}
