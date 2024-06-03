package com.gulio.todo_swing.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.sql.Timestamp

@Entity
@EntityListeners(AuditingEntityListener::class)
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var status: Boolean = false,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: Timestamp? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: Timestamp? = null
) {
    override fun toString(): String {
        return "Todo(id=$id, title='$title', description='$description', status=$status, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}
