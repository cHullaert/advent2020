#!/bin/bash
year=$1
day=$2
echo "create challenge for year $year and day $day"

# create puzzle input
touch ./resources/$year/$day.txt

# create package for source
srcDir=./src/com/kaizoku/advent/application/y$year/d$day
mkdir $srcDir
cp ./resources/template/computer-template $srcDir/Computer.kt

puzzle="D"$day"Puzzle"
cp ./resources/template/puzzle-template $srcDir/$puzzle.kt

sed -i "s/#YEAR#/$year/g" $srcDir/Computer.kt
sed -i "s/#DAY#/$day/g" $srcDir/Computer.kt

sed -i "s/#YEAR#/$year/g" $srcDir/$puzzle.kt
sed -i "s/#DAY#/$day/g" $srcDir/$puzzle.kt
sed -i "s/#PUZZLE#/$puzzle/g" $srcDir/$puzzle.kt

# create package for test
testDir=./test/com/kaizoku/advent/application/y$year/d$day
mkdir $testDir
cp ./resources/template/computer-test-template $testDir/ComputerTest.kt
sed -i "s/#YEAR#/$year/g" $testDir/ComputerTest.kt
sed -i "s/#DAY#/$day/g" $testDir/ComputerTest.kt
sed -i "s/#PUZZLE#/$puzzle/g" $testDir/ComputerTest.kt
