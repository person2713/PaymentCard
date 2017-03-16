Надо указать подгрузить драйвер в репозитория maven. Это делается с помощью следующей команды:

mvn install:install-file -Dfile={Path/to/your/ojdbc7.jar} -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar
