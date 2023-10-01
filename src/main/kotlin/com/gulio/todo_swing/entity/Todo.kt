package com.gulio.todo_swing.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Timestamp

@Entity
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var status: Boolean = false,
    var createdAt: Timestamp = Timestamp(System.currentTimeMillis()),
    var updatedAt: Timestamp = Timestamp(System.currentTimeMillis())
) {
    override fun toString(): String {
        return "Todo(id=$id, title='$title', description='$description', status=$status, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}
