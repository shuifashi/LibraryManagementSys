$(document).ready(function(){
  $("button").click(function(){
  	alert($(this)[0].value)
    $.post("", {
    	book.bookId: $(this)[0].value
    });
    
  })
})