@echo off
rem %Z%%M% %I% %G%
rem Indirect point for using 1.1 or 1.2 commands
rem uses JHW_KP for classpath and %1 for class
if ."%JHHOME%".==."". goto nojhhome
goto runnit
:nojhhome
echo The environment variable JHHOME has not been set
goto done
:runnit

if ."%2".==."-jdk". goto jdk
set JHW_OKP=%CLASSPATH%
set CLASSPATH=%JHW_KP%;%CLASSPATH%
@echo on
java %1 %2 %3 %4 %5 %6 %7 %8 %9
@echo off
set CLASSPATH=%JHW_OKP%
goto done

:jdk
set JHW_OKP=%CLASSPATH%
set CLASSPATH=%JHW_KP%;%CLASSPATH%
@echo on
java %1 %3 %4 %5 %6 %7 %8 %9
@echo off
set CLASSPATH=%JHW_OKP%

:done
