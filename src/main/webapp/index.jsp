    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<link type="text/css" rel="stylesheet" href="/portal/css/ext/bootstrap.min.css?@@TIMESTAMP@@" />
<link type="text/css" rel="stylesheet" href="/portal/css/int/stylish-portfolio.css?@@TIMESTAMP@@" />
<script type="text/javascript" src="/portal/script/ext/jquery-1.11.0.min.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.simpletip-1.3.1.min.js"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.i18n.properties-min-1.0.9.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.validate-1.8.1.min.js"></script>
<script type="text/javascript" src="/portal/script/int/join.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/int/serverSideValidation.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/int/add.i18n.capability.js?@@TIMESTAMP@@"></script>
<link type="text/css" rel="stylesheet" href="/portal/css/ext/bootstrap-responsive.min.css?@@TIMESTAMP@@"/>




    <title>Simple Registration App</title>

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand">
                <a href="#top">Start Mini App</a>
            </li>
            <li>
                <a href="#top">Home</a>
            </li>
            <li>
                <a href="registration">Registration</a>
            </li>
        </ul>
    </nav>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Start Mini App</h1>
            <h3>Simple Registration App</h3>
            <br>
            <a href="registration" class="btn btn-dark btn-lg">Find Out More</a>
        </div>
    </header>

     <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <br>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; 2015</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- Custom Theme JavaScript -->
    <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    </script>

</body>
