#!/bin/bash

function prepare_commits() {
  N=$1
  ((N = N + 1))
  for ((counter = 2; counter <= $N; counter++)); do
    ARG="$counter""p"
    COMMIT=$(git log | grep commit | head -$N | awk '{print $2}' | sed -n $ARG)

    git checkout $COMMIT
    git checkout master build.xml
    git checkout master temps.properties
    ant build

    git add -f build/mispi-3.jar
    git stash save build/mispi-3.jar
  done
  git checkout master
}

prepare_commits $1

##!/bin/bash
#
#function prepare_commits() {
#  N=$1
#  ((N = N + 1))
#  for ((counter = 2; counter <= $N; counter++)); do
#    ARG="$counter""p"
#    COMMIT=$(git log | grep commit | head -$N | awk '{print $2}' | sed -n $ARG)
#    echo $COMMIT
#    git checkout $COMMIT
#    git checkout master build.xml
#    git checkout master temps.properties
#    ant build
#
#    ((NUMBER = counter - 1))
#    CUR_JAR=build/commit$NUMBER.jar
#    mv build/mispi-3.jar $CUR_JAR
#
#    git add -f $CUR_JAR
#    git stash save $CUR_JAR
#  done
#  git checkout master
#  for ((i = 2; i <= $N; i++)); do
#    git stash pop
#  done
#  zip build/gitpackage.zip build/commit*
#  rm -rf build/commit*
#  git rm -rf build/commit*.jar
#}
#
#prepare_commits $1
