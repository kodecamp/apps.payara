# MicroProfile generated Application

## Introduction
-----------------------------------

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

    mvn clean

##Development Mode: (Exploded War)
------------------------------------
    mvn compile war:exploded -Pdev

    #run it from the exploded war(./target/services/) the root of the project by using dcevm settings

    java -Xmx1g -Xms1g -XXaltjvm=dcevm \
         -javaagent:<your-dir>/hotswap-agent.jar \
         -XX:+UnlockDiagnosticVMOptions -XX:+EnableInvokeDynamic \
         -jar location_of_payara-micro-5.184.jar --deploy ./target/services

    -> For changes to be reloaded
    export JAVA_HOME=<DCEVM_JDK_HOME>

    mvn compile war:exploded

    or slightly faster way(If we are using ide)
    mvn war:exploded

    Note : we can use system variables to set the jvm options
    export JVM_OPTIONS="-Xmx1g -Xms1g -XXaltjvm=dcevm \
    -javaagent:/home/peehu/DevTools/hotswap-agent.jar \
    -XX:+UnlockDiagnosticVMOptions -XX:+EnableInvokeDynamic"

    java -jar $JVM_OPTIONS payara-micro.jar --deploy ./target/services

   OR

# use ./run to run the app and ./reload to hot reload the app



## Production Mode (fatjar creation)/(payara-micro version will be embedded into the jar
-----------------------------------------------------------------------------------------
    mvn clean package -Pprod

    java -jar target/servies-microbundel.jar

This will create an executable jar file **services-microbundle.jar** within the _target_ maven folder. This can be started by executing the following command

    java -jar target/services-microbundle.jar

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html

## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)


### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)

The example class **ConfigTestController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.














