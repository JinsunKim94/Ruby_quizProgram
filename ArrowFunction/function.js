"use strict";
//Function 
// - fundamental building block in the program
// - performs a task or calculates a value

// 1. Function declaration
// function name(param1, param2) { body... return; }
// one function === one thing
// naming: doSomething, command, verb
// e.g. createCardAndPoint -> createCard, createPoint
// function is object in JS (function은 object의 일종이다.)
function printHello(){
    console.log('Hello');
}
printHello();

function log(message){
    console.log(message);
}
log('Hello@');
log(1234);

// 2. Parameters
// premitive parameters: passed by value
// object parameters: passed by reference
function changeName(obj){
    obj.name = 'coder';
}
const jinsun = { name: 'jinsun'};
changeName(jinsun);
console.log(jinsun);

// 3. Default parameters (added in ES6)
function showMessage(message, from = 'unknown'){
    /*if(from === undefined){
        from = 'unknown';
    } 프로그램이 undefined일 때를 대비해서 default 저장했음*/
    console.log('${message} by ${from}');
}
showMessage('Hi!');

// 4. Rest parameters (added in ES6)
function printAll(...args){// '...'는 배열 3칸
    for(let i = 0; i < args.length; i++){
        console.log(args[i]);
    }

    for(const arg of args){//args에 있는 모든 값들이 arg에 들어감
        console.log(arg);
    }

    args.forEach((arg) => console.log(arg));
}
printAll('dream', 'coding', 'ellie');

// 5. local scope
let globalMessage = 'global'; //global variable
function printMessage(){
    let message = 'hello';
    console.log(message); // local variable
    console.log(globalMessage);
    function printAnother(){
        console.log(message);
        let childMessage = 'hello';
    }
    console.log(childMessage);//에러발생
}
printMessage();

// 6. Return a value
function sum(a, b){
    return a + b;
}
const result = sum(1, 2); // 3
console.log(`sum: ${sum(1, 2)}`);//return 타입이 없는 함수는 return undefined가 들어가 있는 것과 같다.

// 7. Early return early exit
// bad
function upgradeUser(user){
    if(user.point > 10){
        // long upgrade logic...
    }
}

// good
function upgradeUser(user){
    if(user.point <= 10){
        return;
    }
    // long upgrade logic...
}
