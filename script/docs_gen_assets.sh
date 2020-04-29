#!/bin/sh

set -e

cd showcase

expo build:web --no-pwa

#rm -r ../docs/fonts
rm -r ../docs/static
cp -R ./web-build/fonts ../docs/
cp -R ./web-build/static ../docs/
cp ./web-build/index.html ../docs/showcase.html
