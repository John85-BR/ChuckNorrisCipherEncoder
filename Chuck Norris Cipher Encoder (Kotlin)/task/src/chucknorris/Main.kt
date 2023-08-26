package chucknorris

fun encode(string: String){

    var prev = ' '
    println("Encoded string:")
    for (char in string) {
        val binary = Integer.toBinaryString(char.code).padStart(7,'0')
        for (num in binary) {
            when {
                num == prev -> print("0")
                num == '1' -> print(" 0 0")
                num == '0' -> print(" 00 0")
            }
            prev = num
        }
    }
    println("\n")
}

fun decode(string: String){
    val list = string.split(" ").chunked(2)
    var temp = ""
    for(l in list){
        if(l[0] == "0"){
            if("0" in l[1]){
                repeat(l[1].length){
                    temp+="1"
                }
            } else{
                println("Encoded string is not valid.\n")
                return
            }

        }else if(l[0] == "00"){
            if("0" in l[1]){
                repeat(l[1].length){
                    temp+="0"
                }
            } else{
                println("Encoded string is not valid.\n")
                return
            }
        }else {
            println("Encoded string is not valid.\n")
            return

        }
    }
    var result = ""
    if(temp.length%7!=0){
        println("Encoded string is not valid.\n")
        return
    }
    val list2 = temp.chunked(7)

    for(l in list2){
        var temp2 = 0.0
        var cont = 6.0

        for(t in l){
            if(t == '1'){
                temp2 += Math.pow(2.0,cont)
            }
            cont--
        }
        result+=temp2.toChar()
    }
    println("Decoded string:")
    println("$result\n")
}

fun main() {

    while(true){
        println("Please input operation (encode/decode/exit):")
        when(val op = readln()){
            "encode" -> {
                println("Input string:")
                val string = readln()
                encode(string)}
            "decode" -> {
                println("Input encoded string:")
                val string = readln()
                decode(string)}
            "exit" -> break
            else -> println("There is no \'$op\' operation\n")
        }
    }
    println("Bye!")
}