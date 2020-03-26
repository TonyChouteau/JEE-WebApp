
function verifySecondPassword() {
    if (document.getElementById("fpassword1").value != document.getElementById("fpassword2").value) {
        document.getElementById("fpassword2").style["border"] = "1px solid red";
    } else {
        document.getElementById("fpassword2").style["border"] = "0px #00000000";
    }
}