const radius = 150
const shift = 25

function getDot() {
    const rVal = +localStorage.getItem('rVal')
    localStorage.removeItem('rVal')
    const coordinates = getCoordinates(rVal)
    const xVal = coordinates.xVal
    const yVal = coordinates.yVal

    if (rVal == null || isNaN(rVal) || rVal < 1 || rVal > 5) {
        alertR()
    } else if (xVal <= 3 && xVal >= -5 && yVal >= -3 && yVal <= 5) {
        sendRequest(xVal, yVal, rVal);
    } else {
        if (xVal < -5 || xVal > 3) {
            alertX()
        } else if (yVal < -3 || yVal > 5) {
            alertY()
        }
    }
}

function sendRequest(x, y, r) {
    console.log(x, y, r);
    // let http = new XMLHttpRequest();
    // const main = 'http://localhost:8080/sniper-3-1.0-SNAPSHOT';
    // const page = '/controller-servlet';
    // const params = '?x=' + x.toString() + '&y=' + y + '&r=' + r.toString() + '&' + 'check=dotCheck';
    // let url = main + page + params;
    // localStorage.setItem('rVal', r);
    // http.onload = function () {
    //     document.location.href = 'main.xhtml';
    // };
    // http.open('GET', url, true);
    // http.send();
}

function getCoordinates(rVal) {
    const svgArea = document.getElementById("area-graph");
    let rect = svgArea.getBoundingClientRect();
    let yCor = (event.clientY - rect.top);
    let xCor = (event.clientX - rect.left);
    const xVal = Math.floor(((xCor - (radius + shift)) / radius * rVal) * 100) / 100;
    const yVal = -Math.floor(((yCor - (radius + shift)) / radius * rVal) * 100) / 100;
    return {
        xVal: xVal,
        yVal: yVal
    }
}

document.getElementById('area-graph').onclick = getDot;
