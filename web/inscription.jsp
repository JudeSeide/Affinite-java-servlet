<!doctype html>
<html class="no-js">

    <head>
        <meta charset="utf-8"/>
        <title>AFFINITE|inscription</title>


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
                    <li class="current-menu-item"><a href="inscription.jsp">Inscription</a></li>
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
                    <option value="index.jsp" >Accueil</option>
                    <option value="inscription.jsp" selected="selected">Inscription</option>
                    <option value="connexion.jsp">Usager</option>
                    <option value="connexion.jsp">Administrateur</option>
                    <option value="contact.jsp">Contact</option>
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
                    <h1>Inscription</h1><span class="subheading">Remplissez le formulaire d'inscription.</span>
                </div>
                <div class='mh-div'></div>
                <!-- ENDS masthead -->



                <!-- page content -->
                <div id="page-content" class="clearfix">       	


                    <h4 class="heading">Formulaire d'inscription</h4>

                    <!-- form -->
                    <script type="text/javascript" src="js/form-validation.js"></script>
                    <form id="inscriptionForm" action="createUser" method="post">

                        <!-- 2 cols -->
                        <div class="left-page-block">

                            <fieldset>

                                <div>
                                    <input name="nom"  id="nom" type="text" class="form-poshytip" title="Entrez votre nom" placeholder="Doe"/>
                                    <label>Nom</label>
                                </div>
                                <div>
                                    <input name="prenom"  id="prenom" type="text" class="form-poshytip" title="Entrez votre prenom" placeholder="John"/>
                                    <label>Prenom</label>
                                </div>
                                <div>
                                    <input name="telephone"  id="telephone" type="text" class="form-poshytip" title="Entrez votre numero de telephone" placeholder="000-000-0000"/>
                                    <label>Telephone</label>
                                </div>
                                <div>
                                    <input name="email"  id="email" type="text" class="form-poshytip" title="Entrez votre courriel" placeholder="johndoe@server.com"/>
                                    <label>Courriel</label>
                                </div>
                                <div>									
                                    <input name="password"  id="password" type="password" class="form-poshytip" title="Entrez votre mot de passe" />
                                    <label>Mot de passe</label>
                                </div>
                                <div>									
                                    <input name="photo"  id="photo" type="file" value="" class="form-poshytip" title="Selectionnez une photo" />
                                    <label>Photo</label>
                                </div>
                        </div>

                        <div class="right-page-block">
                            <div>
                                <input name="pays"  id="pays" type="text" class="form-poshytip" title="Entrez votre pays de residence" placeholder="Canada"/>
                                <label>Pays</label>
                            </div>
                            <div>
                                <input name="province"  id="province" type="text" class="form-poshytip" title="Entrez votre province de residence" placeholder="Quebec"/>
                                <label>Province</label>
                            </div>
                            <div>
                                <input name="ville"  id="ville" type="text" class="form-poshytip" title="Entrez votre ville de residence" placeholder="Montreal"/>
                                <label>Ville</label>
                            </div>
                            <div>
                                <input name="municipalite"  id="municipalite" type="text" class="form-poshytip" title="Entrez votre municipalite" placeholder="St-laurent"/>
                                <label>Municipalite</label>
                            </div>
                            <div>
                                <input name="numerorue"  id="numerorue" type="text" class="form-poshytip" title="Entrez le numero et la rue de residence" placeholder="000 ste-catherine"/>
                                <label>Rue</label>
                            </div>
                            <div>
                                <input name="codepostal"  id="codepostal" type="text" class="form-poshytip" title="Entrez votre code postal" placeholder="X0X 0X0"/>
                                <label>Code Postal</label>
                            </div>

                            <p><input type="button" value="Enregistrer" name="submit" id="submit" /> <span id="error" class="warning">Message</span></p>


                            </fieldset>
                        </div>
                        <!-- ENDS 2 cols -->

                    </form>
                    <p id="sent-form-msg" class="success">
                        Merci de votre inscription !
                        <a href="connexion.jsp">Cliquez pour vous connecter.</a>
                    </p>



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

