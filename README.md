Dessin Vectoriel
================

Rapport final
-------------
### Ce qui marche
Tout.  Tous les tests unitaires passent et les deux programmes de test marchent
parfaitement.

### Ce qui ne marche pas
Rien.

### Spécifications non respectées
Aucune.

### Difficultés
Aucune, à part les quelques révisions de trigonométrie, et la documentation de
`Graphics2D` était suffisamment claire pour ce qui est du dessin des figures.

### Choix
Nous avons décidé de faire tenir autant que possible le code dans 80 colonnes
pour des raisons de lisibilité.  Nous avons également réécrit la méthode
`Rectangle#getSommets` afin de privilégier la lisibilité (l'ancienne
implémentation, plus élégante mais plus ésotérique se trouve dans la Javadoc de
la méthode).

Nous avons également utilisé le mot-clé `final` dans le corps de certaines
méthodes pour indiquer que la valeur qui suit ne change pas jusqu'à la fin du
bloc et/ou qu'elle ne sert que de "cache", pour éviter des appels de getter
inutiles par exemple.

Voir aussi [Vérification des paramètres](#vérification-des-paramètres).

### Ce qui n'était pas clair dans le sujet
Il n'était pas évident au départ de voir l'utilité des méthodes `initTrait` et
`initRemplissage`, mais on comprend assez vite quand on implémente les
différentes méthodes `dessiner`.


Etat d'avancement au 28/05
--------------------------
Le projet (sources `.java` et Javadoc) est terminé, et des tests unitaires ont
été réalisé pour les classes `Dessin`, `Vecteur` et `Angle`.  Les programmes de
démo `Albers` et `DessinVectTest2` marchent parfaitement.

Pour ce qui est de la conception, nous avons respecté au maximum possible la
spécification (DCc et sujet).

### Vérification des paramètres
Pour la gestion des paramètres des méthodes, nous avons la politique suivante :
- s'il y a une incohérence au niveau mathématique (longueur négative, ou
  inférieure à la largeur dans le cas du rectangle, etc.), on lance une
  `IllegalArgumentException` ;
- si le paramètre est la référence `null`, mais qu'il est directement utilisé
  dans le corps de la méthode, on laisse la `NullPointerException` arriver
  "naturellement" ;
- sinon, si on affecte le paramètre à un attribut de classe ou d'une instance de
  classe, dans un constructeur ou un setter par exemple, on utilise
  `Objects#requireNonNull` pour suivre le principe
  "[fail-fast](https://en.wikipedia.org/wiki/Fail-fast)" en déclenchant la
  `NullPointerException` dès que possible.
