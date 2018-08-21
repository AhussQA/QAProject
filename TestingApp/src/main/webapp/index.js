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

function login(){
    var req = new XMLHttpRequest();
req.open('GET', document.location, false);
req.send(null);
var headers = req.getAllResponseHeaders().toLowerCase();
alert(headers);
//    var usernameField = document.getElementById("username");
//    var passwordField = document.getElementById("password");
//    var username = usernameField.value;
//    var password = passwordField.value;
//
//    var request = new XMLHttpRequest();
//        console.log(username); 
//
//
//    request.open('GET',"http://localhost:8080/TestingApp/example/rest/authenticate?username="+username+"&password="+password);
//    request.responseType='json';
//    request.send();
//    request.onload = function(){
//    var reply = request.response;
//        console.log(reply.username);
//    }
  
    
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