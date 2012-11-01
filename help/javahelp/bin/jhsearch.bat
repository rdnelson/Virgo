@echo off
rem Run the JHSearch
rem @(#)jhsearch.bat 1.9 01/29/99

if ."%JHHOME%".==."". goto nojhhome
goto runnit
:nojhhome
echo The environment variable JHHOME has not been set
goto done
echo 
:runnit
@echo on
set JHW_KP=%JHHOME%\javahelp\lib\jsearch.jar
%JHHOME%\javahelp\bin\jhwrap com.sun.java.help.search.QueryEngine %1
@echo off

:done

