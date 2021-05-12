// Get the elements with class="column"
const elements = document.getElementsByClassName("column");


// Full-width images
function one() {
  for (i = 0; i < elements.length; i++) {
    elements[i].style.flex = "100%";
  }
}

// // // Two images side by side
// function two() {
//   for (i = 0; i < elements.length; i++) {
//     elements[i].style.flex = "50%";
//   }
// }

// // Four images side by side
function four() {
  for (let i = 0; i < elements.length; i++) {
    elements[i].style.flex = "33%";
  }
}
