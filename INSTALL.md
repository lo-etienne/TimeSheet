# Deloitte Application: Installation

Ce document est destiné à toute personne souhaitant installer l'application sur son propre ordinateur. 

## Pré-requis

Lors du développement de l'application, nous avons utilisé ces différentes versions de technologie :

- Version de l'OS minimum : 6.0 (API >= 23) 
- Librairies internes (androidx)


- Base de données locale : Room, version 2.2.6
- Material (Google) : version 1.3.0
- Gson (Google)  : version 2.8.6

## Etapes de déploiement

1. Cloner le projet depuis [le dépôt Git](https://git.cg.helmo.be/e191088/TimeSheet.git)  
`git clone https://git.cg.helmo.be/e191088/TimeSheet.git`

2. Importer le projet dans un IDE (Android Studio, ...).

3. Lancez l'application.

4. Afin de vous authentifier à l'application, deux comptes sont à votre disposition :
   
|         Username         |      Password      |    Type    |
|:------------------------:|:------------------:|:----------:|
| paul.basin@gmail.com     | password           | User       |
| emiledavignon@gmail.com  | 123123             | Manager    |


## Fonctionnalités

- Utilisateur Basique

    - Connexion
    - Ajout d'une Timesheet
    - Visualisation de l'ensemble de ses Timesheets
    - Visualisation d'une Timesheet spécifique
    - Suppression d'une Timesheet

- Manager

    - Visualiser les Timesheets à approuver
    - Visualiser l'historique des Timesheets approuvées

## Bugs connus

1. Lorsque l'utilisateur souhaite se connecter, la connexion échouera systématiquement la première fois même avec des identifiants corrects. Il sera nécessaire de réappuyer une deuxième fois au minimum pour accéder à l'accueil de l'utilisateur.

    Cause du bug : La base de données n'est pas initialisée avant la première interaction avec le bouton 'Login'.