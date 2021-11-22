const FORM_NAME = 'j_idt24'
const rInputId = 'radius-table'
const rId = 'r-input'

function initR(r) {
    getR().value = r
    displayR(r)
    dotsDrawer.drawDots()
}

function displayR(radius) {
    document.getElementById('Rx').textContent = radius
    document.getElementById('-Rx').textContent = '-' + radius
    document.getElementById('Ry').textContent = radius
    document.getElementById('-Ry').textContent = '-' + radius
}

function initGraph() {
    if (isEmpty(getR().value)) {
        displayR('R')
    } else {
        displayR(getR().value)
    }
}

clearTable = () => document.forms[FORM_NAME].elements[2].value = ''
isEmpty = (temp) => temp === ''

getXInput = () => document.forms[FORM_NAME].elements[1]
getYInput = () => document.forms[FORM_NAME].elements[2]
getRInput = () => document.getElementById(rInputId)
getR = () => document.getElementById(FORM_NAME + ':' + rId)
getRVal = () => getR().value

window.onload = setTimeout(initGraph, 10)