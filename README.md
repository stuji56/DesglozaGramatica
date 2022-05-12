# DesglozaGramatica
Solución que desgloza una gramática libre de contexto en sus partes
La solución incluye un jForm que muestra los resultados del desgloce de la gramática en partes.
Ejemplo:
input:

S:S'+'T
S:T
T:T'*'F|F
F:'a'
output:
VAR
S
T
F
TER
+
*
a
PROD
S'+'T
T
T'*'F|F
'a'

