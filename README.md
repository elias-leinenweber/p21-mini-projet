Dessin Vectoriel
================

Etat d'avancement au 28/05
--------------------------
Le projet (sources `.java` et javadoc) est terminé, et des tests unitaires ont
été réalisé pour les classes `Dessin`, `Vecteur` et `Angle`.  Les programmes de
démo `Albers` et `DessinVectTest2` marchent parfaitement.

Pour ce qui est de la conception, nous avons respecté au maximum possible la
spécification (DCC et sujet).

Pour la gestion des paramètres des méthodes, nous avons la poltique suivante :
- si il y a une incohérence au niveau mathématique (longueur négative, ou
  inférieure à la largeur dans le cas du rectangle, etc.), on lance une
  `IllegalArgumentException` ;
- si le paramètre est la référence `null`, mais qu'il est directement utilisé
  dans le corps de la méthode, on laisse la `NullPointerException` arriver
  "naturellement" ;
- sinon, si on affecte le paramètre à un attribut de classe ou d'une instance de
  classe, dans un constructeur ou un setter par exemple, on utilise
  `Objects#requireNonNull` pour suivre le principe
  ["fail-fast"](https://en.wikipedia.org/wiki/Fail-fast) en déclenchant la
  `NullPointerException` dès que possible.