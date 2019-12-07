//declaring an array of colors
var colors = ['red', 'blue', 'green', 'yellow', 'pink', 'brown'],
i = 0;

var elementToChange = document.getElementById('colouring');  
//invoking a function by click event which changes color of the background
document.body.addEventListener('click', function(event){
    elementToChange.style.backgroundColor = colors[++i];
    if (i >= colors.length){
        i = 0;
    }
});