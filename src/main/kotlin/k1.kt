/*mport kotlinx.coroutines.*

// Función de suspensión que simula la búsqueda de palabras en la sopa de letras
private suspend fun userSearchWords(): Long {
    val t0 = System.currentTimeMillis()
    (1..5).forEach {
        delay(300)
        println("¡Palabra $it encontrada!")
    }
    return System.currentTimeMillis() - t0
}*/

// Función principal del programa
/*fun main() = runBlocking {

    // 1. Inicio
    println("¡Go!")

    // 2. Buscar palabras en el background con GlobalScope.launch
    launch {
        (1..5).forEach {
            delay(300)
            println("¡Palabra $it encontrada!")
        }
    }

    // 3. Iniciar temporizador en foreground con un bucle for
    for (i in 10 downTo 1) {
        println("${i}s")
        delay(100)
    }

    // 4. Tiempo fuera
    println("Se terminó el tiempo")

    // 5. Esperar a la corrutina usando runBlocking
    runBlocking {
        delay(600)
    }

    // 6. Iniciar una corrutina con async() para medir el tiempo empleado
    val totalTime = async {
        userSearchWords()
    }.await()

    println("Tiempo empleado: ${totalTime}")

    // 7. Iniciar una corrutina con alcance personalizado usando coroutineScope
    coroutineScope {
        val totalTimeScoped = async {
            userSearchWords()
        }.await()

        println("Tiempo empleado con alcance personalizado: ${totalTimeScoped}")
    }
}*/




/*fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}*/

// Importar componentes de corrutinas
/*import kotlinx.coroutines.*

fun main() {
    // 1. Inicio
    println("¡Go!")

    // 2. Buscar palabras en el background
    GlobalScope.launch {
        (1..5).forEach {
            delay(300)
            println("¡Palabra $it encontrada!")
        }
    }

    // 3. Iniciar temporizador en foreground
    for (i in 10 downTo 1) {
        println("${i}s")
        Thread.sleep(100)
    }

    // 4. Tiempo fuera
    println("Se terminó el tiempo")
}*/



