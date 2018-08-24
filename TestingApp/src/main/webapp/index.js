
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