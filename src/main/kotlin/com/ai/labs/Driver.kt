package com.ai.labs

import com.ai.labs.domain.*
import kotlin.properties.Delegates

const val POPULATION_SIZE = 9
const val MUTATION_RATE = 0.1
const val CROSSOVER_RATE = 0.9
const val TOURNAMENT_SELECTION_SIZE = 3
const val NUMB_OF_ELITE_SCHEDULES = 1

fun main() {
    val driver = Driver()
    driver.data = Data()
    val generationNumber = 0
    driver.printAvailableData()
    println("> Generation # $generationNumber")
    print("  Schedule # |                                             ")
    print("Classes [dept,class,room, instructor, meeting-time]        ")
    println("                                     | Fitness | Conflicts")
    print("---------------------------------------------------------------------------------")
    println("-----------------------------------------------------------------------------------")
    val geneticAlgorithm = GeneticAlgorithm(driver.data)
    val population = Population(POPULATION_SIZE, driver.data).sortByFitness()
    population.schedules.forEach{ schedule -> println("         ${driver.scheduleNumb} " +
            "       | schedule | " + String.format("%.5f", schedule.fitness) + " |  ${schedule.numbOfConflicts}")}

}

public class Driver {
    lateinit var data: Data
    var scheduleNumb: Int = 0
    fun printAvailableData() {
        println("Available Departments:")
        data.depts.forEach{ x -> println("name: ${x.name}, courses: ${x.courses}")}
        println("\nAvailable Courses:")
        data.courses.forEach{ x -> println("course #: ${x.number}, name: ${x.name}, max # of students: ${x.maxNumbOfStudents}, instructors: ${x.instructors}")}
        println("Available Rooms:")
        data.rooms.forEach{ x -> println("room #: ${x.number}, max seating capacity: ${x.seatingCapacity}")}
        println("Available Instructors:")
        data.instructors.forEach{ x -> println("id: ${x.id}, name: ${x.name}")}
        println("Available Meeting Times:")
        data.meetingTimes.forEach{ x -> println("id #: ${x.id}, Meeting Time: ${x.time}")}
    }
}