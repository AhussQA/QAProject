"use strict";
function sendSearch(){
    var searchBar = document.getElementById("search_bar");
    var searchString = searchBar.value;
    var request = new XMLHttpRequest();
        console.log(searchString); 


    request.open('GET',"http://localhost:8080/TestingApp/example/rest/search?srstring="+searchString);
    request.responseType='json';
    request.send();
    request.onload = function(){
    var reply = request.response;
    }
  
    
}

//function createUser(){
//    var name = document.getElementById("firstname").value;
//    var username = document.getElementById("username").value;
//    var password = document.getElementById("password").value;
//    
//    var email = document.getElementById("email").value;
//    var doornumber = document.getElementById("doornumber").value;
//    var street = document.getElementById("street").value;
//    var postcode = document.getElementById("postcode").value;
//
//
//    var postRequest = new XMLHttpRequest();
//    postRequest.open("POST","http://localhost:8080/TestingApp/example/rest/createUser",false);
//    postRequest.setRequestHeader('Content-Type','application/json');
//    var data = JSON.stringify({"personID":1,"doorNumber":doornumber,"userName":username,"password":password,"firstName":name,"lastName":"a","postcode":postcode});
//    postRequest.send(data);
//}