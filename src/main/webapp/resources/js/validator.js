const Alerter = {
    X_TEXT: 'X must be number in range [-5; 3]',
    Y_TEXT: 'Y must be integer number in range [-3; 5]',
    R_TEXT: 'Choose R, must be number in {1, 2, 3, 4, 5}',
    RECOVER_TIMEOUT: 750,
    ALERT_COLOR: 'red',
    RECOVER_COLOR: 'inherit',
    alertX: () => {
        getXInput().style.backgroundColor = Alerter.ALERT_COLOR
        alert(Alerter.X_TEXT)
        setTimeout(recoverX, Alerter.RECOVER_TIMEOUT)
    },
    alertY: () => {
        getYInput().style.backgroundColor = Alerter.ALERT_COLOR
        alert(Alerter.Y_TEXT)
        setTimeout(recoverY, Alerter.RECOVER_TIMEOUT)
    },
    alertR: () => {
        getRInput().style.backgroundColor = Alerter.ALERT_COLOR
        alert(Alerter.R_TEXT)
        setTimeout(recoverR, Alerter.RECOVER_TIMEOUT)
    }
}

function validate() {
    const xVal = getXInput().value
    const yVal = getYInput().value
    const rVal = getRVal()
    validateAll(xVal, yVal, rVal)
}

function validateAll(xVal, yVal, rVal) {
    if (validateR(rVal)) {
        Alerter.alertR()
        return false
    } else if (validateX(xVal)) {
        Alerter.alertX()
        return false
    } else if (validateY(yVal)) {
        Alerter.alertY()
        return false
    }
    return true
}

recoverX = () => getXInput().style.backgroundColor = Alerter.RECOVER_COLOR

recoverY = () => getYInput().style.backgroundColor = Alerter.RECOVER_COLOR

recoverR = () => getRInput().style.backgroundColor = Alerter.RECOVER_COLOR

validateX = (xVal) => xVal == null || isNaN(xVal) || xVal < -5 || xVal > 3
validateY = (yVal) => yVal == null || yVal === '' || isNaN(yVal) || yVal < -3 || yVal > 5
validateR = (rVal) => rVal == null || isNaN(+rVal) || +rVal < 1 || +rVal > 5