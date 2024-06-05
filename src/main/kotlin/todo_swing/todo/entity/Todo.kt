package todo_swing.todo.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.sql.Timestamp

/**
 * Todo ORM Class
 *
 * @author Namju Kim
 */
@Entity
@EntityListeners(AuditingEntityListener::class)
class Todo(
    /**
     * ID (Primary Key)
     * Auto Increment를 통해 자동으로 증가
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    /**
     * TODO 제목
     */
    var title: String = "",

    /**
     * TODO 설명
     */
    var description: String = "",

    /**
     * TODO 완료 여부
     */
    var status: Boolean = false,

    /**
     * 생성일자
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: Timestamp? = null,

    /**
     * 수정일자
     */
    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: Timestamp? = null
) {
    /**
     * toString 메소드 재정의
     * @return String Todo 객체의 문자열
     */
    override fun toString(): String {
        return "Todo(id=$id, title='$title', description='$description', status=$status, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}
