<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/styleIndex.css" />
<!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>Travel Share</title>
</head>
<!--[if IE 6 ]><body class="ie6 old_ie"><![endif]-->
<!--[if IE 7 ]><body class="ie7 old_ie"><![endif]-->
<!--[if IE 8 ]><body class="ie8"><![endif]-->
<!--[if IE 9 ]><body class="ie9"><![endif]-->
<!--[if !IE]><!-->
<body>
	<!--<![endif]-->
	
	<c:if test="${ sessionScope.user == null }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	 <script type="text/javascript">
            function ReadCookie()
            {
               var allcookies = document.cookie;
              // document.write ("All Cookies : " + allcookies );
               
               // Get all the cookies pairs in an array
               cookiearray = allcookies.split(';');
               
               // Now take key value pair out of this array
               for(var i=0; i<cookiearray.length; i++){
                  name = cookiearray[i].split('=')[0];
                  value = cookiearray[i].split('=')[1];
                  document.write ("Hello " + value);
               }
            }
      </script>

	<header>



	<h1>
		<a href="index.jsp">Travel Share</a><span id="version">v1</span>
	</h1>
	<nav>
	<ul>
		<li><a href="index.jsp" class="current">Home</a></li>
		<li><a href="myProfile.jsp">My Profile</a></li>
		<li><a href="newPost.jsp">New Post</a></li>
		<li><a href="categories.jsp">Categories</a></li>
		<li><a href="about.jsp">About</a></li>
		<li><a href="contact.jsp">Contact</a></li>
		<li><form id="logoutButton" action="logout" method="post">
				<button type="submit">Logout</button></li>
	</ul>
	</nav> </header>
	<div id="adbanner">
		<div id="ad">

		</div>
	</div>
	<div id="secwrapper">
		<section> <article id="featured"> <a href="post.jsp"> <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/travel_share"
         user = "root"  password = "BratinDol14"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
      	
         SELECT * from users WHERE user_id = 36;
      </sql:query>
 
      <table>
         <tr>
            <th>Post</th>

         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><img src="<c:out value = "${row.user_pictureURL}"/>"/>
               <h3>User: <c:out value = "${row.user_firstname}"/></h3>
               </td>
            </tr>
         </c:forEach>
      </table></a>
		<p>This is a jar</p>
		<a href="post.jsp" class="readmore">Read more</a> </article> <article> <a
			href="#"><img src="images/2.jpg" alt="" /></a>
			
		<h1>Tortor at Vulputate Blandit</h1>
		<p>Aenean quis dignissim diam. Etiam venenatis congue velit,
			varius gravida mi volutpat ac. Sed ut pretium dolor. Etiam tempor
			felis ac eros dictum quis consectetur dolor tristique. Aliquam
			scelerisque, odio vel luctus commodo, nisl nisl vehicula metus, ut
			lobortis eros sem blandit est.</p>
		<a href="#" class="readmore">Read more</a> </article> <article class="rightcl">
		<a href="#"><img src="images/3.jpg" alt="" /></a>
		<h1>Curabitur ut Eros a Justo Fermentum Vulputate</h1>
		<p>Etiam tempor felis ac eros dictum quis consectetur dolor
			tristique. Aliquam scelerisque, odio vel luctus commodo, nisl nisl
			vehicula metus, ut lobortis eros sem blandit est. Lorem ipsum dolor
			sit amet, consectetur adipiscing elit. Ut tempor, tortor at vulputate
			blandit, magna risus posuere turpis.</p>
		<a href="#" class="readmore">Read more</a> </article> <article id="photobox">
		<h1>Photos Box</h1>
		<img src="images/pbs1.jpg" alt="" />
		<img src="images/pbs2.jpg" alt="" />
		<img src="images/pbs3.jpg" alt="" /> <img src="images/pbs4.jpg"
			alt="" />
		<img src="images/pbs5.jpg" alt="" />
		<img src="images/pbs6.jpg" alt="" /> <img src="images/pbs7.jpg"
			alt="" /> </article> <article> <a href="#"><img
			src="images/4.jpg" alt="" /></a>
		<h1>Fermentum Vulputate Ac Sit Amet Metus</h1>
		<p>Mauris sed lectus dui. Suspendisse enim elit, tempor ac
			ullamcorper et, eleifend quis sem. Sed euismod sagittis ligula, a
			imperdiet sapien molestie nec. Curabitur ut eros a justo fermentum
			vulputate ac sit amet metus. Aenean quis dignissim diam.</p>
		<a href="#" class="readmore">Read more</a> </article> <article id="sponsors">
		<h1>Categories</h1>
		<a href="#"><p>Nature</p></a>
		<a href="#"><p>Animals</p></a>
		<a href="#"><p>People</p></a>
		<a href="#">
			<p>Cities</p>
		</a> </article> <article> <a href="#"><img src="images/5.jpg" alt="" /></a>
		<h1>Aenean Quis Dignissim Diam</h1>
		<p>Vulputate ac sit aenean quis dignissim diam. Etiam venenatis
			congue velit, varius gravida mi volutpat ac. Sed ut pretium dolor.
			Etiam tempor felis ac eros dictum quis consectetur dolor tristique.
			Aliquam scelerisque, odio vel luctus commodo, nisl nisl vehicula
			metus, ut lobortis eros sem blandit est.</p>
		<a href="#" class="readmore">Read more</a> </article> </section>
	</div>
	<footer> </footer>
</body>
</html>