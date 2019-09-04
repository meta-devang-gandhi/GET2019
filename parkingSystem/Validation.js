/**
  It have method to validate html form.
*/

//Method to validate name.
function fullNameValidation(){
   var name = document.getElementById("name").value;
   var pattern = /^[A-Za-z A-Za-z]+$/;
  
   if(pattern.test(name) == false  ){
       alert( " name does not allow special charater or number.");
       document.getElementById("name").value = "";
    }
    if(name.length < 2){
        alert("Name should be contain 2 charater ");
        document.getElementById("name").value = "";
    }
}

//Method to validate email.
function emailValidation(){
   var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
   var email  = document.getElementById("email").value;

   if(pattern.test(email) == false){
       alert("Please enter valid email address.");
       document.getElementById("email").value = "";
   }
}

//Method to validate password.
function passwordValidation(){
    var pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    var password = document.getElementById("password").value;

    if(pattern.test(password) == false){
        alert("Password should have contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8" );
        document.getElementById("passowrd").value = "";
    }
}

//Method to validate confirm pass word.
function confirmPasswordValidation() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    if (password != confirmPassword) {
        alert("Confirm password do not match!");
        document.getElementById("confirmPassword").value = "";
    }
}

//Method to validate contact .
function contactValidation() {
    var contact = document.getElementById("contact").value;
    if(isNaN(contact) || contact.length != 10) {
        alert("Not a valid number");
        document.getElementById("contact").value = "";
    }
}