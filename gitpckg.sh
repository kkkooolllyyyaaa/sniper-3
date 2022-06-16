#!/bin/bash

function prepare_commits() {
  echo "" > commits.properties
  for ((counter = 1; counter <= $1; counter++)); do
    ARG="$counter""p"
    COMMIT=$(git log | grep commit | head -$1 | awk '{print $2}' | sed -n $ARG)
    echo commit$counter=$COMMIT >> 'commits.properties'
  done
}

#touch commits.properties
#prepare_commits $1
ant build