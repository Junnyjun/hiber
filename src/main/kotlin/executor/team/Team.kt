package executor.team

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
data class Team(
    @Id @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0,
    val name: String = "",
)