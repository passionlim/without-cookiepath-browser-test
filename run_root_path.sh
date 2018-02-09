#!/bin/sh

cd `dirname $0`
scout_java_agent=scouter
./mvnw spring-boot:run  -Drun.jvmArguments="-Dcookie=1 -Dpath=/"
 
