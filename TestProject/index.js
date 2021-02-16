'use strict';

function check(){
    for(let i = 0; i < 10; i++){
        console.log('🌱');
    }
}

function check2(){
    for(let i = 0; i < 10; i++){
        for(let j = i; j < 10; j++){
            console.log('🌹');
        }
    }
}






function init(){
    check();
    check2();
}
init();
