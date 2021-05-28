#!/bin/bash
docker build . -t break-even-calculator
mkdir -p build
docker run --rm --entrypoint cat break-even-calculator  /home/application/function.zip > build/function.zip