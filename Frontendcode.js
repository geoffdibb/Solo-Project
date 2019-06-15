function createkaijuAccount() {

    const account = {
        name: document.getElementById("kaijuNameInput").value,
        height: document.getElementById("heightInput").value,
        weight: document.getElementById("weightInput").value,
        creatureType: document.getElementById("creatureTypeInput").value,
        description: document.getElementById("descriptionInput").value
    };
    return JSON.stringify(account);
}

function updateAccount() {
    const accountupd = {
        name: document.getElementById("kaijuNameInput").value,
        height: document.getElementById("heightInput").value,
        weight: document.getElementById("weightInput").value,
        creatureType: document.getElementById("creatureTypeInput").value,
        description: document.getElementById("descriptionInput").value
    };
    return JSON.stringify(accountupd);
}
function getaccname() {
    let text = document.getElementById("kaijuNameInput").value;
    return text;
}

const clickActions = {
    getKaijubyname: () => buttonClick('GET', 'http://localhost:8080/SoloProject/api/kaijuAccount/getAKaijuAccount/' + getaccname()),
    getAllKaiju: () => buttonClick("GET", "http://localhost:8080/SoloProject/api/kaijuAccount/getAllKaijuAccounts"),

    deleteKaijuAcc: () => buttonClick('DELETE', 'http://localhost:8080/SoloProject/api/kaijuAccount/deleteKaijuAccount/' + getaccname()),
    createKaijuAcc: () => buttonClick('POST', 'http://localhost:8080/SoloProject/api/kaijuAccount//createKaijuAccount', createkaijuAccount()),

    updateKaijuAcc: () => buttonClick("PUT", 'http://localhost:8080/SoloProject/api/kaijuAccount/updateKaijuAccount/' + getaccname(), updateAccount())
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
    if (result.name === undefined) {
        for (let c in result) {
            let output = "account" + JSON.stringify(result[c].name)
            let textnode = document.createTextNode(output);
            let node = document.createElement("div");
            node.setAttribute("id", "resInner");
            document.getElementById("results").appendChild(node);
            node.appendChild(textnode);
        }
    }
    else {
        let node = document.createElement("div");
        node.setAttribute("id", "resInner");
        document.getElementById("results").appendChild(node);

        let output = "account" + JSON.stringify(result.name)
        let textnode = document.createTextNode(output);
        node.appendChild(textnode);
    }
}

function rejected(reason) {
    console.log(reason);
}