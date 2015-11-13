Description:
An API compatible with Java.util.Random RNG with a focus on a simple secure API. Based on 'liburandy'.

Principals:
Simple to use, easy to audit, secure by default.

Known Issues:
It is slow. Really slow. It looks like the read to /dev/random is the issue but I am not sure.
It won't work on windows. This is a low priority for me as I want to build it right before I start thinking about different platforms.

