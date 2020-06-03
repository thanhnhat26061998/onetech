<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cart</title>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="description" content="OneTech shop project"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>


        <link href="<c:url value="../static/business/styles/bootstrap4/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../static/business/plugins/fontawesome-free-5/0/1/css/fontawesome-all.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="../static/business/styles/cart_styles.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="../static/business/styles/cart_responsive.css"/>"/>
        <link href="<c:url value="../static/business/styles/bootstrap3/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div class="super_container">

            <!-- Header -->

            <header class="header">

                <!-- Top Bar -->

                <div class="top_bar">
                    <div class="container">
                        <div class="row">
                            <div class="col d-flex flex-row">
                                <div class="top_bar_contact_item"><div class="top_bar_icon"><img src="images/phone.png" alt=""/></div>+38 068 005 3570</div>
                                <div class="top_bar_contact_item"><div class="top_bar_icon"><img src="images/mail.png" alt=""/></div><a href="mailto:fastsales@gmail.com">fastsales@gmail.com</a></div>
                                <div class="top_bar_content ml-auto">
                                    <div class="top_bar_menu">
                                        <ul class="standard_dropdown top_bar_dropdown">
                                            <li>
                                                <a href="#">English<i class="fas fa-chevron-down"></i></a>
                                                <ul>
                                                    <li><a href="#">Italian</a></li>
                                                    <li><a href="#">Spanish</a></li>
                                                    <li><a href="#">Japanese</a></li>
                                                </ul>
                                            </li>
                                            <li>
                                                <a href="#">$ US dollar<i class="fas fa-chevron-down"></i></a>
                                                <ul>
                                                    <li><a href="#">EUR Euro</a></li>
                                                    <li><a href="#">GBP British Pound</a></li>
                                                    <li><a href="#">JPY Japanese Yen</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="top_bar_user">
                                        <div class="user_icon"><img src="images/user.svg" alt=""/></div>
                                        <div><a href="#">Register</a></div>
                                        <div><a href="#">Sign in</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>		
                </div>

                <!-- Header Main -->

                <div class="header_main">
                    <div class="container">
                        <div class="row">

                            <!-- Logo -->
                            <div class="col-lg-2 col-sm-3 col-3 order-1">
                                <div class="logo_container">
                                    <div class="logo"><a th:href="@{/}">OneTech</a></div>
                                </div>
                            </div>

                            <!-- Search -->
                            <div class="col-lg-6 col-12 order-lg-2 order-3 text-lg-left text-right">
                                <div class="header_search">
                                    <div class="header_search_content">
                                        <div class="header_search_form_container">
                                            <form action="#" class="header_search_form clearfix">
                                                <input type="search" required="required" class="header_search_input" placeholder="Search for products..."/>
                                                <div class="custom_dropdown">
                                                    <div class="custom_dropdown_list">
                                                        <span class="custom_dropdown_placeholder clc">All Categories</span>
                                                        <i class="fas fa-chevron-down"></i>
                                                        <ul class="custom_list clc">
                                                            <li><a class="clc" href="#">All Categories</a></li>
                                                            <li><a class="clc" href="#">Computers</a></li>
                                                            <li><a class="clc" href="#">Laptops</a></li>
                                                            <li><a class="clc" href="#">Cameras</a></li>
                                                            <li><a class="clc" href="#">Hardware</a></li>
                                                            <li><a class="clc" href="#">Smartphones</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <button type="submit" class="header_search_button trans_300" value="Submit"><img src="images/search.png" alt=""/></button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Wishlist -->
                            <div class="col-lg-4 col-9 order-lg-3 order-2 text-lg-left text-right">
                                <div class="wishlist_cart d-flex flex-row align-items-center justify-content-end">


                                    <!-- Cart -->
                                    <div class="cart">
                                        <div class="cart_container d-flex flex-row align-items-center justify-content-end">
                                            <div class="cart_icon">
                                                <img src="images/cart.png" alt=""/>
                                                <div class="cart_count"><span>10</span></div>
                                            </div>
                                            <div class="cart_content">
                                                <div class="cart_text"><a href="#">Cart</a></div>
                                                <div class="cart_price" th:utext="${cartForm.amountTotal}"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Navigation -->

                <nav class="main_nav">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="main_nav_content d-flex flex-row">

                                    <!-- Categories Menu -->

                                    <div class="cat_menu_container">
                                        <div class="cat_menu_title d-flex flex-row align-items-center justify-content-start">
                                            <div class="cat_burger"><span></span><span></span><span></span></div>
                                            <div class="cat_menu_text">categories</div>
                                        </div>

                                        <ul class="cat_menu">
                                            <li><a href="#">Computers & Laptops <i class="fas fa-chevron-right ml-auto"></i></a></li>
                                            <li><a href="#">Cameras & Photos<i class="fas fa-chevron-right"></i></a></li>
                                            <li class="hassubs">
                                                <a href="#">Hardware<i class="fas fa-chevron-right"></i></a>
                                                <ul>
                                                    <li class="hassubs">
                                                        <a href="#">Menu Item<i class="fas fa-chevron-right"></i></a>
                                                        <ul>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                        </ul>
                                                    </li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-right"></i></a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#">Smartphones & Tablets<i class="fas fa-chevron-right"></i></a></li>
                                            <li><a href="#">TV & Audio<i class="fas fa-chevron-right"></i></a></li>
                                            <li><a href="#">Gadgets<i class="fas fa-chevron-right"></i></a></li>
                                            <li><a href="#">Car Electronics<i class="fas fa-chevron-right"></i></a></li>
                                            <li><a href="#">Video Games & Consoles<i class="fas fa-chevron-right"></i></a></li>
                                            <li><a href="#">Accessories<i class="fas fa-chevron-right"></i></a></li>
                                        </ul>
                                    </div>

                                    <!-- Main Nav Menu -->

                                    <div class="main_nav_menu ml-auto">
                                        <ul class="standard_dropdown main_nav_dropdown">
                                            <li><a href="index.html">Home<i class="fas fa-chevron-down"></i></a></li>
                                            <li class="hassubs">
                                                <a href="#">Super Deals<i class="fas fa-chevron-down"></i></a>
                                                <ul>
                                                    <li>
                                                        <a href="#">Menu Item<i class="fas fa-chevron-down"></i></a>
                                                        <ul>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                        </ul>
                                                    </li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                </ul>
                                            </li>
                                            <li class="hassubs">
                                                <a href="#">Featured Brands<i class="fas fa-chevron-down"></i></a>
                                                <ul>
                                                    <li>
                                                        <a href="#">Menu Item<i class="fas fa-chevron-down"></i></a>
                                                        <ul>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                            <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                        </ul>
                                                    </li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="#">Menu Item<i class="fas fa-chevron-down"></i></a></li>
                                                </ul>
                                            </li>
                                            <li class="hassubs">
                                                <a href="#">Pages<i class="fas fa-chevron-down"></i></a>
                                                <ul>
                                                    <li><a href="shop.html">Shop<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="product.html">Product<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="blog.html">Blog<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="blog_single.html">Blog Post<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="regular.html">Regular Post<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="cart.html">Cart<i class="fas fa-chevron-down"></i></a></li>
                                                    <li><a href="contact.html">Contact<i class="fas fa-chevron-down"></i></a></li>
                                                </ul>
                                            </li>
                                            <li><a href="blog.html">Blog<i class="fas fa-chevron-down"></i></a></li>
                                            <li><a href="contact.html">Contact<i class="fas fa-chevron-down"></i></a></li>
                                        </ul>
                                    </div>

                                    <!-- Menu Trigger -->

                                    <div class="menu_trigger_container ml-auto">
                                        <div class="menu_trigger d-flex flex-row align-items-center justify-content-end">
                                            <div class="menu_burger">
                                                <div class="menu_trigger_text">menu</div>
                                                <div class="cat_burger menu_burger_inner"><span></span><span></span><span></span></div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </nav>

                <!-- Menu -->

                <div class="page_menu">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="page_menu_content">

                                    <div class="page_menu_search">
                                        <form action="#">
                                            <input type="search" required="required" class="page_menu_search_input" placeholder="Search for products...">
                                        </form>
                                    </div>
                                    <ul class="page_menu_nav">
                                        <li class="page_menu_item has-children">
                                            <a href="#">Language<i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">English<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Italian<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Spanish<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Japanese<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#">Currency<i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">US Dollar<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">EUR Euro<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">GBP British Pound<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">JPY Japanese Yen<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item">
                                            <a href="index.html">Home<i class="fa fa-angle-down"></i></a>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#">Super Deals<i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">Super Deals<i class="fa fa-angle-down"></i></a></li>
                                                <li class="page_menu_item has-children">
                                                    <a href="#">Menu Item<i class="fa fa-angle-down"></i></a>
                                                    <ul class="page_menu_selection">
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#">Featured Brands<i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">Featured Brands<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#">Trending Styles<i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">Trending Styles<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item"><a href="blog.html">blog<i class="fa fa-angle-down"></i></a></li>
                                        <li class="page_menu_item"><a href="contact.html">contact<i class="fa fa-angle-down"></i></a></li>
                                    </ul>

                                    <div class="menu_contact">
                                        <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/phone_white.png" alt=""></div>+38 068 005 3570</div>
                                        <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/mail_white.png" alt=""></div><a href="mailto:fastsales@gmail.com">fastsales@gmail.com</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </header>

            <!-- Cart -->

            <div class="cart_section row">

                <div class="col-lg-8 offset-lg-1">
                    <div class="cart_container">

                        <div class="cart_items">
                            <ul class="cart_list">
                                <li class="cart_item clearfix">
                                    <c:if test="${cartForm == null || cartForm.cartLines == null || empty cartForm.cartLines}">
                                        <h2>There is no items in Cart</h2>
                                        <a href="<c:url value="/"/>">Show Product List</a>
                                    </c:if>

                                    <c:if test="${cartForm != null && cartForm.cartLines != null && not empty cartForm.cartLines}">
                                        <form:form method="post" modelAttribute="cartForm" action="cart">

                                            <c:forEach var="cartLineInfo" items="${cartForm.cartLines}">
                                                <c:url var="deleteLink" value="/cartRemoveProduct">
                                                    <c:param name="code" value="${cartLineInfo.productInfo.code}"/>
                                                </c:url>
                                                <div>
                                                    <form:hidden path="cartLineInfo.productInfo.code"/>                                                             

                                                    <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                                        <div class="cart_item_image cart_info_col">
                                                            <img src="cartLineInfo.productInfo.productImage" alt=""/>
                                                        </div>
                                                        <div class="cart_item_name cart_info_col">
                                                            <div class="cart_item_title">Name</div>
                                                            <div class="cart_item_text">${cartLineInfo.productInfo.name}</div>
                                                        </div>
                                                        <div class="cart_item_color cart_info_col">
                                                            <div class="cart_item_title">Color</div>
                                                            <div class="cart_item_text"><span style="background-color:#999999;"></span>Silver</div>
                                                        </div>
                                                        <div class="cart_item_quantity cart_info_col">
                                                            <div class="cart_item_title">Quantity</div>
                                                            <div class="cart_item_text">
                                                                <form:input path="cartLineInfo.quantity" type="text" size="4"/>
                                                            </div>
                                                        </div>
                                                        <div class="cart_item_price cart_info_col">
                                                            <div class="cart_item_title">Price</div>
                                                            <div class="cart_item_text">
                                                                ${cartLineInfo.productInfo.price}
                                                            </div>
                                                        </div>
                                                        <div class="cart_item_total cart_info_col">
                                                            <div class="cart_item_title">Total</div>
                                                            <div class="cart_item_text">
                                                                ${cartLineInfo.amount}
                                                            </div>
                                                        </div>
                                                        <div class="cart_item_quantity cart_info_col">
                                                            <div class="cart_item_title">
                                                                <a href="${deleteLink}">Xóa khỏi giỏ hàng</a>
                                                            </div>
                                                            <div class="cart_item_text">
                                                                <div class="row">                                                                            
                                                                    <div class="input-group"> 
                                                                        <div class="input-group-btn">    
                                                                            <button type="button" class="btn btn-default btn-light" disabled="disabled" data-type="minus" data-field="quant[1]"> 
                                                                                <span class="glyphicon glyphicon-minus"></span> 
                                                                            </button>    
                                                                        </div> 
                                                                        <input name="quant[1]" class="form-control input-group-text" size="1" value="1" type="text"/> 
                                                                        <div class="input-group-btn">    
                                                                            <button type="button" class="btn btn-default btn-light" data-type="plus" data-field="quant[1]"> 
                                                                                <span class="glyphicon glyphicon-plus"></span> 
                                                                            </button>    
                                                                        </div> 
                                                                    </div> 
                                                                </div> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-offset-3 col-md-6">
                                                    <input type="submit" value="Update Quantity" />
                                                </div>
                                                </div>
                                            </c:forEach>         
                                        </form:form>
                                    </c:if>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>


                <!-- Order Total -->
                <div class="col-lg-2">
                    <div class="cart_items">
                        <div class="order_total">
                            <div class="order_total_content">                                        
                                <div class="order_total_title text-left">Order Total:</div>
                                <div class="order_total_amount">${cartForm.amountTotal}</div> 
                            </div>                            
                        </div>
                        <a href="<c:url value="/shoppingCartCustomer" class="btn btn-lg btn-danger cart_order_button"/>">Order now</a>
                        <a href="<c:url value="/" class="btn btn-lg btn-primary cart_order_button"/>">Continue Buy</a>
                    </div>
                </div>
            </div>




            <!-- Newsletter -->

            <div class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="newsletter_container d-flex flex-lg-row flex-column align-items-lg-center align-items-center justify-content-lg-start justify-content-center">
                                <div class="newsletter_title_container">
                                    <div class="newsletter_icon"><img src="images/send.png" alt=""></div>
                                    <div class="newsletter_title">Sign up for Newsletter</div>
                                    <div class="newsletter_text"><p>...and receive %20 coupon for first shopping.</p></div>
                                </div>
                                <div class="newsletter_content clearfix">
                                    <form action="#" class="newsletter_form">
                                        <input type="email" class="newsletter_input" required="required" placeholder="Enter your email address">
                                        <button class="newsletter_button">Subscribe</button>
                                    </form>
                                    <div class="newsletter_unsubscribe_link"><a href="#">unsubscribe</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer -->

            <footer class="footer">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-3 footer_col">
                            <div class="footer_column footer_contact">
                                <div class="logo_container">
                                    <div class="logo"><a href="#">OneTech</a></div>
                                </div>
                                <div class="footer_title">Got Question? Call Us 24/7</div>
                                <div class="footer_phone">+38 068 005 3570</div>
                                <div class="footer_contact_text">
                                    <p>17 Princess Road, London</p>
                                    <p>Grester London NW18JR, UK</p>
                                </div>
                                <div class="footer_social">
                                    <ul>
                                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fab fa-youtube"></i></a></li>
                                        <li><a href="#"><i class="fab fa-google"></i></a></li>
                                        <li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-2 offset-lg-2">
                            <div class="footer_column">
                                <div class="footer_title">Find it Fast</div>
                                <ul class="footer_list">
                                    <li><a href="#">Computers & Laptops</a></li>
                                    <li><a href="#">Cameras & Photos</a></li>
                                    <li><a href="#">Hardware</a></li>
                                    <li><a href="#">Smartphones & Tablets</a></li>
                                    <li><a href="#">TV & Audio</a></li>
                                </ul>
                                <div class="footer_subtitle">Gadgets</div>
                                <ul class="footer_list">
                                    <li><a href="#">Car Electronics</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-lg-2">
                            <div class="footer_column">
                                <ul class="footer_list footer_list_2">
                                    <li><a href="#">Video Games & Consoles</a></li>
                                    <li><a href="#">Accessories</a></li>
                                    <li><a href="#">Cameras & Photos</a></li>
                                    <li><a href="#">Hardware</a></li>
                                    <li><a href="#">Computers & Laptops</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-lg-2">
                            <div class="footer_column">
                                <div class="footer_title">Customer Care</div>
                                <ul class="footer_list">
                                    <li><a href="#">My Account</a></li>
                                    <li><a href="#">Order Tracking</a></li>
                                    <li><a href="#">Wish List</a></li>
                                    <li><a href="#">Customer Services</a></li>
                                    <li><a href="#">Returns / Exchange</a></li>
                                    <li><a href="#">FAQs</a></li>
                                    <li><a href="#">Product Support</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </footer>

            <!-- Copyright -->

            <div class="copyright">
                <div class="container">
                    <div class="row">
                        <div class="col">

                            <div class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
                                <div class="copyright_content"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                </div>
                                <div class="logos ml-sm-auto">
                                    <ul class="logos_list">
                                        <li><a href="#"><img src="images/logos_1.png" alt=""></a></li>
                                        <li><a href="#"><img src="images/logos_2.png" alt=""></a></li>
                                        <li><a href="#"><img src="images/logos_3.png" alt=""></a></li>
                                        <li><a href="#"><img src="images/logos_4.png" alt=""></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('.btn-light').click(function (e) {
                    e.preventDefault();
                    var fieldName = $(this).attr('data-field');
                    var type = $(this).attr('data-type');
                    var input = $("input[name='" + fieldName + "']");
                    var currentVal = parseInt(input.val());
                    if (!isNaN(currentVal)) {
                        if (type === 'minus') {
                            var minValue = parseInt(input.attr('min'));
                            if (!minValue)
                                minValue = 1;
                            if (currentVal > minValue) {
                                input.val(currentVal - 1).change();
                            }
                            if (parseInt(input.val()) === minValue) {
                                $(this).attr('disabled', true);
                            }
                        } else if (type === 'plus') {
                            var maxValue = parseInt(input.attr('max'));
                            if (!maxValue)
                                maxValue = 9999999999999;
                            if (currentVal < maxValue) {
                                input.val(currentVal + 1).change();
                            }
                            if (parseInt(input.val()) === maxValue) {
                                $(this).attr('disabled', true);
                            }
                        }
                    } else {
                        input.val(0);
                    }
                });
                $('.input-group-text').focusin(function () {
                    $(this).data('oldValue', $(this).val());
                });
                $('.input-group-text').change(function () {
                    var minValue = parseInt($(this).attr('min'));
                    var maxValue = parseInt($(this).attr('max'));
                    if (!minValue)
                        minValue = 1;
                    if (!maxValue)
                        maxValue = 9999999999999;
                    var valueCurrent = parseInt($(this).val());
                    var name = $(this).attr('name');
                    if (valueCurrent >= minValue) {
                        $(".btn-light[data-type='minus'][data-field='" + name + "']").removeAttr('disabled');
                    } else {
                        alert('Sorry, the minimum value was reached');
                        $(this).val($(this).data('oldValue'));
                    }
                    if (valueCurrent >= maxValue) {
                        $(".btn-light[data-type='plus'][data-field='" + name + "']").removeAttr('disabled');
                    } else {
                        alert('Sorry, the maximum value was reached');
                        $(this).val($(this).data('oldValue'));
                    }
                });
                $(".input-group-text").keydown(function (e) {
// Allow: backspace, delete, tab, escape, enter and .            
                    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
// Allow: Ctrl+A                
                            (e.keyCode === 65 && e.ctrlKey === true) ||
// Allow: home, end, left, right                
                            (e.keyCode >= 35 && e.keyCode <= 39)) {
// let it happen, don't do anything                     
                        return;
                    }
// Ensure that it is a number and stop the keypress            
                    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                        e.preventDefault();
                    }
                });
            });
        </script>

        <script src="../static/business/js/jquery-3.3.1.min.js" 
        type="text/javascript"></script>
        <script src="../static/business/styles/bootstrap4/popper.js" 
        type="text/javascript"></script>
        <script src="../static/business/styles/bootstrap3/bootstrap.min.js" 
        type="text/javascript"></script>
        <script src="../static/business/styles/bootstrap4/bootstrap.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/greensock/TweenMax.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/greensock/TimelineMax.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/scrollmagic/ScrollMagic.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/greensock/animation.gsap.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/greensock/ScrollToPlugin.min.js" type="text/javascript"></script>
        <script src="../static/business/plugins/easing/easing.js" type="text/javascript"></script>
        <script src="../static/business/js/cart_custom.js" type="text/javascript"></script>
    </body>

</html>