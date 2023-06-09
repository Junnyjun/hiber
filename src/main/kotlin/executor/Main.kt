package executor

import executor.config.emf
import executor.team.Team

fun main(args: Array<String>) {

    val em = emf.createEntityManager()

    em.run {
        val transaction = this.transaction
        transaction.begin()
        em.persist(Team(name = "test123"))
        transaction.commit()
    }

    em.close()
    println("Transaction closed")
}