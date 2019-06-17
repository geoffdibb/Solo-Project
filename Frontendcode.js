function createkaijuAccount() {

    const account = {
        name: document.getElementById("kaijuNameInput").value,
        height: Number(document.getElementById("heightInput").value),
        weight: Number(document.getElementById("weightInput").value),
        creatureType: document.getElementById("creatureTypeInput").value,
        description: document.getElementById("descriptionInput").value
    };
    console.log(account);
    return JSON.stringify(account);
}

function updateAccount() {
    const accountupd = {
        name: document.getElementById("kaijuNameInput").value,
        height: Number(document.getElementById("heightInput").value),
        weight: Number(document.getElementById("weightInput").value),
        creatureType: document.getElementById("creatureTypeInput").value,
        description: document.getElementById("descriptionInput").value

    };
    console.log(accountupd);
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

    createKaijuAcc: () => buttonClick('POST', 'http://localhost:8080/SoloProject/api/kaijuAccount/createKaijuAccount', createkaijuAccount()),

    updateKaijuAcc: () => buttonClick("PUT", 'http://localhost:8080/SoloProject/api/kaijuAccount/updateKaijuAccount/' + getaccname(), updateAccount()),
    //getFilmbyname: () => buttonClick('GET', 'http://localhost:8080/SoloProject/api/FilmData/getAFilmData/' + getaccname()),

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
    let node = document.createElement("tbody");
    node.setAttribute("id", "tbody");
    document.getElementById("results").appendChild(node);
    let tr = "<tr>";
    if (result.name === undefined) {
        tr += "<td> Codename </td></tr>";


        for (let c in result) {

            let btn = '<input class="btn btn-success btn btn-primary btn-lg mx-auto font-weight-bold" type="button" name="filmbutton" value="filmbutton" onclick="clickActions.getFilmbyname()">'

            tr += "<td>" + result[c].name + "</td> </tr>";

            // let node = document.createElement("div");
            // node.setAttribute("id", "resInner");
            // document.getElementById("results").appendChild(node);
            // node.appendChild(textnode);
        }
        tbody.innerHTML += tr;
    }
    else {
        tr += "<td> Codename </td> <td> Height </td> <td> Weight</td> <td>genus</td> <td>Description </td> <td> more</td></tr>";

        let btn = '<input class="btn btn-success btn btn-primary btn-lg mx-auto font-weight-bold" id="btnfilm" type="button" name="filmbutton" value="filmbutton" onclick="filmDetailButton()">'

        tr += "<td>" + result.name + "</td> <td>" + result.height + "</td> <td>" + result.weight + "</td> <td>" + result.creatureType + "</td> <td>" + result.description + "</td> <td>" + btn + "</td> </tr>";
        //  let textnode = document.createTextNode(output);


        // node.appendChild(textnode);
        tbody.innerHTML += tr;

    }
}

function rejected(reason) {
    console.log(reason);
}


function filmDetailButton() {

    let req = new XMLHttpRequest()
    req.onload = function () {
        promisesfilm(req);
    }
    req.open('GET', 'http://localhost:8080/SoloProject/api/FilmData/getAFilmData/' + getaccname());
    req.send();
}
function promisesfilm(req) {
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
        .then((result) => resolvefilm(result))
        .catch(error => rejected(error))

}

function resolvefilm(result) {
     let node = document.createElement("tbody");
    node.setAttribute("id", "tbodyfilm");
    document.getElementById("results").appendChild(node);
        let tr = "<br><tr>";
        tr += "<td> Number Of Films </td> <td> First Film </td> <td> Win Count</td> </tr>";

        tr += "<td>" + result.noOfFilms + "</td> <td>" + result.firstFilm + "</td> <td>" + result.winCount + "</td></tr>";
        tbodyfilm.innerHTML += tr;


}