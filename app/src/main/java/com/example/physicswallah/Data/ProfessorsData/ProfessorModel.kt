package com.example.physicswallah.Data.ProfessorsData

data class ProfessorModel(
    val id: Int,
    val name: String,
    val subjects: List<String>,
    val qualifications: List<String>,
    val profilePic: String?
) {
}