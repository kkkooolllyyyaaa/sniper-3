#!/bin/bash

function prepare_commits() {
  N=$1
  ((N = N + 1))
  git stash push -a build/mispi-3.jar
  for ((counter = 2; counter <= $N; counter++)); do
    ARG="$counter""p"
    COMMIT=$(git log | grep commit | head -$N | awk '{print $2}' | sed -n $ARG)
    echo commit$counter=$COMMIT >>'commits.properties'

    git checkout $COMMIT
    git checkout master build.xml
    git checkout master temp.properties
    ant build

    ((NUMBER = counter - 1))
    CUR_JAR=build/commit$NUMBER.jar
    mv build/mispi-3.jar $CUR_JAR

    git stash push -a $CUR_JAR
  done
  git checkout master
  for ((i = 2; i <= $N; i++)); do
    git stash pop
  done
    zip build/gitpackage.zip build/commit*
    git stash pop
    rm -rf build/commit*
}

prepare_commits $1
