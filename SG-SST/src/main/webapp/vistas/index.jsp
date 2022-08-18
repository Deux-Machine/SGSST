<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SG-SST</title>

	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

<style>

/*the container must be positioned relative:*/
.autocompleteBS {
  position: relative;
  /*display: inline-block;*/
}

.autocompleteBS-items {
  position: absolute;
  border: 1px solid #d4d4d4;
  border-bottom: none;
  border-top: none;
  z-index: 99;
  /*position the autocomplete items to be the same width as the container:*/
  top: 100%;
  left: 0;
  right: 0;
}

.autocompleteBS-items div {
  padding: 10px;
  cursor: pointer;
  background-color: #fff; 
  border-bottom: 1px solid #d4d4d4; 
}

/*when hovering an item:*/
.autocompleteBS-items div:hover {
  background-color: #e9e9e9; 
}

/*when navigating through the items using the arrow keys:*/
.autocompleteBS-active {
  background-color:  #d4d4d4 !important; 
  color: #ffffff;
}

</style>

</head>
<body>
<div class="contrainer">
	<form>
        <div class="mb-3 autocompleteBS">
          <label for="inputText1" class="form-label">Diagnosticos</label>
          <input type="text" class="form-control" id="inputText1">
        </div>

        <div class="d-nonx mt-2">
          <div class="mb-3">
            <label for="inputID1" class="form-label">CIE10</label>
            <input type="text" class="form-control" id="inputID1" disabled>
          </div>
          
        </div>
      </form>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <script src="https://oportuna.red/apks/autocompleteBS.js"></script>
    <script type="text/javascript">
    
    const autoCompleteConfig = [{
        name: 'Diagnosticos CIE10',
        debounceMS: 250,
        minLength: 3,
        maxResults: 10,
        inputSource: document.getElementById('inputText1'),
        targetID: document.getElementById('inputID1'),
        fetchURL: 'http://localhost:8087/apis/diagnosticos?texto={term}',
        fetchMap: {id: "codigo",
                   name: "diagnostico"}
      }
    ];

    console.log(autoCompleteConfig);

    // Initiate Autocomplete to Create Listeners
    autocompleteBS(autoCompleteConfig);

    function resultHandlerBS(inputName, selectedData) {
      console.log(inputName);
      console.log(selectedData);
    }
    
    </script>
</body>
</html>