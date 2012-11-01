@echo off
rem Run the JHIndexer
rem @(#)jhindexer.bat 1.17 01/29/99

if ."%JHHOME%".==."". goto nojhhome
goto runnit
:nojhhome
echo The environment variable JHHOME has not been set
goto done

:runnit
set JHW_KP=%JHHOME%\javahelp\lib\jhall.jar;%JHHOME%\swing\swingall.jar

%JHHOME%\javahelp\bin\jhwrap com.sun.java.help.search.Indexer %1 %2 %3 %4 %5 %6 %7 %8 %9

:done
echo on
