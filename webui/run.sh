#!/bin/bash
export JAVA_HOME=/home/sunil_arc/DevTools/dcevm-11.0.5+5
mvn compile war:exploded
${HOME}/DevTools/dcevm-11.0.5+5/bin/java -javaagent:${HOME}/DevTools/hotswap-agent.jar \
-jar ${HOME}/DevTools/SERVERS/payara-micro-5.194.jar \
--deploy ./target/webui \
--contextroot /app
