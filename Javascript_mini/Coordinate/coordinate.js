'use strict'
const abnormal = document.querySelector('.abnormal');
abnormal.addEventListener('click', event =>{
    const abnormalRect = abnormal.getBoundingClientRect();
        console.log(abnormalRect);
        console.log(`client = ${event.clientX}, ${event.clientY}`);
        console.log(`page = ${event.pageX}, ${event.pageY}`);
});