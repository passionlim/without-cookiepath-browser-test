#!/bin/sh

cd `dirname $0`
scout_java_agent=scouter
./mvnw spring-boot:run  -Drun.jvmArguments="-javaagent:scouter/scouter-agent-java-1.8.1.1-p1.jar -Dscouter.config=scouter/scouter.conf -Dobj_name=boot"
 
