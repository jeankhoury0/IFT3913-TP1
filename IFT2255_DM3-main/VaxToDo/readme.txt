compiler le projet manuellement avec la commande : 
$ javac -d out .\src\main\java\application\*.java .\src\main\java\controller\*.java .\src\main\java\view\*.java .\src\main\java\model\*.java .\src\main\java\repository\*.java .\src\main\java\utils\*.java

créer le fichier jar avec :
$ jar cfm VaxToDo.jar manifest.txt .\out\*

ouvrir le fichier jar avec : 
$ java -jar VaxToDo.jar