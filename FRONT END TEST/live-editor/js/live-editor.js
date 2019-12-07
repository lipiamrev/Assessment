//linking the html, css, and js ids to variables using document.getElementById()

function compile() {
  var html = document.getElementById("html");
  var css = document.getElementById("css");
  var js = document.getElementById("js");

  //setting the iframe id’s contentWindow to a variable

  var code = document.getElementById("code").contentWindow.document;


  //writing a function that runs on document.body.keyup (when a key is pressed) that:-
  // opens the textarea's contentWindow and
  //writes the values of the html, css, and js variables in it

  document.body.onkeyup = function () {
    code.open();
    code.writeln(
      html.value +
      "<style>" +
      css.value +
      "</style>" +
      "<script>" +
      js.value +
      "</script>"
    );
    
    code.close(); //closes the textarea’s contentWindow
  };
}

compile();