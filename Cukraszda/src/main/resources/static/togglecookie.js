const filterButtons = document.querySelectorAll('.filter-button'); // gombok
const menuItems = document.getElementsByClassName('item');
// console.log(filterButtons);
// console.log(menuItems);
filterButtons.forEach(button => {
    button.addEventListener('click', () => {
   //     console.log("Button clicked:", button.dataset.type);
        const filterType = button.dataset.type;
        for (let i = 0; i<menuItems.length; i++) {
         menuItems[i].classList.add('hidden');
    }


    if(filterType && filterType !== 'all') {
        for(let i = 0; i<menuItems.length; i++) {
            if(menuItems[i].classList.contains(filterType)) {
                menuItems[i].classList.remove('hidden');
            }
        }
    } else if(filterType==='all') {
        for(let i = 0; i<menuItems.length; i++) {
            menuItems[i].classList.remove('hidden');
        }
    }
    })

})