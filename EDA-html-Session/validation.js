/*
  It have method to validate html form.
*/

//Method to validate name.
function fullNameValidation(){
   var name = document.getElementById("name").value;
   var pattern = /^[A-Za-z]+$/;
  
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

//Methdo to submit register form of employee.
function submitData(){
    fullNameValidation();
    emailValidation();
    passwordValidation();
    confirmPasswordValidation();
    contactValidation();
    var empId = 'E19/1206';

   document.getElementById("employeeRegistration").innerHTML = "Congrats!! You are successfully registered. Your registration ID is" + " "+ empId;
    document.getElementById("empId").value = empId;

}

//Methdo to add vehicle of employee.
function registerVehicle(){
    console.log("vehicle");
    document.getElementById("addVehicle").innerHTML = "Your Vehicle has been added!!"
}

//Method to show the parking price sheet.
function showPrice(){
    value = document.getElementById("type").value;
    document.getElementById("tableForPass").style.display = 'block';
    console.log(value);
     if(value == "cycle"){
         document.getElementById("dailyPrice").innerHTML = "5";
         document.getElementById("monthlyPrice").innerHTML = "100";
         document.getElementById("yearlyPrice").innerHTML = "500";
     }
     if(value == "motorCycle"){
        document.getElementById("dailyPrice").innerHTML = "10";
        document.getElementById("monthlyPrice").innerHTML = "200";
        document.getElementById("yearlyPrice").innerHTML = "1000";
    }

    if(value == "fourWheelers"){
        document.getElementById("dailyPrice").innerHTML = "20";
        document.getElementById("monthlyPrice").innerHTML = "500";
        document.getElementById("yearlyPrice").innerHTML = "3500";
    }
}

var passSelect;
function getPassOption(value){
     passSelect = value;
}

//Method to generate pass of vehicle. 
function getPass(){
     if(passSelect == "daily"){
        console.log("1");
          document.getElementById("tableForPass").innerHTML = "Your pass price is " + document.getElementById("dailyPrice").innerHTML;
     }
    else if(passSelect == "monthly"){
        console.log("2");
        document.getElementById("tableForPass").innerHTML = "Your pass price is " + document.getElementById("monthlyPrice").innerHTML;
     }
     else if(passSelect == "yearly"){
          console.log("3");
         document.getElementById("tableForPass").innerHTML = "Your pass price is " + document.getElementById("yearlyPrice").innerHTML;
     }
}
