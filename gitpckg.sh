#!/bin/bash

function prepare_commits() {
  N=$1
  ((N = N + 1))
  for ((counter = 2; counter <= $N; counter++)); do
    ARG="$counter""p"
    COMMIT=$(git log | grep commit | head -$N | awk '{print $2}' | sed -n $ARG)
    echo commit$counter=$COMMIT >>'commits.properties'

    git checkout $COMMIT
    git checkout master build.xml
    git checkout master temp.properties
    ant build

    CUR_JAR=build/commit$counter.jar
    mv build/mispi-3.jar $CUR_JAR

    git stash push -a $CUR_JAR
  done
  git checkout master
  for ((i = 2; i <= $N; i++)); do
    git stash pop
  done
}

prepare_commits $1
