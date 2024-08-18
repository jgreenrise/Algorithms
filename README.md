# Algorithms
mkdir -p src-markdown && find src -maxdepth 1 -type f -name "*.java" -exec sh -c 'pandoc -s "$1" -t markdown -o "src-markdown/$(basename ${1%.java}).md"' _ {} \;
