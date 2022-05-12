# DesglozaGramatica
Solución que desgloza una gramática libre de contexto en sus partes
La solución incluye un jForm que muestra los resultados del desgloce de la gramática en partes.
Ejemplo:<br>
input:

S:S'+'T <br>
S:T<br>
T:T'*'F|F<br>
F:'a'<br><br>
output:<br>
VAR<br><br>
S<br>
T<br>
F<br>
TER<br><br>
+<br>
*<br>
a<br>
PROD<br><br>
S'+'T<br>
T<br>
T'*'F|F<br>
'a'<br>

