@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  core-catalog-writer startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CORE_CATALOG_WRITER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\core-catalog-writer-plain.jar;%APP_HOME%\lib\core-catalog-writer-1.0.0-plain.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.15.3.jar;%APP_HOME%\lib\jackson-dataformat-xml-2.15.3.jar;%APP_HOME%\lib\spring-boot-starter-webflux-3.2.2.jar;%APP_HOME%\lib\spring-boot-starter-json-3.2.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.15.3.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.15.3.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.15.3.jar;%APP_HOME%\lib\jackson-databind-2.15.3.jar;%APP_HOME%\lib\jackson-core-2.15.3.jar;%APP_HOME%\lib\jackson-annotations-2.15.3.jar;%APP_HOME%\lib\jackson-module-kotlin-2.15.3.jar;%APP_HOME%\lib\kotlin-reflect-1.9.22.jar;%APP_HOME%\lib\kotlinx-coroutines-reactive-1.7.3.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.7.3.jar;%APP_HOME%\lib\kotlinx-coroutines-reactor-1.7.3.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.9.22.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.9.22.jar;%APP_HOME%\lib\kotlin-stdlib-1.9.22.jar;%APP_HOME%\lib\spring-boot-starter-data-r2dbc-3.2.2.jar;%APP_HOME%\lib\r2dbc-postgresql-1.0.4.RELEASE.jar;%APP_HOME%\lib\reactor-kotlin-extensions-1.2.2.jar;%APP_HOME%\lib\annotations-23.0.0.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-3.2.2.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-3.2.2.jar;%APP_HOME%\lib\spring-webflux-6.1.3.jar;%APP_HOME%\lib\spring-web-6.1.3.jar;%APP_HOME%\lib\spring-data-r2dbc-3.2.2.jar;%APP_HOME%\lib\r2dbc-pool-1.0.1.RELEASE.jar;%APP_HOME%\lib\spring-r2dbc-6.1.3.jar;%APP_HOME%\lib\r2dbc-spi-1.0.0.RELEASE.jar;%APP_HOME%\lib\client-2.1.jar;%APP_HOME%\lib\reactor-netty-http-1.1.15.jar;%APP_HOME%\lib\reactor-netty-core-1.1.15.jar;%APP_HOME%\lib\reactor-pool-1.0.5.jar;%APP_HOME%\lib\reactor-core-3.6.2.jar;%APP_HOME%\lib\snakeyaml-2.2.jar;%APP_HOME%\lib\woodstox-core-6.5.1.jar;%APP_HOME%\lib\stax2-api-4.2.1.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.2.2.jar;%APP_HOME%\lib\spring-boot-3.2.2.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.2.2.jar;%APP_HOME%\lib\spring-data-relational-3.2.2.jar;%APP_HOME%\lib\spring-data-commons-3.2.2.jar;%APP_HOME%\lib\spring-jdbc-6.1.3.jar;%APP_HOME%\lib\spring-tx-6.1.3.jar;%APP_HOME%\lib\spring-context-6.1.3.jar;%APP_HOME%\lib\spring-aop-6.1.3.jar;%APP_HOME%\lib\spring-beans-6.1.3.jar;%APP_HOME%\lib\spring-expression-6.1.3.jar;%APP_HOME%\lib\spring-core-6.1.3.jar;%APP_HOME%\lib\micrometer-observation-1.12.2.jar;%APP_HOME%\lib\logback-classic-1.4.14.jar;%APP_HOME%\lib\log4j-to-slf4j-2.21.1.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.11.jar;%APP_HOME%\lib\slf4j-api-2.0.11.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\common-2.1.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.105.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.105.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.105.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.105.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.105.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.105.Final.jar;%APP_HOME%\lib\netty-handler-4.1.105.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.105.Final-linux-x86_64.jar;%APP_HOME%\lib\spring-jcl-6.1.3.jar;%APP_HOME%\lib\micrometer-commons-1.12.2.jar;%APP_HOME%\lib\jsqlparser-4.6.jar;%APP_HOME%\lib\saslprep-1.1.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.105.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.105.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.105.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.105.Final.jar;%APP_HOME%\lib\netty-codec-4.1.105.Final.jar;%APP_HOME%\lib\netty-transport-4.1.105.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.105.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.105.Final.jar;%APP_HOME%\lib\netty-common-4.1.105.Final.jar;%APP_HOME%\lib\logback-core-1.4.14.jar;%APP_HOME%\lib\log4j-api-2.21.1.jar;%APP_HOME%\lib\stringprep-1.1.jar


@rem Execute core-catalog-writer
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CORE_CATALOG_WRITER_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable CORE_CATALOG_WRITER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%CORE_CATALOG_WRITER_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
