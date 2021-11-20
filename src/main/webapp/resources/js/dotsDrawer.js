window.onload = drawDots

function drawDots() {
    removeDots()
    const values = document.querySelectorAll('#resultTable td')
    for (let i = 0; i < values.length; i += 5) {
        const x = values[i].innerHTML
        const y = values[i + 1].innerHTML
        const r = localStorage.getItem('rVal')
        const res = values[i + 4].innerHTML
        if (x !== '' && y !== '' && res !== '')
            drawOneDot(+x, +y, r, res)
    }
}

function drawOneDot(x, y, r, res) {
    const xCor = x / r * SVG_RADIUS + (SVG_RADIUS + SVG_SHIFT)
    const yCor = -y / r * SVG_RADIUS + (SVG_RADIUS + SVG_SHIFT)
    const color = res === 'true' ? 'green' : 'red'
    const circle = makeSVG('circle', {cx: xCor, cy: yCor, r: 2.5, stroke: color, fill: color, class: 'coordinate-dot'})
    document.getElementById('area-graph').appendChild(circle)
}

function makeSVG(tag, attributes) {
    let element = document.createElementNS('http://www.w3.org/2000/svg', tag);
    for (let i in attributes)
        element.setAttribute(i, attributes[i]);
    return element;
}

function removeDots() {
    $('.coordinate-dot').remove();
}
