const dotsDrawer = {
    namespaceURI: 'http://www.w3.org/2000/svg',
    dotTag: 'circle',
    dotClass: 'coordinate-dot',
    isHit: 'true',
    inAreaColor: 'green',
    outAreaColor: 'red',
    drawDots: () => {
        dotsDrawer.removeDots()
        const values = document.querySelectorAll('#resultTable td')
        for (let i = 0; i < values.length; i += 5) {
            const x = values[i].innerHTML
            const y = values[i + 1].innerHTML
            const r = getRVal()
            const res = values[i + 4].innerHTML
            if (!isEmpty(x) && !isEmpty(y) && !isEmpty(res) && !isEmpty(r))
                dotsDrawer.drawOneDot(+x, +y, r, res)
        }
    },

    drawOneDot: (x, y, r, res) => {
        const xCor = xToSVG(x, r)
        const yCor = yToSVG(y, r)
        const color = dotsDrawer.getColor(res)
        const circle = dotsDrawer.makeSVG(dotsDrawer.dotTag, dotsDrawer.getAttributes(xCor, yCor, color))
        getSVG().appendChild(circle)
    },

    makeSVG: (tag, attributes) => {
        let element = document.createElementNS(dotsDrawer.namespaceURI, tag);
        for (let i in attributes)
            element.setAttribute(i, attributes[i])
        return element
    },

    getAttributes: (xCor, yCor, color) => {
        return {cx: xCor, cy: yCor, r: 2.5, stroke: color, fill: color, class: dotsDrawer.dotClass}
    },

    removeDots: () => $('.' + dotsDrawer.dotClass).remove(),

    getColor: (res) => res === dotsDrawer.isHit ? dotsDrawer.inAreaColor : dotsDrawer.outAreaColor
}

window.onload = dotsDrawer.drawDots