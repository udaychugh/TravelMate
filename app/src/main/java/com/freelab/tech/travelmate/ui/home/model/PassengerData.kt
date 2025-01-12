package com.freelab.tech.travelmate.ui.home.model

data class PassengerData(
    val pCount: String,
    val id: Int,
    var isSelected: Boolean
) {
    companion object {
        fun getPassengerCountList(): List<PassengerData> {
            return listOf(
                PassengerData(
                    pCount = "1",
                    id = 0,
                    isSelected = true
                ),
                PassengerData(
                    pCount = "2",
                    id = 1,
                    isSelected = false
                ),
                PassengerData(
                    pCount = "3",
                    id = 2,
                    isSelected = false
                ),
                PassengerData(
                    pCount = "4",
                    id = 3,
                    isSelected = false
                ),
                PassengerData(
                    pCount = "5",
                    id = 4,
                    isSelected = false
                ),
                PassengerData(
                    pCount = "+",
                    id = 5,
                    isSelected = false
                ),
            )
        }
    }
}
