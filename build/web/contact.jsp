<!doctype html>
<html class="no-js">

    <head>
        <meta charset="utf-8"/>
        <title>AFFINITE|contact</title>

        <link rel="stylesheet" media="all" href="css/style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <!-- Adding "maximum-scale=1" fixes the Mobile Safari auto-zoom bug: http://filamentgroup.com/examples/iosScaleBug/ -->


        <!-- JS -->
        <script src="js/jquery-1.6.4.min.js"></script>
        <script src="js/css3-mediaqueries.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/tabs.js"></script>

        <!-- superfish -->
        <link rel="stylesheet" media="screen" href="css/superfish.css" /> 
        <script  src="js/superfish-1.4.8/js/hoverIntent.js"></script>
        <script  src="js/superfish-1.4.8/js/superfish.js"></script>
        <script  src="js/superfish-1.4.8/js/supersubs.js"></script>
        <!-- ENDS superfish -->

        <!-- poshytip -->
        <link rel="stylesheet" href="js/poshytip-1.1/src/tip-twitter/tip-twitter.css"  />
        <link rel="stylesheet" href="js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css"  />
        <script  src="js/poshytip-1.1/src/jquery.poshytip.min.js"></script>
        <!-- ENDS poshytip -->

        <!-- GOOGLE FONTS -->
        <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>

        <!-- Flex Slider -->
        <link rel="stylesheet" href="css/flexslider.css" >
        <script src="js/jquery.flexslider-min.js"></script>
        <!-- ENDS Flex Slider -->

        <!-- Masonry -->
        <script src="js/masonry.min.js" ></script>
        <script src="js/imagesloaded.js" ></script>
        <!-- ENDS Masonry -->

        <!-- Less framework -->
        <link rel="stylesheet" media="all" href="css/lessframework.css"/>

        <!-- modernizr -->
        <script src="js/modernizr.js"></script>

        <!-- SKIN -->
        <link rel="stylesheet" media="all" href="css/skin.css"/>


    </head>

    <body lang="en">





        <header>
            <div class="wrapper clearfix">

                <div id="logo">
                    <a href="index.jsp"><img  src="img/logo.png" alt="Simpler"></a>
                </div>

                <!-- nav -->
                <ul id="nav" class="sf-menu">
                    <li><a href="index.jsp">Accueil</a></li>
                    <li><a href="inscription.jsp">Inscription</a></li>
                    <li><a href="connexion.jsp">Usager</a>
                        <ul>
                            <li><a href="connexion.jsp">Administrateur</a></li>
                        </ul>					
                    </li>
                    <li class="current-menu-item"><a href="contact.jsp">Contact</a></li>
                    <li><a href="connexion.jsp">Connexion</a>
                        <ul>
                            <li>
                                <form id="deconnexionForm" action="Deconnexion" method="post">
                                    <input type="submit" value="Deconnexion" name=""/>                                   
                                </form>
                            </li>
                        </ul>							
                    </li>
                </ul>
                <!-- ends nav -->

                <!-- comboNav -->
                <select id="comboNav">
                    <option value="index.jsp">Accueil</option>
                    <option value="inscription.jsp">Inscription</option>
                    <option value="connexion.jsp">Usager</option>
                    <option value="connexion.jsp">Administrateur</option>
                    <option value="contact.jsp" selected="selected">Contact</option>
                    <option value="connexion.jsp">Connexion</option>
                    <option value="#deconnexionForm">Deconnexion</option>
                </select>
                <!-- comboNav -->	

            </div>
        </header>



        <!-- MAIN -->
        <div id="main">	
            <div class="wrapper clearfix">

                <!-- masthead -->
                <div class="masthead clearfix">
                    <h1>Contact</h1><span class="subheading">Dites bonjour :-)</span>
                </div>
                <div class='mh-div'></div>
                <!-- ENDS masthead -->

                <!-- page content -->
                <div id="page-content" class="clearfix"> 

                    <!-- 2 cols -->
                    <div class="left-page-block">
                        <h4 class="heading">Formulaire de contact</h4>
                        <p>Il faut d'abord se connecter pour envoyer un courriel</p>
                        <!-- form -->
                        <script type="text/javascript" src="js/form-validation.js"></script>
                        <form id="contactForm" action="SendEmail" method="post">
                            <p>N'oubliez pas de laisser vos coordonnees afin d'obtenir une reponse.</p>
                            <fieldset>
                                <div>
                                    <input name="name"  id="name" type="text" class="form-poshytip" title="Entrez votre nom" placeholder="John Doe"/>
                                    <label>Nom</label>
                                </div>
                                <div>
                                    <input name="email"  id="email" type="text" class="form-poshytip" title="Entrez le courriel du contact" placeholder="johndoe@server.com"/>
                                    <label>Courriel</label>
                                </div>
                                <div>

                                    <input name="phone"  id="phone" type="text" class="form-poshytip" title="Entrez votre telephone" placeholder="000-000-0000"/>
                                    <label>Telephone</label>
                                </div>
                                <div>
                                    <textarea  name="comments"  id="comments" rows="5" cols="20" class="form-poshytip" title="Tapez le message"></textarea>
                                </div>

                                <p><input type="button" value="Envoyez" name="submit" id="submit" /> <span id="error" class="warning">Message</span></p>
                            </fieldset>

                        </form>
                        <p id="sent-form-msg" class="success">Courriel envoye, merci d'utiliser Affinite !</p>
                        <!-- ENDS form -->
                    </div>

                    <div class="right-page-block">
                        <h4 class="heading">Affinite info</h4>
                        <p>En cas de probleme, veuillez s'il vous plait contactez l'administrateur.</p>

                        <ul class="address-block">
                            <li class="address">201, avenue du Pr�sident-Kennedy, H2X 3Y7</li>
                            <li class="phone">123 456 7890</li>
                            <li class="mobile">123 456 7890</li>
                            <li class="email"><a href="mailto:admin@email.bd">email admin</a></li>
                        </ul>
                    </div>
                    <!-- ENDS 2 cols -->





                </div>
                <!-- ENDS page content -->



                <!-- Fold image -->
                <div id="fold"></div>
            </div>

        </div>
        <!-- ENDS MAIN -->


        <footer>	

            <div class="wrapper clearfix">

                <!-- widgets -->
                <ul  class="widget-cols clearfix">
                    <li class="first-col">						

                    </li>					

                </ul>
                <!-- ENDS widgets -->	

            </div>
        </footer>

    </body>

</html>

