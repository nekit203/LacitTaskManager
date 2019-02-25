<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<html>
<head>
<title>My Page</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<link type="text/css" rel="stylesheet" href="css/JFFormStyle-1.css" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!-- //js -->
<!-- fonts -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,700,500italic,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- //fonts -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>
		<link href="css/bootstrap.icon-large.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/runPagestyle.css">
</head>
<body>

		<div class="banner bus-ban">
			<br>
			<div class="container">
				<c:if test="${not empty err}">
					<div class="alert alert-danger">${err}</div>
				</c:if>
				<form method="POST" action="/LacitTaskManager/saveinfo.html"
					enctype="multipart/form-data">
					

						<div class="sap_tabs">
							<div class="booking-info about-booking-info">
								<h2>My info</h2>
							</div>
							<div id="horizontalTab"
								style="display: block; width: 100%; margin: 0px;">
								<!---->
								<div class="facts about-facts">
									<div class="booking-form">
										<link rel="stylesheet" href="css/jquery-ui.css" />
										<div class="online_reservation">
											<div class="b_room">
												<div class="booking_room">
<div class="reservation">
														<ul>
															<li class="span1_of_1">
																<h5>Name Surname</h5>
																<div class="book_date">
																	<span class="glyphicon glyphicon-user"
																		aria-hidden="true"></span> <input type="text"
																		placeholder="Name Surname"
																		class="typeahead1 input-md form-control tt-input"
																		required="" name="real_name" value="${user.real_name}" />
																</div>
															</li>
															<div class="clearfix"></div>
														</ul>
													</div>
													<div class="reservation">
														<ul>
															<li class="span1_of_1">
																<h5>Email</h5>
																<div class="book_date">
																	<span class="glyphicon glyphicon-envelope"
																		aria-hidden="true"></span> <input type="text"
																		class="typeahead1 input-md form-control tt-input"
																		required="" value="${user.email}"
																		name="email">
																</div>
															</li>
															<div class="clearfix"></div>
														</ul>
													</div>
												<div class="reservation">
														<ul>
															<li class="span1_of_1">
																<h5>Phone number</h5>
																<div class="book_date">
																	<span class="glyphicon glyphicon-phone-alt"
																		aria-hidden="true"></span> <input type="text"
																		class="typeahead1 input-md form-control tt-input"
																		placeholder="(xx)xxx-xxxx" required=""
																		name="phone_number" value="${user.phone_number}"
																		onkeydown="javascript:backspacerDOWN(this,event);"
																		onkeyup="javascript:backspacerUP(this,event);">
																</div>
															</li>
															<div class="clearfix"></div>
														</ul>
													</div>
													<div class="reservation">
														<ul>
															<li class="span1_of_1">
																<h5>Password</h5>
																<div class="book_date">
																	<span class="glyphicon glyphicon-lock"
																		aria-hidden="true"></span> <input type="text"
																		class="typeahead1 input-md form-control"
																		placeholder="Password" name="password">
																</div>
															</li>
															<div class="clearfix"></div>
														</ul>
													</div>
													<div class="reservation">
														<div class="reservation">
															<ul>
																<li class="span1_of_3">
																	<div class="date_btn">
																		<input type="submit" value="Update">
																	</div>
																</li>
																<div class="clearfix"></div>
															</ul>
														</div>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<!---->
										</div>
									</div>
								</div>
							</div>
						</div>
					<div class="clearfix"></div>
				</form>
  <script type="text/javascript">
			var zChar = new Array(' ', '(', ')', '-', '.');
			var maxphonelength = 12;
			var phonevalue1;
			var phonevalue2;
			var cursorposition;

			function ParseForNumber1(object) {
				phonevalue1 = ParseChar(object.value, zChar);
			}
			function ParseForNumber2(object) {
				phonevalue2 = ParseChar(object.value, zChar);
			}

			function backspacerUP(object, e) {
				if (e) {
					e = e
				} else {
					e = window.event
				}
				if (e.which) {
					var keycode = e.which
				} else {
					var keycode = e.keyCode
				}

				ParseForNumber1(object)

				if (keycode >= 48) {
					ValidatePhone(object)
				}
			}

			function backspacerDOWN(object, e) {
				if (e) {
					e = e
				} else {
					e = window.event
				}
				if (e.which) {
					var keycode = e.which
				} else {
					var keycode = e.keyCode
				}
				ParseForNumber2(object)
			}

			function GetCursorPosition() {

				var t1 = phonevalue1;
				var t2 = phonevalue2;
				var bool = false
				for (i = 0; i < t1.length; i++) {
					if (t1.substring(i, 1) != t2.substring(i, 1)) {
						if (!bool) {
							cursorposition = i
							bool = true
						}
					}
				}
			}

			function ValidatePhone(object) {

				var p = phonevalue1

				p = p.replace(/[^\d]*/gi, "")

				if (p.length < 2) {
					object.value = p
				} else if (p.length == 2) {
					pp = p;
					d4 = p.indexOf('(')
					d5 = p.indexOf(')')
					if (d4 == -1) {
						pp = "(" + pp;
					}
					if (d5 == -2) {
						pp = pp + ")";
					}
					object.value = pp;
				} else if (p.length > 2 && p.length < 7) {
					p = "(" + p;
					l30 = p.length;
					p30 = p.substring(0, 3);
					p30 = p30 + ")"

					p31 = p.substring(3, l30);
					pp = p30 + p31;

					object.value = pp;

				} else if (p.length >= 7) {
					p = "(" + p;
					l30 = p.length;
					p30 = p.substring(0, 3);
					p30 = p30 + ")"

					p31 = p.substring(3, l30);
					pp = p30 + p31;

					l40 = pp.length;
					p40 = pp.substring(0, 7);
					p40 = p40 + "-"

					p41 = pp.substring(7, l40);
					ppp = p40 + p41;

					object.value = ppp.substring(0, maxphonelength);
				}

				GetCursorPosition()

				if (cursorposition >= 0) {
					if (cursorposition == 0) {
						cursorposition = 2
					} else if (cursorposition <= 2) {
						cursorposition = cursorposition + 1
					} else if (cursorposition <= 5) {
						cursorposition = cursorposition + 2
					} else if (cursorposition == 6) {
						cursorposition = cursorposition + 2
					} else if (cursorposition == 7) {
						cursorposition = cursorposition + 4
						e1 = object.value.indexOf(')')
						e2 = object.value.indexOf('-')
						if (e1 > -1 && e2 > -1) {
							if (e2 - e1 == 4) {
								cursorposition = cursorposition - 1
							}
						}
					} else if (cursorposition < 11) {
						cursorposition = cursorposition + 3
					} else if (cursorposition == 11) {
						cursorposition = cursorposition + 1
					} else if (cursorposition >= 12) {
						cursorposition = cursorposition
					}

					var txtRange = object.createTextRange();
					txtRange.moveStart("character", cursorposition);
					txtRange.moveEnd("character", cursorposition
							- object.value.length);
					txtRange.select();
				}

			}

			function ParseChar(sStr, sChar) {
				if (sChar.length == null) {
					zChar = new Array(sChar);
				} else
					zChar = sChar;

				for (i = 0; i < zChar.length; i++) {
					sNewStr = "";

					var iStart = 0;
					var iEnd = sStr.indexOf(sChar[i]);

					while (iEnd != -1) {
						sNewStr += sStr.substring(iStart, iEnd);
						iStart = iEnd + 1;
						iEnd = sStr.indexOf(sChar[i], iStart);
					}
					sNewStr += sStr.substring(sStr.lastIndexOf(sChar[i]) + 1,
							sStr.length);

					sStr = sNewStr;
				}

				return sNewStr;
			}
		</script>
		<script type="text/javascript">
			$(function() {
				SyntaxHighlighter.all();
			});
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					start : function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
</body>		
</html>												