<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="rest/file/upload" method="post" enctype="multipart/form-data">

      <p>
          Select a file : <input type="file" name="image" id="image" size="45" />
      </p>
      <p>Target Upload Path : <input type="text" name="filename" id="filename" /></p>
      <input type="submit" value="Upload It" />
   </form>


</body>
</html>