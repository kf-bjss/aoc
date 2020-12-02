package days

class Day2 : Day(2) {

    private val payloadList = inputList.map { PasswordPayload(it) }

    override fun partOne(): Any {
        var validPasswords = 0
        payloadList.forEach { pp ->
            val keyCount = pp.password.count { pp.key == it }
            if(keyCount in pp.min..pp.max) {
                validPasswords++
            }
        }
        return validPasswords
    }

    override fun partTwo(): Any {
        var validPasswords = 0
        payloadList.forEach { pp ->
            val point1 = pp.password[pp.min-1]
            val point2 = pp.password[pp.max-1]
            if(point1 == pp.key && point2 != pp.key) {
                validPasswords++
            }
            if(point1 != pp.key && point2 == pp.key) {
                validPasswords++
            }
        }

        return validPasswords
    }
}

class PasswordPayload(line: String) {
    private val parts = line.split(" ")
    val min = parts[0].split("-")[0].toInt()
    val max = parts[0].split("-")[1].toInt()
    val key = parts[1].removeSuffix(":")[0]
    val password = parts[2]

}
