# Project 3: Experiments with Hashing 

* Author: Seth McDaniel
* Class: CS321 Section 002
* Semester: Spring 2025

## Overview

Creates two implementations of a hash table, one using linear probing and
the other using double hashing. The program then fills both with the same
data to compare their performace.

## Reflection

This lab went mostly well. The process of starting at the top and working my
way down is unfamiliar but effective here since I really didn't know what I
needed from my hash object to start. Implementing double hashing was much
easier than I thought it would be, and so was the twin prime generator.

The only part that gave me lots of difficulty was trying to get my SSH
keys to have their permissions set correctly. For some reason I could
not use chmod even after installing and configuring WSL. I found other
guides online to help get it to work, but it was so confusing why
it wasn't working.

## Compiling and Using

     Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>] 
       <dataSource>: 1 ==> random numbers 
                     2 ==> date value as a long 
                     3 ==> word list 
       <loadFactor>: The ratio of objects to table size,  
                       denoted by alpha = n/m 
       <debugLevel>: 0 ==> print summary of experiment 
                     1 ==> save the two hash tables to a file at the end 
                     2 ==> print debugging output for each insert 

## Results 

All tests in run-tests and generate-results match

For a hash table from the word list with a load factor of 0.5 and a size of 95791. Linear probing had an average number of probes of 1.6 per item, while double hashing had 1.39 probes per item. This show cases how double hashing is more effective.

## Sources used

https://www.geeksforgeeks.org/twin-prime-numbers-between-1-and-n/

This was what I based my prime number generator off of, but I deviated pretty quickly with actually specifying a min.