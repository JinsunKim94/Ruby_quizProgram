'use strict'
const tag = document.querySelector('.tag');
function screenSize(){
    tag.innerHTML = `
    window.screen: ${window.screen.width}, ${window.screen.height};</br>
    window.outer: ${window.outerHeight}, ${window.outerWidth};</br>
    window.inner: ${window.innerHeight}, ${window.innerWidth};</br>
    documentElement.clientWidth: ${document.documentElement.clientWidth}
    `;
}

window.addEventListener('resize', () => {
    screenSize();
});
screenSize();