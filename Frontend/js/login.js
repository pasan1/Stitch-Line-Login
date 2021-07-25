const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

const USER_PATH = URL_PATH + "user/";

sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});

$(document).ready(function () {
    $('#infAddress').hide();
    $('#infNIC').hide();
    $('#infEmpNo').hide();

    let obj = $.session.get("obj");
    console.log("obj " + obj);

    if (obj!=null){
        document.location.href="../index.html";
    }

    $('#frmLogin').validate({
        rules: {
            Username: {
                required: true,
                minlength: 3
            },
            Password: {
                required: true,
                minlength: 3
            }
        }
    });

    $('#frmSignUp').validate({
        rules: {
            UserName: {
                required: true,
                email: true
            },
            Password: {
                required: true,
                minlength: 3
            },
            FullName: {
                required: true,
                minlength: 3
            },
            Email: {
                required: true,
                email: true
            },
            MobileNumber: {
                required: true,
                minlength: 9,
                maxlength: 10
            }
        }
    });
})

$('#cmbSignUpRole').change(function () {
    if ($('#cmbSignUpRole').val()==="admin"){
        $('#infNIC').show();
        $('#infEmpNo').show();
        $('#infAddress').hide();
    }
    if ($('#cmbSignUpRole').val()==="customer"){
        $('#infAddress').show();
        $('#infNIC').hide();
        $('#infEmpNo').hide();
    }
})
