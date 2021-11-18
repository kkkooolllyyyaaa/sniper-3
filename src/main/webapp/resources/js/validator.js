const form_name = 'j_idt21'
let rVal = -1

function validate() {
    const yVal = document.forms[form_name].elements[2].value
    if (rVal === -1) {
        alertR()
    } else if (isEmpty(yVal)) {
        alertY()
    } else if (isEmpty(rVal)) {
        alertR()
    } else {
        if (isNaN(yVal) || yVal < -3 || yVal > 5) {
            alertY()
        } else if (isNaN(rVal) || rVal < 1 || rVal > 5) {
            alertR()
        }
    }
}

function initR(radius) {
    rVal = radius
}

function alertY() {
    document.forms[form_name].elements[2].style.background = 'red'
    alert('Y must be integer number in range [-3; 5]')
}

function alertR() {
    const links = document.getElementsByTagName('a')
    for (let i = 0; i < links.length; ++i) {
        if (links.item(i).getAttribute('type') === 'button')
            links.item(i).style.background = 'red'
    }
    alert('Choose R, must be number in range [1; 5]')
}

function isEmpty(obj) {
    for (let key in obj) {
        return false
    }
    return true
}