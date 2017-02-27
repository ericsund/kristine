# Kristine
Your personal assistant

Kristine is Copyright (C) 2017 Eric Sund

This project makes use of the Voce JSAPI library (C) 2005 Tyler Streeter
Please see license-BSD.txt for more details

RECENT FIXES
- When Kristine is speaking, Kristine would also listen to herself simultaneously,
which would cause an infinite loop of speaking back what she said.  This has been
patched now.

TODO
- Weather
- Time

USAGE

- Execute build.sh to build
- Execute run.sh to run
- Your "classpath" tells Voce where the class files are.  Doesn't matter where
as long as the path is correct.  Keep everything in that folder.
  - This means you can change the classpath in build.sh and run.sh if you move
  your class files folder
