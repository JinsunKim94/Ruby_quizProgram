'use strict';
//Fetch the items from the JSON file
function loadItems(){
    return fetch('data/data.json')
    .then(response => response.json())
    .then(json => json.items);
}

//Update the list with the given items
function displayItems(items){
    const container = document.querySelector('.products__menubar');
    container.innerHTML = items.map(item => createHTMLString(item)).join('');
}

//Create HTML list item from the given data item
function createHTMLString(item){
    return `
    <li class="products__list">
    <img src="${item.image}" alt="${item.type}" class="products__thumbnail" />
    <span class="products__info">${item.gender}, ${item.size}</span>
    </li>
    `;
}

function onButtonClick(event, items){
    const datset = event.target.dataset;
    const key = datset.key;
    const value = datset.value;

    if(key == null || value == null){
        return;
    }

    displayItems(items.filter(item => item[key] === value));
}

function setEventListeners(items) {
    const logo = document.querySelector('.btn__store');
    const buttons = document.querySelector('.menubar__btn');
    logo.addEventListener('click', () => displayItems(items));
    buttons.addEventListener('click', event => onButtonClick(event, items));
}
//main
loadItems()
.then(items => {
    displayItems(items);
    setEventListeners(items);
})
.catch(console.log);
