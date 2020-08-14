function getResult(){
	var itemId = document.getElementById("itemId").innerHTML;
	var itemPrice = document.getElementById("itemPrice").innerHTML;
	var totalPrice = document.getElementById("totalPrice").innerHTML;  //0
	var totalItemPrice = parseFloat(totalPrice);
	console.log(itemId);
	console.log(itemPrice);
	console.log(totalPrice);
	console.log(totalItemPrice);
	if(itemId !== null){
		if(typeof totalItemPrice === number){
			totalItemPrice = totalItemPrice + itemPrice;
		}	
	}
	document.getElementById("totalPrice").innerHTML = totalPrice;
	document.getElementById("totalPrice").value = totalPrice;
}