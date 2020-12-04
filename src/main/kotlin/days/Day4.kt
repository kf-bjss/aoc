package days

import java.util.regex.Matcher
import java.util.regex.Pattern


class Day4 : Day(4) {
    private val keys: Set<String> = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid") //cid
    private val passportDataList = inputString.split("\r\n\r\n").map { PassportData(it) }.toList()

    override fun partOne(): Any {
        return passportDataList.filter { passportData -> keys.filter { key -> passportData.data.contains(key) }.size == keys.size }.size
    }

    override fun partTwo(): Any {
        return passportDataList.filter { passportData -> passportData.data.filter { validatePassportData(it.key, it.value) }.size == keys.size }.size
    }

    private fun validatePassportData(key: String, value: String): Boolean {
        return when (key) {
            "byr" -> value.length == 4 && value.toInt() in 1920..2002
            "iyr" -> value.length == 4 && value.toInt() in 2010..2020
            "eyr" -> value.length == 4 && value.toInt() in 2020..2030
            "hgt" -> (value.contains("cm") && value.removeSuffix("cm").toInt() in 150..193) ||
                    (value.contains("in") && value.removeSuffix("in").toInt() in 59..76)
            "hcl" -> {
                val colorPattern: Pattern = Pattern.compile("#([0-9a-f]{6})")
                val m: Matcher = colorPattern.matcher(value)
                m.matches()
            }
            "ecl" -> setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").any { it == value }
            "pid" -> value.length == 9 && value.chars().allMatch(Character::isDigit)
            else -> false
        }
    }
}

class PassportData(rawData: String) {
    val data: Map<String, String> =
            rawData.replace("\r\n", " ")
                    .split(" ")
                    .filter { it.contains(":") }
                    .associate {
                        val (left, right) = it.split(":")
                        left to right
                    }
}
