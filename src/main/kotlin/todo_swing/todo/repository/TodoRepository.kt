package todo_swing.todo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import todo_swing.todo.entity.Todo

/**
 * Todo Repository (Spring Data JPA)
 */
@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
}
