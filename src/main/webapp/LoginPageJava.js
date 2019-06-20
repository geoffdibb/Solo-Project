
function getLoginname() {
    let text = document.getElementById("kaijuNameInput").value;
    return text;
}

const clickActions = {
    getLogin: () => buttonClick('GET', 'http://35.228.254.158:8888/SoloProject/api/LoginAccount/getLoginAccount/' + getLoginname()),
 deleteLogin: () => buttonClick('DELETE', 'http://35.228.254.158:8888/SoloProject/api/LoginAccount/deleteLoginAccount/' + getLoginname()),
};
function buttonClick(reqType, url, body) {

    let req = new XMLHttpRequest()
    req.onload = function () {

        promises(req);
    }
    req.open(reqType, url);
    req.send(body);
}
function promises(req) {
    const createPromise = new Promise(
        function (res, rej) {
            if (req.status === 200) {
                let result = JSON.parse(req.responseText);
                res(result);

            } else {
                const reason = new Error("Invalid entry field")
                rej(reason);
            }
        }


    )
    createPromise
        .then((result) => resolved(result))
        .catch(error => rejected(error))

}
function resolved(result) {
    if (result.userName === result.userName) {
   document.location.href = "FrontEnd.html";

    }
    else {


    }

}

function rejected(reason) {
    console.log(reason);
}

function createLogin(){
   document.location.href = "createLogin.html";


}

