const FORM_NAME = 'j_idt24'

function initR(r) {
    getHiddenRInput().value = r
    setRVal(r)
    displayR(r)
    dotsDrawer.drawDots()
}

function displayR(radius) {
    document.getElementById('Rx').textContent = radius
    document.getElementById('-Rx').textContent = radius
    document.getElementById('Ry').textContent = radius
    document.getElementById('-Ry').textContent = radius
}

clearTable = () => document.forms[FORM_NAME].elements[2].value = ''

isEmpty = (temp) => temp === ''

setRVal = (r) => localStorage.setItem('rVal', r)
getRVal = () => localStorage.getItem('rVal')

getXInput = () => document.forms[FORM_NAME].elements[1]
getYInput = () => document.forms[FORM_NAME].elements[2]
getRInput = () => document.getElementById('radius-table')
getHiddenRInput = () => document.getElementById(FORM_NAME + ':r-input')