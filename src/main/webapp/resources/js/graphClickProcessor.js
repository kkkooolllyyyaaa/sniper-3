const SVG_RADIUS = 150
const SVG_SHIFT = 25
const SVG_FORM_NAME = 'j_idt22'

function getDot() {
    const rVal = localStorage.getItem('rVal')
    const coordinates = getFromSVG(rVal)
    const xVal = coordinates.xVal
    const yVal = coordinates.yVal

    if (validateR(rVal)) {
        Alerter.alertR()
    } else if (validateX(xVal)) {
        Alerter.alertX()
    } else if (validateY(yVal)) {
        Alerter.alertY()
    } else {
        sendRequest(xVal, yVal, rVal)
    }
}

function sendRequest(x, y, r) {
    document.forms[SVG_FORM_NAME][1].value = x
    document.forms[SVG_FORM_NAME][2].value = y
    document.forms[SVG_FORM_NAME][3].value = r
    document.forms[SVG_FORM_NAME][4].click()
}

function getFromSVG(rVal) {
    const svgArea = document.getElementById('area-graph');
    let rect = svgArea.getBoundingClientRect();
    let yCor = (event.clientY - rect.top);
    let xCor = (event.clientX - rect.left);
    const xVal = Math.floor(((xCor - (SVG_RADIUS + SVG_SHIFT)) / SVG_RADIUS * rVal) * 100) / 100;
    const yVal = -Math.floor(((yCor - (SVG_RADIUS + SVG_SHIFT)) / SVG_RADIUS * rVal) * 100) / 100;
    return {
        xVal: xVal,
        yVal: yVal
    }
}

document.getElementById('area-graph').onclick = getDot;