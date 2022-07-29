class KotilinTest {
}

fun main(args:Array<String>){
    print("hi kotlin")

    var i = 1
    if (i in 1..10) { // equivalent of 1
        println(i)
    }
    for (i in 0..12 step 3) print("$i ") // 0 3 6 9 12 출력
    print("\n")
    for (i in 12 downTo 5 step 2) print("$i ") // 12 10 8 6 4 2 0 출력
    print("\n")

    var x = 7
    when (x) {
        0, 1 -> print("boolean")
        2 -> print("콩\n콩")
        !in 1..9 step 2 -> print("홀수 아님")
        in 0..9 -> print("한자릿수")
        else -> print("otherwise")
    }
    print("\n")

    var a = 3
    var b = 2
    val max = if (a > b) {
        print("Choose a")
        a
    }
    else {
        print("Choose b")
        b
    }
    print("\n")
    print(max)


    /*
null이거나 null은 아니지만 대상 타입으로 형변환될 수 없는 경우와 같은
형변환이 실패하는 모든 경우에 대해 안전하게 null을 반환해준다.
*/
    null as? String // null
//    "string" as? File // null

/*
반면 as는 경우에 따라 kotlin.TypeCastException이나
java.lang.ClassCastException 예외를 발생시킬 수 있다
*/
//    null as File // kotlin.TypeCastException 예외 발생
//    null as File? // null
//    "string" as File // java.lang.ClassCastException 예외 발생
//    "string" as File? // java.lang.ClassCastException 예외 발생
}
