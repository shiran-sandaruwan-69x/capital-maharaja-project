

$('#btncreate').click(()=>{
  if (checkvalidationCustomer()){


      if (checkvalidationCustomer()){
          let name = $('#inputName').val();
          let contact = $('#inputContactNo').val();
          let email = $('#inputEmail').val();
          let address = $('#inputAddress').val();
          let type = $('#carstype').find(":selected").text();
          let nic = $('#inputNIC').val();
          let emNumber = $('#employeeNo').val();
          let userName = $('#inputUserName').val();
          let password = $('#inputPassword').val();

          $.ajax({
              method: "POST",
              url: "http://localhost:8080/api/v1/addUser",
              data:JSON.stringify({
                  "userName":userName,
                  "name":name,
                  "address":address,
                  "email": email,
                  "mobile": contact,
                  "password":password,
                  "type":type,
                  "nic":nic,
                  "emNumber":emNumber


              }),
              dataType:'Json',
              contentType: "application/json; charset=utf-8",
              success: function (res) {
                  if(res.message=='Success'){
                      alert('Registration Successful');
                  }
              },
              error: function (ob, textStatus, error) {
                  console.log("error from : " + ob + " " + textStatus + " " + error);
                  if(res.message!='Success'){
                      alert('Registration UnSuccessful! Try again');
                  }
              }
          });
      }

  }


});

function checkLogin(){
    let userName = $('#email1').val();
    let password = $('#password1').val();
    if (userName!=""){
        if (password!=""){
            return true;
        }else {
            alert("enter user password");
            return false;
        }
    }else {
        alert("enter user name");
        return false;
    }
}



$('#submit1').click(function () {

    if (checkLogin()){
        let userName = $('#email1').val();
        let password = $('#password1').val();
        console.log(userName,password);
        if (userName == ""){
            alert('Enter User Name..!');
        }else if(password == ""){
            alert('Enter Password..!');
        }else{
            $.ajax({
                method: "GET",
                url: 'http://localhost:8080/api/v1/'+userName+'/'+password,
                success:function (res) {
                    if(res.message == 'user'){
                        // document.cookie = "user="+res.data.name;
                        // document.cookie = "userID="+res.data.customerID;
                        window.location.replace("UserForm.html");
                    }else if(res.message == 'admin'){
                        // document.cookie = "user="+res.data.name;
                        // document.cookie = "userID="+res.data.DriverID;
                        // localStorage.setItem('loggedUser', res);
                        window.location.replace("AdminForm.html");
                    }
                },
                error:function (ob, textStatus, error) {
                    console.log("error from : " + error);
                    alert('please input your correct details ..!');
                }
            });
    }


    }

});

function checkvalidationCustomer() {

    let name = $('#inputName').val();
    let contact = $('#inputContactNo').val();
    let email = $('#inputEmail').val();
    let address = $('#inputAddress').val();
    let userName = $('#inputUserName').val();
    let password = $('#inputPassword').val();

    if (name!=""){
        if (contact!=""){
            if(email!=""){
                if (address!=""){
                            if (userName!=""){
                                if (password){
                                    return true;
                                }else{
                                    alert("Please Enter Password");
                                    return false;
                                }
                            }else{
                                alert("Please Enter Username");
                                return false;
                            }


                }else{
                    alert("Please Enter Address");
                    return false;
                }
            }else{
                alert("Please Enter Email Address");
                return false;
            }
        }else {
            alert("Please Enter Contact");
            return false;
        }
    }else{
        alert("Please Enter Name");
        return false;
    }

}

//---------------------------------------
hideOrHidden();
function hideOrHidden() {
  $('#hideOr').hide();
}

$('#carstype').click(function () {
    choseType();
})

function choseType() {
    let tp = $('#carstype').find(":selected").text();
    if(tp=='admin'){
        $('#hideOr').show();
    }else{
        $('#hideOr').hide();
    }
}
