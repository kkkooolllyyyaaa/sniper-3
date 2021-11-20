const FORM_NAME = 'j_idt24'
const RECOVER_TIMEOUT = 500
const Alerter = {
    X_TEXT: 'X must be number in range [-5; 3]',
    Y_TEXT: 'Y must be integer number in range [-3; 5]',
    R_TEXT: 'Choose R, must be number in {1, 2, 3, 4, 5}',
    ALERT_COLOR: 'red',
    RECOVER_COLOR: 'inherit',
    alertX: () => alert(Alerter.X_TEXT),
    alertY: () => {
        document.forms[FORM_NAME].elements[2].style.background = Alerter.ALERT_COLOR
        alert(Alerter.Y_TEXT)
        setTimeout(recoverY, RECOVER_TIMEOUT)
    },
    alertR: () => {
        document.getElementById('radius-table').style.backgroundColor = Alerter.ALERT_COLOR
        alert(Alerter.R_TEXT)
        setTimeout(recoverR, RECOVER_TIMEOUT)
    }
}

function validate() {
    const yVal = document.forms[FORM_NAME].elements[2].value
    const rVal = localStorage.getItem('rVal')
    if (validateR(rVal)) {
        Alerter.alertR()
    } else if (isEmpty(yVal) || validateY(yVal)) {
        Alerter.alertY()
    }
}

recoverY = () => document.forms[FORM_NAME].elements[2].style.background = Alerter.RECOVER_COLOR

recoverR = () => document.getElementById('radius-table').style.backgroundColor = Alerter.RECOVER_COLOR

validateX = (xVal) => xVal == null || isNaN(xVal) || xVal < -5 || xVal > 3
validateY = (yVal) => yVal == null || isNaN(yVal) || yVal < -3 || yVal > 5
validateR = (rVal) => rVal == null || isNaN(+rVal) || +rVal < 1 || +rVal > 5
