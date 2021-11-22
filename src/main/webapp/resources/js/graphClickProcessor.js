const SVG_RADIUS = 150
const SVG_SHIFT = 25
const SVG_FORM_NAME = 'j_idt22'

function getDot() {
    const rVal = getRVal()
    const coordinates = getFromSVG(rVal)
    const xVal = coordinates.xVal
    const yVal = coordinates.yVal
    if (validateAll(xVal, yVal, rVal)) {
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
    const svgArea = getSVG()
    const rect = svgArea.getBoundingClientRect()
    const yCor = (event.clientY - rect.top)
    const xCor = (event.clientX - rect.left)
    const xVal = SVGtoX(xCor, rVal)
    const yVal = SVGtoY(yCor, rVal)
    return {
        xVal: xVal,
        yVal: yVal
    }
}

getSVG = () => document.getElementById('area-graph')

xToSVG = (x, r) => x / r * SVG_RADIUS + (SVG_RADIUS + SVG_SHIFT)
yToSVG = (y, r) => -y / r * SVG_RADIUS + (SVG_RADIUS + SVG_SHIFT)

SVGtoX = (xCor, rVal) => Math.floor(((xCor - (SVG_RADIUS + SVG_SHIFT)) / SVG_RADIUS * rVal) * 100) / 100
SVGtoY = (yCor, rVal) => -Math.floor(((yCor - (SVG_RADIUS + SVG_SHIFT)) / SVG_RADIUS * rVal) * 100) / 100

getSVG().onclick = getDot;