function onSubmit(){
    
}

$(document).ready(function () {
    let id;
    

    $("#uploadItem").submit(function (event) {

        event.preventDefault();
        
        var dataToSend = (this);
        dataToSend[5].value = sessionStorage.getItem("userid");
        console.log(dataToSend);
        $.post("example/rest/uploadItem", $(dataToSend).serialize(), function (data, status) {
            id = JSON.parse(data);
            console.log("hello");
            if (id.status == "fail") {
                $("#loginResponse").html("Email or Password Incorrect");
            } else {

                
                


            }
        });
    });
});