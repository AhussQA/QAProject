
function sendSearch() {
    var searchBar = document.getElementById("search_bar");
    var searchString = searchBar.value;
    var request = new XMLHttpRequest();
    console.log(searchString);


    request.open('GET', "http://localhost:8080/TestingApp/example/rest/search?srstring=" + searchString);
    request.responseType = 'json';
    request.send();
                console.log("hello");

    request.onload = function () {
        var reply = request.response;
        var table = document.getElementById("item-table");
        var tablebody = document.getElementById("table-body");


        for(var i = 0; i<reply.length;i++){
            console.log("hello");
            var tableRow = document.createElement("tr");

            var itemQuantity = document.createElement("td");
            var itemName = document.createElement("td");
            var itemPrice = document.createElement("td");
            let t1 = document.createTextNode(reply[i].name);
            let t2 = document.createTextNode(reply[i].price);
            let t3 = document.createTextNode(reply[i].quantity);
            itemName.appendChild(t1);
            itemPrice.appendChild(t2);
            itemQuantity.appendChild(t3);
            
            tableRow.appendChild(itemName);
            tableRow.appendChild(itemPrice);
            tableRow.appendChild(itemQuantity);
            table.appendChild(tableRow);
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