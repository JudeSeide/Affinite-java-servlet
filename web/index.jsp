<!doctype html>
<html class="no-js">

    <head>
        <meta charset="utf-8"/>
        <title>AFFINITE|accueil</title>

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
                    <li class="current-menu-item"><a href="index.jsp">Accueil</a></li>
                    <li><a href="inscription.jsp">Inscription</a></li>
                    <li><a href="connexion.jsp">Usager</a>
                        <ul>
                            <li><a href="connexion.jsp">Administrateur</a></li>
                        </ul>					
                    </li>
                    <li><a href="contact.jsp">Contact</a></li>
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
                    <option value="index.jsp" selected="selected">Accueil</option>
                    <option value="inscription.jsp">Inscription</option>
                    <option value="connexion.jsp">Usager</option>
                    <option value="connexion.jsp">Administrateur</option>
                    <option value="contact.jsp">Contact</option>
                    <option value="connexion.jsp">Connexion</option>
                    <option value="#deconnexionForm">Deconnexion</option>
                </select>
                <!-- comboNav -->	

                <!-- slider holder -->
                <div class="clearfix"></div>
                <div id="slider-holder" class="clearfix">

                    <!-- slider -->
                    <div class="flexslider home-slider">
                        <ul class="slides">
                            <li>
                                <img src="img/slides/01.jpg" alt="alt text" />
                                <p class="flex-caption">Rencontrez l'amour.</p>
                            </li>
                            <li>
                                <img src="img/slides/02.jpg" alt="alt text" />
                                <p class="flex-caption">Faites-vous des amis.</p>
                            </li>
                            <li>
                                <img src="img/slides/03.jpg" alt="alt text" />
                                <p class="flex-caption">Partagez vos passions.</p>
                            </li>
                            <li>
                                <img src="img/slides/04.jpg" alt="alt text" />
                                <p class="flex-caption">Ayez des party inoubliables.</p>
                            </li>
                        </ul>
                    </div>
                    <!-- ENDS slider -->

                    <div class="home-slider-clearfix "></div>

                    <!-- Headline -->
                    <div id="headline">
                        <h4>Bienvenue sur Affinite !</h4>
                        <p class="headline-text">
                            Ceci est une application web de publication et de recherche d'affinites entre personnes.
                        </p> 
                        <p class="headline-text">
                            Le systeme offre la possibilite de faire des correspondances entre un usager et d'autres sur la base 
                            des categories et mots-cles qu'ils ont en communs. A chaque usager, on presente les 3 usagers ayant le plus d'affinites avec 
                            lui. Cette affinite est presentee a l'usager sous forme de pourcentages.
                        </p>
                        <p class="headline-text">
                            Le systeme detecte les personnes qui ont des affinites tout en utilisant leur proximite geographique.
                        </p>
                        <p class="headline-text">
                            Une fois qu'un usager a trouve des affinites avec d'autres, il peut passer a une page suivante pour echanger ses 
                            coordonnes a travers un formulaire tout en restant dans la meme session. Il peut se deconnecter par la suite.
                        </p> 
                    </div>
                    <!-- ENDS headline -->


                </div>
                <!-- ENDS slider holder -->

            </div>
        </header>



    </body>

</html>
