var numberofsquares = 6;
var colors = generaterandomcolor(numberofsquares);
var pickedcolor = pickcolor();
var square = document.querySelectorAll(".squares");
var displaycolor = document.querySelector("span");
var messagedisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetbutton = document.querySelector("#reset");
// var easybtn = document.querySelector("#easybtn");
// var hardbtn	= document.querySelector("#hardbtn");

var modeButtons = document.querySelectorAll(".mode");

for(var i=0; i<modeButtons.length; i++)
{
	modeButtons[i].addEventListener("click", function()
		{
			modeButtons[0].classList.remove("selected");
			modeButtons[1].classList.remove("selected");
			this.classList.add("selected");
			this.textContent === "Easy" ? numberofsquares = 3 : numberofsquares = 6;
			reset();
		});
}

function reset()
{
colors = generaterandomcolor(numberofsquares);
pickedcolor = pickcolor();

displaycolor.textContent = pickedcolor;

resetbutton.textContent = "New Colors";
messagedisplay.textContent = "";

for(var i=0; i<square.length; i++)
{
	if(colors[i])
	{
	square[i].style.display = "block";
	square[i].style.background = colors[i];	
	}
	else
	{
	square[i].style.display = "none";	
	}
	
}
h1.style.background = "steelblue";
}

// easybtn.addEventListener("click", function()
// {
// h1.style.background = "steelblue";
// easybtn.classList.add("selected");
// hardbtn.classList.remove("selected");
// numberofsquares = 3
// colors = generaterandomcolor(numberofsquares);
// pickedcolor = pickcolor();

// displaycolor.textContent = pickedcolor;

// for(var i=0; i<square.length; i++)
// {
// 	if(colors[i])
// 	{
// 	square[i].style.background = colors[i];	
// 	}
// 	else
// 	{
// 	square[i].style.display = "none";
// 	}
	
// }


// });


// hardbtn.addEventListener("click", function()
// {
// h1.style.background = "steelblue";
// easybtn.classList.remove("selected");
// hardbtn.classList.add("selected");
// numberofsquares = 6;
// colors = generaterandomcolor(numberofsquares);
// pickedcolor = pickcolor();

// displaycolor.textContent = pickedcolor;

// for(var i=0; i<square.length; i++)
// {
// 	square[i].style.background = colors[i];	
// 	square[i].style.display = "block";	
// }

// });

resetbutton.addEventListener("click", function()
{
reset();
// colors = generaterandomcolor(numberofsquares);
// pickedcolor = pickcolor();

// displaycolor.textContent = pickedcolor;

// for(var i=0; i<square.length; i++)
// {
// 	square[i].style.background = colors[i];
// }
// h1.style.background = "steelblue";
// resetbutton.textContent = "New Colors";
// messagedisplay.textContent = "";
});

displaycolor.textContent = pickedcolor; 

for(var i=0; i<square.length; i++)
{
	square[i].style.background = colors[i];

	square[i].addEventListener("click", function()
{
var clickedcolor = this.style.background;

if(pickedcolor === clickedcolor)
{
	messagedisplay.textContent = "Correct";
	resetbutton.textContent = "Play Again!!";
	changecolors(clickedcolor);
	h1.style.background = pickedcolor;
}
else
{
this.style.background = "black";
messagedisplay.textContent = "Try Again !!!";
}
});

}

function changecolors(color)
{
	for(var i=0; i<square.length; i++)
	{
		square[i].style.background = color;
	}
}

function pickcolor()
{
	var random = Math.floor(Math.random() * colors.length);
	return (colors[random])
}

function generaterandomcolor(num)
{
	var arr = [];
    for(var i=0; i<num; i++)
    {
    arr.push(randomcolor());
    }
	return arr;
}

function randomcolor()
{
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);

	return "rgb(" + r + ", " + g + ", " + b +")";
}