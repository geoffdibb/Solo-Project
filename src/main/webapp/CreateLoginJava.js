function createLoginAccount() {

    const account = {
        userName: document.getElementById("kaijuNameInput").value,
        faveKaiju: document.getElementById("heightInput").value,

    };
    return JSON.stringify(account);
}

function updateAccount() {
    const accountupd = {
        userName: document.getElementById("kaijuNameInput").value,
        faveKaiju: document.getElementById("heightInput").value,
    };
    console.log(accountupd);
    return JSON.stringify(accountupd);
}
function getaccname() {
    let text = document.getElementById("kaijuNameInput").value;
    return text;
}

const clickActions = {


    createLogin: () => buttonClick('POST', 'http://35.228.254.158:8888/SoloProject/api/LoginAccount/createLoginAccount', createLoginAccount()),

    updateFaveKaiju: () => buttonClick("PUT", 'http://35.228.254.158:8888/SoloProject/api/LoginAccount/updateLoginAccount/' + getaccname(), updateAccount()),


};
function buttonClick(reqType, url, body) {

    let req = new XMLHttpRequest()
    req.onload = function () {
        const el = document.getElementById("results");
        while (el.firstChild) {
            el.removeChild(el.firstChild);
        }
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

    document.getElementById("results");
    if (result.name === undefined) {
        for (let c in result) {
        }
    }
    else {
        let btn = '<input class="btn btn-success btn btn-primary btn mx-auto font-weight-bold" id="btnfilm" type="button" name="filmbutton" value="filmbutton" onclick="filmDetailButton()">'
        tbody.innerHTML += tr;
    }
}

function rejected(reason) {
    console.log(reason);
}

function backpage(){
document.location.href = "LoginPage.html";


}
