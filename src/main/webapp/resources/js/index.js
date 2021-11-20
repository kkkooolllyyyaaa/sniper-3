function initR(radius) {
    const radiusId = FORM_NAME + ':r-input'
    document.getElementById(radiusId).value = radius
    localStorage.setItem('rVal', radius)
    displayR(radius)
    drawDots()
}

function displayR(radius) {
    document.getElementById('Rx').textContent = radius
    document.getElementById('-Rx').textContent = radius
    document.getElementById('Ry').textContent = radius
    document.getElementById('-Ry').textContent = radius
}

clearTable = () => document.forms[FORM_NAME].elements[2].value = ''

function isEmpty(obj) {
    for (let key in obj) {
        return false
    }
    return true
}