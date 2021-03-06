#! /bin/bash

ssh-keyscan  $DEPLOYMENT_SERVER >> ~/.ssh/known_hosts

scp -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 \
    target/agility-attendee-session.jar \
    $DEPLOYMENT_USER@$DEPLOYMENT_SERVER:/home/$DEPLOYMENT_USER

ssh -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 $DEPLOYMENT_USER@$DEPLOYMENT_SERVER 'kill -9 $(lsof -t -i:8082) & /usr/bin/java -jar agility-attendee-session >> agility-attendee-session.log &'
