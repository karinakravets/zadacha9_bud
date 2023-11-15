import kotlinx.coroutines.*
suspend fun main() = coroutineScope {
    val times = Array(3) {0}//значение времени для каждого будильника
    for (i in 0..2) {
        times[i] = getTime(i)//для получения времени задержки
    }
    val sounds = arrayOf("Звук 1 будильника", "Звук 2 будильника", "Звук 3 будильника")//массив со звуками будильников
    for (i in 0..2) {
        launch {//запускает новую корутину
            for (j in 1..times[i] / 1000) {
                delay(1000L)//задержка на 1 секунду
                println(sounds[i])
            }
            println("$i прозвенел")
        }
    }
}
fun getTime(i: Int): Int {//запрашивает время будильника
    var time: Int?
    do {
        print("Введите время $i будильника: ")
        time = readlnOrNull()?.toIntOrNull()// считывает введенное значение времени и преобразует его в целое число.
    } while (time == null || time <= 0)
    return time * 1000
}

