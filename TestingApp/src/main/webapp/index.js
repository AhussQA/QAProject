
function sendSearch() {
    var searchBar = document.getElementById("search_bar");
    var searchString = searchBar.value;
    var request = new XMLHttpRequest();
    console.log(searchString);


    request.open('GET', "http://localhost:8080/TestingApp/example/rest/search?srstring=" + searchString);
    request.responseType = 'json';
    request.send();
    request.onload = function () {
        var reply = request.response;
        var ul = document.getElementById("#item-list");
//        var length = reply.length;
//        reply = reply.slice(1,length-1);
//        var itemArray = reply.split(",");
//        for(var i=0; i<itemArray.length;i++){
//        var li = document.createElement("li");
//        var itemName = document.createElement("p");
//        var itemPrice = document.createElement("p");
//            itemName.innerHTML=itemArray[i].name;
//            itemPrice.innerHTML laq=itemArray[i].price;
//            li.append(itemName);
//            li.append(itemPrice);
//            ul.append(li);
//        }
        for(var i = 0; i<reply.length;i++){
            var li = document.createElement("li");
        var itemName = document.createElement("p");
        var itemPrice = document.createElement("p");
            itemName.innerHTML=reply[i].name;
            itemPrice.innerHTML laq=reply[i].price;
            li.append(itemName);
            li.append(itemPrice);
            ul.append(li);
        }
        
    }
}


$(document).ready(function () {
    let id;
    $("#loginForm").submit(function (event) {
        event.preventDefault();
        $.post("example/rest/authenticate", $(this).serialize(), function (data, status) {
            id = JSON.parse(data);
            console.log(id);
            if (id.status == "fail") {
                $("#loginResponse").html("Email or Password Incorrect");
            } else {

                sessionStorage.userid = id.username;
                


            }
        });
    });
});


function onSignIn(googleUser){
    var profile = googleUser.getBasicProfile();
    console.log('ID: '+profile.getId());
}

function onClickSignOut(){
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function (){
        console.log("User Signed Out");
    });
}