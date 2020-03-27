
function verify() {
    let ok = true;
    if (document.getElementById("fpassword1").value != document.getElementById("fpassword2").value) {
        document.getElementById("fpassword2").style["border"] = "1px solid red";
        ok = false;
    } else {
        document.getElementById("fpassword2").style["border"] = "0px #00000000";
    }

    if (!document.getElementById("femail").value.includes("@") || !document.getElementById("femail").value.split("@")[1].includes(".")){
        ok = false;
    }

    if (document.getElementById("femail").value === "" || document.getElementById("fusername").value === ""
        || document.getElementById("fbirthday").value === "" || document.getElementById("fpassword1").value === ""
        || !ok) {
            document.getElementById("post-button").setAttribute("disabled","disabled");
    } else {
        document.getElementById("post-button").removeAttribute("disabled");
    }
}