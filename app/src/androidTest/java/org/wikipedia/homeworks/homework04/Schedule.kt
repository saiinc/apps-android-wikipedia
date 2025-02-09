package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    operator fun invoke(function: Schedule.() -> Unit) {
        function()
    }

    /*
    infix fun Char(":").by(minutes: String): LocalTime {
        return LocalTime.of(this.toInt(), minutes.toInt())
    }*/




    operator fun String.rangeTo(endTime: String): Pair<LocalTime, LocalTime> {
        val stringStartTime = this.split(":")
        val intStartTime = LocalTime.of(stringStartTime[0].toInt(), stringStartTime[1].toInt())
        val stringEndTime = endTime.split(":")
        val intEndTime = LocalTime.of(stringEndTime[0].toInt(), stringEndTime[1].toInt())
        return Pair<LocalTime, LocalTime>(intStartTime, intEndTime)
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String): ScheduleEntity {
        return ScheduleEntity(lesson, this.first, this.second)
    }

    /* infix fun String.ScheduleEntity(scheduleEntity: ScheduleEntity) {
        addSchedule(wednesday, scheduleEntity)
    }*/

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }
}



val schedule = Schedule()


fun main() {

// Так добавляется расписание без DSL
    schedule.addSchedule(
        Days.MONDAY,
        ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10))
    )
    schedule.addSchedule(
        Days.MONDAY,
        ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55))
    )

// Промежуточный вариант
    schedule {
        addSchedule(
            Days.TUESDAY,
            ScheduleEntity("History", LocalTime.of(10, 30), LocalTime.of(11, 10))
        )
        addSchedule(
            Days.TUESDAY,
            ScheduleEntity("Literature", LocalTime.of(11, 15), LocalTime.of(11, 55))
        )
        addSchedule(
            Days.TUESDAY,
            "10:30".."11:10" schedule "Biology"
        )
    }

// Так добавляется расписание с использованием DSL
//    schedule {
//
//        monday {
//            "10:30".."11:10" schedule "Biology"
//            "11:15".."11:55" schedule "Chemistry"
//            "09:00".."09:40" schedule "Mathematics"
//            "09:45".."10:25" schedule "History"
//        }
//
//        tuesday {
//            "09:00".."09:40" schedule "English"
//            "09:45".."10:25" schedule "Geography"
//            "11:15".."11:55" schedule "Art"
//            "10:30".."11:10" schedule "Physics"
//        }
//
//        wednesday {
//            "11:15".."11:55" schedule "Biology"
//            "09:00".."09:40" schedule "Literature"
//            "10:30".."11:10" schedule "History"
//            "09:45".."10:25" schedule "Mathematics"
//        }
//
//        thursday {
//            "11:15".."11:55" schedule "Physics"
//            "10:30".."11:10" schedule "Geography"
//            "09:00".."09:40" schedule "Chemistry"
//            "09:45".."10:25" schedule "English"
//        }
//
//        friday {
//            "09:45".."10:25" schedule "Literature"
//            "11:15".."11:55" schedule "History"
//            "09:00".."09:40" schedule "Art"
//            "10:30".."11:10" schedule "Mathematics"
//        }
//    }

    println(schedule.toString())
}
