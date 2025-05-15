Los siguientes ejercicios son una práctica de hilos y concurrencia.

Ejercicio 1: 

  - Realizar un programa que haga productos de matrices cuadradas. 
  - El usuario introduce dos números, el orden de las matrices y el número de hilos a utilizar.
	- El programa crea dos matrices de ese orden con elementos aleatorios, y mediante hilos realiza el producto.
	- Finalmente, se muestra el resultado y el tiempo que ha llevado el cálculo.
 
Ejercicio 3:

  - Simula un ecosistema con tres hilos principales: productor, consumidor y monitor.
  - El productor genera presas (valores flotantes aleatorios) cuando hay menos de 500.
  - El consumidor elimina periódicamente la presa más grande y la más pequeña.
  - El monitor muestra en tiempo real el número de presas y su promedio.
  - Usa sincronización para evitar condiciones de carrera.
  
Ejercicio 4:

  - Objetivo: Implementar un sistema que simule el reparto proporcional de 200 escaños entre partidos políticos basado en sus votos.
  - Entrada requerida: Número total de partidos y cantidad de votos recibidos por cada partido.
  - Lógica de reparto: Asignar 1 escaño por ronda al partido con mayor votos actuales.
  - Recalcular votos del ganador: votos = votos_originales / (escaños_obtenidos + 1). Repetir hasta agotar todos los escaños.
  - Requisitos técnicos: Usar programación multihilo (1 hilo por partido). Garantizar sincronización en registro de votos, verificación de ganador y asignación de escaños.
  - Salida esperada: Mensaje por cada escaño asignado con formato: "Partido [X] (votos: [Y]) ha ganado 1 escaño. Total: [Z]".
  - 
Ejercicio 5:

  - Objetivo: Desarrollar un sistema multihilo para encontrar candidatos compatibles con una pareja ideal predefinida.
  - Entrada: Número de hilos evaluadores (ingresado por usuario). 
  - Generación de candidatos: Atributos aleatorios: sexo, edad (18-35), estatura (140-210cm), estudios (0-5), ingresos (múltiplos de 100 hasta 50000).
  - Cada hilo compara candidatos con el perfil ideal. 
  - Puntuación (0-10) basada en: sexo, edad, estatura, estudios e ingresos.
  - Se almacenan en candidatos.txt aquellos con puntuación ≥5.
  - Finaliza al encontrar 50 candidatos válidos.
  - Salida: Mensajes en consola por evaluación. Archivo candidatos.txt con resultados válidos.
  
  
  
  
