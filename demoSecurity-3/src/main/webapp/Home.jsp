<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script src="jquery-3.4.1.min.js"></script> -->


<script type="text/javascript">


  $(document).ready(function () {
	 alert("in Ready function");

	    $("#search-form").submit(function (event) {
	    	alert("in form function");

	        //stop submit the form, we will post it manually.
	        event.preventDefault();

	        fire_ajax_submit();

	    });

	});

	function fire_ajax_submit() {

	    var search = {}
	    search["id"] = $("#id").val();
	    search["name"] = $("#name").val();
	    search["city"] = $("#city").val();

	  

	    $.ajax({
	        type: "POST",
	        contentType: "application/json",
	        url: "/create",
	        data: JSON.stringify(search),
	        dataType: 'json',
	        cache: false,
	        timeout: 600000,
	        success : function (search) {
	        	
	            $('#result').html(search.id + " " + search.name+ " " + search.city);
	            
	            alert("SUCCESS");

	        },
	        error: function (e) {

	            alert("error"); 

	        }
	    });

	} 
 

</script>
</head>
<body>

<form method="POST" id="search-form">
        Id : <input type="text" id="id" name="id" /></br>
        Name : <input type="text" id="name" name="name"  /> </br>
        City : <input type="text" id="city" name="city"  /></br>
        
        
        <input type="submit" id="button" value="create" />
</form>
 <div id="result"></div>
</body>
</html>